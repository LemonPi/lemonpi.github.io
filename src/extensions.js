function anchorHeader() {
    const ext = {
        type   : 'output',
        regex  : /<h([23])>(.*?)<\/h\1>/g,
        // regex: /<h2>/g,
        replace(fullMatch, headerLevel, title) {
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

function gallery() {
    return {
        type: 'lang',
        regex: /\|\|\|([^]*)\|\|\|/g,
        replace(fullMatch, fullContent) {
            const output = ["<div class='gallery'>"];

            const cols = fullContent.split('||');
            for (let colContent of cols) {
                output.push('<div class="gallery-col">');

                const boxContents = colContent.split('|');

                for (let content of boxContents) {
                    if (content.trim() === "") continue; // Skip empty content

                    const parts = content.trim().split('\n');
                    const [link, img, title, desc, tags] = parts;

                    const repoMatch = link.match(/github\.com\/([^\/]+\/[^\/]+)/);
                    const repoId = repoMatch ? repoMatch[1] : null;

                    output.push(`<a href="${link}">`);
                    output.push('<div class="box">');
                    output.push(`<img src="${img}"/>`);
                    output.push('<div class="caption">');

                    output.push(`<h1 class="caption-title">${title}</h1>`);

                    if (tags) {
                        output.push('<span class="tag-span">');
                        const tagsList = tags.split(",");
                        for (let tag of tagsList) {
                            output.push(`<span class="tag">${tag}</span>`);
                        }
                        output.push('</span>');
                    }

                    output.push(`<p class="caption-desc">${desc}</p>`);

                    // output.push(`<p class="caption-date">${date}</p>`);
                    if (repoMatch) {
                        output.push(`<div id="${repoId}" class="stats"></div>`); // Placeholder for stats
                    }

                    output.push('</div>');
                    output.push('</div>');
                    output.push('</a>');
                }

                output.push('</div>');
            }

            output.push("</div>");
            return output.join("\n");
        }
    }
}

function publications() {
    return {
        type: 'lang',
        regex: /\+\+\+([^]*)\+\+\+/g,
        replace(fullMatch, fullContent) {
            const output = ["<div class='publications'>"];
            const boxContents = fullContent.trim().split('|');

            for (let content of boxContents) {
                const lines = content.trim().split('\n');
                const [img, title, authors, venue, ...rest] = lines;

                const extraFields = {};
                rest.forEach(line => {
                    const [key, ...valueParts] = line.split(':');
                    const value = valueParts.join(':').trim();
                    if (value) {
                        extraFields[key.trim()] = value;
                    }
                });

                output.push('<div class="pub">');
                output.push(`<img src="${img}" alt="${title}"/>`);
                output.push('<div class="caption">');

                output.push(`<h1 class="caption-title">${title}</h1>`);
                output.push(`<p class="caption-authors">${authors}</p>`);

                output.push(`<p class="caption-desc">${venue}</p>`);

                // Add optional fields
                output.push('<div class="caption-extra">');
                for (let key in extraFields) {
                    if (key !== 'tags') { // tags are already processed
                        output.push(`<p class="${key}"><a href="${extraFields[key]}" target="_blank">${key}</a></p>`);
                    }
                }
                output.push('</div>');

                output.push('</div>');
                output.push('</div>');
            }

            output.push("</div>");
            return output.join("\n");

        }
    }
}

module.exports = {
    anchorHeader,
    addTOC,
    highlightCode,
    asideNotes,
    gallery,
    publications,
};