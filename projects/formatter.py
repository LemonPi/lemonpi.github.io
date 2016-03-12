import sys
import os

def format_file(infilename):
	"""format a file to be compatible with the current version of markdown (or strip down to HTML)"""
	temp = ".temp"
	with open(infilename, "r") as inf, open(temp, "w") as outf:
		for l in inf:
			# first rule, eliminate -----* after headers
			if l.startswith("<h2") or l.startswith("<h3"):
				outf.write(l)
				nl = inf.readline()
				if nl.startswith("---"):
					continue	# don't copy this line over
			else:
				outf.write(l)

	# replace the original file
	try:
		os.remove(infilename)
	except OSError:
		pass
	os.rename(temp, infilename)

if __name__ == "__main__":
	print("formatting {}".format(sys.argv[1]))
	format_file(sys.argv[1])