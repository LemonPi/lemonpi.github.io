package autotools;
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
import org.jsoup.nodes.Entities.EscapeMode;

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

			String[] words = StringUtils.split_into_words(line);
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
		public List<Function> private_member_funcs;
		public int indent_level;
		public boolean private_scope;	// whether members currently seen are private or public
		Class(String dec, String n, int il, boolean default_scope) {
			declaration = dec;
			name = n;
			indent_level = il;
			private_scope = default_scope;
			member_funcs = new ArrayList<Function>();
			private_member_funcs = new ArrayList<Function>();
		}
		public void add_member(Function func) {
			member_funcs.add(func);
		}
		public void add_private_member(Function func) {
			private_member_funcs.add(func);
		}		
	}	
	public static class Function {
		public String declaration;
		public String name;	// short form to be referred to in html
		public List<String> params;
		Function(String dec, String n, List<String> ps) {
			declaration = dec;
			name = n;
			params = ps;
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
		// all global functions are declared with a '{' at the end (class members can be declared, match those times instead)
		if (current_class == null && line.indexOf('{') < 0) return null;
		// check to see if (type) can be found - assumes the first word is a type, or qualified otherwise
		int lp_index = line.indexOf('(');
		int rp_index = line.indexOf(')');
		if (lp_index < 0) {
			println("not function: no parameter list");
			return null;
		}
		if (rp_index < 0) rp_index = line.length() - 1;	// could be multiple line

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
		// skip class member definitions outside of class definition since the declaration has been seen already
		if (func_name.indexOf("::") > -1) return null;
		// can be excused of containing operators if is an operator
		if (possible_call && !func_name.startsWith("operator")) {
			println("not function: possible call");
			return null;
		}

		String func_dec;
		List<String> func_params = new ArrayList<String>();
		// right next to each other, no parameters such as operator()()
		if (rp_index == lp_index + 1) {
			// fix operator()()
			if (func_name.startsWith("operator")) func_name += "()";

			int term_index = rp_index + 1;
			while (!dec_term.contains(line.charAt(term_index))) ++term_index;
			func_dec = line.substring(0, term_index).trim() + statement_term;
		}
		else {
			String[] params_with_types = line.substring(lp_index+1, rp_index).split(",");
			// last word is param name
			for (String param : params_with_types) {
				// default parameter, get rid of = value
				if (param.indexOf('=') > -1) 
					param = param.split("=")[0];
				param = param.trim();
				func_params.add(trim_first_char(param.substring(param.lastIndexOf(' ') + 1), "&*"));
			}

			if (!is_type(get_first_word(params_with_types[0]).word)) {
				println("not function: parameter is invalid type");
				return null;
			}
			func_dec = line.substring(0, rp_index+1) + statement_term;
		}

		println("func name: " + '[' + func_name + ']');
		for (String param : func_params) print('[' + param + "] ");
		if (!func_params.isEmpty()) println("");

		func_dec = decorate_with_template(func_dec, func_info.indent_level);
		Function func = new Function(func_dec, func_name, func_params);
		// add as member function instead of global function
		if (current_class != null) {
			// for sure is a member function else check indent level is nested
			if (class_member_keywords.contains(func_info.word) || func_info.indent_level > current_class.indent_level) {
				if (current_class.private_scope) {
					current_class.add_private_member(func);
					println("private class member: " + func.declaration);
				}
				else {
					current_class.add_member(func);
					println("class member: " + func.declaration);
				}
				return null;
			}
		}
		return func;
	}
	public static Class get_class(String line, First_word class_info) {
		// private class defined inside the private scope of the latest class
		if (!cur_classes.isEmpty() && cur_classes.get(cur_classes.size()-1).private_scope) {
			println("privately declared class");
			return null;
		}
		// all classes are declared with a '{' at the end
		int term_index = line.indexOf('{');
		if (term_index < 0) term_index = line.length();
		--term_index;
		while (line.charAt(term_index) == ' ') --term_index;

		String class_name = get_first_word(line.substring(class_info.word.length())).word;
		int name_end_index = class_name.length() - 1;
		while (!Character.isLetterOrDigit(class_name.charAt(name_end_index))) --name_end_index;
		class_name = class_name.substring(0, name_end_index + 1);
		println("class name: " + '[' + class_name + ']');

		String class_dec = line.substring(0, term_index+1) + statement_term;
		class_dec = decorate_with_template(class_dec, class_info.indent_level);

		boolean private_scope = true;
		if (class_info.word.equals("struct")) private_scope = false;
		println("private scope: " + private_scope);

		Class cur_class = new Class(class_dec, class_name, class_info.indent_level, private_scope);
		return cur_class;
	}

	// utility functions
	public static void print(String s) {
		System.out.print(s);
	}
	public static void println(String s) {
		System.out.println(s);
	}
	public static String trim_first_char(String word, String delims) {
		if (delims.indexOf(word.charAt(0)) > -1) return word.substring(1);
		return word;
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
	public static boolean modify_class_access(String modifier) {
		if (!cur_classes.isEmpty()) {
			// protected and public are both part of its API
			if (modifier.startsWith("private")) cur_classes.get(cur_classes.size()-1).private_scope = true;
			else cur_classes.get(cur_classes.size()-1).private_scope = false;
			return true;
		}
		return false;
	}
	// input is source file
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
				// modifies class member access
				else if (access_modifiers.contains(first_word.word)) {
					println("access modifier: " + first_word.word);
					modify_class_access(first_word.word);
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
	public static Element create_header(Tag header_type, String name) {
		Element header = new Element(header_type, "");
		header.addClass("anchor");
		header.addClass("doc-header");
		header.text(name + ' ');

		Element header_link = new Element(link, "");
		header_link.addClass("anchor-link");
		header_link.attr("href", "#"+name);
		header_link.attr("name", name);
		header_link.attr("title", "permalink to section");
		header_link.text("&para;");

		header.appendChild(header_link);
		return header;
	}
	public static Element create_member_header(Tag header_type, String name, String classname) {
		Element header = new Element(header_type, "");
		header.addClass("anchor");
		header.addClass("doc-header");
		header.text(name + " | ");

		Element qualifier = new Element(code, "");
		qualifier.addClass("qualifier");
		qualifier.text(classname + scope_seq);
		header.appendChild(qualifier);
		header.appendText(name);

		Element header_link = new Element(link, "");
		header_link.addClass("anchor-link");
		header_link.attr("href", "#"+name);
		header_link.attr("name", name);
		header_link.attr("title", "permalink to section");
		header_link.text("&para;");
		header.appendChild(header_link);

		return header;
	}
	public static Element create_doc_header(String name) {
		Element header = new Element(paragraph, "");
		header.addClass("doc-section");
		header.text(name);
		return header;
	}
	// list of related functions to be in the same block
	public static Element create_block(List<Function> funcs) {
		Element block = new Element(div, "");
		block.addClass("block");

		block.appendText("\n\n");
		block.appendChild(create_doc_header("Declaration"));
		block.appendText("\n");
		// collect then append function declarations as TextNode
		StringBuilder func_decs = new StringBuilder();
		func_decs.append("{% highlight c++ %}");
		for (Function func : funcs) {
			func_decs.append("\n");
			func_decs.append(func.declaration);
			func_decs.append("\n");
		}
		func_decs.append("{% endhighlight %}\n");
		block.appendText(func_decs.toString());


		List<String> params = new ArrayList<String>();
		for (Function func : funcs) {
			for (String p : func.params) {
				if (params.indexOf(p) < 0) params.add(p);
			}
		}
		if (!params.isEmpty()) {
			block.appendText("\n\n");
			block.appendChild(create_doc_header("Parameters"));
			block.appendText("\n");
			Element param_table = new Element(table, "");
			param_table.addClass("pretty");
			// union of parameters in functions
			// each param gets a row
			param_table.appendText("\n");
			for (String param : params) {
				Element param_row = new Element(tr, "");
				Element param_name = new Element(td, "");
				param_name.text(param);
				Element param_desc = new Element(td, "");
				param_row.appendChild(param_name);
				param_row.appendChild(param_desc);
				param_table.appendChild(param_row);
				param_table.appendText("\n");
			}
			block.appendChild(param_table);
			block.appendText("\n");
		}


		block.appendChild(create_doc_header("Return value"));
		block.appendText("\n\n");


		block.appendChild(create_doc_header("Example"));
		block.appendText("\n{% highlight c++ %}\n\n{% endhighlight %}\n");


		block.appendText("\n");
		block.appendChild(create_doc_header("Discussion"));
		block.appendText("\n");
		Element discussion_block = new Element(div, "");
		discussion_block.appendText("\n");
		Element discussion_paragraph = new Element(paragraph, "");
		discussion_paragraph.appendText("\n\t\n");
		discussion_block.appendChild(discussion_paragraph);
		discussion_block.appendText("\n");
		block.appendChild(discussion_block);

		return block;
	}
	public static Element create_dec_list_row(Tag cell_type, String name, boolean is_class) {
		Element row = new Element(tr, "");
		Element name_cell = new Element(cell_type, "");

		Element list_link = new Element(link, "");
		list_link.addClass("doc-list-name");
		if (is_class) list_link.attr("href", name);
		else 		  list_link.attr("href", "#"+name);
		list_link.text(name);
		name_cell.appendChild(list_link);

		Element desc_cell = new Element(cell_type, "");
		row.appendChild(name_cell);
		row.appendChild(desc_cell);
		return row;
	}	
	public static Element create_dec_list(Declarations dec, Class cur_class) {
		Element wrapper_block = new Element(div, "");
		wrapper_block.addClass("block");
		wrapper_block.appendText("\n");

		Element github_link = new Element(link, "");
		github_link.attr("href", github_base + source_section + github_branch + source_topic + ".h");
		github_link.text(library_name + doc_source);
		Element wrapper_h4 = new Element(h4, "");
		wrapper_h4.appendChild(github_link);
		wrapper_h4.appendText("\n");
		wrapper_block.appendChild(wrapper_h4);

		Element dec_list = new Element(table, "");
		dec_list.addClass("pretty");
		dec_list.appendText("\n");

		
		// cur_class == null means working with global namespace functions; only list class declaration, leaving class member to actual page
		if (cur_class == null) {
			// add functions in order but without repeat
			Set<String> listed_names = new HashSet<String>();
			for (Function func : dec.functions) {
				if (listed_names.contains(func.name)) continue;
				listed_names.add(func.name);
				dec_list.appendChild(create_dec_list_row(td, func.name, false));
				dec_list.appendText("\n");
			}
			dec_list.appendText("\n");
			// add class declarations
			Set<String> listed_classes = new HashSet<String>();
			for (Class clas : dec.classes) {
				if (listed_classes.contains(clas.name)) continue;
				listed_classes.add(clas.name);
				dec_list.appendChild(create_dec_list_row(th, clas.name, true));
				dec_list.appendText("\n");
			}
			dec_list.appendText("\n");
		}
		// only detail the single class and its members
		else {
			// class constructors and core methods
			dec_list.appendChild(create_dec_list_row(th, cur_class.name, false));
			dec_list.appendText("\n");
			// add member functions in order but without repeat
			Set<String> listed_members = new HashSet<String>();
			
			listed_members.add(cur_class.name);	// constructors and core functions
			for (Function func : cur_class.member_funcs) {
				if (listed_members.contains(func.name)) continue;
				listed_members.add(func.name);
				dec_list.appendChild(create_dec_list_row(td, func.name, false));
				dec_list.appendText("\n");
			}
		}

		wrapper_block.appendChild(dec_list);
		return wrapper_block;
	}
	public static Document create_doc(Declarations dec, Class cur_class) {
		Document doc = new Document("");
		doc.outputSettings(new Document.OutputSettings().prettyPrint(false).escapeMode(EscapeMode.xhtml));//makes html() preserve linebreaks and spacing

		// yaml header
		StringBuilder yaml_header = new StringBuilder(100);
		yaml_header.append("---\nlayout: algorithms\ntitle: ");
		if (cur_class != null) yaml_header.append(cur_class.name);
		yaml_header.append("\npermalink: ");
		yaml_header.append('/');
		yaml_header.append(library_name);
		yaml_header.append(source_topic);
		if (cur_class != null) {
			yaml_header.append('/');
			yaml_header.append(cur_class.name);
		}
		yaml_header.append("/index.html\nsection: ");
		yaml_header.append(source_topic.split("/",2)[0]);
		if (cur_class != null) {
			yaml_header.append("\nclassname: ");
			yaml_header.append(cur_class.name);
		}
		yaml_header.append("\n---\n\n");
		doc.appendText(yaml_header.toString());

		doc.appendChild(create_dec_list(dec, cur_class));
		doc.appendText("\n\n\n\n");

		// working on the namespace scope functions
		Set<String> parsed_names = new HashSet<String>();
		if (cur_class == null) {
			for (int f = 0; f < dec.functions.size(); ++f) {
				String func_name = dec.functions.get(f).name;
				if (parsed_names.contains(func_name)) continue;
				parsed_names.add(func_name);

				Element header = create_header(h3, func_name);

				List<Function> related_funcs = new ArrayList<Function>();
				related_funcs.add(dec.functions.get(f));
				// linear search from current location for all related ones (if a related one was earlier in index, this function would be covered)
				for (int ff = f + 1; ff < dec.functions.size(); ++ff)
					if (dec.functions.get(ff).name.equals(func_name))
						related_funcs.add(dec.functions.get(ff));

				println("Related functions: " + func_name);
				for (Function func : related_funcs)
					println(func.declaration);
				println("");

				Element func_block = create_block(related_funcs);
				if (func_block == null) println("null block how come?");
				doc.appendChild(header);
				doc.appendText("\n");
				doc.appendChild(func_block);
				doc.appendText("\n\n\n\n\n\n");
			}
		}
		// working on a specific class, refer to that instead of dec for declarations
		else {
			println("creating doc for class: " + cur_class.name);
			boolean parsed_core_members = false;
			for (int f = 0; f < cur_class.member_funcs.size(); ++f) {
				String member_name = cur_class.member_funcs.get(f).name;
				if (parsed_names.contains(member_name)) continue;
				parsed_names.add(member_name);

				// use h2 for class core
				Element header;
				if (!parsed_core_members && member_name.equals(cur_class.name)) {
					header = create_header(h2, member_name);
					parsed_core_members = true;
				}
				else header = create_member_header(h3, member_name, cur_class.name);


				List<Function> related_members = new ArrayList<Function>();
				related_members.add(cur_class.member_funcs.get(f));
				for (int ff = f + 1; ff < cur_class.member_funcs.size(); ++ff)
					if (cur_class.member_funcs.get(ff).name.equals(member_name))
						related_members.add(cur_class.member_funcs.get(ff));	

				println("Related member functions: " + member_name);
				for (Function func : related_members)
					println(func.declaration);
				println("");
				
				Element member_block = create_block(related_members);	
				doc.appendChild(header);
				doc.appendText("\n");
				doc.appendChild(member_block);
				doc.appendText("\n\n\n\n\n\n");					
			}
		}

		return doc;
	} 
	public static void flush_doc(Document doc, File file) {
		// flush to file
		try {
			BufferedWriter htmlWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
			htmlWriter.write(StringUtils.unescapeHtml3(doc.toString()));
			htmlWriter.flush();
			htmlWriter.close();
		}
		catch (IOException e) {
			println("could not open: " + file.getPath());
		}		
	}

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
	public static void print_declarations(Declarations dec) {
		println("\nDeclared classes");
		for (Class clas : dec.classes) {
			println(clas.declaration);
			println("API:");
			for (Function member : clas.member_funcs) {
				println(member.declaration.replaceAll("^", "\t"));
			}
			println("private:");
			for (Function member : clas.private_member_funcs) {
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
	public static File get_output_file(String topic, String namespace, List<String> options) {
		// no advanced argument parsing...
		// resolve conflict if not forcing
		new File(portfolio_dir.resolve(namespace + topic).toString()).mkdirs();				// make directory if it doesn't exist
		String[] topic_levels = topic.split("/");
		String topic_name = topic_levels[topic_levels.length-1];
		File output = new File(portfolio_dir.resolve(namespace + topic + "/" + topic_name + ".md").toString());

		if (options.size() < 2 || (!options.contains("-f") && !options.contains("--force"))) {
			int version = 1;
			while (output.exists()) {
				output = new File(portfolio_dir.resolve(namespace + topic + "/" + topic_name + version + ".md").toString());
				++version;
			}
		}
		return output;
	}
	public static void main(String[] args) {
		if (args.length < 1) {System.out.println(args.length);println("usage: java Autodoc <source_file>"); return;}
		init_keywords();

		doc_source = args[0];
		source_section = doc_source.split("/",2)[0];
		source_topic = StringUtils.removeExtension(doc_source.split("/",2)[1]);

		File source = new File(library_dir.resolve(doc_source).toString());

		println("source: " + source.getPath());



		Declarations dec = read_declarations(source);
		print_declarations(dec);

		List<String> opts = Arrays.asList(args);
		// main document for all the namespace scope functions and class declarations
		Document doc = create_doc(dec, null);
		// for all additional functions, should create sub
		// table of contents for generated document
		if (dec.functions.size() > toc_threshold) {
			Element toc = Autotoc.create_toc(doc);
			doc.childNode(0).after(toc);
		}

		File output = get_output_file(source_topic, "", opts);
		println("output: " + output.getPath());

		System.out.print(StringUtils.unescapeHtml3(doc.toString()));
		flush_doc(doc, output);

		// documentation page for each class
		for (Class clas : dec.classes) {
			Document class_doc = create_doc(dec, clas);
			if (clas.member_funcs.size() > toc_threshold) {
				Element class_toc = Autotoc.create_toc(class_doc);
				class_doc.childNode(0).after(class_toc);
			}

			// class name becomes topic under the source topic namespace (ex. prime/Sieve)
			File class_output = get_output_file(clas.name, source_topic + '/', opts);
			println("class output: " + class_output.getPath());
			System.out.print(StringUtils.unescapeHtml3(class_doc.toString()));

			flush_doc(class_doc, class_output);
		}

	}

	static Tag h2 = Tag.valueOf("h2");
	static Tag h3 = Tag.valueOf("h3");
	static Tag h4 = Tag.valueOf("h4");
	static Tag div = Tag.valueOf("div");
	static Tag link = Tag.valueOf("a");
	static Tag code = Tag.valueOf("code");
	static Tag paragraph = Tag.valueOf("p");
	static Tag table = Tag.valueOf("table");
	static Tag tr = Tag.valueOf("tr");
	static Tag th = Tag.valueOf("th");
	static Tag td = Tag.valueOf("td");

	static int toc_threshold = 4;	// number of functions before a table of contents should be created
	// paths relative to my local copy of sal, this should be modifiable...
	static Path library_dir = Paths.get(System.getProperty("user.home") + "/Documents/mylibs/sal/");
	static Path portfolio_dir = Paths.get(System.getProperty("user.home") + "/Documents/portfolio/sal/");
	static Path portfolio_base_dir = Paths.get(System.getProperty("user.home") + "/Documents/portfolio/");
	static String doc_readme = "README.md";
	static String doc_source;
	static String source_section;	// algo, data
	static String source_topic;		// sort, prime...
	static String doc_file;
	static String github_base = "https://github.com/LemonPi/";
	static String github_branch = "/blob/master/";
	static String library_name = "sal/";

	// temporarily introduce types to the namespace
	private static List<Template> templates;
	// temporarily modify functions to be members
	private static List<Class> cur_classes;

	private static Set<Character> indent_delim = new HashSet<Character>();
	private static char scope_term = '}';
	private static char statement_term = ';';
	// ordered (by chance of cutting name short) characters that would force a name to be finished
	private static List<Character> name_term = new ArrayList<Character>();
	// characters that would force a declaration to be finished (after a right parenthesis)
	private static Set<Character> dec_term = new HashSet<Character>();
	// characters that distinguish a function call from definition (before a left parenthesis)
	private static Set<Character> call_beg = new HashSet<Character>();

	private static String template_typeword = "typename";
	private static String template_keyword = "template";

	private static String scope_seq = "::";
	private static String namespace_scopeword = "namespace";
	private static Set<String> alias_keywords = new HashSet<String>();
	private static Set<String> user_type_keywords = new HashSet<String>();
	private static Set<String> types = Stream.of("volatile", "const", "static", "constexpr", "typename",
			"void", "size_t", "int", "short", "long", "char", "uint32_t", "double", "float", "bool",
			"vector", "queue", "string", "stack",
			"std::vector", "std::queue", "std::string", "std::stack",
			"SPM",
			"ostream", "std::ostream").collect(Collectors.toCollection(HashSet::new));
	private static Set<String> class_member_keywords = Stream.of("static", "virtual").collect(Collectors.toCollection(HashSet::new));
	private static Set<String> access_modifiers = Stream.of("private:", "public:", "protected:").collect(Collectors.toCollection(HashSet::new));
}