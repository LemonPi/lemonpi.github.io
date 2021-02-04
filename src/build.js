const showdown = require('showdown');
const fs = require('fs');
const path = require('path');
const extensions = require('./extensions');

const converter = new showdown.Converter({
    extensions: [
        extensions.asideNotes,
        extensions.anchorHeader,
        extensions.addTOC,
        extensions.highlightCode,
        extensions.gallery
    ],
    noHeaderId: true,
    metadata  : true
});
const SRC_ROOT = 'src';

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
    const relativePathStart = parts.indexOf(SRC_ROOT);
    if (relativePathStart < 0) {
        console.error(`Need to run script from ${SRC_ROOT} or above`);
        return;
    }

    let relativePath = path.join(...parts.slice(relativePathStart + 1, parts.length - 1),
        path.basename(p, '.md'));
    relativePath += '.html';

    // find output path (html directory of some level)
    let prefix = '.';
    let tries = 0;
    // keep going up a directory
    while (!fs.existsSync(path.join(prefix, SRC_ROOT))) {
        prefix = path.join(prefix, '../');
        if (++tries > 8) {
            console.error(`Couldn't find ${SRC_ROOT} when running from this location`);
            return;
        }
    }

    const outPath = path.join(prefix, relativePath);

    let output = ["---"];
    Object.entries(converter.getMetadata()).forEach(([key, value]) => {
        output.push(`${key}: ${value}`);
    });
    output.push("---");
    output.push(html);

    // ensure folder exists
    fs.mkdir(path.dirname(outPath), {recursive: true}, (err) => {
        if (err) {
            throw err;
        }
    });

    fs.writeFileSync(outPath, output.join("\n"));
    console.log(`Done writing to ${outPath}`);
}
