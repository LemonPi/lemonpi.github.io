function anchorHeader() {
    const ext = {
        type   : 'output',
        regex  : /<h2>(.*?)<\/h2>/g,
        // regex: /<h2>/g,
        replace: function (fullMatch, title) {
            // console.log(title);
            // want to convert title to an ID
            const id = title.toLowerCase().replace(" ", "_");
            return `<h2 class="anchor">${title} <a class="anchor-link" title="permalink to section" href="#${id}"
                               name="${id}">&para;</a></h2>`;
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

module.exports = {
    anchorHeader,
    addTOC
};