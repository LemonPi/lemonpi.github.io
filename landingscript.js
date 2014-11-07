var possiblyGoogler = false;

function css_select(url) {
	for (var i = 0; i < document.styleSheets.length; ++i) {
		if (document.styleSheets[i].href == url) {
			return document.styleSheets[i];
		}
	}
	return null;
}

window.onload = function(e) {
	var url1_select = css_select("https://uberchromegw.corp.google.com/i/chromiumos.tryserver/default.css");
	var url2_select = css_select("https://www.corp.google.com/eng/docstyle.css");
	

	// possiblyGoogler = true;
	if (typeof(prettyPrint) != "undefined") {
		possiblyGoogler = true;
	}
	if (url1_select != null && url1_select.rules != null) {possiblyGoogler = true;}
	if (url2_select != null && url2_select.rules != null) {possiblyGoogler = true;}
	if (possiblyGoogler) {
		var landing = document.getElementById("google_landing");
		landing.style.display = "";
	}
}

function close_landing() {
	document.getElementById("google_landing").style.display = "none";
}