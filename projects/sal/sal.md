---
layout: default
title: Simple Algorithms and Data Structures
permalink: /projects/sal/index.html
css: syntax
group: projects
---
<div class="text-block">
<p>
	Source on <a href="https://github.com/LemonPi/sal">github</a><br>
	SAL is a C++11 header only library containing simple implementations of
	efficient algorithms and data structures. Simplicity refers to how close 
	the implementation represents the essence of each concept, leaving out convoluted optimizations.
</p>
</div>


<a name="#algo" class="anchor">Algorithms</a>
---
- [numerics](numeric.html)
- [permutation and combination](perm.html)
- [prime generation and manipulation](prime.html)
- [basic searching, substring matching, and finding longest common features](search.html)
- [comparison, distributive, and hybrid sorts](sort.html)
- [string edit distances](string.html)
- [integer factorization](factorize.html)
- [utility and testing functions](utility.html)
- [**graph searches**](graph_search.html)
- [**important graph algorithms**](graph_utility.html)
- [**shortest paths for graphs and trees**](shortest.html)
- [linear programming](linear.html)

<a name="#data" class="anchor">Data structures</a>
---
- [basic linked list](list.html)
- [binary heap](heap.html)
- [2D matrix](matrix.html)
- [red black tree and augmentations of it](tree.html)
- [interval tree](interval.html)
- [**directed and undirected graphs**](graph.html)


<h2 class="anchor">Features <a class="anchor-link" title="permalink to section" href="#features" name="features">&para;</a></h2>
-------------------------------
Decoupled algorithms so most files are standalone 

- contest friendly 
- paste specific functions in without the rest of the library

<br>

Simple implementation of efficient algorithms 

- learning friendly
- engineered for readability
- clarity of ideas is top priority
- algorithms with low complexities


<h2 class="anchor">Getting started <a class="anchor-link" title="permalink to section" href="#getting_started" name="getting_started">&para;</a></h2>
-------------------------------
1. open cmd/terminal and change directory to somewhere in your include path (ex. /usr/local/include)
2. type `git clone --recursive git@github.com:LemonPi/sal.git`
3. if you missed(2.html and cloned it without `--recursive`, get the submodules with `git submodule update --init`


<h2 class="anchor">Motivation <a class="anchor-link" title="permalink to section" href="#motivation" name="motivation">&para;</a></h2>
-------------------------------
<div class="text-block">
<p>
	While working on my <a href="../clisp">Lisp interpreter</a>, I was introduced to the boost
	library. It provided the feature I needed (variant) with a flexible interface,
	but I found the library too cumbersome as a whole. It was impossible to understand conceptual slices
	of it as they would be optimized into obscurity. 
</p>
<p>
	This library is <b>more suited for learning than production usage</b>, or for contests that
	allow custom libraries. I personally use it for Project Euler problems.
</p>
</div>

<h2 class="anchor">Simplicity Demonstration <a class="anchor-link" title="permalink to section" href="#simplicity" name="simplicity">&para;</a></h2>
-------------------------------
<div class="text-block">
<p>
	Consider Djikstra's algorithm for shortest path in a non-negative directed graph.
	The pseudo code:
</p>
</div>
```
Dijkstra(G, s)  {
   Initialize-single-source(G, s)
   S ← Ø
   Q ← V[G] // priority queue by d[v]
   while Q ≠ Ø do
      u ← Extract-Min(Q)
      S ← S U {u}
      for each vertex v in Adj[u] do
         Relax(u, v)
}
```

With direct parallels in the actual code:

{% highlight C++ linenos %}
template <typename Graph>
SPM<Graph> dijkstra(const Graph& g, typename Graph::vertex_type s, DJ_visitor&& visitor = {}) {
	using V = typename Graph::vertex_type;
	using Cmp = Shortest_cmp<SPM<Graph>>;
	SPM<Graph> property;
	initialize_single_source(property, g, s);

	// comparator querying on distance

	Heap<V, Cmp> exploring {Cmp{property}};	 /* Q */
	exploring.batch_insert(g.begin(), g.end());

	while (!exploring.empty()) {
		V u {exploring.extract_top()};
		auto edges = g.adjacent(u);
		for (auto v = edges.first; v != edges.second; ++v) 
			visitor.relax(property, exploring, {u, v});
	}

	return property;
}
{% endhighlight %}

<br>

```
Initialize-single-source(G, s) {
   for each vertex v in V(G)
      d[v] ← ∞
      p[v] ← NIL
   d[s] ← 0
}
``` 
{% highlight C++ linenos %}
template <typename Property_map, typename Graph>
void initialize_single_source(Property_map& property, const Graph& g, typename Graph::vertex_type s) {
	for (auto v = g.begin(); v != g.end(); ++v) 
		property[*v] = {*v};	/* initially parent is itself, distance is infinity */
	property[s].distance = 0;
}	
{% endhighlight %}

<br>

```
Relax(u, v) {
   //update only if we found a strictly shortest path
   if d[v] > d[u] + w(u,v) 
      d[v] ← d[u] + w(u,v)
      p[v] ← u
      update(Q, v)
}
```

{% highlight C++ linenos %}
struct DJ_visitor {
	/* relaxes an edge if it meets certain requirements */
	template <typename Property_map, typename Queue>
	void relax(Property_map& property, Queue& exploring, 
		const Edge<typename Property_map::key_type, typename Property_map::mapped_type::edge_type>& edge) {
		/*
		   property keeps track of d[] and p[]
		   exploring is Q
		   edge is the (u,v) seen in the pseudo code 
		*/

		size_t d_i {exploring.key(edge.dest())};
		// d_i == 0 means not in exploring

		if (d_i && edge.weight() < property[edge.dest()].distance + edge.weight()) {
			property[edge.dest()].distance = property[edge.source()].distance + edge.weight();
			property[edge.dest()].parent = edge.source();
			/* fix heap property */
			exploring.check_key(d_i);
		}		
	}
};
{% endhighlight %}

<div class="text-block">
<p>
	Most of the library maintains this degree of correspondence to fundamental ideas.
	Optimizations are done if fundamentally changes the behaviour, such as reducing
	the complexity or removing memory constraints. For example, prime generation is implemented
	as a segmented sieve rather than a straight forward sieve since it effectively removes
	memory as a limit on the largest prime I can find.
</p>
<p>
	
</p>
</div>

<h2 class="anchor">Gains from Experience <a class="anchor-link" title="permalink to section" href="#gains" name="gains">&para;</a></h2>
-----------------------
 - Strong foundation in algorithms and data structures
 - C++ implementation experience (creating my own iterators, visitors, and lower level data structures)
 - Experience easily expressing ideas in efficient code