---
layout: algorithms
title: 
permalink: /sal/tree/tree/Tree/index.html
section: tree/tree
classname: Tree
---

<div class="toc">
	<a class="toc-link toch3" href="#rotate_left">rotate_left</a>
	<a class="toc-link toch3" href="#rotate_right">rotate_right</a>
	<a class="toc-link toch3" href="#tree_insert">tree_insert</a>
	<a class="toc-link toch3" href="#rb_insert">rb_insert</a>
	<a class="toc-link toch3" href="#rb_insert_fixup">rb_insert_fixup</a>
	<a class="toc-link toch3" href="#rb_delete">rb_delete</a>
	<a class="toc-link toch3" href="#rb_delete_fixup">rb_delete_fixup</a>
	<a class="toc-link toch3" href="#transplant">transplant</a>
	<a class="toc-link toch3" href="#blackheight">blackheight</a>
	<a class="toc-link toch2" href="#Tree">Tree</a>
	<a class="toc-link toch3" href="#~Tree">~Tree</a>
	<a class="toc-link toch3" href="#insert">insert</a>
	<a class="toc-link toch3" href="#erase">erase</a>
	<a class="toc-link toch3" href="#find">find</a>
	<a class="toc-link toch3" href="#begin">begin</a>
	<a class="toc-link toch3" href="#end">end</a>
	<a class="toc-link toch3" href="#print">print</a>
	<a class="toc-link toch3" href="#valid">valid</a>
<p class="toc-caption">(bolded sections are more interesting)</p>
<p class="toc-toggle">toggle TOC (ctrl + &#8660;)</p>
</div><div class="block">
<h4><a href="https://github.com/LemonPi/data/blob/master/tree/tree.h">sal/data/tree/tree.h</a>
</h4><table class="pretty">
<tr><th><a class="doc-list-name" href="#Tree">Tree</a></th><th></th></tr>
<tr><td><a class="doc-list-name" href="#rotate_left">rotate_left</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#rotate_right">rotate_right</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#tree_insert">tree_insert</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#rb_insert">rb_insert</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#rb_insert_fixup">rb_insert_fixup</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#rb_delete">rb_delete</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#rb_delete_fixup">rb_delete_fixup</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#transplant">transplant</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#blackheight">blackheight</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#~Tree">~Tree</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#insert">insert</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#erase">erase</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#find">find</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#begin">begin</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#end">end</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#print">print</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#valid">valid</a></td><td></td></tr>
</table></div>



<h3 class="anchor doc-header">rotate_left | <code class="qualifier">Tree::</code>rotate_left<a class="anchor-link" href="#rotate_left" name="rotate_left" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
virtual void rotate_left(NP node);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
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





<h3 class="anchor doc-header">rotate_right | <code class="qualifier">Tree::</code>rotate_right<a class="anchor-link" href="#rotate_right" name="rotate_right" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
virtual void rotate_right(NP node);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
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





<h3 class="anchor doc-header">tree_insert | <code class="qualifier">Tree::</code>tree_insert<a class="anchor-link" href="#tree_insert" name="tree_insert" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
virtual void tree_insert(NP start, NP node);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>start</td><td></td></tr>
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





<h3 class="anchor doc-header">rb_insert | <code class="qualifier">Tree::</code>rb_insert<a class="anchor-link" href="#rb_insert" name="rb_insert" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void rb_insert(NP node);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
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





<h3 class="anchor doc-header">rb_insert_fixup | <code class="qualifier">Tree::</code>rb_insert_fixup<a class="anchor-link" href="#rb_insert_fixup" name="rb_insert_fixup" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void rb_insert_fixup(NP node);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
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





<h3 class="anchor doc-header">rb_delete | <code class="qualifier">Tree::</code>rb_delete<a class="anchor-link" href="#rb_delete" name="rb_delete" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
virtual void rb_delete(NP node);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
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





<h3 class="anchor doc-header">rb_delete_fixup | <code class="qualifier">Tree::</code>rb_delete_fixup<a class="anchor-link" href="#rb_delete_fixup" name="rb_delete_fixup" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void rb_delete_fixup(NP successor);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>successor</td><td></td></tr>
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





<h3 class="anchor doc-header">transplant | <code class="qualifier">Tree::</code>transplant<a class="anchor-link" href="#transplant" name="transplant" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void transplant(NP old, NP moved);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>old</td><td></td></tr>
<tr><td>moved</td><td></td></tr>
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





<h3 class="anchor doc-header">blackheight | <code class="qualifier">Tree::</code>blackheight<a class="anchor-link" href="#blackheight" name="blackheight" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
int blackheight(NP root);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>root</td><td></td></tr>
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





<h2 class="anchor doc-header">Tree <a class="anchor-link" href="#Tree" name="Tree" title="permalink to section">&para;</a></h2>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Tree() = default;
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





<h3 class="anchor doc-header">~Tree | <code class="qualifier">Tree::</code>~Tree<a class="anchor-link" href="#~Tree" name="~Tree" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
virtual ~Tree();
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





<h3 class="anchor doc-header">insert | <code class="qualifier">Tree::</code>insert<a class="anchor-link" href="#insert" name="insert" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void insert(T data);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>data</td><td></td></tr>
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





<h3 class="anchor doc-header">erase | <code class="qualifier">Tree::</code>erase<a class="anchor-link" href="#erase" name="erase" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void erase(T data);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>data</td><td></td></tr>
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





<h3 class="anchor doc-header">find | <code class="qualifier">Tree::</code>find<a class="anchor-link" href="#find" name="find" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
iterator find(T key);

const_iterator find(T key);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
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





<h3 class="anchor doc-header">begin | <code class="qualifier">Tree::</code>begin<a class="anchor-link" href="#begin" name="begin" title="permalink to section">&para;</a></h3>
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





<h3 class="anchor doc-header">end | <code class="qualifier">Tree::</code>end<a class="anchor-link" href="#end" name="end" title="permalink to section">&para;</a></h3>
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





<h3 class="anchor doc-header">print | <code class="qualifier">Tree::</code>print<a class="anchor-link" href="#print" name="print" title="permalink to section">&para;</a></h3>
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





<h3 class="anchor doc-header">valid | <code class="qualifier">Tree::</code>valid<a class="anchor-link" href="#valid" name="valid" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
int valid() const;
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





