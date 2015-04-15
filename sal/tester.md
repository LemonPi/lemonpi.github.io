---
layout: console
title: Algorithm Testing
permalink: /sal/tester.html
---

<div id="console" style="top:0px; left:0px; height:100%; width:100%;"></div> 


<script src="//ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js" type="text/javascript"></script>
<script src="algotest.js" type="text/javascript"></script>
<script src="/res/jq-console/jqconsole.min.js" type="text/javascript"></script>
<script type="text/javascript">
function expr_terminate(input) {
	var paren_stack = new Array();
	for (var i = 0; i < input.length; ++i) {
		if (input.charAt(i) === '(') paren_stack.push('(');
		if (input.charAt(i) === ')' && paren_stack.length) paren_stack.pop();
	}
	if (paren_stack.length) return paren_stack.length;
	return false;
}


$(window).load(function () {
	var jqconsole = $("#console").jqconsole('SAL algorithm testing, generate random numbers first \n', '>> ');

	var startPrompt = function() {
		// start prompt with history enabled
		jqconsole.Prompt(true, 
		function(input) {
			jqconsole.Write(Module.algo_str(input+' '), 'jqconsole-output');
			// restart prompt
			startPrompt();
		}, 
		function(input) {
			return false;
			// check if expression's terminated
		});
		Module.print = Module.printErr = function(a) {
			console.log(a);
			jqconsole.Write(a + '\n');
		};
	};
	startPrompt();
});

</script>
