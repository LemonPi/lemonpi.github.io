// usage: java Autodoc [FILEPATH]
// creates toc_file in directory run, with the content being the table of contents
import java.nio.file.*;
import java.io.File;
import java.util.*;
import java.io.*;
import java.util.stream.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.parser.Tag;

public class Autodoc {

	private static class First_word {
		public String word;
		public int indent_level;
	}
	public static class Declarations {
		public List<Class> classes;
		public List<Function> functions;
		Declarations() {
			classes = new ArrayList<Class>();
			functions = new ArrayList<Function>();
		}
	}
	public static class Template {
		public String declaration;
		Set<String> types;
		public int indent_level;
		Template(String line, int il) {
			declaration = line;
			indent_level = il;
			types = new HashSet<String>();

			String[] words = split_into_words(line);
			// search for typeword before the last word (even if last is typeword, nothing afterwards)
			for (String word : words) print('[' + word + "] ");
			println("");
			for (int i = 0; i < words.length - 1; ++i) {
				if (words[i].equals(template_typeword)) {
					println("typeword: " + words[i+1]);
					types.add(words[i+1]);
					++i;	// skip typeword value
				}
			}
		}
		public boolean add_type(String type) {
			return types.add(type);
		}
	}
	public static class Class {
		public String declaration;
		public String name;
		public List<Function> member_funcs;
		public int indent_level;
		Class(String dec, String n, int il) {
			declaration = dec;
			name = n;
			indent_level = il;
			member_funcs = new ArrayList<Function>();
		}
		public void add_member(Function func) {
			member_funcs.add(func);
		}
	}	
	public static class Function {
		public String declaration;
		public String name;	// short form to be referred to in html
		Function(String dec, String n) {
			declaration = dec;
			name = n;
		}
	}
	public static First_word get_first_word(String line) {
		First_word first_word = new First_word();

		int indent = 0;
		while (indent < line.length() && indent_delim.contains(line.charAt(indent))) ++indent;
		first_word.indent_level = indent;

		String trimmed_line = line.substring(indent);
		int space_index = trimmed_line.indexOf(' ');
		if (space_index > -1) {
			trimmed_line = trimmed_line.substring(0, space_index);
			for (Character term_char : name_term) {
				int term_index = trimmed_line.indexOf(term_char);
				if (term_index > -1) trimmed_line = trimmed_line.substring(0, term_index);
			}
		}
		// trimmed to the first word
		first_word.word = trimmed_line;

		return first_word;
	}
	public static String[] split_into_words(String line) {
		line = line.replaceAll("[,<>]", "");	
		return line.split("\\s+");
	}
	public static void add_new_type(String line, First_word first_word) {
		String new_type = get_first_word(line.substring(first_word.word.length())).word;
		types.add(new_type);
		print("new type: ");
		println(new_type);
	}
	public static boolean is_type(String word) {
		if (types.contains(word)) return true;
		// check templates for temporary types
		for (Template template : templates) {
			if (template.types.contains(word)) return true;
		}
		return false;
	}
	public static String decorate_with_template(String declaration, int indent_level) {
		if (templates.isEmpty()) return declaration;
		Template temp = templates.get(templates.size() - 1);
		if (temp.indent_level == indent_level) return temp.declaration + '\n' + declaration;
		return declaration;
	}
	public static Function get_function(String line, First_word func_info, Class current_class) {
		// all functions are declared with a '{' at the end
		if (line.indexOf('{') < 0) return null;
		// check to see if (type) can be found - assumes the first word is a type, or qualified otherwise
		int lp_index = line.indexOf('(');
		int rp_index = line.indexOf(')');
		if (lp_index < 0 || rp_index < 0) return null;

		// the word preceeding '('
		String func_name = line.substring(0, lp_index).trim();
		// try to disqualify name to distinguish from a function call (unless )
		int name_start_index = -1;
		boolean possible_call = false;
		for (int i = func_name.length()-1; i >= 0; --i) {
			char c = func_name.charAt(i);
			if (c == ' ' && name_start_index == -1) name_start_index = i;
			// a function call rather than function declaration
			else if (call_beg.contains(c)) possible_call = true; 
		}
		if (name_start_index > -1) func_name = func_name.substring(name_start_index + 1);
		// can be excused of containing operators if is an operator
		if (possible_call && !func_name.startsWith("operator")) return null;

		String func_dec;
		// right next to each other, no parameters such as operator()()
		if (rp_index == lp_index + 1) {
			// fix operator()()
			if (func_name.startsWith("operator")) func_name += "()";

			int term_index = rp_index + 1;
			while (!dec_term.contains(line.charAt(term_index))) ++term_index;
			func_dec = line.substring(0, term_index).trim() + statement_term;
		}
		else {
			String func_params = line.substring(lp_index+1, rp_index);
			println("func params: " + func_params);
			if (!is_type(get_first_word(func_params).word)) return null;
			func_dec = line.substring(0, rp_index+1) + statement_term;
		}

		println("func name: " + '[' + func_name + ']');

		func_dec = decorate_with_template(func_dec, func_info.indent_level);
		Function func = new Function(func_dec, func_name);
		// add as member function instead of global function
		if (current_class != null) {
			// for sure is a member function else check indent level is nested
			if (class_member_keywords.contains(func_info.word) || func_info.indent_level > current_class.indent_level) {
				current_class.add_member(func);
				println("class member: " + func.declaration);
				return null;
			}
		}
		return func;
	}
	public static Class get_class(String line, First_word class_info) {
		// all classes are declared with a '{' at the end
		int term_index = line.indexOf('{');
		if (term_index < 0) return null;

		--term_index;
		while (line.charAt(term_index) == ' ') --term_index;

		String class_dec = line.substring(0, term_index+1) + statement_term;
		class_dec = decorate_with_template(class_dec, class_info.indent_level);

		Class cur_class = new Class(class_dec, class_info.word, class_info.indent_level);
		return cur_class;
	}

