---
layout: algorithms
title: Permutations and Combinations
permalink: /projects/sal/perm/index.html
section: perm
---

#### [sal/algo/perm.h](https://github.com/LemonPi/algo/blob/master/perm.h)

<table class="pretty">
<tr><td><a class="doc-list-name" href="#perm">perm</a></td><td>indexed permutation of a sequence</td></tr>
<tr><td><a class="doc-list-name" href="#allperms">allperms</a></td><td>all permutations of a sequence</td></tr>
<tr><td><a class="doc-list-name" href="#allperms">allperms_distinct</a></td><td>all distinct permutations of a sequence</td></tr>
<tr><td><a class="doc-list-name" href="#combine">combine</a></td><td>all pairwise combinations using given operator</td></tr>
<tr><td><a class="doc-list-name" href="#count_combos">count_combos</a></td><td>number of ways to reach a sum given a set of values (change-making problem)</td></tr>
</table>





<h3 class="anchor doc-header">Permutation <a class="anchor-link" title="permalink to section" href="#perm" name="perm">&para;</a></h3>

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Indexable>
void perm(Indexable& s, unsigned long long k);
{% endhighlight %}

<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>s</td><td>any indexable sequence - <code>operator[]</code> is defined.</td></tr>
<tr><td>k</td><td>permutation index - from 0 to s.size()! - 1</td></tr>
</table>

<p class="doc-section">Example</p>

{% highlight c++ %}
std::string word {"Hello"};

perm(word, 0);

std::cout << word;
// word becomes "oHell"
{% endhighlight %}

<p class="doc-section">Discussion</p>
<div class="text-block">
<p>
	Perm modifies the sequence without returing. <code>Θ(s.size())</code> time complexity with no comparisons, 
	but the permutation indices do not correspond to any order. (for lexicographic ordered permutation,
	such as generating numbers in order, use <code>std::next_permutation</code> or <code>std::prev_permutation</code>). The algorithm has high parallelism as the interval [0,s.size()!-1] could be arbitrarily divided
	and run on separate cores.
</p>
</div>

<br>





<h3 class="anchor doc-header">All Permutations <a class="anchor-link" title="permalink to section" href="#allperms" name="allperms">&para;</a></h3>

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Indexable>
std::vector<Indexable> allperms(const Indexable& s);

template <typename Indexable>
std::set<Indexable> allperms_distinct(const Indexable& s);
{% endhighlight %}

<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>s</td><td>any indexable sequence - <code>operator[]</code> is defined.</td></tr>
</table>

<p class="doc-section">Example</p>

{% highlight c++ %}
std::string word {"Hello"};

allperms(words);
// vector<std::string> (120 permutations of "Hello")

allperms_distinct(words);
// set<std::string> (60 distinct permutations of "Hello")
{% endhighlight %}

<p class="doc-section">Discussion</p>
<div class="text-block">
<p>
	A simple wrapper for <a href="#perm"><code>perm</code></a> above; generating
	permutations and storing them in <code>std::vector</code> and <code>std::set</code> for distinct.
</p>
</div>

<br>




<h3 class="anchor doc-header">Combinations <a class="anchor-link" title="permalink to section" href="#combine" name="combine">&para;</a></h3>

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Iter, typename Op>
set<Iter_value<Iter>> combine(Iter start, Iter end, Op op);

template <typename Iter, typename Op, typename Pred>
set<Iter_value<Iter>> combine(Iter start, Iter end, Op op, Pred pred);

// overloads for containers
template <typename Container, typename Op>
set<typename Container::value_type> combine(Container& c, Op op);

template <typename Container, typename Op, typename Pred>
set<typename Container::value_type> combine(Container& c, Op op, Pred pred);
{% endhighlight %}

<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>op</td><td>callable object - <code>val operator()(val, val)</code> is defined</td></tr>
<tr><td>prep</td><td>filtering object - <code>bool operator()(val, val)</code> is defined to filter out combinations</td></tr>
</table>

<p class="doc-section">Example</p>

{% highlight c++ %}
std::vector<int> ints {1,2,3,4,5,6};

combine(ints, [](int a, int b){return a + b;});
// set<int> 2 3 4 5 6 7 8 9 10 11 12 handshake by adding

combine(ints,
	[](int a, int b){return a + b;},
	[](int a, int b){return (a & 1) && (b & 1);});
// set<int> 2 4 6 8 10 handshake by adding odd elements
{% endhighlight %}

<p class="doc-section">Discussion</p>
<div class="text-block">
<p>
	Functions taking iterators are generally more memory efficient and conforms to the 
	style of the C++ standard library. Note that the filtering predicate filters on
	the combination of 2 elements, which gives more freedom such as accepting when the first
	element is odd and second element is even.
</p>
</div>

<br>




<h3 class="anchor doc-header">Counting Combinations <a class="anchor-link" title="permalink to section" href="#count_combos" name="count_combos">&para;</a></h3>

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename T>
size_t count_combos(const vector<T>& vals, T sum);
{% endhighlight %}

<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>vals</td><td>sequence of usable values in ascending order of value</td></tr>
<tr><td>sum</td><td>target to reach by summing up elements of vals</td></tr>
</table>

<p class="doc-section">Example</p>

{% highlight c++ %}
std::vector<int> coins {1, 2, 5, 10, 20, 50, 100, 200};
count_combos(coins, 200);
// size_t 73682 (ways to sum up to 200 using coins)
{% endhighlight %}

<p class="doc-section">Discussion</p>
<div class="text-block">
<p>
	Dynamic programming is used with <code>O(vals.size() * sum)</code> work.
	The change-making problem is a classic situation to use this algorithm - 
	how many ways can you make a certain amount of change given certain coins (unlimited amount of each).
</p>
</div>

<br>