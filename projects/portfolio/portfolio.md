---
layout: default
title: Engineering Design Portfolio
permalink: /projects/portfolio/index.html
group: projects
---
<div class="block">
The portfolio is a mandatory assignment for all first year Engineering Science students.  
We choose how we build it, and since I strive to be robust myself, learning as many tools as possible,  
I built this engineering portfolio manually with these goals in mind:  
<ul>
  <li>Learn all the tools involved in creating a website rather than just making a website</li>
  <li>Explore designing for usability in terms of user-interface  </li>
  <li>Present my accomplishments in a robust, usable, and efficient way</li>
</ul>

Code and site history: <a href="https://github.com/LemonPi/lemonpi.github.io">on github</a>

<h2 class="anchor">Understanding the Problem <a class="anchor-link" title="permalink to section" href="#analysis" name="analysis">¶</a></h2>
<hr>

The first step was researching how building a website could be broken down and to that effect I consulted a classmate,  
<a href="http://zhuoweizhang.net">Zhuowei Zhang</a>, who had more web development experience. With permission, I used his November 
<a href="https://github.com/zhuowei/design/tree/5b67c2a088f0330f5681924b0d83a94319ba4b96">build</a> as my starting point.  

I found the problem of building a website can be decomposed into:  
<ul>
  <li>Content</li>
  <li>Layout</li>
  <li>Styling</li>
  <li>Hosting</li>
</ul>


<h2 class="anchor">Solution Pool <a class="anchor-link" title="permalink to section" href="#pool" name="pool">¶</a></h2>
<hr>
In line with my engineering process, solutions for each problem component were generated.  
<ol>
  <li> Content needs to be easily editable, not bogged down in syntax
    <ul>
      <li>HTML: too much syntax; its strength in versatility may be useful though</li>
      <li>Markdown:  although functionality is limited and requires parsing into HTML, great for the purpose of creating and maintaining content</li>
    </ul>
  </li>
  <li> Layout needs to readable by all browsers, as quickly as possible
    <ul>
      <li>HTML: pretty much the only choice, and the syntax is not a problem since there will only be one layout  </li>
    </ul>
  </li>
  <li> Styling needs to be supported by most browsers and easily changeable; loading speed (file size) is a consideration for first time visitors
    <ul>
      <li>CSS: superior to HTML for styling in every way</li>
    </ul>
  </li>
  <li> Hosting needs to be reliable, fast, and not place too many restrictions on usage
    <ul>
      <li>ECF UToronto: very fast, but restricted to "satisfy(ing) the requirements of some web based courses"</li>
      <li>UTORweb: restricted to "individual use in support of one's role in the University"</li>
      <li>Google Sites: slower, but no restrictions on usage </li>
      <li>GithubPages: slower, but no restrictions on usage and provides server side Jekyll to parse markdown into HTML.
          Note that users are only viewing static HTML pages, markdown is parsed</li>
    </ul>
  </li>
</ol>

<h2 class="anchor">Solution Comparison <a class="anchor-link" title="permalink to section" href="#compare" name="compare">¶</a></h2>
<hr>
<div class="text-block">
<p>
  The combination that I selected was (Markdown + HTML) + CSS + Jekyll + GithubPages.  
  Markdown does not natively support tables or CSS classes, so HTML is used to generate tables and picture frames.  
  Jekyll is quite robust in being able to parse multiple languages in one file - a YAML header, HTML elements, and markdown elements.  
  One area of improvement for Jekyll is to support markdown inside HTML div elements.  
</p>

<p>
  An important part of my engineering design process is comparing solutions against each other.  
  Out of 256 portfolios posted by my classmates, 189 were made using Wix, 21 Wordpress, 20 Weebly.  
  My current portfolio was compared against empty templates from Wix, Wordpress, and Weebly  
  using the metric of no-cache first visit load time for efficiency.  
  Usability can be partially measured by load time, but otherwise is more to do with layout and user-interface. 
</p>
</div>

<table class="pretty">
<tr>
  <th>Site</th>
  <th>Users</th>
  <th>HTTP Requests</th>
  <th>Home page load time without caching (ms)</th>
  <th>Average time per request (ms)</th>
</tr>
<tr>
  <td>Wix</td>
  <td>189</td>
  <td>75</td>
  <td><a href="wixload.png">700-1500</a></td>
  <td>15</td>
</tr>
<tr>
  <td>Wordpress</td>
  <td>21</td>
  <td>49</td>
  <td><a href="wordpressload.png">1200-2000</a></td>
  <td>33</td>
