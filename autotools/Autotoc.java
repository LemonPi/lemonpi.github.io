package autotools;
// usage: java Autotoc file_to_parse [toc_caption]
// creates toc_file in directory run, with the content being the table of contents
import java.nio.file.*;
import java.io.File;
import java.util.*;
import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.parser.Tag;

public class Autotoc {
	public static void print(String s) {
		System.out.print(s);
	}
	public static void println(String s) {
		System.out.println(s);
	}
	static String readFile(String path) throws IOException {
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return new String(encoded);
	}
	public static Element create_toc(Document doc) {

		Tag div = Tag.valueOf("div");
		Tag link = Tag.valueOf("a");
		Tag paragraph = Tag.valueOf("p");

		Element toc = new Element(div, "");
		toc.addClass("toc");
		toc.appendText("\n");


		Elements titles = doc.getElementsByClass(title_class);

		for (Element title : titles) {
			Element title_link = title.getElementsByClass(title_link_class).first();

			String title_tag = title.tagName();
			String title_name = title.ownText();
			String title_link_name = title_link.attr("name");
			String title_link_href = title_link.attr("href");
			// System.out.format("%s %-30s %-20s %s\n", title_tag, title_name, title_link_name, title_link_href);

			Element toc_title = new Element(link, "");
			toc_title.addClass("toc-link");
			toc_title.addClass("toc"+title_tag);
			toc_title.attr("href", title_link_href);
			toc_title.text(title_name.split(name_delims)[0].trim());

			toc.appendText("\t");
			toc.appendChild(toc_title);
			toc.appendText("\n");
		}

		// add caption
		Element caption = new Element(paragraph, "");
		caption.addClass("toc-caption");
		caption.text(toc_caption);
		toc.appendChild(caption);
		toc.appendText("\n");

		Element toggle = new Element(paragraph, "");
		toggle.addClass("toc-toggle");
		toggle.text(toggle_text);
		toc.appendChild(toggle);
		toc.appendText("\n");

		return toc;
	} 




	public static void main(String[] args) {
		if (args.length < 1) {println("usage: java Autotoc file_to_parse [toc_caption]"); return;}
		if (args.length == 2) toc_caption = args[1];
		String filename = Autodoc.portfolio_base_dir.resolve(args[0]).toString();
		println("file to parse: " + filename);

		File file = new File(filename);
		try {
			Document doc = Jsoup.parse(file, "UTF-8", "");
			Element toc = create_toc(doc);
			// flush to file
			try {
				BufferedWriter htmlWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(toc_file), "UTF-8"));
				htmlWriter.write(StringUtils.unescapeHtml3(toc.toString()));
				System.out.print(StringUtils.unescapeHtml3(toc.toString()));
				htmlWriter.flush();
				htmlWriter.close();
			}
			catch (IOException e) {
				println("could not open: " + toc_file);
			}
		}
		catch (IOException ex) {
			println("could not read: " + filename);
		}
	}

	static String title_link_class = "anchor-link";
	static String title_class = "anchor";
	static String toc_file = "toc.md";
	static String toc_caption = "";
	static String toggle_text = "toggle TOC (ctrl + &#8660;)";
	private static String name_delims = "\\|";

}