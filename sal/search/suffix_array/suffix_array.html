---
layout: algorithms
title: Suffix array
permalink: /sal/search/suffix_array/index.html
section: search
classname: Suffix_array
---

<div class="block">
<table class="pretty">
<tr><th><a class="doc-list-name" href="#suffix_array">Suffix_array</a></th><th>efficient data structure for indexing large texts</th></tr>
<tr><td><a class="doc-list-name" href="#size">.size</a></td><td>give number of suffixes</td></tr>
<tr><td><a class="doc-list-name" href="#print">.print</a></td><td>summarize suffix array representation</td></tr>
<tr><td><a class="doc-list-name" href="#suffix">.suffix</a></td><td>give index of ith smallest suffix</td></tr>
<tr><td><a class="doc-list-name" href="#lcp">.common_prefix_len</a></td><td>give length of longest common prefix between adjacent suffixes</td></tr>
<tr><td><a class="doc-list-name" href="#occurrance">.occurrance</a></td><td>list positions in the original text where a substring occurred </td></tr>
</table>
</div>

<h3 class="anchor doc-header">Suffix array <a class="anchor-link" title="permalink to section" href="#suffix_array" name="suffix_array">&para;</a></h3>
<div class="block">
<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Sequence = std::string>
class Suffix_array;

// constructor
Suffix_array(const Sequence& text);
{% endhighlight %}

<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>text</td><td>A <b>non-temporary</b> text that the suffix array keeps a reference of; should not be modified
afterwards</td></tr>
</table>

<p class="doc-section">Example</p>

{% highlight c++ %}
std::ifstream text_file("mobydick.txt");
text_file.seekg(0, std::ios::end);
size_t size {text_file.tellg()};
std::string text(size, ' ');
// go back to beginning
text_file.seekg(0);
// read into string
text_file.read(&text[0], size); 

// index the file
sal::Suffix_array<> sa {text};
{% endhighlight %}

<p class="doc-section">Discussion</p>
<div class="text-block">
<p>
	The algorithm used for suffix array construction is currently suboptimal at <code>O(n(lgn)^2)</code> and
	could be improved to <code>O(n)</code>. For a more efficient (but much less readable) implementation,
	see <a href="https://sites.google.com/site/yuta256/sais">Yuta Mori's use of SAIS</a>.
</p>
<p>
	A suffix array is a very efficient data structure for indexing text for future searches.
	It allows for <code>O(lg(n))</code> queries on the number and position of substrings. 
	It is a recent (1990) invention as a space efficient alternative to suffix trees, which have
	the same applications. 
	Variations of suffix array are usually behind the convenient <code>ctrl+f</code> features in editors and browsers.
</p>
</div>
</div>





<h3 class="anchor doc-header">Number of suffixes | <code class="qualifier">{{page.classname}}::</code>size <a class="anchor-link" title="permalink to section" href="#size" name="size">&para;</a></h3>
<div class="block">
<p class="doc-section">Declaration</p>
{% highlight c++ %}
size_t size() const;
{% endhighlight %}

<p class="doc-section">Discussion</p>
<div class="text-block">
<p>
	The number of suffixes is equal to the length of the original text (new suffixs for each character).
</p>
</div>
</div>





<h3 class="anchor doc-header">Suffix array summarization | <code class="qualifier">{{page.classname}}::</code>print <a class="anchor-link" title="permalink to section" href="#print" name="print">&para;</a></h3>
<div class="block">
<p class="doc-section">Declaration</p>
{% highlight c++ %}
void print() const;
{% endhighlight %}

<p class="doc-section">Discussion</p>
<div class="text-block">
<p>
	Summarizes internal representation; for example with text="consternation":
