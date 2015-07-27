---
layout: algorithms
title: 
permalink: /sal/matrix/Matrix/index.html
section: matrix
classname: Matrix
---

<div class="toc">
	<a class="toc-link toch2" href="#Matrix">Matrix</a>
	<a class="toc-link toch3" href="#operator=">operator=</a>
	<a class="toc-link toch3" href="#row">row</a>
	<a class="toc-link toch3" href="#col">col</a>
	<a class="toc-link toch3" href="#resize_rows">resize_rows</a>
	<a class="toc-link toch3" href="#resize">resize</a>
	<a class="toc-link toch3" href="#get">get</a>
	<a class="toc-link toch3" href="#rotate">rotate</a>
	<a class="toc-link toch3" href="#clear_zero">clear_zero</a>
	<a class="toc-link toch3" href="#print">print</a>
	<a class="toc-link toch3" href="#row_op">row_op</a>
	<a class="toc-link toch3" href="#col_op">col_op</a>
	<a class="toc-link toch3" href="#row_sum">row_sum</a>
	<a class="toc-link toch3" href="#col_sum">col_sum</a>
	<a class="toc-link toch3" href="#row_prod">row_prod</a>
	<a class="toc-link toch3" href="#col_prod">col_prod</a>
	<a class="toc-link toch3" href="#operator*=">operator*=</a>
	<a class="toc-link toch3" href="#operator+=">operator+=</a>
	<a class="toc-link toch3" href="#operator-=">operator-=</a>
	<a class="toc-link toch3" href="#pow">pow</a>
	<a class="toc-link toch3" href="#operator==">operator==</a>
