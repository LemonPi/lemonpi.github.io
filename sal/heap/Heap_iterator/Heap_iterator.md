---
layout: algorithms
title: 
permalink: /sal/heap/Heap_iterator/index.html
section: heap
classname: Heap_iterator
---

<div class="toc">
	<a class="toc-link toch3" href="#operator++()">operator++()</a>
	<a class="toc-link toch3" href="#operator--()">operator--()</a>
	<a class="toc-link toch3" href="#operator++">operator++</a>
	<a class="toc-link toch3" href="#operator--">operator--</a>
	<a class="toc-link toch3" href="#operator*()">operator*()</a>
	<a class="toc-link toch3" href="#operator->()">operator->()</a>
	<a class="toc-link toch3" href="#operator==">operator==</a>
	<a class="toc-link toch3" href="#operator!=">operator!=</a>
<p class="toc-caption">(bolded sections are more interesting)</p>
<p class="toc-toggle">toggle TOC (ctrl + &#8660;)</p>
</div><div class="block">
<h4><a href="https://github.com/LemonPi/data/blob/master/heap.h">sal/data/heap.h</a>
</h4><table class="pretty">
<tr><th><a class="doc-list-name" href="#Heap_iterator">Heap_iterator</a></th><th></th></tr>
<tr><td><a class="doc-list-name" href="#operator++()">operator++()</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator--()">operator--()</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator++">operator++</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator--">operator--</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator*()">operator*()</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator->()">operator->()</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator==">operator==</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator!=">operator!=</a></td><td></td></tr>
</table></div>



<h3 class="anchor doc-header">operator++() | <code class="qualifier">Heap_iterator::</code>operator++()<a class="anchor-link" href="#operator++()" name="operator++()" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void operator++();
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





<h3 class="anchor doc-header">operator--() | <code class="qualifier">Heap_iterator::</code>operator--()<a class="anchor-link" href="#operator--()" name="operator--()" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void operator--();
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





<h3 class="anchor doc-header">operator++ | <code class="qualifier">Heap_iterator::</code>operator++<a class="anchor-link" href="#operator++" name="operator++" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Heap_iterator operator++(int);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>int</td><td></td></tr>
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





<h3 class="anchor doc-header">operator-- | <code class="qualifier">Heap_iterator::</code>operator--<a class="anchor-link" href="#operator--" name="operator--" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Heap_iterator operator--(int);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>int</td><td></td></tr>
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





<h3 class="anchor doc-header">operator*() | <code class="qualifier">Heap_iterator::</code>operator*()<a class="anchor-link" href="#operator*()" name="operator*()" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
T& operator*();
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





<h3 class="anchor doc-header">operator->() | <code class="qualifier">Heap_iterator::</code>operator->()<a class="anchor-link" href="#operator->()" name="operator->()" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Iter& operator->();
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





<h3 class="anchor doc-header">operator== | <code class="qualifier">Heap_iterator::</code>operator==<a class="anchor-link" href="#operator==" name="operator==" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
bool operator==(CR other);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>other</td><td></td></tr>
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





<h3 class="anchor doc-header">operator!= | <code class="qualifier">Heap_iterator::</code>operator!=<a class="anchor-link" href="#operator!=" name="operator!=" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
bool operator!=(CR other);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>other</td><td></td></tr>
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





