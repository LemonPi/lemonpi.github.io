---
layout: default
title: Engineering Design Portfolio
permalink: /projects/portfolio/index.html
---
The portfolio is a mandatory assignment for all first year Engineering Science students in which we are free  
to choose how to construct it.
Striving for robustness, my approach is to learn as many tools as possible while I am in school.  
Having no prior experience, I built this engineering portfolio manually with these goals in mind:  
- Learn all the tools involved in creating a website
- Explore designing for usability in terms of user-interface  
- Present my accomplishments in a robust, usable, and efficient way

Code and site history: [https://github.com/LemonPi/portfolio](https://github.com/LemonPi/portfolio)  

##Understanding the Problem
------------------------
I first researched how creating a website could be broken into components and consulted a classmate,  
[Zhuowei Zhang](zhuoweizhang.net), who had more web development experience. With permission, I used his November [build](https://github.com/zhuowei/design/tree/5b67c2a088f0330f5681924b0d83a94319ba4b96) as a starting point.  

I found the problem of building a website can be decomposed into:  
- Content
- Layout
- Styling
- Hosting

##Solutions  
-------------
1. Content needs to be easily editable, not bogged down in syntax
  - HTML: too much syntax; its strength in versatility may be useful though
  - Markdown:  although functionality is limited and requires parsing into HTML, great for the purpose of creating and maintaining content
2. Layout needs to readable by all browsers, as quickly as possible
  - HTML: pretty much the only choice, and the syntax is not a problem since there will only be one layout  
  - 
3. Styling needs to be supported by most browsers and easily changeable; loading speed (file size) is a consideration for first time visitors
  - CSS: superior to HTML for styling in every way
  -
4. Hosting needs to be reliable, fast, and not place too many restrictions on usage
  - ECF UToronto: very fast, but restricted to "satisfy(ing) the requirements of some web based courses"
  - UTORweb: restricted to "individual use in support of one's role in the University"
  - Google Sites: slower, but no restrictions on usage
  - GithubPages: slower, but no restrictions on usage and provides server side Jekyll to parse markdown into HTML
    Note that users are only viewing static HTML pages, markdown is parsed 

<a name="compare"> </a>
##Solution Comparison
--------------------
The combination that I selected was (Markdown + HTML) + CSS + Jekyll + GithubPages.  
Markdown does not natively support tables or CSS classes, so HTML to generate tables and picture frames.  
Jekyll is quite robust in being able to parse multiple languages in one file - a YAML header, HTML elements, and markdown elements.  
One area of improvement for Jekyll is to support markdown inside HTML div elements.  

An important part of my engineering design process is comparing solutions against each other.  
Possible solutions were compared using the metric of no-cache first visit load time for efficiency, and .  
My current portfolio was compared against empty templates from Wix, Weebly, and Wordpress.


##Design decisions for usability  
---------------------------------
- page anchors for quick annotation
- row highlight for ease of tracking items in one row

<a name="prototype"> </a>
##Prototyping
--------------

<a name="gains"> </a>
##Gains from Experience
-----------------------
- Writing in markdown