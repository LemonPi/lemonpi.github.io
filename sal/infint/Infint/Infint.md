---
layout: algorithms
title: Infint
permalink: /sal/infint/Infint/index.html
section: infint
classname: Infint
---

<div class="toc">
	<a class="toc-link toch2" href="#Infint">Infint</a>
	<a class="toc-link toch3" href="#operator=">operator=</a>
	<a class="toc-link toch3" href="#operator++()">operator++()</a>
	<a class="toc-link toch3" href="#operator--()">operator--()</a>
	<a class="toc-link toch3" href="#operator++">operator++</a>
	<a class="toc-link toch3" href="#operator--">operator--</a>
	<a class="toc-link toch3" href="#operator+=">operator+=</a>
	<a class="toc-link toch3" href="#operator-=">operator-=</a>
	<a class="toc-link toch3" href="#operator*=">operator*=</a>
	<a class="toc-link toch3" href="#operator/=">operator/=</a>
	<a class="toc-link toch3" href="#operator%=">operator%=</a>
	<a class="toc-link toch3" href="#operator-()">operator-()</a>
	<a class="toc-link toch3" href="#operator+">operator+</a>
	<a class="toc-link toch3" href="#operator-">operator-</a>
	<a class="toc-link toch3" href="#operator*">operator*</a>
	<a class="toc-link toch3" href="#operator/">operator/</a>
	<a class="toc-link toch3" href="#operator%">operator%</a>
	<a class="toc-link toch3" href="#operator==">operator==</a>
	<a class="toc-link toch3" href="#operator!=">operator!=</a>
	<a class="toc-link toch3" href="#operator<">operator<</a>
	<a class="toc-link toch3" href="#operator<=">operator<=</a>
	<a class="toc-link toch3" href="#operator>">operator></a>
	<a class="toc-link toch3" href="#operator>=">operator>=</a>
	<a class="toc-link toch3" href="#isqrt">isqrt</a>
	<a class="toc-link toch3" href="#digit">digit</a>
	<a class="toc-link toch3" href="#digit_num">digit_num</a>
	<a class="toc-link toch3" href="#size">size</a>
	<a class="toc-link toch3" href="#str">str</a>
	<a class="toc-link toch3" href="#toInt">toInt</a>
	<a class="toc-link toch3" href="#toLong">toLong</a>
	<a class="toc-link toch3" href="#toLongLong">toLongLong</a>
