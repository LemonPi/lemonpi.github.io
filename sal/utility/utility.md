---
layout: algorithms
title: 
permalink: /sal/utility/index.html
section: utility
---

<div class="toc">
	<a class="toc-link toch3" href="#print">print</a>
	<a class="toc-link toch3" href="#append">append</a>
	<a class="toc-link toch3" href="#tol">tol</a>
	<a class="toc-link toch3" href="#randgen">randgen</a>
	<a class="toc-link toch3" href="#randint">randint</a>
	<a class="toc-link toch3" href="#natrual">natrual</a>
	<a class="toc-link toch3" href="#perturb">perturb</a>
	<a class="toc-link toch3" href="#ftovec">ftovec</a>
	<a class="toc-link toch3" href="#rand_vlist">rand_vlist</a>
	<a class="toc-link toch3" href="#shuffled_vlist">shuffled_vlist</a>
	<a class="toc-link toch3" href="#ftostr">ftostr</a>
	<a class="toc-link toch3" href="#test_constexpr">test_constexpr</a>
<p class="toc-caption">(bolded sections are more interesting)</p>
<p class="toc-toggle">toggle TOC</p>
</div><div class="block">
<h4><a href="https://github.com/LemonPi/algo/blob/master/utility.h">sal/algo/utility.h</a>
</h4><table class="pretty">
<tr><td><a class="doc-list-name" href="#print">print</a></td><td></td>
</tr><tr><td><a class="doc-list-name" href="#append">append</a></td><td></td>
</tr><tr><td><a class="doc-list-name" href="#tol">tol</a></td><td></td>
</tr><tr><td><a class="doc-list-name" href="#randgen">randgen</a></td><td></td>
</tr><tr><td><a class="doc-list-name" href="#randint">randint</a></td><td></td>
</tr><tr><td><a class="doc-list-name" href="#natrual">natrual</a></td><td></td>
</tr><tr><td><a class="doc-list-name" href="#perturb">perturb</a></td><td></td>
</tr><tr><td><a class="doc-list-name" href="#ftovec">ftovec</a></td><td></td>
</tr><tr><td><a class="doc-list-name" href="#rand_vlist">rand_vlist</a></td><td></td>
</tr><tr><td><a class="doc-list-name" href="#shuffled_vlist">shuffled_vlist</a></td><td></td>
</tr><tr><td><a class="doc-list-name" href="#ftostr">ftostr</a></td><td></td>
</tr><tr><td><a class="doc-list-name" href="#test_constexpr">test_constexpr</a></td><td></td>
</tr>
</table></div>



<h3 class="anchor doc-header">print <a class="anchor-link" href="#print" name="print" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Iter>
void print(Iter begin, Iter end, std::ostream& os = std::cout);

template <typename Sequence>
void print(const Sequence& v, std::ostream& os = std::cout);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>begin</td><td></td></tr>
<tr><td>end</td><td></td></tr>
<tr><td>os</td><td></td></tr>
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





<h3 class="anchor doc-header">append <a class="anchor-link" href="#append" name="append" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Sequence>
void append(Sequence& a, const Sequence& b);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>a</td><td></td></tr>
<tr><td>b</td><td></td></tr>
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





<h3 class="anchor doc-header">tol <a class="anchor-link" href="#tol" name="tol" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
long tol(const char* s);

long tol(const std::string& s);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>s</td><td></td></tr>
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





<h3 class="anchor doc-header">randgen <a class="anchor-link" href="#randgen" name="randgen" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
std::vector<int> randgen(int min, int max, size_t num);

template <typename T>
std::vector<T> randgen(T min, T max, size_t num, int granularity);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>min</td><td></td></tr>
<tr><td>max</td><td></td></tr>
<tr><td>num</td><td></td></tr>
<tr><td>granularity</td><td></td></tr>
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





<h3 class="anchor doc-header">randint <a class="anchor-link" href="#randint" name="randint" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
int randint(int min, int max);

int randint(int max);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>min</td><td></td></tr>
<tr><td>max</td><td></td></tr>
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





<h3 class="anchor doc-header">natrual <a class="anchor-link" href="#natrual" name="natrual" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
int natrual();
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
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





<h3 class="anchor doc-header">perturb <a class="anchor-link" href="#perturb" name="perturb" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Iter>
void perturb(const Iter begin, const Iter end, size_t range);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>begin</td><td></td></tr>
<tr><td>end</td><td></td></tr>
<tr><td>range</td><td></td></tr>
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





<h3 class="anchor doc-header">ftovec <a class="anchor-link" href="#ftovec" name="ftovec" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename T>
vector_2d<T> ftovec(const std::string& name, int& n_line, int& w_line, int& range);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>name</td><td></td></tr>
<tr><td>n_line</td><td></td></tr>
<tr><td>w_line</td><td></td></tr>
<tr><td>range</td><td></td></tr>
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





<h3 class="anchor doc-header">rand_vlist <a class="anchor-link" href="#rand_vlist" name="rand_vlist" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename T>
vector_2d<T> rand_vlist(int l_num, int l_size, int r);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>l_num</td><td></td></tr>
<tr><td>l_size</td><td></td></tr>
<tr><td>r</td><td></td></tr>
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





<h3 class="anchor doc-header">shuffled_vlist <a class="anchor-link" href="#shuffled_vlist" name="shuffled_vlist" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename T>
vector_2d<T> shuffled_vlist(int l_num, int l_size, int r);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>l_num</td><td></td></tr>
<tr><td>l_size</td><td></td></tr>
<tr><td>r</td><td></td></tr>
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





<h3 class="anchor doc-header">ftostr <a class="anchor-link" href="#ftostr" name="ftostr" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
std::vector<std::string> ftostr(const std::string& name);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>name</td><td></td></tr>
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





<h3 class="anchor doc-header">test_constexpr <a class="anchor-link" href="#test_constexpr" name="test_constexpr" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename T, T x>
constexpr bool test_constexpr(bool print);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>print</td><td></td></tr>
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





