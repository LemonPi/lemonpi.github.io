function anchorHeader() {
    const ext = {
        type   : 'output',
        regex  : /<h([23])>(.*?)<\/h\1>/g,
        // regex: /<h2>/g,
        replace: function (fullMatch, headerLevel, title) {
            // want to convert title to an ID
            const id = title.toLowerCase().replace(" ", "_");
            return `<h${headerLevel} class="anchor">${title} <a class="anchor-link" title="permalink to section" href="#${id}"
                               name="${id}">&para;</a></h${headerLevel}>`;
        }
    };
    return ext;
}

function addTOC() {
    const ext = {
        type  : 'output',
        filter: function (text) {
            // add a table of contents if there are headers
            const titleRegex = /<h([23])[^>]*>(.*?)<[^>]*name="([^"]*)"/g;

            const headers = [];
            let m = null;
            do {
                m = titleRegex.exec(text);
                if (m) {
                    const headerLevel = m[1];
                    const title = m[2].trim();
                    const name = m[3];

                    headers.push({
                        headerLevel,
                        title,
                        name,
                    });
                }
            } while (m);

            const output = [];
            // check if there are any headers
            if (headers.length) {
                output.push('<div class="toc">');

                for (let header of headers) {
                    output.push(`<a class="toc-link toch${header.headerLevel}" href="#${header.name}">${header.title}</a>`);
                }

                output.push('<p class="toc-caption"></p>');
                output.push('<p class="toc-toggle">toggle TOC (ctrl + &#8660;)</p>');
                output.push('</div>');
            }

            output.push(text);
            return output.join("\n");
        }
    };
    return ext;
}

function highlightCode() {
    return {
        type: 'output',
        regex: /<pre><code class="(\w+) [^"]*?">([\s\S]*?)<\/code><\/pre>/g,
        // replace: function(fullmatch, language, content) {
        //     console.log(`matched ${language}`);
        // }
        replace: "\n{% highlight $1 %}$2{% endhighlight %}\n"
    };
}

function asideNotes() {
    return [{
        type: 'lang',
        regex: />>> ([^>]*?)\n\n/g,
        replace: "<aside class='important'><h4>Important</h4>$1</aside>\n"
    }, {
        type: 'lang',
        regex: />> ([^>]*?)\n\n/g,
        replace: "<aside class='notice'><h4>Note</h4>$1</aside>\n"
    }];
}

module.exports = {
    anchorHeader,
    addTOC,
    highlightCode,
    asideNotes,
};