var possiblyGoogler = false;

function test_css(classname, test) {
	var meta = document.getElementById("puretesting");
	meta.className = classname + " puretesting";
	return test(meta);
}


window.onload = function(e) {

	// possiblyGoogler = true;
	if (typeof(prettyPrint) != "undefined") {possiblyGoogler = true;}
	// public css for testing: http://build.chromium.org/p/chromium/default.css
	if (test_css("Project", function(meta){return meta.clientWidth == 100;})) {
		console.log("test passed - chromium buildbot");
		possiblyGoogler = true;
	}

	if (possiblyGoogler) {
		var landing = document.getElementById("google_landing");
		landing.style.display = "";
	}
}

function close_landing() {
	document.getElementById("google_landing").style.display = "none";
}