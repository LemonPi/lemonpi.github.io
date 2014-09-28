
	$(function () {
		var jqconsole = $("#console").jqconsole('Hi\n', '>>');
		var startPrompt = function() {
			// start prompt with history enabled
			jqconsole.Prompt(true, function(input) {
				jqconsole.Write(Module.str_calc(input) + '\n', 'jqconsole-output');
				// restart prompt
				startPrompt();
			});
		};
		startPrompt();
	});
