---
layout: algorithms
title: DFS_visitor
permalink: /sal/graph/search/DFS_visitor/index.html
section: graph
classname: DFS_visitor
---

<div class="toc">
	<a class="toc-link toch3" href="#initialize_vertex">initialize_vertex</a>
	<a class="toc-link toch3" href="#start_vertex">start_vertex</a>
	<a class="toc-link toch3" href="#discover_vertex">discover_vertex</a>
	<a class="toc-link toch3" href="#finish_vertex">finish_vertex</a>
	<a class="toc-link toch3" href="#back_edge">back_edge</a>
	<a class="toc-link toch3" href="#forward_or_cross_edge">forward_or_cross_edge</a>
<p class="toc-caption"></p>
<p class="toc-toggle">toggle TOC (ctrl + &#8660;)</p>
</div><div class="block">
<h4><a href="https://github.com/LemonPi/data/blob/master/graph/search.h">sal/data/graph/search.h</a>
</h4><table class="pretty">
<tr><th><a class="doc-list-name" href="#DFS_visitor">DFS_visitor</a></th><th></th></tr>
<tr><td><a class="doc-list-name" href="#initialize_vertex">initialize_vertex</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#start_vertex">start_vertex</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#discover_vertex">discover_vertex</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#finish_vertex">finish_vertex</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#back_edge">back_edge</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#forward_or_cross_edge">forward_or_cross_edge</a></td><td></td></tr>
</table></div>



<h3 class="anchor doc-header">initialize_vertex | <code class="qualifier">DFS_visitor::</code>initialize_vertex<a class="anchor-link" href="#initialize_vertex" name="initialize_vertex" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Property_map, typename Graph>
std::vector<typename Graph::vertex_type> initialize_vertex(Property_map& property, const Graph& g);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>property</td><td></td></tr>
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





<h3 class="anchor doc-header">start_vertex | <code class="qualifier">DFS_visitor::</code>start_vertex<a class="anchor-link" href="#start_vertex" name="start_vertex" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Graph>
void start_vertex(typename Graph::vertex_type, const Graph&);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>Graph::vertex_type</td><td></td></tr>
<tr><td>Graph&</td><td></td></tr>
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





<h3 class="anchor doc-header">discover_vertex | <code class="qualifier">DFS_visitor::</code>discover_vertex<a class="anchor-link" href="#discover_vertex" name="discover_vertex" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Graph>
void discover_vertex(typename Graph::vertex_type, const Graph&);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>Graph::vertex_type</td><td></td></tr>
<tr><td>Graph&</td><td></td></tr>
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





<h3 class="anchor doc-header">finish_vertex | <code class="qualifier">DFS_visitor::</code>finish_vertex<a class="anchor-link" href="#finish_vertex" name="finish_vertex" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Graph>
void finish_vertex(typename Graph::vertex_type, const Graph&);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>Graph::vertex_type</td><td></td></tr>
<tr><td>Graph&</td><td></td></tr>
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





<h3 class="anchor doc-header">back_edge | <code class="qualifier">DFS_visitor::</code>back_edge<a class="anchor-link" href="#back_edge" name="back_edge" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Graph>
void back_edge(typename Graph::vertex_type, const Graph&);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>Graph::vertex_type</td><td></td></tr>
<tr><td>Graph&</td><td></td></tr>
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





<h3 class="anchor doc-header">forward_or_cross_edge | <code class="qualifier">DFS_visitor::</code>forward_or_cross_edge<a class="anchor-link" href="#forward_or_cross_edge" name="forward_or_cross_edge" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Graph>
void forward_or_cross_edge(typename Graph::vertex_type, const Graph&);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>Graph::vertex_type</td><td></td></tr>
<tr><td>Graph&</td><td></td></tr>
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





