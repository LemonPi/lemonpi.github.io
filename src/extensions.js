function anchorHeader() {
    const ext = {
        type: 'output',
        regex: /<h2>(.*?)<\/h2>/g,
        // regex: /<h2>/g,
        replace: function(fullMatch, title) {
            console.log(title);
            // want to convert title to an ID
            const id = title.toLowerCase().replace(" ", "_");
            return `<h2 class="anchor">${title} <a class="anchor-link" title="permalink to section" href="#${id}"
                               name="${id}">&para;</a></h2>`;
        }
    };
    return ext;
}

module.exports = {anchorHeader};