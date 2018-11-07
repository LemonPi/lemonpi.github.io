## Usage guide
The preferred method of creating content is to write markdown documents inside `src`
then generate an HTML to host with instructions below.

1. `npm install`
2. write content in markdown inside the `src` directory (see examples in there)
3. `node src/build.js <path to markdown source inside src/>`
    - will automatically generate and move the resulting HTML file into the html directory
    
You can alternatively directly create the HTML (or markdown) files outside of `src`.

### Markdown language extensions
Put asides in a block of text starting with `>>` or `>>>` for more important notes, like:

```
>> This is an aside.
This is still part of the aside.

No longer part of the aside
```

## Local build
If you want to preview the webpage before pushing to github to be hosted, you need jekyll.

### Installation
1. install the latest version of ruby
2. install rubydevkit and point to the previous installation of ruby
3. navigate to portfolio root directory with git bash
4. `gem install bundler`
5. `bundle install`


### Previewing
1. `bundle exec jekyll serve`
