
var toc;
var header;
var offset_from_top = 0;

document.addEventListener('DOMContentLoaded', function() {

toc = document.getElementsByClassName("toc");
header = document.getElementById("header");

console.log(toc.length);
if (toc.length) toc = toc[0];
offset_from_top = header.offsetTop + header.offsetHeight;


if (toc) {
	console.log("adding scroll listener");
	// both rising and falling edge
	document.addEventListener('scroll', debounce(fix_toc, 200, true));
	document.addEventListener('scroll', debounce(fix_toc, 200, false));
}


});



function fix_toc(e) {
	window.scrollY >= offset_from_top ? toc.classList.add('toc-fixed') :
										toc.classList.remove('toc-fixed');
}

// limit fire rate to once every wait miliseconds; originally from http://davidwalsh.name/function-debounce
function debounce(func, wait, immediate) {
	var timeout;
	return function() {
		var context = this, args = arguments;
		var later = function() {
			timeout = null;
			if (!immediate) func.apply(context, args);
		};
		var callNow = immediate && !timeout;
		clearTimeout(timeout);
		timeout = setTimeout(later, wait);
		if (callNow) func.apply(context, args);
	};
};
