---
layout: algorithms
title: Matrix_adjacent_const_iterator
permalink: /sal/graph/adjacency_matrix/Matrix_adjacent_const_iterator/index.html
section: graph
classname: Matrix_adjacent_const_iterator
---

<div class="toc">
	<a class="toc-link toch2" href="#Matrix_adjacent_const_iterator">Matrix_adjacent_const_iterator</a>
	<a class="toc-link toch3" href="#operator++()">operator++()</a>
	<a class="toc-link toch3" href="#operator--()">operator--()</a>
	<a class="toc-link toch3" href="#operator*()">operator*()</a>
	<a class="toc-link toch3" href="#operator==">operator==</a>
	<a class="toc-link toch3" href="#operator!=">operator!=</a>
	<a class="toc-link toch3" href="#dest">dest</a>
	<a class="toc-link toch3" href="#weight">weight</a>
<p class="toc-caption"></p>
<p class="toc-toggle">toggle TOC (ctrl + &#8660;)</p>
</div><div class="block">
<h4><a href="https://github.com/LemonPi/data/blob/master/graph/adjacency_matrix.h">sal/data/graph/adjacency_matrix.h</a>
</h4><table class="pretty">
<tr><th><a class="doc-list-name" href="#Matrix_adjacent_const_iterator">Matrix_adjacent_const_iterator</a></th><th></th></tr>
<tr><td><a class="doc-list-name" href="#operator++()">operator++()</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator--()">operator--()</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator*()">operator*()</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator==">operator==</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator!=">operator!=</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#dest">dest</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#weight">weight</a></td><td></td></tr>
</table></div>



<h2 class="anchor doc-header">Matrix_adjacent_const_iterator <a class="anchor-link" href="#Matrix_adjacent_const_iterator" name="Matrix_adjacent_const_iterator" title="permalink to section">&para;</a></h2>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Matrix_adjacent_const_iterator() = default;

Matrix_adjacent_const_iterator(const Mat* m, size_t row);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>m</td><td></td></tr>
<tr><td>row</td><td></td></tr>
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





<h3 class="anchor doc-header">operator++() | <code class="qualifier">Matrix_adjacent_const_iterator::</code>operator++()<a class="anchor-link" href="#operator++()" name="operator++()" title="permalink to section">&para;</a></h3>
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





<h3 class="anchor doc-header">operator--() | <code class="qualifier">Matrix_adjacent_const_iterator::</code>operator--()<a class="anchor-link" href="#operator--()" name="operator--()" title="permalink to section">&para;</a></h3>
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





<h3 class="anchor doc-header">operator*() | <code class="qualifier">Matrix_adjacent_const_iterator::</code>operator*()<a class="anchor-link" href="#operator*()" name="operator*()" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
size_t operator*() const;
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





<h3 class="anchor doc-header">operator== | <code class="qualifier">Matrix_adjacent_const_iterator::</code>operator==<a class="anchor-link" href="#operator==" name="operator==" title="permalink to section">&para;</a></h3>
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





<h3 class="anchor doc-header">operator!= | <code class="qualifier">Matrix_adjacent_const_iterator::</code>operator!=<a class="anchor-link" href="#operator!=" name="operator!=" title="permalink to section">&para;</a></h3>
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





<h3 class="anchor doc-header">dest | <code class="qualifier">Matrix_adjacent_const_iterator::</code>dest<a class="anchor-link" href="#dest" name="dest" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
size_t dest() const;
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





<h3 class="anchor doc-header">weight | <code class="qualifier">Matrix_adjacent_const_iterator::</code>weight<a class="anchor-link" href="#weight" name="weight" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
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





