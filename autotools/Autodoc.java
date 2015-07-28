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
	public static interface Namespace {
		public boolean class_scope();
		public boolean visible_dec();
		public List<Function> get_functions();
		public List<String> get_attributes();
		public String get_name();
		public Template get_template();
		public void add_function(Function f);
		public void add_class(Class c);
		public void add_member(String m);
		public void add_template(Template t);
		public void modify_access(String modifier);
	}
	public static class Anonymous_ns implements Namespace {
		Template template;
		Anonymous_ns() {
			template = null;
		}

		public boolean class_scope() {
			return false;
		}
		public boolean visible_dec() {
			return false;
		}		
		public List<Function> get_functions() {
			return null;
		}
		public List<String> get_attributes() {
			return null;
		}
		public String get_name() {
			return "anonymous or function";
		}
		public Template get_template() {
			return template;
		}
		public void add_function(Function f) {}
		public void add_class(Class c) {}
		public void add_member(String m) {}
		public void add_template(Template t) {
			template = t;
		}
		public void modify_access(String modifier) {}
	}
	private static class First_word {
		public String word;
		public int indent_level;
	}
	public static class Declarations implements Namespace {
		public List<Class> classes;
		public List<Function> functions;
		public List<String> globals;
		Template template;
		Declarations() {
			classes = new ArrayList<Class>();
			functions = new ArrayList<Function>();
			globals = new ArrayList<String>();
			template = null;
		}
		public boolean class_scope() {
			return false;
		}
		public boolean visible_dec() {
			return true;
		}
		public List<Function> get_functions() {
			return functions;
		}
		public List<String> get_attributes() {
			return globals;
		}
		public String get_name() {
			return "global namespace";
		}
		public Template get_template() {
			return template;
		}
		public void add_function(Function f) {
			functions.add(f);
		}
		public void add_class(Class c) {
			classes.add(c);
		}
		public void add_member(String m) {
			globals.add(m);
		}
		public void add_template(Template t) {
			template = t;
		}
		public void modify_access(String modifier) {}
	}
	public static class Template {
		public String declaration;
		Set<String> types;
		Template(String line) {
			declaration = line;
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

		private static String template_typeword = "typename";
	}
	public static class Class implements Namespace {
		public String declaration;
		public String name;
		public List<Function> member_funcs;
		public List<Function> private_member_funcs;
		public List<String> members;
		public List<String> private_members;
		public boolean private_scope;	// whether members currently seen are private or public
		Template template;
		Class(String dec, String n, boolean default_scope, Template t) {
			if (t != null) declaration = t.declaration + '\n' + dec;
			else declaration = dec;
			name = n;
			private_scope = default_scope;
			member_funcs = new ArrayList<Function>();
			private_member_funcs = new ArrayList<Function>();
			members = new ArrayList<String>();
			private_members = new ArrayList<String>();
			template = t;
		}
		public void add_member_func(Function func) {
			if (private_scope) private_member_funcs.add(func);
			else member_funcs.add(func);
		}	
		public boolean class_scope() {
			return true;
		}
		public boolean visible_dec() {
			return true;
		}		
		public List<Function> get_functions() {
			return member_funcs;
		}
		public List<String> get_attributes() {
			return members;
		}
		public String get_name() {
			return name;
		}
		public Template get_template() {
			return template;
		}	
		public void add_function(Function f) {
			if (private_scope) private_member_funcs.add(f);
			else member_funcs.add(f);
		}
		public void add_class(Class c) {
			return;	// not implemented yet
		}	
		public void add_member(String m) {
			if (private_scope) private_members.add(m);
			else members.add(m);
		}
		public void add_template(Template t) {
			template = t;
		}
		public void modify_access(String modifier) {
			if (modifier.startsWith("private")) private_scope = true;
			else private_scope = false;			
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

	// utility functions
	public static void print(String s) {
		System.out.print(s);
	}
	public static void println(String s) {
		System.out.println(s);
	}

	// input is source file
	public static class Declaration_stream {
		BufferedReader br;
		Declarations dec;

		Deque<Namespace> nss;
		// current namespace (should always be the top namespace in nss)		
		Namespace ns;
		// namespace under construction
		Namespace new_ns;

		Template template;	// current template, attaches onto next namespace it sees
		// current character
		int c;

		Declaration_stream(File file) {
			try {
				br = new BufferedReader(new FileReader(file));
				dec = new Declarations();
				nss = new ArrayDeque<Namespace>();
				nss.push(dec);
				ns = dec;
				new_ns = new Anonymous_ns();
				template = null;
				c = 0;
				println("starting namespace: " + (nss.size() - 1) + " " + ns.get_name());
			}
			catch (IOException e) {
				println("could not read: " + file.getPath());
				dec = null;
			}
		}


		public void add_new_type(String new_type) {
			types.add(new_type);
			print("new type: ");
			println(new_type);			
		}

		public boolean is_type(String word) {
			if (types.contains(word)) return true;
			if (template != null && template.types.contains(word)) return true;
			// check existing nested namespaces for the name
			for (Namespace n : nss) {
				if (n.get_template() != null && n.get_template().types.contains(word)) return true;
			}	
			return false;		
		}
		public boolean weak_declaration(String word) {
			return weak_references.contains(word);
		}

		public boolean read_char() throws IOException {
			return (c = br.read()) != -1;
		}
		// read with the first character being c (ch is just an overload)
		public String read_word(int ch) throws IOException {
			StringBuilder word_builder = new StringBuilder();
			word_builder.append((char)c);
			// && short circuit to force read first
			while ((read_char()) && (Character.isJavaIdentifierPart(c) || c == scope_op))
				word_builder.append((char)c);
			// has to check here since every caller works with the next character
			if (c == scope_term) exit_namespace();
			else if (c == '{') enter_namespace();
			return word_builder.toString();
		}
		// read from the end of a word to the next word
		public String read_word() throws IOException {
			c = br.read();
			while (Character.isWhitespace(c)) if ((c = br.read()) == -1) return null;
			return read_word(c);			
		}

		public void skip_statement() throws IOException {
			while (read_char() && c != statement_term);
		}
		public void skip_line() throws IOException {
			while (read_char() && c != '\n');
		}		
		public Function get_function(String line) {
			// assumes caller found both parenthesis
			int lp_index = line.indexOf('(');
			int rp_index = line.indexOf(')');
			if (lp_index < 0 || rp_index < 0) {
				println("not function: lacks parenthesis");
				return null;
			} 

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

			int term_index = line.length() - 2;
			while (Character.isWhitespace(line.charAt(term_index)) || line.charAt(term_index) == '{') --term_index;
			String func_dec = line.substring(0,term_index+1) + statement_term;

			List<String> func_params = new ArrayList<String>();
			// right next to each other, no parameters such as operator()()
			if (rp_index == lp_index + 1) {
				// fix operator()()
				if (func_name.startsWith("operator")) func_name += "()";
			}
			else {
				String[] params_with_types = line.substring(lp_index+1, rp_index).split(",");
				// verify first param preceeded by type
				boolean valid_param_type = false;
				String fp = params_with_types[0];
				// perhaps declared like void foo(int&);
				if (fp.indexOf(' ') < 0) fp = StringUtils.trim_last(fp, "&*");
				else fp = StringUtils.trim_last(fp.substring(0, fp.indexOf(' ')), "&*");
				if (fp.indexOf('<') > -1) fp = fp.substring(0, fp.indexOf('<'));

				valid_param_type = is_type(fp);

				if (!valid_param_type) {
					println("not function: parameter is invalid type: " + fp);
					return null;
				}
				// last word is param name
				for (String param : params_with_types) {
					// default parameter, get rid of = value
					if (param.indexOf('=') > -1) 
						param = param.split("=")[0];
					param = param.trim();

					func_params.add(StringUtils.trim_first(param.substring(param.lastIndexOf(' ')+1), "&*"));
				}
			}

			println("func name: " + '[' + func_name + ']');
			for (String param : func_params) print('[' + param + "] "); if (!func_params.isEmpty()) println("");

			Function func = new Function(decorate_with_template(func_dec), func_name, func_params);
			return func;
		}
		public String decorate_with_template(String declaration) {
			if (template != null) {
				declaration = template.declaration + '\n' + declaration;
				template = null;
			}
			return declaration;
		}
		// parsing functions take the first word (template, class, struct, ...)
		public void parse_template(String word) throws IOException {
			StringBuilder sb = new StringBuilder(word);
			sb.append((char)c);
			
			while (read_char()) {
				sb.append((char)c);
				if (c == '<') break;
			}
			int template_level = 1;	// 1 level of <>, finish reading by counting '>'
			while (template_level != 0 && (read_char())) {
				sb.append((char)c);
				if (c == '<') ++template_level;
				else if (c == '>') --template_level;
			}
			template = new Template(sb.toString());
		}
		public void parse_class(String word) throws IOException {
			StringBuilder sb = new StringBuilder(word);
			sb.append((char)c);
			String class_name = read_word();
			sb.append(class_name);
			sb.append((char)c);

			boolean private_scope = true;
			if (word.equals("struct")) private_scope = false;
			println("private scope: " + private_scope);


			while (read_char()) {
				sb.append((char)c);
				if (c == statement_term) {
					add_new_type(class_name);
					Class clas = new Class(sb.toString(), class_name, private_scope, template);
					template = null;
					ns.add_class(clas);
					new_ns = clas;
					println("class: " + clas.declaration);
					return;
				}
				else if (c == '{') {
					add_new_type(class_name);
					int term_index = sb.length() - 2;
					while (Character.isWhitespace(sb.charAt(term_index))) --term_index;
					sb.setCharAt(++term_index, statement_term);
					Class clas = new Class(sb.substring(0, term_index+1), class_name, private_scope, template);
					template = null;
					ns.add_class(clas);
					new_ns = clas;
					enter_namespace();
					println("class: " + clas.declaration);
					return;
				}
			}			
		}
		public void parse_type(String word) throws IOException {
			StringBuilder sb = new StringBuilder(word);
			sb.append((char)c);
			
			int potential = 0;	// 0 for no potential, 1 for (, 2 for both ()
			if (c == '(') potential = 1;	// '(' following classname
			while (read_char()) {
				sb.append((char)c);
				// System.out.println("[" + (char)c + ']');
				// potential start of function
				if (c == '(') potential = 1;
				else if (c == ')' && potential == 1) potential = 2;
				else if (dec_term.contains((char)c) || (potential == 2 && c == ':')) {
					if (potential == 2) {
						Function func = get_function(sb.toString());
						if (func != null) {
							println("function: " + func.declaration);
							ns.add_function(func);
						}
					}
					// could be public class member
					else if (ns.class_scope()) {
						// if terminated on a default initializer, such as size_t n {3};
						if (c != statement_term) {
							while (read_char() && c != statement_term) sb.append((char)c);
							sb.append(statement_term);
						}
						String class_member = sb.toString();
						println("class member: " + class_member);
						ns.add_member(class_member);
					}
					if (c == '{') enter_namespace();
					return;
				}
			}			
		}

		public void parse_keyword() throws IOException {
			String word = read_word(c);
			if (word == null) return;
			println("word: " + word);

			if (word.equals(template_keyword)) parse_template(word);
			else if (weak_declaration(word)) {
				println("weak declaration: ");
				skip_statement();
			}
			else if (is_type(word)) {
				println("type: ");
				parse_type(word);
			}
			else if (access_modifiers.contains(word)) {
				println("access modifier: ");
				ns.modify_access(word);
			}
			// ignore namespace sal { declarations
			else if (word.equals(namespace_scopeword)) {
				println("assuming sal namespace:");
				while (read_char()) if (c == '{') return;
			}
			// new user defined type
			else if (user_type_keywords.contains(word)) {
				print("\nuser type: ");
				parse_class(word);
			}
			else if (alias_keywords.contains(word)) {
				print("alias: ");

				// using something from a namespace without giving new name
				String next_word = read_word();
				if (next_word == null) return;
				println("next word: " + next_word);

				if (next_word.equals(namespace_scopeword)) {
					// just ignore bringing whole namespaces 
					String[] alias_words = br.readLine().split(scope_seq);
					// using specific name from namespace
					if (alias_words.length > 1) {
						println("bringing in name: " + alias_words[alias_words.length - 1]);
						types.add(alias_words[alias_words.length - 1]);
					}
				}
				// else aliasing new local type
				else {
					add_new_type(next_word);
					// have to terminate statement, and nothing interesting afterwards
					skip_statement();
				}
			}										
		}
		public void enter_namespace() throws IOException {
			// worthwhile to keep track of because declarations can be seen
			if (new_ns.visible_dec()) {
				println("\nbegin namespace: " + nss.size() + " " + new_ns.get_name());
				if (template != null) {
					new_ns.add_template(template);
					template = null;
				}
				nss.push(new_ns);
				// traverse "inwards" in namespace
				ns = new_ns;
				new_ns = new Anonymous_ns();			
				return;
			}
			println("\nskipping anonymous namespace");
			// skip to end of anonymous namespace
			int scope_level = 1;
			while (read_char() && scope_level != 0) {
				if (c == '{') ++scope_level;
				else if (c == '}') --scope_level;
			}
		}
		public void exit_namespace() {
			// traverse "outwards"
			println("end namespace: " + ns.get_name());
			nss.pop();
			if (!nss.isEmpty()) {
				ns = nss.peek();
				println("back on: " + (nss.size() - 1) + " " + ns.get_name() + '\n');
			}
			new_ns = new Anonymous_ns();
		}
		public void read_declarations() throws IOException {
			while (read_char()) {
				// skip all whitespaces
				while (Character.isWhitespace(c)) if ((c = br.read()) == -1) return;

				switch ((char) c) {
					// prcompilation
					case '#': {
						String preprocessing = br.readLine();
						if (preprocessing.contains("include") && preprocessing.indexOf('<') > 0) {
							String new_data = preprocessing.substring(preprocessing.indexOf('<')+1, preprocessing.indexOf('>'));
							add_new_type(new_data);
							add_new_type("std::"+new_data);
						}
						break;
					}
					// potential comment, ignore line
					case '/':
						c = br.read();
						if (c == '/') skip_line();
						else if (c == '*') {
							while (read_char()) {
								if (c == '*' && ((read_char()) && c == '/')) break;
							}
						}
						break;
						// else not a comment and should drop down
					case '{':
						enter_namespace();
						break;
					case '}':
						exit_namespace();
						break;
					// begin function
					case '(':
						// assumes mark set at the start of 
						break;
					case ')':
						break;
					case ':':
						break;
					case ';':
						break;
					// keywords
					default:
						if (Character.isJavaIdentifierStart(c)) parse_keyword();
				}
			}
		}

		public Declarations get_declarations() {
			return dec;
		}

		// static members
		private static Set<Character> indent_delim = Stream.of(' ', '\t').collect(Collectors.toCollection(HashSet::new));
		private static char scope_term = '}';
		private static char scope_op = ':';
		private static char statement_term = ';';
		// ordered (by chance of cutting name short) characters that would force a name to be finished
		private static List<Character> name_term = Stream.of('<','&','*','(').collect(Collectors.toCollection(ArrayList::new));
		// characters that would force a declaration to be finished (after a right parenthesis)
		private static Set<Character> dec_term = Stream.of('{',';').collect(Collectors.toCollection(HashSet::new));
		// characters that distinguish a function call from definition (before a left parenthesis)
		private static Set<Character> call_beg = Stream.of('{',',','=','+','-','/','.').collect(Collectors.toCollection(HashSet::new));

		private static String template_typeword = "typename";
		private static String template_keyword = "template";

		private static String scope_seq = "::";
		private static String namespace_scopeword = "namespace";
		private static Set<String> weak_references = Stream.of("friend").collect(Collectors.toCollection(HashSet::new));
		private static Set<String> alias_keywords = Stream.of("using", "typedef").collect(Collectors.toCollection(HashSet::new));
		private static Set<String> user_type_keywords = Stream.of("struct", "class").collect(Collectors.toCollection(HashSet::new));
		private static Set<String> types = Stream.of("volatile", "const", "static", "constexpr", "typename", 
				"void", "size_t", "int", "short", "long", "char", "uint32_t", "double", "float", "bool",
				"vector", "queue", "string", "stack", "istream",
				"std::vector", "std::queue", "std::string", "std::stack", "std::istream",
				"SPM",
				"ostream", "std::ostream").collect(Collectors.toCollection(HashSet::new));
		private static Set<String> class_member_keywords = Stream.of("static", "virtual").collect(Collectors.toCollection(HashSet::new));
		private static Set<String> access_modifiers = Stream.of("private:", "public:", "protected:").collect(Collectors.toCollection(HashSet::new));		
	}

	public static Declarations read_declaration_stream(File file) {
		try {
			Declaration_stream ds = new Declaration_stream(file);
			ds.read_declarations();
			return ds.get_declarations();
		}
		catch (IOException e) {
			println("could not read from: " + file.getPath());
			return null;
		}
	}


	// --------------------------------------------
	//	Document creation methods
	// --------------------------------------------

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
	public static Element create_block(List<Function> funcs, Namespace ns) {
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
		// if currently detailing the core functions of the namespace
		println("creating block for related: " + funcs.get(0).name);
		if (ns != null && funcs.get(0).name.equals(ns.get_name()) && !ns.get_attributes().isEmpty()) {
			println("creating public attributes");
			func_decs.append("\npublic:\n");
			for (String attr : ns.get_attributes()) {
				func_decs.append("\t");
				func_decs.append(attr);
				func_decs.append("\n");
			}
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
	public static void add_members_to_dec_list(Element dec_list, Class cur_class) {
			Set<String> listed_members = new HashSet<String>();
					
			listed_members.add(cur_class.name);	// constructors and core functions
			for (Function func : cur_class.member_funcs) {
				if (listed_members.contains(func.name)) continue;
				listed_members.add(func.name);
				dec_list.appendChild(create_dec_list_row(td, func.name, false));
				dec_list.appendText("\n");
			}		
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
				// add class name and all its members directly
				if (collapse_classes) {
					dec_list.appendChild(create_dec_list_row(th, clas.name, false));
					add_members_to_dec_list(dec_list, clas);
				}
				else {
					dec_list.appendChild(create_dec_list_row(th, clas.name, true));
				}
				dec_list.appendText("\n");
			}
			dec_list.appendText("\n");
		}
		// working on a class document
		else {
			// class constructors and core methods
			dec_list.appendChild(create_dec_list_row(th, cur_class.name, false));
			dec_list.appendText("\n");
			// add member functions in order but without repeat
			add_members_to_dec_list(dec_list, cur_class);
		}

		wrapper_block.appendChild(dec_list);
		return wrapper_block;
	}
	public static void create_all_blocks(Document doc, Namespace ns) {
		List<Function> funcs = ns.get_functions();
		Set<String> parsed_names = new HashSet<String>();
		boolean parsed_core_members = false;

		for (int f = 0; f < funcs.size(); ++f) {
			String func_name = funcs.get(f).name;
			if (parsed_names.contains(func_name)) continue;
			parsed_names.add(func_name);

			Element header;
			if (ns.class_scope()) {
				// use h2 for class core
				if (!parsed_core_members && func_name.equals(ns.get_name())) {
					header = create_header(h2, func_name);
					parsed_core_members = true;
				}
				else header = create_member_header(h3, func_name, ns.get_name());
			}
			else header = create_header(h3, func_name);


			List<Function> related_funcs = new ArrayList<Function>();
			related_funcs.add(funcs.get(f));
			// linear search from current location for all related ones (if a related one was earlier in index, this function would be covered)
			for (int ff = f + 1; ff < funcs.size(); ++ff)
				if (funcs.get(ff).name.equals(func_name))
					related_funcs.add(funcs.get(ff));

			println("Related functions: " + func_name);
			for (Function func : related_funcs)
				println(func.declaration);
			println("");

			Element func_block = create_block(related_funcs, ns);
			if (func_block == null) println("null block how come?");
			doc.appendChild(header);
			doc.appendText("\n");
			doc.appendChild(func_block);
			doc.appendText("\n\n\n\n\n\n");
		}
	}
	public static Document create_doc(Declarations dec, Class cur_class, Document base_doc) {
		Document doc = new Document("");
		doc.outputSettings(new Document.OutputSettings().prettyPrint(false).escapeMode(EscapeMode.xhtml));//makes html() preserve linebreaks and spacing

		// yaml header only for the base document, or class documents when they're not being collapsed
		if (cur_class == null || !collapse_classes) {
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
		}

		// working on the namespace scope functions
		if (cur_class == null) {
			create_all_blocks(doc, dec);
		}
		// working on a specific class, refer to that instead of dec for declarations
		else {
			// work off of base doc instead
			if (collapse_classes) doc = base_doc;
			println("creating doc for class: " + cur_class.name);
			create_all_blocks(doc, cur_class);			

			// null signifies no work was done on own document
			if (collapse_classes) return null;
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


	public static void print_declarations(Declarations dec) {
		println("\nDeclared classes");
		for (Class clas : dec.classes) {
			println(clas.declaration);
			println("API:");
			for (Function member : clas.member_funcs) 
				println("\t" + member.declaration.replaceAll("\n", "\n\t"));
			println("data:");
			for (String member : clas.members) 
				println("\t" + member.replaceAll("\n", "\n\t"));
			println("private:");
			for (Function member : clas.private_member_funcs) 
				println("\t" + member.declaration.replaceAll("\n", "\n\t"));
			println("private members:");
			for (String member : clas.private_members) 
				println("\t" + member.replaceAll("\n", "\n\t"));
			println("");
		}
		println("\nDeclared functions");
		for (Function func : dec.functions) {
			println(func.declaration);
			println("");
		}		
	}
	public static void parse_args(String[] args) {
		for (String arg : args) {
			if (!force_override && (arg.equals("-f") || arg.equals("--force"))) force_override = true;
			else if (!collapse_classes && (arg.equals("-c") || arg.equals("--collapse"))) collapse_classes = true;
		}
	}
	public static File get_output_file(String topic, String namespace) {
		// no advanced argument parsing...
		// resolve conflict if not forcing
		new File(portfolio_dir.resolve(namespace + topic).toString()).mkdirs();				// make directory if it doesn't exist
		String[] topic_levels = topic.split("/");
		String topic_name = topic_levels[topic_levels.length-1];
		File output = new File(portfolio_dir.resolve(namespace + topic + "/" + topic_name + ".md").toString());

		if (!force_override) {
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
		// init_keywords();
		parse_args(args);

		doc_source = args[0];
		source_section = doc_source.split("/",2)[0];
		source_topic = StringUtils.removeExtension(doc_source.split("/",2)[1]);

		File source = new File(library_dir.resolve(doc_source).toString());

		println("source: " + source.getPath());



		Declarations dec = read_declaration_stream(source);
		print_declarations(dec);

		// main document for all the namespace scope functions and class declarations
		Document doc = create_doc(dec, null, null);



		// documentation page for each class
		for (Class clas : dec.classes) {
			Document class_doc = create_doc(dec, clas, doc);
			// will be null if collapsing classes into the base document
			if (class_doc != null) {
				if (clas.member_funcs.size() > toc_threshold) {
					Element class_toc = Autotoc.create_toc(class_doc);
					class_doc.childNode(0).after(class_toc);
				}

				// class name becomes topic under the source topic namespace (ex. prime/Sieve)
				File class_output = get_output_file(clas.name, source_topic + '/');
				println("class output: " + class_output.getPath());
				System.out.print(StringUtils.unescapeHtml3(class_doc.toString()));
				flush_doc(class_doc, class_output);

			}
		}
		// for all additional functions, should create sub
		// table of contents for generated document
		if (dec.functions.size() > toc_threshold || collapse_classes) {
			Element toc = Autotoc.create_toc(doc);
			doc.childNode(0).after(toc);
		}
		File output = get_output_file(source_topic, "");
		println("output: " + output.getPath());
		System.out.print(StringUtils.unescapeHtml3(doc.toString()));
		flush_doc(doc, output);
	}
	// commandline options
	private static boolean force_override = false;
	private static boolean collapse_classes = false;

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

	private static String scope_seq = "::";

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

}