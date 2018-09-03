## Installation
1. install the latest version of ruby
2. install rubydevkit and point to the previous installation of ruby
3. navigate to portfolio root directory with git bash
4. `gem install bundler`
5. `bundle install`

## Local build
1. `bundle exec jekyll serve`

## Generating HTML from markdown
Jekyll looks in the html directory for all source files to generate the site.
You can either create HTML/Markdown source in there directly, or through creating Markdown
and converting it to HTML through Showdown. This has the advantage of automatically defining
classes and is the preferred way.

1. `npm install`
2. `node src/build.js <path to markdown source inside src/>`
    - will automatically generate and move the resulting HTML file into the html directory

## Generating table of contents
1. create TOC anchors in the html/md file
	1. <h2 class="anchor">... <a class="anchor-link" title="permalink to section" href="#..." name="...">&para;</a></h2>
	2. use <h3> for sub headings
2. compile Autotoc.java if necessary 
	1. navgiate to portfolio root
	2. ensure Java is installed and accessible via git bash `javac -version`
	3. `javac -cp <path to jsoup.jar>:. autotools/Autotoc.java`
3. run Autotoc on the html/md file
	1. `java -cp <path to jsoup.jar>:. autotools/Autotoc <path to input>`
	2. copy output (stdout and the toc.md file) to the top of the input file