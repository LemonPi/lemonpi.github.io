---
layout: default
title: Engineering Process 
permalink: /process/index.html
group: process
css: interactive
branch: base
---
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
function is_touch_device() {
  return 'ontouchstart' in window
      || 'onmsgesturechange' in window;
};
$(document).ready(function() {
    if (is_touch_device()) {
		$('.hover').bind('click', function(mobile) {
			$('.mobile_hover').removeClass("mobile_hover");
			mobile.preventDefault();
			$(this).toggleClass('mobile_hover');
		});
	}
});
</script>
<h1 style="text-align:center;font-size:50px;">Engineering Process</h1>
<div class="holder">
	<div class="hot-spots">
		<div class="hot-spot hover" id="problem"><br><h2>Problem</h2>
			<div class="info">
				<h2>Problem Understanding</h2>
				<p>Map out the causes and impacts of the problem as well as who it affects.
				Dig into research to really understand the cycle of influences.</p>
			</div>
		</div>
		<div class="hot-spot hover" id="component"><h4>Component<br> 2</h4>
			<div class="info">
				<h2>Problem module</h2>
				<p>Independent (approximate) components of the problem that can be addressed individually.</p>
			</div>
		</div>
		<div class="hot-spot hover" id="prototype"><br><h3>Prototype</h3>
			<div class="info">
				<h2>Rapid prototyping</h2>
				<p>Test out the practicality of the proposed solution by actually making it. This filters out
				the concepts that are sound in theory but are impractical in actuality.</p>
			</div>
		</div>
		<div class="text-spot hover" id="func"><h3>Functional decomposition</h3>
			<div class="info info_txt">
				<p>Simplify and approximate the problem cycle into a linear cause-and-effect model.
				Then treat each cause of the problem as a component, decomposing that down as much as possible.</p>
			</div>
		</div>
		<div class="text-spot hover" id="monomaniac"><h3>Monomaniacal design</h3>
			<div class="info info_txt">
				<p>Generate specialized solutions for each component without worrying too much about holistic effectiveness.</p>
			</div>
		</div>
		<div class="text-spot hover" id="compare"><h3>Compare and select</h3>
			<div class="info info_txt">
				<p>For each component, select a few specialized solutions that are <b>interesting</b>, which encourages
				creative solutions as opposed to just selecting the most obvious and "effective" ones.</p>
			</div>
		</div>
		<div class="text-spot hover" id="generate"><h3>Create combinations</h3>
			<div class="info info_txt">
				<p>Combine the prospective component solutions by taking compatible and strong aspects of each solution.
				Keep these combined solutions in the solution pool for future iterations.</p>
			</div>
		</div>
		<div class="text-spot hover" id="compare_2"><h3>Compare and select</h3>
			<div class="info info_txt">
				<p>Select the best suited solution from the pool, judging based on the requirements and my own principles.</p>
			</div>
		</div>
		<div class="text-spot hover" id="pool"><h3>Solution Pool</h3>
			<div class="info info_txt info_down">
				<p>An essential part of my design process is keeping my <b>options open and solutions creative</b> by holding onto
				solutions that didn't quite make the selection process but still has interesting components. These could
				be modified to be compatible with the solution in future iterations.</p>
			</div>
		</div>
		<a id="handbook-diagram" href="/handbook/" class="handbook">Tools Handbook</a>
	</div>
		<div id="patch">
			<div class="text-spot hover" id="basis"><h3>Basis of selection & refinement</h3>
			<div class="info info_txt info_down">
				<p>The requirements of the stakeholders and my own design principles are the criteria for selection and refinement.
				The stakeholders are those who are affected by the problem, explored while understanding the problem.</p>
			</div>
		</div>
	</div>
</div>



--------------------------
<div class="block">
<ol>
	<h2 class="anchor"><li>Understand problem <a class="anchor-link" title="permalink to section" href="#step1" name="step1">¶</a></li></h2>
		<ul>
			<li>Consider the <b>causes and impacts</b> of problem to give basis for reframing</li>
			<ul>
				<li>Physically reconstruct problem then apply physics models to analyze problem factors</li>
				<li>Research literature relevant to problem</li>
				<li>Set initial constraints and objectives to guide solution generation</li>
			</ul>
			<li>Determine key stakeholders</li>
			<ul>
				<li>who will use the solution </li>
				<li>who will the use of the solution effect </li>
				<li>who will produce the solution</li>
			</ul>
		</ul>

	<h2 class="anchor"><li>Break problem down to its components - what needs to be done? <a class="anchor-link" title="permalink to section" href="#step2" name="step2">¶</a></li></h2>
		<ul>
			<li>Pick as independent components as you can (ex. drawing a picture --> outlining, colouring)</li>
			<li>Keep breaking it down until the components are as independent and easy to approach as necessary</li>
		</ul>
	
	<h2 class="anchor"><li>Generate specialized solutions for each component problem (monomaniacal design) <a class="anchor-link" title="permalink to section" href="#step3" name="step3">¶</a></li></h2>
		<ul>
			<li>Relate problem to one solved in nature (biomimicry)</li>
			<li>Consider what can provide forces if something needs to be moved</li>
			<li>Consider buckling or bending to fold something</li>
			<li>Consider friction to hold two things together but still allow for lateral shearing</li>
			<li>Keep all solutions inside the solution pool; no elimination as revision might use a previously rejected solution</li>
		</ul>
	
	<h2 class="anchor"><li>Compare solutions based on my <a href="/principles.html">principles</a>, adjusted for what the context demands <a class="anchor-link" title="permalink to section" href="#step4" name="step4">¶</a></li></h2>
		<ul>
			<li>Use Pugh chart for performance comparison </li>
			<li>Use simple comparison matrix for general appeal</li>
			<li>Don't be afraid to challenge stakeholder requirements if they haven't understood the problem</li>
		</ul>
	
	<h2 class="anchor"><li>Combine component solutions <a class="anchor-link" title="permalink to section" href="#step5" name="step5">¶</a></li></h2>
		<ul>
			<li>Keep unused components inside solution pool, <b>key to making the solution robust</b></li>
			<li>Switch components if the requirements or environment changes (ex. now needs to operate in a corrosive environment)</li>
		</ul>
	
	<h2 class="anchor"><li>Prototype - allows better understanding of solution and possible issues with design <a class="anchor-link" title="permalink to section" href="#step6" name="step6">¶</a></li></h2>
		<ul>
			<li>Have at least one <b>purpose</b></li>
			<ul>
				<li>Prove and communicate concept</li>
				<li>Communicate shape and appearance</li>
				<li>Demonstrate feasibility</li>
				<li>Show functionality</li>
			</ul>
			<li>Prototype is ideally physical, to scale, and functional</li>
			<li>Start with conceptual drawings by hand or with Inkscape</li>
		</ul>
	
	<h2 class="anchor"><li>Refine solutions <a class="anchor-link" title="permalink to section" href="#step7" name="step7">¶</a></li></h2>
		<ul>
			<li>Can one part perform multiple functions?</li>
			<ul>
				<li>Can structural elements also become functional ones?</li>
				<li>How will the user interact with it?</li>
				<li>How will it be stored and cleaned?</li>
				<li>How long do I have to spend explaining how to use it and what it does?</li>
			</ul>
		</ul>
	
	<h2 class="anchor"><li>Refine understanding of the problem at each step and adjust solutions accordingly <a class="anchor-link" title="permalink to section" href="#step8" name="step8">¶</a></li></h2>
