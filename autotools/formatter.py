import sys
import os
import argparse
import re

def format_file(infilename, tohtml=False):
	"""format a file to be compatible with the current version of markdown (or strip down to HTML)"""
	temp = ".temp"
	ul_format = re.compile("^\s*- (.*)")
	ol_format = re.compile("^\s*\d\. (.*)")
	link_format = re.compile("(.*?)(!?)\[(.*?)\]\((.*?)\)(.*)")

	def format_link(l):
		match = link_format.match(l)
		if not match:
			return l
		# else there was a match so alter it
		src = "img src=" if match.group(2) else "a href="
		return '{}<{}"{}">{}</a>{}'.format(match.group(1), src, match.group(4), match.group(3), match.group(5))

	with open(infilename, "r") as inf, open(temp, "w") as outf:
		for l in inf:
			# first rule, eliminate -----* after headers
			if l.startswith("<h2") or l.startswith("<h3"):
				outf.write(l)
				l = inf.readline()
				if l.startswith("---"):
					outf.write("<!--- new section -->\n")
					continue
			# convert all unordered lists
			if ul_format.match(l):
				outf.write("<ul>\n")
				li = ul_format.match(l)
				while li:
					outf.write("\t<li>"+format_link(li.group(1))+"\n")
					l = inf.readline()
					li = ul_format.match(l)
				outf.write("</ul>\n\n")
			# ordered lists
			elif ol_format.match(l):
				outf.write("<ol>\n")
				li = ol_format.match(l)
				while li:
					outf.write("\t<li>"+format_link(li.group(1))+"\n")
					l = inf.readline()
					li = ol_format.match(l)
				outf.write("</ol>\n\n")
			# code blocks
			elif l.startswith("```"):
				outf.write("<pre><code>")
				l = inf.readline()
				while not l.startswith("```"):
					outf.write(l)
					l = inf.readline()
				outf.write("</code></pre>\n")

			elif l.startswith("----"): # horizontal rule
				outf.write("<hr><!--- new section -->\n")
			else:
				outf.write(format_link(l))

	# replace the original file
	try:
		os.remove(infilename)
	except OSError:
		pass
	os.rename(temp, infilename)
	# no longer markdown, completely html
	if tohtml:
		pre, ext = os.path.splitext(infilename)
		outname = pre+".html"
		try:
			os.remove(outname)
		except:
			pass
		os.rename(infilename, outname)

def parse_args(ns=None):
	parser = argparse.ArgumentParser(
		description="Format a markdown file to be compiler compliant or to convert to html.",
		usage="%(prog)s [OPTIONS]")

	parser.add_argument("file",
		help="file to format")

	parser.add_argument("--html",
		action="store_true",
		help="convert extension to html;\
		default: %(default)s")

	params = parser.parse_args(namespace=ns)

	return params

if __name__ == "__main__":
	params = parse_args()
	print("formatting {}".format(params.file))

	format_file(params.file, params.html)