<p class="toc-caption">(bolded sections are more interesting)</p>
<p class="toc-toggle">toggle TOC (ctrl + &#8660;)</p>
</div><div class="block">
<h4><a href="https://github.com/LemonPi/data/blob/master/matrix.h">sal/data/matrix.h</a>
</h4><table class="pretty">
<tr><th><a class="doc-list-name" href="#Matrix">Matrix</a></th><th></th></tr>
<tr><td><a class="doc-list-name" href="#operator=">operator=</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#row">row</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#col">col</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#resize_rows">resize_rows</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#resize">resize</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#get">get</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#rotate">rotate</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#clear_zero">clear_zero</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#print">print</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#row_op">row_op</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#col_op">col_op</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#row_sum">row_sum</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#col_sum">col_sum</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#row_prod">row_prod</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#col_prod">col_prod</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator*=">operator*=</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator+=">operator+=</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator-=">operator-=</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#pow">pow</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator==">operator==</a></td><td></td></tr>
</table></div>



<h2 class="anchor doc-header">Matrix <a class="anchor-link" href="#Matrix" name="Matrix" title="permalink to section">&para;</a></h2>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Matrix();

Matrix(size_t r, size_t c, T d = 0);

Matrix(size_t r, size_t c, vector<T>&& e);

Matrix(const Matrix& a);

Matrix(Matrix&& a);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>r</td><td></td></tr>
<tr><td>c</td><td></td></tr>
<tr><td>d</td><td></td></tr>
<tr><td>e</td><td></td></tr>
<tr><td>a</td><td></td></tr>
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





<h3 class="anchor doc-header">operator= | <code class="qualifier">Matrix::</code>operator=<a class="anchor-link" href="#operator=" name="operator=" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Matrix<T>& operator=(const Matrix& a);

Matrix<T>& operator=(Matrix&& a);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>a</td><td></td></tr>
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





<h3 class="anchor doc-header">row | <code class="qualifier">Matrix::</code>row<a class="anchor-link" href="#row" name="row" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
size_t row() const;
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





<h3 class="anchor doc-header">col | <code class="qualifier">Matrix::</code>col<a class="anchor-link" href="#col" name="col" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
size_t col() const;
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





<h3 class="anchor doc-header">resize_rows | <code class="qualifier">Matrix::</code>resize_rows<a class="anchor-link" href="#resize_rows" name="resize_rows" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void resize_rows(size_t new_rows, T def = 0);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>new_rows</td><td></td></tr>
<tr><td>def</td><td></td></tr>
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





<h3 class="anchor doc-header">resize | <code class="qualifier">Matrix::</code>resize<a class="anchor-link" href="#resize" name="resize" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void resize(size_t new_rows, size_t new_cols, T def = 0);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>new_rows</td><td></td></tr>
<tr><td>new_cols</td><td></td></tr>
<tr><td>def</td><td></td></tr>
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





<h3 class="anchor doc-header">get | <code class="qualifier">Matrix::</code>get<a class="anchor-link" href="#get" name="get" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
T& get(size_t row, size_t col);

const T& get (size_t row, size_t col);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>row</td><td></td></tr>
<tr><td>col</td><td></td></tr>
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





<h3 class="anchor doc-header">rotate | <code class="qualifier">Matrix::</code>rotate<a class="anchor-link" href="#rotate" name="rotate" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void rotate();
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





<h3 class="anchor doc-header">clear_zero | <code class="qualifier">Matrix::</code>clear_zero<a class="anchor-link" href="#clear_zero" name="clear_zero" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void clear_zero();
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





<h3 class="anchor doc-header">print | <code class="qualifier">Matrix::</code>print<a class="anchor-link" href="#print" name="print" title="permalink to section">&para;</a></h3>
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





<h3 class="anchor doc-header">row_op | <code class="qualifier">Matrix::</code>row_op<a class="anchor-link" href="#row_op" name="row_op" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Op>
T row_op(size_t row, Op&& op, T res = 0);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>row</td><td></td></tr>
<tr><td>op</td><td></td></tr>
<tr><td>res</td><td></td></tr>
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





<h3 class="anchor doc-header">col_op | <code class="qualifier">Matrix::</code>col_op<a class="anchor-link" href="#col_op" name="col_op" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Op>
T col_op(size_t col, Op&& op, T res = 0);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>col</td><td></td></tr>
<tr><td>op</td><td></td></tr>
<tr><td>res</td><td></td></tr>
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





<h3 class="anchor doc-header">row_sum | <code class="qualifier">Matrix::</code>row_sum<a class="anchor-link" href="#row_sum" name="row_sum" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
T row_sum(size_t row);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
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





<h3 class="anchor doc-header">col_sum | <code class="qualifier">Matrix::</code>col_sum<a class="anchor-link" href="#col_sum" name="col_sum" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
T col_sum(size_t col);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>col</td><td></td></tr>
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





<h3 class="anchor doc-header">row_prod | <code class="qualifier">Matrix::</code>row_prod<a class="anchor-link" href="#row_prod" name="row_prod" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
T row_prod(size_t row);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
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





<h3 class="anchor doc-header">col_prod | <code class="qualifier">Matrix::</code>col_prod<a class="anchor-link" href="#col_prod" name="col_prod" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
T col_prod(size_t col);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>col</td><td></td></tr>
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





<h3 class="anchor doc-header">operator*= | <code class="qualifier">Matrix::</code>operator*=<a class="anchor-link" href="#operator*=" name="operator*=" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Matrix<T>& operator*=(T);

Matrix<T>& operator*=(const Matrix&);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>T</td><td></td></tr>
<tr><td>Matrix&</td><td></td></tr>
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





<h3 class="anchor doc-header">operator+= | <code class="qualifier">Matrix::</code>operator+=<a class="anchor-link" href="#operator+=" name="operator+=" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Matrix<T>& operator+=(const Matrix&);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>Matrix&</td><td></td></tr>
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





<h3 class="anchor doc-header">operator-= | <code class="qualifier">Matrix::</code>operator-=<a class="anchor-link" href="#operator-=" name="operator-=" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Matrix<T>& operator-=(const Matrix&);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>Matrix&</td><td></td></tr>
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





<h3 class="anchor doc-header">pow | <code class="qualifier">Matrix::</code>pow<a class="anchor-link" href="#pow" name="pow" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Matrix<T>& pow(size_t exponent);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>exponent</td><td></td></tr>
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





<h3 class="anchor doc-header">operator== | <code class="qualifier">Matrix::</code>operator==<a class="anchor-link" href="#operator==" name="operator==" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
bool operator==(const Matrix&);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>Matrix&</td><td></td></tr>
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





