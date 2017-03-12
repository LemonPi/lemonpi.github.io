## Installation
1. install the latest version of ruby
2. install rubydevkit and point to the previous installation of ruby
3. navigate to portfolio root directory with git bash
4. `gem install bundler`
5. `bundle install`

## Local build
1. `bundle exec jekyll serve`

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