	// utility functions
	public static void print(String s) {
		System.out.print(s);
	}
	public static void println(String s) {
		System.out.println(s);
	}
	public static String removeExtension(String s) {
	    String separator = System.getProperty("file.separator");
	    String filename;

	    // Remove the path upto the filename.
	    int lastSeparatorIndex = s.lastIndexOf(separator);
	    if (lastSeparatorIndex == -1) {
	        filename = s;
	    } else {
	        filename = s.substring(lastSeparatorIndex + 1);
	    }

	    // Remove the extension.
	    int extensionIndex = filename.lastIndexOf(".");
	    if (extensionIndex == -1)
	        return filename;

	    return filename.substring(0, extensionIndex);
	}

	public static boolean exit_template(int indent_level) {
		if (!templates.isEmpty() && templates.get(templates.size()-1).indent_level == indent_level) {
			println("exiting template: " + templates.get(templates.size()-1).declaration + '\n');
			templates.remove(templates.size()-1);
			return true;
		}		
		return false;
	}
	public static boolean exit_class(int indent_level) {
		if (!cur_classes.isEmpty() && cur_classes.get(cur_classes.size()-1).indent_level == indent_level) {
			println("exiting class: " + cur_classes.get(cur_classes.size()-1).declaration + '\n');
			cur_classes.remove(cur_classes.size()-1);
			return true;
		}
		return false;
	}
	public static Declarations read_declarations(File file) {
		Declarations dec = new Declarations();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = null;

			// stack of seen declarations (and that are still in scope)
			templates = new ArrayList<Template>(); 
			cur_classes = new ArrayList<Class>();

			while ((line = br.readLine()) != null) {
				First_word first_word = get_first_word(line);
				line = line.substring(first_word.indent_level);

				println("first word: " + first_word.indent_level + " " + first_word.word);
				// found nothing?
				if (first_word.word.length() < 1) continue;
				// terminates a scope
				else if (first_word.word.charAt(0) == scope_term) {
					exit_template(first_word.indent_level);
					if (line.length() > 1 && line.charAt(1) == statement_term) 
						exit_class(first_word.indent_level);
				}
				// add to template stack
				else if (first_word.word.startsWith(template_keyword)) {
					print("\ntemplate: ");
					// insert space if necessary
					if (line.charAt(template_keyword.length()) != ' ') 
						line = line.substring(0,template_keyword.length()) + ' ' + line.substring(template_keyword.length());
					Template template = new Template(line, first_word.indent_level);
					templates.add(template);
					println(line);
				}
				// populating local type keywords
				else if (alias_keywords.contains(first_word.word)) {
					print("\nalias: ");
					println(line);
					// using something from a namespace without giving new name
					if (line.contains(namespace_scopeword)) {
						// just ignore bringing whole namespaces 
						String[] alias_words = line.split(scope_seq);
						// using specific name from namespace
						if (alias_words.length > 1) {
							println("bringing in name: " + alias_words[alias_words.length - 1]);
							types.add(alias_words[alias_words.length - 1]);
						}
					}
					// else aliasing new local type
					else {
						// templated alias
						exit_template(first_word.indent_level);
						add_new_type(line, first_word);
					}
				}
				// new user defined type
				else if (user_type_keywords.contains(first_word.word)) {
					print("\nuser type: ");
					println(line);

					Class cur_class = get_class(line, first_word);
					if (cur_class != null) {
						// add to both all declarations and the current classes (for tracking function membership)
						dec.classes.add(cur_class);
						cur_classes.add(cur_class);
						add_new_type(line, first_word);
						println("class: " + cur_class.declaration);
					}
				}
				// either a variable or function or class member declaration
				else if (is_type(first_word.word) || (!cur_classes.isEmpty() && class_member_keywords.contains(first_word.word))) {
					println("declaration: " + line);

					Class cur_class = null;
					if (!cur_classes.isEmpty()) cur_class = cur_classes.get(cur_classes.size()-1);

					Function func = get_function(line, first_word, cur_class);
					if (func != null) {
						dec.functions.add(func);
						println("function: " + func.declaration);
					}
				}
			}
		}
		catch (IOException e) {
			println("could not read: " + file.getPath());
		}

