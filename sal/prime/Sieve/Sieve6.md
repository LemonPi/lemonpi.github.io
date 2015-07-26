---
layout: algorithms
title: 
permalink: /sal/prime/Sieve/index.html
section: prime
classname: Sieve
---

<div class="toc">
	<a class="toc-link toch2" href="#Sieve">Sieve</a>
	<a class="toc-link toch3" href="#set_limit">set_limit </a>
	<a class="toc-link toch3" href="#next_prime">next_prime </a>
	<a class="toc-link toch3" href="#closest_prime">closest_prime </a>
	<a class="toc-link toch3" href="#nth_prime">nth_prime </a>
	<a class="toc-link toch3" href="#cur_prime">cur_prime </a>
	<a class="toc-link toch3" href="#primes_upto">primes_upto </a>
	<a class="toc-link toch3" href="#count">count </a>
	<a class="toc-link toch3" href="#is_prime">is_prime </a>
<p class="toc-caption">(bolded sections are more interesting)</p>
<p class="toc-toggle">toggle TOC</p>
</div><div class="block">
<h4><a href="https://github.com/LemonPi/algo/blob/master/prime.h">sal/algo/prime.h</a>
</h4><table class="pretty">
<tr><th><a class="doc-list-name" href="#Sieve">Sieve</a></th><th></th></tr>
<tr><td><a class="doc-list-name" href="#set_limit">set_limit</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#next_prime">next_prime</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#closest_prime">closest_prime</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#nth_prime">nth_prime</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#cur_prime">cur_prime</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#primes_upto">primes_upto</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#count">count</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#is_prime">is_prime</a></td><td></td></tr>
</table></div>



<h2 class="anchor doc-header">Sieve <a class="anchor-link" href="#Sieve" name="Sieve" title="permalink to section">&para;</a></h2>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Sieve(big_int init_limit = 0, size_t seg_size = L1D_CACHE_SIZE);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>init_limit</td><td></td></tr>
<tr><td>seg_size</td><td></td></tr>
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





<h3 class="anchor doc-header">set_limit | <code class="qualifier">Sieve::</code>set_limit<a class="anchor-link" href="#set_limit" name="set_limit" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
void set_limit(big_int l);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>l</td><td></td></tr>
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





<h3 class="anchor doc-header">next_prime | <code class="qualifier">Sieve::</code>next_prime<a class="anchor-link" href="#next_prime" name="next_prime" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
big_int next_prime();

big_int next_prime(big_int guess);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>guess</td><td></td></tr>
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





<h3 class="anchor doc-header">closest_prime | <code class="qualifier">Sieve::</code>closest_prime<a class="anchor-link" href="#closest_prime" name="closest_prime" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
big_int closest_prime(big_int guess);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>guess</td><td></td></tr>
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





<h3 class="anchor doc-header">nth_prime | <code class="qualifier">Sieve::</code>nth_prime<a class="anchor-link" href="#nth_prime" name="nth_prime" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
big_int nth_prime(big_int nth);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>nth</td><td></td></tr>
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





<h3 class="anchor doc-header">cur_prime | <code class="qualifier">Sieve::</code>cur_prime<a class="anchor-link" href="#cur_prime" name="cur_prime" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
big_int cur_prime() const;
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





<h3 class="anchor doc-header">primes_upto | <code class="qualifier">Sieve::</code>primes_upto<a class="anchor-link" href="#primes_upto" name="primes_upto" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
const std::vector<big_int>& primes_upto(big_int l);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>l</td><td></td></tr>
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





<h3 class="anchor doc-header">count | <code class="qualifier">Sieve::</code>count<a class="anchor-link" href="#count" name="count" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
size_t count();

size_t count(big_int upper);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>upper</td><td></td></tr>
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





<h3 class="anchor doc-header">is_prime | <code class="qualifier">Sieve::</code>is_prime<a class="anchor-link" href="#is_prime" name="is_prime" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
bool is_prime(big_int guess);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>guess</td><td></td></tr>
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





