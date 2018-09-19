const showdown = require('showdown');
const fs = require('fs');
const path = require('path');
const extensions = require('./extensions');

const converter = new showdown.Converter({
    extensions: [
        extensions.asideNotes,
        extensions.anchorHeader,
        extensions.addTOC,
        extensions.highlightCode
    ],
    noHeaderId: true,
    metadata  : true
});
const OUTPUT_ROOT = 'portfolio';

const files = process.argv.slice(2);
for (let file of files) {
    convertFile(file);
}

function convertFile(p) {
    const md = fs.readFileSync(p, {encoding: 'utf8'});
    // convert
    const html = converter.makeHtml(md);

    // output to html directory where jekyll will use it to build site
    // extract relative path
    const parts = p.split(path.sep);
    const relativePathStart = parts.indexOf("src");
    if (relativePathStart < 0) {
        console.error("Need to run script from src or above");
        return;
    }

    let relativePath = path.join(...parts.slice(relativePathStart + 1, parts.length - 1),
        path.basename(p, '.md'));
    relativePath += '.html';

    // find output path (html directory of some level)
    let prefix = '.';
    let tries = 0;
    // keep going up a directory
    while (!fs.existsSync(path.join(prefix, OUTPUT_ROOT))) {
        prefix = path.join(prefix, '../');
        if (++tries > 8) {
            console.error(`Couldn't find ${OUTPUT_ROOT} when running from this location`);
            return;
        }
    }

    const outPath = path.join(prefix, OUTPUT_ROOT, relativePath);

    let output = ["---"];
    Object.entries(converter.getMetadata()).forEach(([key, value]) => {
        output.push(`${key}: ${value}`);
    });
    output.push("---");
    output.push(html);

    fs.writeFileSync(outPath, output.join("\n"));
    console.log(`Done writing to ${outPath}`);
}
