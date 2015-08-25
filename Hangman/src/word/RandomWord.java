package word;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


public class RandomWord extends Word {
	
	public RandomWord() {
		HttpResponse<JsonNode> response;
		try {
			response = Unirest.get("https://wordsapiv1.p.mashape.com/words/bump/also")
					.header("X-Mashape-Key", "xJkqXGguDTmshoNIaGVnrMZlFPmUp1WrnZLjsn8DDx3DFQhNq5")
					.header("Accept", "application/json")
					.asJson();
			System.out.println(response.getBody());
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			length = word.length();
			characters = new HashMap<Integer, String>();
		for (int i = 0; i < getLength(); i++) {
			characters.put(i, "hidden");
		}
	}

}