		return dec;
	}
	// public static void create_toc(File file) {
	// 	Document doc = null;
	// 	try {
	// 		doc = Jsoup.parse(file, "UTF-8", "");
	// 	}
	// 	catch (IOException e) {
	// 		println("could not load file" + file.getName());
	// 	}

	// 	Tag div = Tag.valueOf("div");
	// 	Tag link = Tag.valueOf("a");
	// 	Tag paragraph = Tag.valueOf("p");

	// 	Element toc = new Element(div, "");
	// 	toc.addClass("toc");


	// 	Elements titles = doc.getElementsByClass(title_class);

	// 	for (Element title : titles) {
	// 		Element title_link = title.getElementsByClass(title_link_class).first();

	// 		String title_tag = title.tagName();
	// 		String title_name = title.ownText();
	// 		String title_link_name = title_link.attr("name");
	// 		String title_link_href = title_link.attr("href");
	// 		// System.out.format("%s %-30s %-20s %s\n", title_tag, title_name, title_link_name, title_link_href);

	// 		Element toc_title = new Element(link, "");
	// 		toc_title.addClass("toc"+title_tag);
	// 		toc_title.attr("href", title_link_href);
	// 		toc_title.text(title_name);

	// 		toc.appendChild(toc_title);
	// 	}

	// 	// add caption
	// 	Element caption = new Element(paragraph, "");
	// 	caption.addClass("toc-caption");
	// 	caption.text(toc_caption);
	// 	toc.appendChild(caption);

	// 	Element toggle = new Element(paragraph, "");
	// 	toggle.addClass("toc-toggle");
	// 	toggle.text(toggle_text);
	// 	toc.appendChild(toggle);

	// 	// flush to file
	// 	try {
	// 		BufferedWriter htmlWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(toc_file), "UTF-8"));
	// 		htmlWriter.write(toc.toString());
	// 		htmlWriter.flush();
	// 		htmlWriter.close();
	// 	}
	// 	catch (IOException e) {
	// 		println("could not open: " + toc_file);
	// 	}
	// } 


	public static void init_keywords() {
		alias_keywords.add("using");
		alias_keywords.add("typedef");

		user_type_keywords.add("struct");
		user_type_keywords.add("class");

		indent_delim.add(' ');
		indent_delim.add('\t');

		dec_term.add(':');
		dec_term.add('{');
		dec_term.add(';');

		name_term.add('<');
		name_term.add('&');
		name_term.add('*');
		name_term.add('(');

		call_beg.add('{');
		call_beg.add(',');
		call_beg.add('=');
		call_beg.add('+');
		call_beg.add('-');
		call_beg.add('/');
		call_beg.add('.');
	}

	public static void main(String[] args) {
		if (args.length < 1) {System.out.println(args.length);println("usage: java Autodoc <source_file>"); return;}
		init_keywords();

		doc_source = args[0];
		File source = new File(library_dir.resolve(doc_source).toString());

		doc_file = removeExtension(source.getName()) + ".md";

		println("source: " + source.getPath());
		println("doc_file: " + doc_file);

		Declarations dec = read_declarations(source);
		println("\nDeclared classes");
		for (Class clas : dec.classes) {
			println(clas.declaration);
			for (Function member : clas.member_funcs) {
				println(member.declaration.replaceAll("^", "\t"));
			}
			println("");
		}
		println("\nDeclared functions");
		for (Function func : dec.functions) {
			println(func.declaration);
			println("");
		}
	}

	static Path library_dir = Paths.get(System.getProperty("user.home") + "/Documents/mylibs/sal/");
	static String doc_readme = "README.md";
	static String doc_source;
	static String doc_file;

	// temporarily introduce types to the namespace
	static List<Template> templates;
	// temporarily modify functions to be members
	static List<Class> cur_classes;

	static Set<Character> indent_delim = new HashSet<Character>();
	static char scope_term = '}';
	static char statement_term = ';';
	// ordered (by chance of cutting name short) characters that would force a name to be finished
	static List<Character> name_term = new ArrayList<Character>();
	// characters that would force a declaration to be finished (after a right parenthesis)
	static Set<Character> dec_term = new HashSet<Character>();
	// characters that distinguish a function call from definition (before a left parenthesis)
	static Set<Character> call_beg = new HashSet<Character>();

	static String template_typeword = "typename";
	static String template_keyword = "template";

	static String scope_seq = "::";
	static String namespace_scopeword = "namespace";
	static Set<String> alias_keywords = new HashSet<String>();
	static Set<String> user_type_keywords = new HashSet<String>();
	static Set<String> types = Stream.of("volatile", "const", "static", "constexpr",
			"void", "size_t", "int", "short", "long", "char", "uint32_t", "double", "float", "bool",
			"vector", "queue", "string", "stack",
			"std::vector", "std::queue", "std::string", "std::stack",
			"ostream", "std::ostream").collect(Collectors.toCollection(HashSet::new));
	static Set<String> class_member_keywords = Stream.of("static", "virtual").collect(Collectors.toCollection(HashSet::new));
}