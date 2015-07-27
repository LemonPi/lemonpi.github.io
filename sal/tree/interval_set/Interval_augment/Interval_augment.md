---
layout: algorithms
title: 
permalink: /sal/tree/interval_set/Interval_augment/index.html
section: tree/interval_set
classname: Interval_augment
---

<div class="toc">
	<a class="toc-link toch2" href="#Interval_augment">Interval_augment</a>
	<a class="toc-link toch3" href="#insert">insert</a>
	<a class="toc-link toch3" href="#erase">erase</a>
	<a class="toc-link toch3" href="#find">find</a>
	<a class="toc-link toch3" href="#find_first">find_first</a>
	<a class="toc-link toch3" href="#find_exact">find_exact</a>
	<a class="toc-link toch3" href="#find_all">find_all</a>
	<a class="toc-link toch3" href="#print">print</a>
<p class="toc-caption">(bolded sections are more interesting)</p>
<p class="toc-toggle">toggle TOC (ctrl + &#8660;)</p>
</div><div class="block">
<h4><a href="https://github.com/LemonPi/data/blob/master/tree/interval_set.h">sal/data/tree/interval_set.h</a>
</h4><table class="pretty">
<tr><th><a class="doc-list-name" href="#Interval_augment">Interval_augment</a></th><th></th></tr>
<tr><td><a class="doc-list-name" href="#insert">insert</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#erase">erase</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#find">find</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#find_first">find_first</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#find_exact">find_exact</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#find_all">find_all</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#print">print</a></td><td></td></tr>
</table></div>



<h2 class="anchor doc-header">Interval_augment <a class="anchor-link" href="#Interval_augment" name="Interval_augment" title="permalink to section">&para;</a></h2>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Interval_augment() = default;
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





<h3 class="anchor doc-header">insert | <code class="qualifier">Interval_augment::</code>insert<a class="anchor-link" href="#insert" name="insert" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void insert(T low, T high);

void insert(Interval<T> interval);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>low</td><td></td></tr>
<tr><td>high</td><td></td></tr>
<tr><td>interval</td><td></td></tr>
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





<h3 class="anchor doc-header">erase | <code class="qualifier">Interval_augment::</code>erase<a class="anchor-link" href="#erase" name="erase" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void erase(T low, T high);

void erase(Interval<T> interval);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>low</td><td></td></tr>
<tr><td>high</td><td></td></tr>
<tr><td>interval</td><td></td></tr>
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





<h3 class="anchor doc-header">find | <code class="qualifier">Interval_augment::</code>find<a class="anchor-link" href="#find" name="find" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
iterator find(T low, T high);

iterator find(Interval<T> interval);

const_iterator find(T low, T high);

const_iterator find(Interval<T> interval);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>low</td><td></td></tr>
<tr><td>high</td><td></td></tr>
<tr><td>interval</td><td></td></tr>
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





<h3 class="anchor doc-header">find_first | <code class="qualifier">Interval_augment::</code>find_first<a class="anchor-link" href="#find_first" name="find_first" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
iterator find_first(T low, T high);

iterator find_first(Interval<T> interval);

const_iterator find_first(T low, T high);

const_iterator find_first(Interval<T> interval);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>low</td><td></td></tr>
<tr><td>high</td><td></td></tr>
<tr><td>interval</td><td></td></tr>
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





<h3 class="anchor doc-header">find_exact | <code class="qualifier">Interval_augment::</code>find_exact<a class="anchor-link" href="#find_exact" name="find_exact" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
iterator find_exact(T low, T high);

iterator find_exact(Interval<T> interval);

const_iterator find_exact(T low, T high);

const_iterator find_exact(Interval<T> interval);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>low</td><td></td></tr>
<tr><td>high</td><td></td></tr>
<tr><td>interval</td><td></td></tr>
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





<h3 class="anchor doc-header">find_all | <code class="qualifier">Interval_augment::</code>find_all<a class="anchor-link" href="#find_all" name="find_all" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
std::vector<NP> find_all(T low, T high);

std::vector<NP> find_all(Interval<T> interval);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>low</td><td></td></tr>
<tr><td>high</td><td></td></tr>
<tr><td>interval</td><td></td></tr>
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





<h3 class="anchor doc-header">print | <code class="qualifier">Interval_augment::</code>print<a class="anchor-link" href="#print" name="print" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
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





