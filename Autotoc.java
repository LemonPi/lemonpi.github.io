// usage: java Autodoc.java [FILEPATH]
// creates toc_file in directory run, with the content being the table of contents
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

	public static void create_toc(File file) {
		Document doc = null;
		try {
			doc = Jsoup.parse(file, "UTF-8", "");
		}
		catch (IOException e) {
			println("could not load file" + file.getName());
		}

		Tag div = Tag.valueOf("div");
		Tag link = Tag.valueOf("a");
		Tag paragraph = Tag.valueOf("p");

		Element toc = new Element(div, "");
		toc.addClass("toc");


		Elements titles = doc.getElementsByClass(title_class);

		for (Element title : titles) {
			Element title_link = title.getElementsByClass(title_link_class).first();

			String title_tag = title.tagName();
			String title_name = title.ownText();
			String title_link_name = title_link.attr("name");
			String title_link_href = title_link.attr("href");
			// System.out.format("%s %-30s %-20s %s\n", title_tag, title_name, title_link_name, title_link_href);

			Element toc_title = new Element(link, "");
			toc_title.addClass("toc"+title_tag);
			toc_title.attr("href", title_link_href);
			toc_title.text(title_name);

			toc.appendChild(toc_title);
		}

		// add caption
		Element caption = new Element(paragraph, "");
		caption.addClass("toc-caption");
		caption.text(toc_caption);
		toc.appendChild(caption);

		Element toggle = new Element(paragraph, "");
		toggle.addClass("toc-toggle");
		toggle.text(toggle_text);
		toc.appendChild(toggle);

		// flush to file
		try {
			BufferedWriter htmlWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(toc_file), "UTF-8"));
			htmlWriter.write(toc.toString());
			htmlWriter.flush();
			htmlWriter.close();
		}
		catch (IOException e) {
			println("could not open: " + toc_file);
		}
	} 




	public static void main(String[] args) {
		if (args.length != 1) {System.out.println(args.length);println("Need to provide one file to parse"); return;}
		String filename = args[0];
		println("file to parse: " + filename);

		File file = new File(filename);

		create_toc(file);

	}

	static String title_link_class = "anchor-link";
	static String title_class = "anchor";
	static String toc_file = "toc.md";
	static String toc_caption = "(bolded sections are more interesting)";
	static String toggle_text = "toggle TOC";

}