---
layout: algorithms
title: List
permalink: /sal/list/List/index.html
section: list
classname: List
---

<div class="toc">
	<a class="toc-link toch2" href="#List">List</a>
	<a class="toc-link toch3" href="#kth_last">kth_last</a>
	<a class="toc-link toch3" href="#insert">insert</a>
	<a class="toc-link toch3" href="#insert_after">insert_after</a>
	<a class="toc-link toch3" href="#append">append</a>
	<a class="toc-link toch3" href="#erase">erase</a>
	<a class="toc-link toch3" href="#remove_dup">remove_dup</a>
	<a class="toc-link toch3" href="#print">print</a>
<p class="toc-caption"></p>
<p class="toc-toggle">toggle TOC (ctrl + &#8660;)</p>
</div><div class="block">
<h4><a href="https://github.com/LemonPi/data/blob/master/list.h">sal/data/list.h</a>
</h4><table class="pretty">
<tr><th><a class="doc-list-name" href="#List">List</a></th><th></th></tr>
<tr><td><a class="doc-list-name" href="#kth_last">kth_last</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#insert">insert</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#insert_after">insert_after</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#append">append</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#erase">erase</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#remove_dup">remove_dup</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#print">print</a></td><td></td></tr>
</table></div>



<h2 class="anchor doc-header">List <a class="anchor-link" href="#List" name="List" title="permalink to section">&para;</a></h2>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
List(T d);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>d</td><td></td></tr>
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





<h3 class="anchor doc-header">kth_last | <code class="qualifier">List::</code>kth_last<a class="anchor-link" href="#kth_last" name="kth_last" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
NP kth_last(size_t k);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>k</td><td></td></tr>
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





<h3 class="anchor doc-header">insert | <code class="qualifier">List::</code>insert<a class="anchor-link" href="#insert" name="insert" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void insert(T d);

void insert(NP node);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>d</td><td></td></tr>
<tr><td>node</td><td></td></tr>
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





<h3 class="anchor doc-header">insert_after | <code class="qualifier">List::</code>insert_after<a class="anchor-link" href="#insert_after" name="insert_after" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void insert_after(T d, NP prev);

void insert_after(NP node, NP prev);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>d</td><td></td></tr>
<tr><td>prev</td><td></td></tr>
<tr><td>node</td><td></td></tr>
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





<h3 class="anchor doc-header">append | <code class="qualifier">List::</code>append<a class="anchor-link" href="#append" name="append" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void append(T d);

void append(NP node);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>d</td><td></td></tr>
<tr><td>node</td><td></td></tr>
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





<h3 class="anchor doc-header">erase | <code class="qualifier">List::</code>erase<a class="anchor-link" href="#erase" name="erase" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void erase(T d);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>d</td><td></td></tr>
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





<h3 class="anchor doc-header">remove_dup | <code class="qualifier">List::</code>remove_dup<a class="anchor-link" href="#remove_dup" name="remove_dup" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void remove_dup();
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





<h3 class="anchor doc-header">print | <code class="qualifier">List::</code>print<a class="anchor-link" href="#print" name="print" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename TT>
void print() const;
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





