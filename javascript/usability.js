var blocks;
var toc;
var header;
var offset_from_top = 1;
var page_height;

document.addEventListener('DOMContentLoaded', function() {

header = document.getElementById("header");
toc = document.getElementsByClassName("toc");
setTimeout(function(){page_height = document.body.offsetHeight - 10;}, 1000);	// after images load

if (toc.length) {
	var content = document.getElementById("content");
	content.classList.add('has-toc');

	toc = toc[0];
	var toc_toggle = toc.getElementsByClassName("toc-toggle");
	toc_toggle = toc_toggle[0];
	// both rising and falling edge
	document.addEventListener('scroll', throttle(fix_toc, 200));

}


});


function fix_toc(e) {
	window.scrollY >= offset_from_top ? toc.classList.add('toc-fixed') :
										toc.classList.remove('toc-fixed');
}


function hasClass(element, cls) {
    return (' ' + element.className + ' ').indexOf(' ' + cls + ' ') > -1;
}

// limit firing to leading or falling edges; originally from http://davidwalsh.name/function-debounce
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


// limit fire rate to once every wait miliseconds; originally from http://documentcloud.github.io/underscore/
function throttle(func, wait, options) {
	var context, args, result;
	var timeout = null;
	var previous = 0;
	options || (options = {});
	var later = function() {
		previous = new Date;
		timeout = null;
		result = func.apply(context, args);
	};
	return function() {
		var now = new Date;
		if (!previous && options.leading === false) previous = now;
		var remaining = wait - (now - previous);
		context = this;
		args = arguments;
		if (remaining <= 0) {
			clearTimeout(timeout);
			timeout = null;
			previous = now;
			result = func.apply(context, args);
		} else if (!timeout && options.trailing !== false) {
			timeout = setTimeout(later, remaining);
		}
		return result;
	};
};