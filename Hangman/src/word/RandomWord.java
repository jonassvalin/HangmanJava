package word;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import org.apache.commons.io.IOUtils;

public class RandomWord extends Word {
	
	public RandomWord() {
		/*
		try {
			HttpResponse<JsonNode> response = Unirest.get("https://wordsapiv1.p.mashape.com/words/bump/also")
					.header("X-Mashape-Key", "<required>")
					.header("Accept", "application/json")
					.asJson();
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		URL url;
		try {
			url = new URL("https://wordsapiv1.p.mashape.com/words/soliloquy");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
            con.setDoOutput(true);
			con.addRequestProperty("X-Mashape-Key", "xJkqXGguDTmshoNIaGVnrMZlFPmUp1WrnZLjsn8DDx3DFQhNq5");
			con.addRequestProperty("Accept", "application/json");
			InputStream in = con.getInputStream();
			String encoding = con.getContentEncoding();
			encoding = encoding == null ? "UTF-8" : encoding;
			String body = IOUtils.toString(in, encoding);
			System.out.println(body);
			length = word.length();
			characters = new HashMap<Integer, String>();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < getLength(); i++) {
			characters.put(i, "hidden");
		}
	}

}
