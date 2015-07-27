---
layout: algorithms
title: 
permalink: /sal/tree/tree/index.html
section: tree
---

<div class="toc">
	<a class="toc-link toch3" href="#tree_find">tree_find</a>
	<a class="toc-link toch3" href="#tree_min">tree_min</a>
	<a class="toc-link toch3" href="#tree_max">tree_max</a>
	<a class="toc-link toch3" href="#tree_successor">tree_successor</a>
	<a class="toc-link toch3" href="#tree_predecessor">tree_predecessor</a>
	<a class="toc-link toch3" href="#preorder_walk">preorder_walk</a>
	<a class="toc-link toch3" href="#inorder_walk">inorder_walk</a>
	<a class="toc-link toch3" href="#postorder_walk">postorder_walk</a>
<p class="toc-caption"></p>
<p class="toc-toggle">toggle TOC (ctrl + &#8660;)</p>
</div><div class="block">
<h4><a href="https://github.com/LemonPi/data/blob/master/tree/tree.h">sal/data/tree/tree.h</a>
</h4><table class="pretty">
<tr><td><a class="doc-list-name" href="#tree_find">tree_find</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#tree_min">tree_min</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#tree_max">tree_max</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#tree_successor">tree_successor</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#tree_predecessor">tree_predecessor</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#preorder_walk">preorder_walk</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#inorder_walk">inorder_walk</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#postorder_walk">postorder_walk</a></td><td></td></tr>

<tr><th><a class="doc-list-name" href="Tree_adj_iterator">Tree_adj_iterator</a></th><th></th></tr>
<tr><th><a class="doc-list-name" href="Tree_adj_const_iterator">Tree_adj_const_iterator</a></th><th></th></tr>
<tr><th><a class="doc-list-name" href="Tree_iterator">Tree_iterator</a></th><th></th></tr>
<tr><th><a class="doc-list-name" href="Tree_const_iterator">Tree_const_iterator</a></th><th></th></tr>
<tr><th><a class="doc-list-name" href="Tree">Tree</a></th><th></th></tr>
<tr><th><a class="doc-list-name" href="Basic_node">Basic_node</a></th><th></th></tr>

</table></div>



<h3 class="anchor doc-header">tree_find <a class="anchor-link" href="#tree_find" name="tree_find" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Node>
Node* tree_find(Node* start, typename Node::key_type key);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>start</td><td></td></tr>
<tr><td>key</td><td></td></tr>
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





<h3 class="anchor doc-header">tree_min <a class="anchor-link" href="#tree_min" name="tree_min" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Node>
Node* tree_min(Node* start);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>start</td><td></td></tr>
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





<h3 class="anchor doc-header">tree_max <a class="anchor-link" href="#tree_max" name="tree_max" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Node>
Node* tree_max(Node* start);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>start</td><td></td></tr>
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





<h3 class="anchor doc-header">tree_successor <a class="anchor-link" href="#tree_successor" name="tree_successor" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Node>
Node* tree_successor(Node* start);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>start</td><td></td></tr>
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





<h3 class="anchor doc-header">tree_predecessor <a class="anchor-link" href="#tree_predecessor" name="tree_predecessor" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Node>
Node* tree_predecessor(Node* start);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>start</td><td></td></tr>
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





<h3 class="anchor doc-header">preorder_walk <a class="anchor-link" href="#preorder_walk" name="preorder_walk" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Node, typename Op>
void preorder_walk(Node* start, Op op);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>start</td><td></td></tr>
<tr><td>op</td><td></td></tr>
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





<h3 class="anchor doc-header">inorder_walk <a class="anchor-link" href="#inorder_walk" name="inorder_walk" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Node, typename Op>
void inorder_walk(Node* start, Op op);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>start</td><td></td></tr>
<tr><td>op</td><td></td></tr>
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





<h3 class="anchor doc-header">postorder_walk <a class="anchor-link" href="#postorder_walk" name="postorder_walk" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Node, typename Op>
void postorder_walk(Node* start, Op op);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>start</td><td></td></tr>
<tr><td>op</td><td></td></tr>
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