</p>
</div>
```
    8-0: ation
    0-0: consternation
    5-0: ernation
   10-0: ion
   12-1: n
    7-1: nation
    2-0: nsternation
   11-2: on
    1-0: onsternation
    6-0: rnation
    3-0: sternation
    4-1: ternation
    9-0: tion
```
<div class="text-block">
<p>
	The suffixes are sorted by lexicographic (alphabetical) order.
	The first number is the starting index of the suffix in the original text.
	The second number is the common prefix length with the next ordered suffix,
	so "ternation" and "tion" both share 't' as a prefix.
</p>
</div>
</div>


<h3 class="anchor doc-header">Suffix array indices | <code class="qualifier">{{page.classname}}::</code>suffix <a class="anchor-link" title="permalink to section" href="#suffix" name="suffix">&para;</a></h3>
<div class="block">
<p class="doc-section">Declaration</p>
{% highlight c++ %}
size_t suffix(size_t ith_suffix) const;
{% endhighlight %}

<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>ith_suffix</td><td>lexicographic rank of suffix with 0 being the smallest</td></tr>
</table>

<p class="doc-section">Example</p>

{% highlight c++ %}
std::string text {"consternation"};
Suffix_array<> sa {text};

sa.suffix(2);
// 5 index in text that starts the suffix "ernation", 3rd smallest suffix
{% endhighlight %}

<p class="doc-section">Discussion</p>
<div class="text-block">
<p>
	Requires the original text to not have been modified.
	The actual suffix is the substring from the index returned to <code>text.end()</code>.
</p>
</div>
</div>


<h3 class="anchor doc-header">Longest common prefix | <code class="qualifier">{{page.classname}}::</code><code>common_prefix_len</code><a class="anchor-link" title="permalink to section" href="#lcp" name="lcp">&para;</a></h3>
<div class="block">
<p class="doc-section">Declaration</p>
{% highlight c++ %}
size_t common_prefix_len(size_t ith_suffix) const;
{% endhighlight %}

<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>ith_suffix</td><td>lexicographic rank of suffix with 0 being the smallest</td></tr>
</table>

<p class="doc-section">Example</p>

{% highlight c++ %}
// using same sa as above with text = "consternation"
sa.common_prefix_len(2);
// 0 shared suffix between "ernation" and "ion", 3rd and 4th smallest suffixes
{% endhighlight %}

<p class="doc-section">Discussion</p>
<div class="text-block">
<p>
	The function is a simple access to the LCP array, which is built right after the suffix array is built.
	This array enables a lot of applications to be efficient, such as search queries for occurrances.
</p>
</div>
</div>




<h3 class="anchor doc-header">All occurrances of substring | <code class="qualifier">{{page.classname}}::</code>occurrance <a class="anchor-link" title="permalink to section" href="#occurrance" name="occurrance">&para;</a></h3>
<div class="block">
<p class="doc-section">Declaration</p>
{% highlight c++ %}
std::vector<size_t> occurrance(const Sequence& target) const;
{% endhighlight %}

<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>target</td><td>substring to search for</td></tr>
</table>

<p class="doc-section">Example</p>

{% highlight c++ %}
std::ifstream text_file("mobydick.txt");
text_file.seekg(0, std::ios::end);
size_t size {text_file.tellg()};
std::string text(size, ' ');
// go back to beginning
text_file.seekg(0);
// read into string
text_file.read(&text[0], size); 

// index the file
sal::Suffix_array<> sa {text};
std::vector<size_t> whales {sa.occurrance("whales")};

whales.size();
// 1323 occurrances of the word "whale" 

for (size_t starting_location : whales) std::cout << starting_location << ' ';
// prints out all the starting indices of where "whale" occurs
{% endhighlight %}

<p class="doc-section">Discussion</p>
<div class="text-block">
<p>
	Basically performs the function of <code>ctrl+f</code> in text editors and browsers.
	It can do this in <code>O(lgn)</code> time since it is a single binary search followed
	by looking at following suffixes to see if they share a prefix as large as the target.
	An alternative without building the LCP is to use two binary searches to find the first
	and last occurrance of it and taking the difference.
</p>
</div>
</div>
