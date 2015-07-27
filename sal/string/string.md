---
layout: algorithms
title: 
permalink: /sal/string/index.html
section: string
---

<div class="toc">
	<a class="toc-link toch3" href="#levenshtein">levenshtein</a>
	<a class="toc-link toch3" href="#ssplit">ssplit</a>
	<a class="toc-link toch3" href="#ltrim">ltrim</a>
<p class="toc-caption">(bolded sections are more interesting)</p>
<p class="toc-toggle">toggle TOC (ctrl + &#8660;)</p>
</div><div class="block">
<h4><a href="https://github.com/LemonPi/algo/blob/master/string.h">sal/algo/string.h</a>
</h4><table class="pretty">
<tr><td><a class="doc-list-name" href="#levenshtein">levenshtein</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#ssplit">ssplit</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#ltrim">ltrim</a></td><td></td></tr>


</table></div>



<h3 class="anchor doc-header">levenshtein <a class="anchor-link" href="#levenshtein" name="levenshtein" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Sequence>
size_t levenshtein(const Sequence& a, const Sequence& b);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>a</td><td></td></tr>
<tr><td>b</td><td></td></tr>
</table>
<p class="doc-section">Return value</p>

<p class="doc-section">Example</p>
{% highlight c++ %}

{% endhighlight %}

<p class="doc-section">Discussion</p>
<div>
<p>
	
</p>
</div></div>





<h3 class="anchor doc-header">ssplit <a class="anchor-link" href="#ssplit" name="ssplit" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
std::vector<std::string> ssplit(const std::string &s, char delim);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>s</td><td></td></tr>
<tr><td>delim</td><td></td></tr>
</table>
<p class="doc-section">Return value</p>

<p class="doc-section">Example</p>
{% highlight c++ %}

{% endhighlight %}

<p class="doc-section">Discussion</p>
<div>
<p>
	
</p>
</div></div>





<h3 class="anchor doc-header">ltrim <a class="anchor-link" href="#ltrim" name="ltrim" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
std::string& ltrim(std::string& s);

std::string ltrim(const std::string& s);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>s</td><td></td></tr>
</table>
<p class="doc-section">Return value</p>

<p class="doc-section">Example</p>
{% highlight c++ %}

{% endhighlight %}

<p class="doc-section">Discussion</p>
<div>
<p>
	
</p>
</div></div>





