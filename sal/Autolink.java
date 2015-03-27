import java.io.File;
import java.util.*;
import java.io.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Autolink {
	public static void print(String s) {
		System.out.print(s);
	}
	public static void println(String s) {
		System.out.println(s);
	}

	public static HashMap<String, String> store_words(Elements doc_links) {
		HashMap<String, String> page_words = new HashMap<>();

		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(dataname, true)))) {
		    for (Element link : doc_links) {
		    	String existing_link = keywords.get(link.text());
		    	// hasn't already been written
		    	if (existing_link == null) {
		    		out.println(link.text() + ',' + link.attr("abs:href"));
			    }
		    	// name clash of different functions
		    	else if (!link.attr("abs:href").equals(existing_link)) {
		    		System.out.println("name clash: " + link.text());
		    	}
		    	page_words.put(link.text(), link.attr("abs:href"));
		    }
		} 
		catch (IOException e) {}	

		return page_words;
	}

	// reads keywords from local file (names.txt) and holds it in memory
	public static void read_words() {
		keywords = new HashMap<String, String>();

		try(BufferedReader br = new BufferedReader(new FileReader(dataname))) {
	        String line = br.readLine();

	        while (line != null) {
	            String[] pair = line.split(",");
	            keywords.put(pair[0],pair[1]);
	            line = br.readLine();
	        }
	    }
	    catch (IOException e) {
	    	// make file
	    	File f = new File(dataname);
	    	try {
				f.createNewFile();
	    	}
	    	catch (IOException ee) {
	    		ee.printStackTrace();
	    	}
	    }

	}

	public static void link_page(File file, String base_name) {
		Document doc = null;
		try {
			doc = Jsoup.parse(file, "UTF-8", base_name);
		}
		catch (IOException e) {}

		Elements doc_links = doc.select("a.doc-list-name");

		// keywords specific to the page
		HashMap<String, String> page_words = store_words(doc_links);

		// look for unlinked keywords inside code blocks and link them
		boolean modified = false;
		Elements names = doc.select(link_elements);
		for (Element name : names) {
			// is a global keyword but not a page keyword
			String abs_link = keywords.get(name.text());
			if ((abs_link != null) && (page_words.get(name.text()) == null)) {
				// only consider the first instance, so store into page_words to avoid duplicate links
				page_words.put(name.text(), "");
				name.wrap("<a class='inlink' href=\""+abs_link+"\"></a>");
				// debugging print for
				System.out.format("%-15s --:%s\n", doc.title(), name.text());
				modified = true;
			} 
		}

		if (modified) {
			// flush to file
			System.out.format("modified: %s\n", file.getName());
			try {
				BufferedWriter htmlWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
				htmlWriter.write(doc.toString());
				htmlWriter.flush();
				htmlWriter.close();
			}
			catch (IOException e) {}
		}
	} 




    public static void walk(String path, String previous_path) {
    	// println("walking: " + path);
        File root = new File(path);
        File[] list = root.listFiles();

        if (list == null) return;

        for (File f : list) {
            if (f.isDirectory()) {
                walk(f.getAbsolutePath(), root.getName()+'/');
            }
            else if (f.getName().equals("index.html")) {
            	String short_name =  previous_path + root.getName() + '/';
            	System.out.format("linking: %s\n", short_name);

            	link_page(f, base_url + short_name);
            }
        }
    }



	public static void main(String[] args) {
		read_words();

		walk(site_directory, "");

	}

	static HashMap<String, String> keywords;	// keyword - link
	static String dataname = "names.txt";
	static String site_directory = "../_site/sal";
	static String base_url = "http://johnsonzhong.me/";
	static String link_elements = ".n, .nf";
}