</ol>   


 With experience, I found some tools helpful in progressing through each step, and their description and use are covered in the
 <a class="handbook" id="handbook-inline" href="/handbook/">Tools Handbook</a>

<h2 class="anchor">Analysis of Process <a class="anchor-link" title="permalink to section" href="#analysis" name="analysis">¶</a></h2>
<div class="text-block">
<p>
	My process is characterized by being <b>cyclical</b> and by heavily <b>relying on functional decomposition</b>.
</p>
<p>
	From experience, multiple iterations generally increase quality through integrating component solutions better, 
	finding new component solutions, and addressing flaws found in the previous iteration.
	Cyclic design processes are also the norm in industry, promoted by 
	<a href="http://www.nasa.gov/audience/foreducators/plantgrowth/reference/Eng_Design_5-12.html#">NASA</a> <a href="#ref1">[1]</a>, 
	and many educational sites <a href="#ref2">[2]</a> <a href="#ref3">[3]</a>.
</p>
<p>
	My prevalent use of functional decomposition distinguishes my design process from many others.
	It has proved very useful in promoting modular solutions, which in turn tend to be more robust and easily changeable.
	The solution can be changed by simply swapping in a different component solution without requiring change in other components, 
	making multiple iterations more productive as less backtracking is done. This approach does not seem to be as
	prevalent as cyclic design in industry, since all the sources above present a <b>single-branch</b> approach,
	directly creating solutions for the entire problem. While that might be faster (allowing time for more iterations) than
	my <b>multi-branch</b> approach - generating component solutions for each part of the problem - I believe my
	approach requires less iterations to produce a quality product.
</p>
<p>
	The keeping of a <b>solution pool</b> also distinguishes my personal design process.
	Its purpose is to allow effective responses to small changes in the problem. 
	An analogy is the caching of websites - remaining on the same site (overall problem) 
	will result in your browser caching site resources such as css, javascript, and images, 
	so that switching to another page (small change to problem) will be fast and efficient, 
	directly loading the resources from cache rather than the expensive route of downloading them again.
	This idea of <b>solving a class of problems rather than a particular problem</b> makes 
	my solutions robust, and is endorsed by computer science giants such as Hal Abelson and Gerald Jay Sussman <a href="#ref4">[4]</a>.
</p>
</div>

<h2 class="anchor">References <a class="anchor-link" title="permalink to section" href="#reference" name="reference">¶</a></h2>
<div class="reference">
<a name="ref1">[1]</a> NASA, 
	(2008, Feb 7). <i>Engineering Design Process</i> [Online]. Available:
	<a href="http://www.nasa.gov/audience/foreducators/plantgrowth/reference/Eng_Design_5-12.html">http://www.nasa.gov/audience/foreducators/plantgrowth/reference/Eng_Design_5-12.html</a>
<br>
<a name="ref2">[2]</a> Teach Engineering, 
	(n.a.). <i>Engineering Design Process</i> [Online]. Available:
	<a href="http://www.teachengineering.org/engrdesignprocess.php">http://www.teachengineering.org/engrdesignprocess.php</a>
<br>
<a name="ref3">[3]</a> PBS, 
	(2008, Feb 7). <i>What Is the Design Process?</i> [Online]. Available:
	<a href="http://www.pbslearningmedia.org/resource/phy03.sci.engin.design.desprocess/what-is-the-design-process/">http://www.pbslearningmedia.org/resource/phy03.sci.engin.design.desprocess/what-is-the-design-process/</a>
<br>
<a name="ref4">[4]</a> Abelson H. and Sussman J. G.,
	<i>Structure and Interpretation of Computer Programs [Online].</i> Available: 
	<a href="http://mitpress.mit.edu/sicp/full-text/book/book.html">http://mitpress.mit.edu/sicp/full-text/book/book.html</a>
<br>
</div>
</div>