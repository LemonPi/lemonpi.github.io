---
layout: algorithms
title: Adjacency_list_directed
permalink: /sal/graph/adjacency_list/Adjacency_list_directed/index.html
section: graph
classname: Adjacency_list_directed
---

<div class="toc">
	<a class="toc-link toch2" href="#Adjacency_list_directed">Adjacency_list_directed</a>
	<a class="toc-link toch3" href="#num_edge">num_edge</a>
	<a class="toc-link toch3" href="#add_edge">add_edge</a>
<p class="toc-caption"></p>
<p class="toc-toggle">toggle TOC (ctrl + &#8660;)</p>
</div><div class="block">
<h4><a href="https://github.com/LemonPi/data/blob/master/graph/adjacency_list.h">sal/data/graph/adjacency_list.h</a>
</h4><table class="pretty">
<tr><th><a class="doc-list-name" href="#Adjacency_list_directed">Adjacency_list_directed</a></th><th></th></tr>
<tr><td><a class="doc-list-name" href="#num_edge">num_edge</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#add_edge">add_edge</a></td><td></td></tr>
</table></div>



<h2 class="anchor doc-header">Adjacency_list_directed <a class="anchor-link" href="#Adjacency_list_directed" name="Adjacency_list_directed" title="permalink to section">&para;</a></h2>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Adjacency_list_directed() = default;

Adjacency_list_directed(const std::initializer_list<WEdge<V,E>>& l);

Adjacency_list_directed(const std::initializer_list<UEdge<V>>& l);

template <typename Iter_edgelist>
Adjacency_list_directed(Iter_edgelist begin, const Iter_edgelist end);

Adjacency_list_directed(Adjacency_list_directed&& g);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>std::initializer_list<WEdge<V</td><td></td></tr>
<tr><td>l</td><td></td></tr>
<tr><td>begin</td><td></td></tr>
<tr><td>end</td><td></td></tr>
<tr><td>g</td><td></td></tr>
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





<h3 class="anchor doc-header">num_edge | <code class="qualifier">Adjacency_list_directed::</code>num_edge<a class="anchor-link" href="#num_edge" name="num_edge" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
size_t num_edge() const override;
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





<h3 class="anchor doc-header">add_edge | <code class="qualifier">Adjacency_list_directed::</code>add_edge<a class="anchor-link" href="#add_edge" name="add_edge" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void add_edge(V u, V v, E weight = 1);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>u</td><td></td></tr>
<tr><td>v</td><td></td></tr>
<tr><td>weight</td><td></td></tr>
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





