---
layout: console
title: Binc Testing
permalink: /projects/bincalc/tester.html
---

<div id="console" style="top:0px; left:0px; height:100%; width:100%;"></div> 


<script src="//ajax.googleapis.com/ajax/libs/jquery/1.4.3/jquery.min.js" type="text/javascript"></script>
<script src="binc.js" type="text/javascript"></script>
<script src="/res/jq-console/jqconsole.min.js" type="text/javascript"></script>
<script type="text/javascript">
$(window).load(function () {
	var jqconsole = $("#console").jqconsole('Command line calculator supporting I/O in binary, hex, oct, and dec\nType funcs to see functions, modifiers to see modifiers\nex. a = (b10001101 ^ 0xF2) >> 1\n', '');

	var startPrompt = function() {
		// start prompt with history enabled
		jqconsole.Prompt(true, 
		function(input) {
			jqconsole.Write(Module.calc_str(input+'\n'), 'jqconsole-output');
			// restart prompt
			startPrompt();
		}, 
		function() {return false;});
		Module.print = Module.printErr = function(a) {
			jqconsole.Write(a + '\n');
		};
	};
	startPrompt();
	setTimeout(function(){jqconsole.Write('> ');}, 300);
});

</script>
