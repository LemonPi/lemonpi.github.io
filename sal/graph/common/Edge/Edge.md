---
layout: algorithms
title: 
permalink: /sal/graph/common/Edge/index.html
section: graph/common
classname: Edge
---

<div class="toc">
	<a class="toc-link toch2" href="#Edge">Edge</a>
	<a class="toc-link toch3" href="#source">source</a>
	<a class="toc-link toch3" href="#dest">dest</a>
	<a class="toc-link toch3" href="#weight">weight</a>
<p class="toc-caption">(bolded sections are more interesting)</p>
<p class="toc-toggle">toggle TOC (ctrl + &#8660;)</p>
</div><div class="block">
<h4><a href="https://github.com/LemonPi/data/blob/master/graph/common.h">sal/data/graph/common.h</a>
</h4><table class="pretty">
<tr><th><a class="doc-list-name" href="#Edge">Edge</a></th><th></th></tr>
<tr><td><a class="doc-list-name" href="#source">source</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#dest">dest</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#weight">weight</a></td><td></td></tr>
</table></div>



<h2 class="anchor doc-header">Edge <a class="anchor-link" href="#Edge" name="Edge" title="permalink to section">&para;</a></h2>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Adj_iter>
Edge(V a, Adj_iter& b);
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





<h3 class="anchor doc-header">source | <code class="qualifier">Edge::</code>source<a class="anchor-link" href="#source" name="source" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Adj_iter>
V source() const;
{% endhighlight %}
<p class="doc-section">Return value</p>

<p class="doc-section">Example</p>
{% highlight c++ %}

{% endhighlight %}

<p class="doc-section">Discussion</p>
<div>
<p>
	
</p>
</div></div>





<h3 class="anchor doc-header">dest | <code class="qualifier">Edge::</code>dest<a class="anchor-link" href="#dest" name="dest" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Adj_iter>
V dest() const;
{% endhighlight %}
<p class="doc-section">Return value</p>

<p class="doc-section">Example</p>
{% highlight c++ %}

{% endhighlight %}

<p class="doc-section">Discussion</p>
<div>
<p>
	
</p>
</div></div>





<h3 class="anchor doc-header">weight | <code class="qualifier">Edge::</code>weight<a class="anchor-link" href="#weight" name="weight" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Adj_iter>
E weight() const;
{% endhighlight %}
<p class="doc-section">Return value</p>

<p class="doc-section">Example</p>
{% highlight c++ %}

{% endhighlight %}

<p class="doc-section">Discussion</p>
<div>
<p>
	
</p>
</div></div>