</tr>
<tr>
  <td>Weebly</td>
  <td>20</td>
  <td>22</td>
  <td><a href="weeblyload.png">1200-1400</a></td>
  <td>59</td>
</tr>
<tr>
  <td>This site</td>
  <td>N/A</td>
  <td>2</td>
  <td><a href="mysourceload.png">200-240</a></td>
  <td>120</td>
</tr>
</table>

<div class="text-block">
<p>
  The load times (including mine) are reduced to about 40% after first visit due to caching,  
  but first impressions often make the greatest impact on user satisfaction.  
</p>

<p>
  An important aspect to reducing load time is reducing the number of HTTP requests.  
  Each request carries overhead that is often greater than time spent on receiving data, as is the case for my home page.
</p>

<div class="frames">
<img src="loadpartition.png">
<p>Only 1ms spent on receiving data!</p>
</div>

<p>
  In light of this, Wix provides great hosting by having a low load time to requests made ratio; however,  
  the relationship between request number and load time is not linear, and should be **considered along with total load time**.  
  For me, these sites do not give enough control to the developer over what gimmicks the user has to face and thus is not robust enough.  
</p>
</div>

<h2 class="anchor">Design Decisions for Usability <a class="anchor-link" title="permalink to section" href="#usability" name="usability">¶</a></h2>
---------------------------------
In my opinion, making a product more usable is almost equivalent to increasing its quality - the overall feel of the product.  
Attention to detail with the consideration of what could irk the users is key to my process of designing for usability.  
These are the key design decisions to make this site more usable:  

<ol>
  <li> Table rows highlight on hover to easily track items belonging to the same row; I personally had this difficulty with data sheets
    (<a href="/evaluations/handmixer/#efficiency">demonstrated here</a>)</li>

  <li> Page anchors (¶) allow parts of the page to be redirected to; makes redirect links more relevant  </li>

  <li> Site and page history at the footer of each page to allow anyone interested to see how I have progressed  </li>

  <li> Dynamic scaling of page elements (including images) to accomodate for different monitor sizes and avoid stretching  </li>

  <li> Subtle bump down of navigation bar links when activated to provide a more satisfying clicking experience</li>

  <li> No Javascript unless absolutely necessary to avoid the overhead of loading additional resources</li>

  <li> Thumbnail of pictures with links to full-size versions where appropriate to reduce loading time  </li>
</ol>

<div class="frames">
<img src="picturestoolarge.png">
<p>Example of embedding large images; 42s load time!</p>
</div>


<h2 class="anchor">Prototyping <a class="anchor-link" title="permalink to section" href="#prototype" name="prototype">¶</a></h2>
--------------
Developing for the web inherently makes it easy to prototype.  
Jekyll can serve the site locally and constantly regenerate each time an edit is made.
<div class="frames">
<img src="jekyllprototyping.png">
<p>Rapid prototyping with Jekyll made easy</p>
</div>

<h2 class="anchor">Polishing <a class="anchor-link" title="permalink to section" href="#polishing" name="polishing">¶</a></h2>
------------
Rapidly prototyping a product is fine for initial launch and ironing out bugs, but I believe great usability comes from long term polish.  
Nuances take time and usage to notice, therefore I will gradually add features to improve the quality of my portfolio.  
<div class="frames">
<img src="reverse.png">
<p>Reverse email entry to protect against spam bots</p>
</div>

Some features improve the security, and others are for user appeal.
<div class="frames">
<img src="gallery.png">
<p>Attention grabbing gallery</p>
</div>

Presenting visuals first, especially interactive ones, highly engages readers.  
Compressing pngs with pngcrush greatly reduces their size and load time (10-80% reduction).  
<div class="frames">
<img src="process_visual.png">
<p>Visual and interactive flowchart for my process page</p>
</div>

The interactive flowchart took a little more work than it appears because I wanted to keep it clean from JavaScript.  
Unfortunately I had to resort to JS to make it **work on mobile devices**; will seek lighter alternatives in the future.  

Check the page history to see when these features were added!

<h2 class="anchor">Gains from Experience <a class="anchor-link" title="permalink to section" href="#gains" name="gains">¶</a></h2>
-----------------------
<ul>
  <li>Understanding of the components to creating an efficient website</li>
  <li>Proficiency in CSS, HTML, and markdown</li>
  <li>Principles: designing for usability is attention to detail to provide a quality user experience</li>
</ul>

</div>