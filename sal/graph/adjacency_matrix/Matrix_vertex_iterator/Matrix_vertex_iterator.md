---
layout: algorithms
title: 
permalink: /sal/graph/adjacency_matrix/Matrix_vertex_iterator/index.html
section: graph/adjacency_matrix
classname: Matrix_vertex_iterator
---

<div class="toc">
	<a class="toc-link toch3" href="#operator++()">operator++()</a>
	<a class="toc-link toch3" href="#operator--()">operator--()</a>
	<a class="toc-link toch3" href="#operator+">operator+</a>
	<a class="toc-link toch3" href="#operator-">operator-</a>
	<a class="toc-link toch3" href="#operator*()">operator*()</a>
	<a class="toc-link toch3" href="#operator==">operator==</a>
	<a class="toc-link toch3" href="#operator!=">operator!=</a>
	<a class="toc-link toch3" href="#edge">edge</a>
	<a class="toc-link toch3" href="#begin">begin</a>
	<a class="toc-link toch3" href="#end">end</a>
<p class="toc-caption">(bolded sections are more interesting)</p>
<p class="toc-toggle">toggle TOC (ctrl + &#8660;)</p>
</div><div class="block">
<h4><a href="https://github.com/LemonPi/data/blob/master/graph/adjacency_matrix.h">sal/data/graph/adjacency_matrix.h</a>
</h4><table class="pretty">
<tr><th><a class="doc-list-name" href="#Matrix_vertex_iterator">Matrix_vertex_iterator</a></th><th></th></tr>
<tr><td><a class="doc-list-name" href="#operator++()">operator++()</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator--()">operator--()</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator+">operator+</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator-">operator-</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator*()">operator*()</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator==">operator==</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator!=">operator!=</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#edge">edge</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#begin">begin</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#end">end</a></td><td></td></tr>
</table></div>



<h3 class="anchor doc-header">operator++() | <code class="qualifier">Matrix_vertex_iterator::</code>operator++()<a class="anchor-link" href="#operator++()" name="operator++()" title="permalink to section">&para;</a></h3>
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





<h3 class="anchor doc-header">operator--() | <code class="qualifier">Matrix_vertex_iterator::</code>operator--()<a class="anchor-link" href="#operator--()" name="operator--()" title="permalink to section">&para;</a></h3>
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





<h3 class="anchor doc-header">operator+ | <code class="qualifier">Matrix_vertex_iterator::</code>operator+<a class="anchor-link" href="#operator+" name="operator+" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
CR operator+(int scalar);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>scalar</td><td></td></tr>
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





<h3 class="anchor doc-header">operator- | <code class="qualifier">Matrix_vertex_iterator::</code>operator-<a class="anchor-link" href="#operator-" name="operator-" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
CR operator-(int scalar);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>scalar</td><td></td></tr>
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





<h3 class="anchor doc-header">operator*() | <code class="qualifier">Matrix_vertex_iterator::</code>operator*()<a class="anchor-link" href="#operator*()" name="operator*()" title="permalink to section">&para;</a></h3>
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





<h3 class="anchor doc-header">operator== | <code class="qualifier">Matrix_vertex_iterator::</code>operator==<a class="anchor-link" href="#operator==" name="operator==" title="permalink to section">&para;</a></h3>
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





<h3 class="anchor doc-header">operator!= | <code class="qualifier">Matrix_vertex_iterator::</code>operator!=<a class="anchor-link" href="#operator!=" name="operator!=" title="permalink to section">&para;</a></h3>
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





<h3 class="anchor doc-header">edge | <code class="qualifier">Matrix_vertex_iterator::</code>edge<a class="anchor-link" href="#edge" name="edge" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
E& edge(size_t v);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>v</td><td></td></tr>
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





<h3 class="anchor doc-header">begin | <code class="qualifier">Matrix_vertex_iterator::</code>begin<a class="anchor-link" href="#begin" name="begin" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
adjacent_iterator begin();
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





<h3 class="anchor doc-header">end | <code class="qualifier">Matrix_vertex_iterator::</code>end<a class="anchor-link" href="#end" name="end" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
adjacent_iterator end();
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





