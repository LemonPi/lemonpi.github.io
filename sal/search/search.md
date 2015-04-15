---
layout: algorithms
title: Searches and Matching
permalink: /sal/search/index.html
section: search
---

#### [sal/algo/search.h](https://github.com/LemonPi/algo/blob/master/search.h)

<table class="pretty">
<tr><td><a class="doc-list-name" href="#bin_search">bin_search</a></td><td>binary search on ordered sequence</td></tr>
<tr><td><a class="doc-list-name" href="#intersection">intersection</a></td><td>set of common elements among a set of sets</td></tr>
<tr><td><a class="doc-list-name" href="#select">select</a></td><td>order selection of ith smallest element from unsorted sequence</td></tr>
<tr><td><a class="doc-list-name" href="#sub_match">sub_match</a></td><td>search for occurance of a substring inside a larger string</td></tr>
<tr><td><a class="doc-list-name" href="#lc_subseq">lc_subseq</a></td><td>longest common subsequence between 2 sequences</td></tr>
<tr><td><a class="doc-list-name" href="#lc_subseq">lc_subseq_len</a></td><td>length of longest common subsequence between 2 sequences</td></tr>
<tr><th><a class="doc-list-name" href="#suffix_array">Suffix_array</a></th><th>efficient data structure for finding common substrings</th></tr>
<tr><td><a class="doc-list-name" href="#lc_substr">.lc_substr</a></td><td>longest common substring</td></tr>
</table>





<h3 class="anchor doc-header">Binary search <a class="anchor-link" title="permalink to section" href="#bin_search" name="bin_search">&para;</a></h3><br><br><br>

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Iter, typename T, typename Cmp>  // special comparator requires less and eq methods, can compare cross types
Iter bin_search(Iter begin, Iter end, const T& key, Cmp cmp);

// no given comparator overload uses std::less
template <typename Iter, typename T>
Iter bin_search(Iter begin, Iter end, const T& key);

// convenience overload for containers
template <typename Sequence, typename T>
typename Sequence::iterator bin_search(const Sequence& c, const T& key);
{% endhighlight %}

<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>begin</td><td>iterator pointing to the first sequence element</td></tr>
<tr><td>end</td><td>iterator pointing to one past the last sequence element</td></tr>
<tr><td>key</td><td>value to find; should be an argument to <code>cmp.eq</code> and <code>cmp.less</code></td></tr>
<tr><td>cmp</td><td>comparator that should supply <code>bool less(T,T)</code> and <code>bool eq(T, T)</code></td></tr>
</table>

<p class="doc-section">Example</p>

{% highlight c++ %}
std::vector<int> seq {1,3,12,14,15,18,20};
// bin_search assumes sequence is in order and elements are comparable
bin_search(seq.begin(), seq.end(), 12);
// iterator to element 12

bin_search(seq.begin(), seq.end(), 17);
// iterator seq.end()
{% endhighlight %}

<p class="doc-section">Discussion</p>
<div class="text-block">
<p>
	A fundamental algorithm used because of its <code>Θ(lg(n))</code> time complexity (n is sequence length).
	This is in comparsion to linear sort, which has <code>Θ(n)</code> time complexity. As expected, this
	lg(n) performance is due to reducing the problem size to half each run through the Divide and Conquer strategy.
	Each iteration compares the median value against the target, relying on the sorted property to eliminate the
	half that is on the opposite side of the target relative to the median. 

</p> 
<p>
	Some pitfalls to binary search are 1. it requires random access to the entire sequence, which implies
	2. the entire sequence need to be loaded in memory (or disk access will slow it down dramatically), and for
	small datasets (around n < 64) loses to linear search due to the lack of spacial locality. This issue will
	likely be more apparent in the future when more advanced optimizations for space locality becomes implemented.
</p>
</div>

<br>





<h3 class="anchor doc-header">Intersection <a class="anchor-link" title="permalink to section" href="#intersection" name="intersection">&para;</a></h3><br><br><br>

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Sequence>
unordered_set<typename Sequence::value_type> intersection(const set<Sequence>& s);
{% endhighlight %}

<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>s</td><td>set of sequences from which the intersection should be taken on</td></tr>
</table>

<p class="doc-section">Example</p>

{% highlight c++ %}
std::vector<int> seq {1,3,12,14,15,18,20};
std::vector<int> seq2 {1,3,5,6,7,8,20,32};
std::vector<int> seq3 {2,3,6,9,20,32,45,55};

intersection(std::set<vector<int>>{seq, seq2, seq3});
// unordered_set {3, 20} (elements shared by all 3 sequences)
{% endhighlight %}

<p class="doc-section">Discussion</p>
<div class="text-block">
<p>
	Optimal with time complexity <code>O(n)</code> (n is total sum of sequence elements).
	In the worst case, each element will be looked at if all elements are shared.
	This algorithm, like many other element matching ones, is based on hashtable lookups, which 
	give average <code>O(1)</code> complexity. For known value ranges that's uniquely mappable to natural numbers,
	such as language alphabet, a fixed size array could be used with the value's number value as the hash. 
</p>
<p>
	For example, the UTF-8 encoding represents characters with 8 bits, uniquely mapping each character to
	a number between 0 and 255. An array of size 256 could be used to find the intersection and other characteristics
	among UTF-8 sequences.
</p>
</div>

<br>




<h3 class="anchor doc-header">Order selection <a class="anchor-link" title="permalink to section" href="#selection" name="selection">&para;</a></h3><br><br><br>

<p class="doc-section">Declaration</p>
{% highlight c++ %}
template <typename Iter>
Iter select(Iter begin, Iter end, size_t i);

