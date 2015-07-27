---
layout: algorithms
title: Adjacency_list
permalink: /sal/graph/adjacency_list/Adjacency_list/index.html
section: graph
classname: Adjacency_list
---

<div class="toc">
	<a class="toc-link toch2" href="#Adjacency_list">Adjacency_list</a>
	<a class="toc-link toch3" href="#num_vertex">num_vertex</a>
	<a class="toc-link toch3" href="#num_edge">num_edge</a>
	<a class="toc-link toch3" href="#is_vertex">is_vertex</a>
	<a class="toc-link toch3" href="#is_edge">is_edge</a>
	<a class="toc-link toch3" href="#weight">weight</a>
	<a class="toc-link toch3" href="#degree">degree</a>
	<a class="toc-link toch3" href="#vertex">vertex</a>
	<a class="toc-link toch3" href="#find">find</a>
	<a class="toc-link toch3" href="#begin">begin</a>
	<a class="toc-link toch3" href="#end">end</a>
	<a class="toc-link toch3" href="#rbegin">rbegin</a>
	<a class="toc-link toch3" href="#rend">rend</a>
	<a class="toc-link toch3" href="#min_vertex">min_vertex</a>
	<a class="toc-link toch3" href="#max_vertex">max_vertex</a>
	<a class="toc-link toch3" href="#add_vertex">add_vertex</a>
	<a class="toc-link toch3" href="#add_edge">add_edge</a>
<p class="toc-caption"></p>
<p class="toc-toggle">toggle TOC (ctrl + &#8660;)</p>
</div><div class="block">
<h4><a href="https://github.com/LemonPi/data/blob/master/graph/adjacency_list.h">sal/data/graph/adjacency_list.h</a>
</h4><table class="pretty">
<tr><th><a class="doc-list-name" href="#Adjacency_list">Adjacency_list</a></th><th></th></tr>
<tr><td><a class="doc-list-name" href="#num_vertex">num_vertex</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#num_edge">num_edge</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#is_vertex">is_vertex</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#is_edge">is_edge</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#weight">weight</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#degree">degree</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#vertex">vertex</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#find">find</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#begin">begin</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#end">end</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#rbegin">rbegin</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#rend">rend</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#min_vertex">min_vertex</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#max_vertex">max_vertex</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#add_vertex">add_vertex</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#add_edge">add_edge</a></td><td></td></tr>
</table></div>



<h2 class="anchor doc-header">Adjacency_list <a class="anchor-link" href="#Adjacency_list" name="Adjacency_list" title="permalink to section">&para;</a></h2>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Adjacency_list() = default;

Adjacency_list(const std::initializer_list<UEdge<V>>& l);

Adjacency_list(const std::initializer_list<WEdge<V,E>>& l);

template <typename Iter_edgelist>
Adjacency_list(Iter_edgelist begin, const Iter_edgelist end);

Adjacency_list(Adjacency_list&& g);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>l</td><td></td></tr>
<tr><td>std::initializer_list<WEdge<V</td><td></td></tr>
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





<h3 class="anchor doc-header">num_vertex | <code class="qualifier">Adjacency_list::</code>num_vertex<a class="anchor-link" href="#num_vertex" name="num_vertex" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
size_t num_vertex() const;
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





<h3 class="anchor doc-header">num_edge | <code class="qualifier">Adjacency_list::</code>num_edge<a class="anchor-link" href="#num_edge" name="num_edge" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
virtual size_t num_edge() const;
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





<h3 class="anchor doc-header">is_vertex | <code class="qualifier">Adjacency_list::</code>is_vertex<a class="anchor-link" href="#is_vertex" name="is_vertex" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
bool is_vertex(V v);
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





<h3 class="anchor doc-header">is_edge | <code class="qualifier">Adjacency_list::</code>is_edge<a class="anchor-link" href="#is_edge" name="is_edge" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
bool is_edge(V u, V v);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>u</td><td></td></tr>
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





<h3 class="anchor doc-header">weight | <code class="qualifier">Adjacency_list::</code>weight<a class="anchor-link" href="#weight" name="weight" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
E weight(V u, V v);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>u</td><td></td></tr>
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





<h3 class="anchor doc-header">degree | <code class="qualifier">Adjacency_list::</code>degree<a class="anchor-link" href="#degree" name="degree" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
size_t degree(V v);
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





<h3 class="anchor doc-header">vertex | <code class="qualifier">Adjacency_list::</code>vertex<a class="anchor-link" href="#vertex" name="vertex" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
iterator vertex(V v);

const_iterator vertex(V v);
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





<h3 class="anchor doc-header">find | <code class="qualifier">Adjacency_list::</code>find<a class="anchor-link" href="#find" name="find" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
iterator find(V v);

const_iterator find(V v);
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





<h3 class="anchor doc-header">begin | <code class="qualifier">Adjacency_list::</code>begin<a class="anchor-link" href="#begin" name="begin" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
iterator begin();

const_iterator begin() const;
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





<h3 class="anchor doc-header">end | <code class="qualifier">Adjacency_list::</code>end<a class="anchor-link" href="#end" name="end" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
iterator end();

const_iterator end() const;
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





<h3 class="anchor doc-header">rbegin | <code class="qualifier">Adjacency_list::</code>rbegin<a class="anchor-link" href="#rbegin" name="rbegin" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
reverse_iterator rbegin();

const_reverse_iterator rbegin() const;
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





<h3 class="anchor doc-header">rend | <code class="qualifier">Adjacency_list::</code>rend<a class="anchor-link" href="#rend" name="rend" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
reverse_iterator rend();

const_reverse_iterator rend() const;
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





<h3 class="anchor doc-header">min_vertex | <code class="qualifier">Adjacency_list::</code>min_vertex<a class="anchor-link" href="#min_vertex" name="min_vertex" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
V min_vertex() const;
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





<h3 class="anchor doc-header">max_vertex | <code class="qualifier">Adjacency_list::</code>max_vertex<a class="anchor-link" href="#max_vertex" name="max_vertex" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
V max_vertex() const;
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





<h3 class="anchor doc-header">add_vertex | <code class="qualifier">Adjacency_list::</code>add_vertex<a class="anchor-link" href="#add_vertex" name="add_vertex" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void add_vertex(V v);
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





<h3 class="anchor doc-header">add_edge | <code class="qualifier">Adjacency_list::</code>add_edge<a class="anchor-link" href="#add_edge" name="add_edge" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
virtual void add_edge(V u, V v, E weight = 1);
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