<p class="toc-caption"></p>
<p class="toc-toggle">toggle TOC (ctrl + &#8660;)</p>
</div><div class="block">
<h4><a href="https://github.com/LemonPi/data/blob/master/infint.h">sal/data/infint.h</a>
</h4><table class="pretty">
<tr><th><a class="doc-list-name" href="#Infint">Infint</a></th><th></th></tr>
<tr><td><a class="doc-list-name" href="#operator=">operator=</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator++()">operator++()</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator--()">operator--()</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator++">operator++</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator--">operator--</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator+=">operator+=</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator-=">operator-=</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator*=">operator*=</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator/=">operator/=</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator%=">operator%=</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator-()">operator-()</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator+">operator+</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator-">operator-</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator*">operator*</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator/">operator/</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator%">operator%</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator==">operator==</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator!=">operator!=</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator<">operator<</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator<=">operator<=</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator>">operator></a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#operator>=">operator>=</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#isqrt">isqrt</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#digit">digit</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#digit_num">digit_num</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#size">size</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#str">str</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#toInt">toInt</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#toLong">toLong</a></td><td></td></tr>
<tr><td><a class="doc-list-name" href="#toLongLong">toLongLong</a></td><td></td></tr>
</table></div>



<h2 class="anchor doc-header">Infint <a class="anchor-link" href="#Infint" name="Infint" title="permalink to section">&para;</a></h2>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Infint(const char* c);

Infint(const std::string& s);

Infint(int l);

Infint(long l);

Infint(long long l);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>c</td><td></td></tr>
<tr><td>s</td><td></td></tr>
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





<h3 class="anchor doc-header">operator= | <code class="qualifier">Infint::</code>operator=<a class="anchor-link" href="#operator=" name="operator=" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
const Infint& operator=(const char* c);

const Infint& operator=(const std::string& s);

const Infint& operator=(int l);

const Infint& operator=(long l);

const Infint& operator=(long long l);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>c</td><td></td></tr>
<tr><td>s</td><td></td></tr>
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





<h3 class="anchor doc-header">operator++() | <code class="qualifier">Infint::</code>operator++()<a class="anchor-link" href="#operator++()" name="operator++()" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
const Infint& operator++();
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





<h3 class="anchor doc-header">operator--() | <code class="qualifier">Infint::</code>operator--()<a class="anchor-link" href="#operator--()" name="operator--()" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
const Infint& operator--();
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





<h3 class="anchor doc-header">operator++ | <code class="qualifier">Infint::</code>operator++<a class="anchor-link" href="#operator++" name="operator++" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Infint operator++(int);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>int</td><td></td></tr>
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





<h3 class="anchor doc-header">operator-- | <code class="qualifier">Infint::</code>operator--<a class="anchor-link" href="#operator--" name="operator--" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Infint operator--(int);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>int</td><td></td></tr>
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





<h3 class="anchor doc-header">operator+= | <code class="qualifier">Infint::</code>operator+=<a class="anchor-link" href="#operator+=" name="operator+=" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
const Infint& operator+=(const Infint& rhs);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>rhs</td><td></td></tr>
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





<h3 class="anchor doc-header">operator-= | <code class="qualifier">Infint::</code>operator-=<a class="anchor-link" href="#operator-=" name="operator-=" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
const Infint& operator-=(const Infint& rhs);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>rhs</td><td></td></tr>
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





<h3 class="anchor doc-header">operator*= | <code class="qualifier">Infint::</code>operator*=<a class="anchor-link" href="#operator*=" name="operator*=" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
const Infint& operator*=(const Infint& rhs);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>rhs</td><td></td></tr>
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





<h3 class="anchor doc-header">operator/= | <code class="qualifier">Infint::</code>operator/=<a class="anchor-link" href="#operator/=" name="operator/=" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
const Infint& operator/=(const Infint& rhs);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>rhs</td><td></td></tr>
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





<h3 class="anchor doc-header">operator%= | <code class="qualifier">Infint::</code>operator%=<a class="anchor-link" href="#operator%=" name="operator%=" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
const Infint& operator%=(const Infint& rhs);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>rhs</td><td></td></tr>
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





<h3 class="anchor doc-header">operator-() | <code class="qualifier">Infint::</code>operator-()<a class="anchor-link" href="#operator-()" name="operator-()" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Infint operator-() const;
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





<h3 class="anchor doc-header">operator+ | <code class="qualifier">Infint::</code>operator+<a class="anchor-link" href="#operator+" name="operator+" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Infint operator+(const Infint& rhs);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>rhs</td><td></td></tr>
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





<h3 class="anchor doc-header">operator- | <code class="qualifier">Infint::</code>operator-<a class="anchor-link" href="#operator-" name="operator-" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Infint operator-(const Infint& rhs);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>rhs</td><td></td></tr>
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





<h3 class="anchor doc-header">operator* | <code class="qualifier">Infint::</code>operator*<a class="anchor-link" href="#operator*" name="operator*" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Infint operator*(const Infint& rhs);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>rhs</td><td></td></tr>
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





<h3 class="anchor doc-header">operator/ | <code class="qualifier">Infint::</code>operator/<a class="anchor-link" href="#operator/" name="operator/" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Infint operator/(const Infint& rhs);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>rhs</td><td></td></tr>
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





<h3 class="anchor doc-header">operator% | <code class="qualifier">Infint::</code>operator%<a class="anchor-link" href="#operator%" name="operator%" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Infint operator%(const Infint& rhs);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>rhs</td><td></td></tr>
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





<h3 class="anchor doc-header">operator== | <code class="qualifier">Infint::</code>operator==<a class="anchor-link" href="#operator==" name="operator==" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
bool operator==(const Infint& rhs);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>rhs</td><td></td></tr>
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





<h3 class="anchor doc-header">operator!= | <code class="qualifier">Infint::</code>operator!=<a class="anchor-link" href="#operator!=" name="operator!=" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
bool operator!=(const Infint& rhs);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>rhs</td><td></td></tr>
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





<h3 class="anchor doc-header">operator< | <code class="qualifier">Infint::</code>operator<<a class="anchor-link" href="#operator<" name="operator<" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
bool operator<(const Infint& rhs);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>rhs</td><td></td></tr>
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





<h3 class="anchor doc-header">operator<= | <code class="qualifier">Infint::</code>operator<=<a class="anchor-link" href="#operator<=" name="operator<=" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
bool operator<=(const Infint& rhs);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>rhs</td><td></td></tr>
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





<h3 class="anchor doc-header">operator> | <code class="qualifier">Infint::</code>operator><a class="anchor-link" href="#operator>" name="operator>" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
bool operator>(const Infint& rhs);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>rhs</td><td></td></tr>
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





<h3 class="anchor doc-header">operator>= | <code class="qualifier">Infint::</code>operator>=<a class="anchor-link" href="#operator>=" name="operator>=" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
bool operator>=(const Infint& rhs);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>rhs</td><td></td></tr>
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





<h3 class="anchor doc-header">isqrt | <code class="qualifier">Infint::</code>isqrt<a class="anchor-link" href="#isqrt" name="isqrt" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
Infint isqrt() const;
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





<h3 class="anchor doc-header">digit | <code class="qualifier">Infint::</code>digit<a class="anchor-link" href="#digit" name="digit" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
char digit(size_t i);
{% endhighlight %}


<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>i</td><td></td></tr>
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





<h3 class="anchor doc-header">digit_num | <code class="qualifier">Infint::</code>digit_num<a class="anchor-link" href="#digit_num" name="digit_num" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
size_t digit_num() const;
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





<h3 class="anchor doc-header">size | <code class="qualifier">Infint::</code>size<a class="anchor-link" href="#size" name="size" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
size_t size() const;
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





<h3 class="anchor doc-header">str | <code class="qualifier">Infint::</code>str<a class="anchor-link" href="#str" name="str" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
std::string str() const;
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





<h3 class="anchor doc-header">toInt | <code class="qualifier">Infint::</code>toInt<a class="anchor-link" href="#toInt" name="toInt" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
int toInt() const;
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





<h3 class="anchor doc-header">toLong | <code class="qualifier">Infint::</code>toLong<a class="anchor-link" href="#toLong" name="toLong" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
long toLong() const;
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





<h3 class="anchor doc-header">toLongLong | <code class="qualifier">Infint::</code>toLongLong<a class="anchor-link" href="#toLongLong" name="toLongLong" title="permalink to section">&para;</a></h3>
<div class="block">

<p class="doc-section">Declaration</p>
{% highlight c++ %}
long long toLongLong() const;
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