// convenience overload
template <typename Sequence>
typename Sequence::iterator select(Sequence& c, size_t i);
{% endhighlight %}

<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>begin</td><td>iterator pointing to the first sequence element</td></tr>
<tr><td>end</td><td>iterator pointing to one past the last sequence element</td></tr>
<tr><td>i</td><td>ith smallest element of a sequence to select (1 is smallest)</td></tr>
</table>

<p class="doc-section">Example</p>

{% highlight c++ %}
// no requirement on sortedness of course...
std::vector<int> v {632, 32, 31, 50, 88, 77, 942, 5, 23};
select(v.begin(), v.end(), 4);
// iterator to 4th element (50)
{% endhighlight %}

<p class="doc-section">Discussion</p>
<div class="text-block">
<p>
	Selecting for minimums and maximums are relatively easy tasks requiring <code>O(n)</code> time,
	but finding an arbitrary ith ordered element requires a different approach.
</p>
<p>
	The algorithm implemented is quickselect, which, as the name suggests, is very similar to quicksort with
	<code>O(n)</code> performance.
	Their approach is the same - choosing a pivot to partition the sequence around based on <, but unlike quicksort,
	which recurses on both sides, quickselect recurses only on the side the target is on (found by comparing the
	rank=(pivot-begin) of the pivot against i).
</p>
<p>
	At the end of selection, the sequence will be partially sorted with the ith element being the ith smallest,
	and everything smaller than it on its left while everything larger than it on the right, with no order guranteed.
</p>
</div>

<br>




<h3 class="anchor doc-header">Current prime <a class="anchor-link" title="permalink to section" href="#cur_prime" name="cur_prime">&para;</a></h3><br><br><br>

<p class="doc-section">Declaration</p>
{% highlight c++ %}
big_int cur_prime() const;
{% endhighlight %}

<p class="doc-section">Example</p>

{% highlight c++ %}
Sieve<> sieve;
for (int i = 0; i < 100; ++i)
	sieve.next_prime();

sieve.cur_prime();
// size_t 100th prime (n = 100)

{% endhighlight %}

<p class="doc-section">Discussion</p>
<div class="text-block">
<p>
	Current prime in the sequence.
</p>
</div>

<br>




<h3 class="anchor doc-header">Nth prime <a class="anchor-link" title="permalink to section" href="#nth_prime" name="nth_prime">&para;</a></h3><br><br><br>

<p class="doc-section">Declaration</p>
{% highlight c++ %}
big_int nth_prime(big_int nth);
{% endhighlight %}

<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>nth</td><td>prime index starting with 2(n=1), 3(n=2)</td></tr>
</table>

<p class="doc-section">Example</p>

{% highlight c++ %}
sieve.nth_prime(1000);
// big_int 7919 (1000th prime)
{% endhighlight %}

<p class="doc-section">Discussion</p>
<div class="text-block">
<p>
	Prime numbering starts with an index of 1; nth = 0 or nth < 0 returns 0,
	but beware of underflows if using an unsigned type such as size_t by default.
</p>
</div>

<br>


<h3 class="anchor doc-header">Primes up to <a class="anchor-link" title="permalink to section" href="#primes_upto" name="primes_upto">&para;</a></h3><br><br><br>

<p class="doc-section">Declaration</p>
{% highlight c++ %}
const std::vector<big_int>& primes_upto(big_int lim);
{% endhighlight %}

<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>lim</td><td>upper limit for largest prime</td></tr>
</table>

<p class="doc-section">Example</p>

{% highlight c++ %}
sieve.nth_prime(1000);
// big_int 7919 (1000th prime)
{% endhighlight %}

<p class="doc-section">Discussion</p>
<div class="text-block">
<p>
	Returns a reference to the internal prime vector. Note that the last member
	is not guranteed to be the prime just under lim! 
	(it will be if lim is greater than internal limit prior to running)
	A separate copy guranteeing the last element is not done as that would be very inefficient and unncessary.
	If the last prime is too large, use <code>sieve.count(lim) - 1</code> to retrieve index of the desired back.
</p>
</div>

<br>





<h3 class="anchor doc-header">Check if prime <a class="anchor-link" title="permalink to section" href="#is_prime" name="is_prime">&para;</a></h3><br><br><br>

<p class="doc-section">Declaration</p>
{% highlight c++ %}
bool is_prime(big_int guess);
{% endhighlight %}

<p class="doc-section">Example</p>

{% highlight c++ %}
sieve.is_prime(sieve.nth_prime(420000));
// bool true (the 420000th prime is a prime)
{% endhighlight %}

<p class="doc-section">Discussion</p>
<div class="text-block">
<p>
	Accomplished by first filtering out <a href="../numeric/#factor">smooth numbers</a> (ones with small factors)
	then performing a binary search on existing primes or sieving up to the number;
</p>
</div>

<br>






<h3 class="anchor doc-header">Count primes under <a class="anchor-link" title="permalink to section" href="#count" name="count">&para;</a></h3><br><br><br>

<p class="doc-section">Declaration</p>
{% highlight c++ %}
size_t count();
size_t count(big_int upper);
{% endhighlight %}

<p class="doc-section">Parameters</p>
<table class="pretty">
<tr><td>upper</td><td>upper limit for largest prime</td></tr>
</table>

<p class="doc-section">Example</p>

{% highlight c++ %}
sieve.count(1000000);
// size_t 78498 primes below a million 
{% endhighlight %}

<p class="doc-section">Discussion</p>
<div class="text-block">
<p>
	Counting primes is more efficient than generating them and then counting
	since a bit sieve is used for counting only (8 byte statuses in 1 byte).
	Counting will not increase the current prime index or load primes into the
	internal vector.
</p>
</div>

<br>