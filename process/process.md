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
		<a id="handbook-diagram" href="/portfolio/handbook/" class="handbook">Tools Handbook</a>
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


 1. Understand problem
----------------------------
   - Consider the **causes and impacts** of problem to give basis for reframing
     - Physically reconstruct problem then apply physics models to analyze problem factors
	 - Research literature relevant to problem 
	 - Set initial constraints and objectives to guide solution generation
   - Determine key stakeholders (1) who will use the solution (2) who will the use of the solution effect (3) who will produce the solution
   
 2. Break problem down to its components - what needs to be done?
---------------------------
 
 3. Generate specialized solutions for each component problem (monomaniacal design)
------------------------------
   - Relate problem to one solved in nature (biomimicry)
   - Consider what can provide forces if something needs to be moved
   - Consider buckling or bending to fold something
   - Consider friction to hold two things together but still allow for lateral shearing
   - Keep all solutions inside the solution pool; no elimination as revision might use a previously rejected solution
   
 4. Compare solutions based on my [principles](/portfolio/principles.html), adjusted for what the context demands
------------------------------
 - Use Pugh chart for performance comparison 
 - Use simple comparison matrix for general appeal

 5. Combine component solutions
---------------------------
 - Keep unused components inside solution pool, **key to making a robust solution**
 - Switch components if the environment changes (ex. now needs to operate in a corrosive environment)
 
 6. Prototype - allows better understanding of solution and possible issues with design
----------------------------
 - Has at least one purpose -> proof of concept, showing shape/dimension, demonstrating feasibility, or functional
 - Ideally physically, to scale, and functional
 - Start with conceptual drawings by hand or with Inkscape
   

 7. Refine solutions
----------------------------
 - Can one part perform multiple functions?
   - Can two parts be combined into one?
   - How will the user interact with it?
   - How will it be stored and cleaned?
   
 8. Refine understanding of the problem at each step and adjust solutions accordingly
----------------------------
 With experience, I found some tools helpful in progressing through each step, and their description and use are covered in the
 <a class="handbook" id="handbook-inline" href="/portfolio/handbook/">Tools Handbook</a>

<h2 class="anchor">Analysis of Process <a class="anchor-link" title="permalink to section" href="#analysis" name="analysis">¶</a></h2>
----------------------------
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
</div>

<h2 class="anchor">References <a class="anchor-link" title="permalink to section" href="#reference" name="reference">¶</a></h2>
-------------------------
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
</div>