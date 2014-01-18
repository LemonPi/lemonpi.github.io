---
layout: default
title: Name Game in C
permalink: /projects/namegame/index.html
---
Source on [github](https://github.com/LemonPi/LameNameGame)  
I made this game to explore string processing in C, which my CSC190 professor specifically mentioned not to do.  
The game requires a Unix based user list and quizzes you on the user's real names given their username. 

## Instructions <a name="instructions"> </a>
------------------------
1. Clone code onto your computer from [github](https://github.com/LemonPi/LameNameGame) or using cmd <pre><code>git clone git://github.com/LemonPi/LameNameGame.git</code></pre>
2. Get user list from shared computer (Unix based)  <pre><code>cp /etc/passwd ./user_list </code></pre> 
3. Compile game using gcc or clang <pre><code>gcc -std=c99 -o namegame namegame.c</code></pre> or <pre><code>clang -o namegame namegame.c</code></pre>
4. Run game with first argument being the unix user list  <pre><code>./namegame user_list</code></pre>   
5. Apply group filter (your classmates are all in the same group) 
6. Guess their names!  

<div class="frames">
<img src="playing.png">
<p>Quite simple in concept, but strangely addicting...</p>
</div>

## Making Process <a name="making"> </a>
------------------------
It might seem masochistic to do processing with C rather than a language like Python or Perl, but I wanted to give myself a challenge.  
The best way to learn seems to be taking on a next-to-impossible project, planning out what components are needed (data structure and processes), then figure out the implementation.  
<div class="frames">
<img src="structure.png">
<p>Clearly define all the data structure at the start</p>
</div>

Each person's name(s) and id are stored inside a name_data object for easy referencing.  
Names are stored in an array of C-strings to accommodate for multiple names; dynamic allocation is a possibility for optimization.  
The master_storage doesn't store the objects directly because that unnecessarily uses up memory; instead the name_data objects are dynamically created.  

The next concern is 