package com.googlesearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * http://www.basicsbehind.com/google-search-programmatically/
 * @author shaikhwa
 *
 */
public class CustomGoogleSearch {
	final static String apiKey = "AIzaSyAFmFdHiFK783aSsdbq3lWQDL7uOSbnD-QnCnGbY";
	final static String customSearchEngineKey = "00070362344324199532843:wkrTYvnft8ma";
	final static String searchURL = "https://www.googleapis.com/customsearch/v1?";
 
	public static String search(String pUrl) {
		try {
			URL url = new URL(pUrl);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
 
			String line;
			StringBuffer buffer = new StringBuffer();
			while ((line = br.readLine()) != null) {
				buffer.append(line);
			}
			return buffer.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	private static String buildSearchString(String searchString, int start, int numOfResults) {
		String toSearch = searchURL + "key=" + apiKey + "&cx=" + customSearchEngineKey + "&q=";
 
		// replace spaces in the search query with +
		String newSearchString = searchString.replace(" ", "%20");
 
		toSearch += newSearchString;
 
		// specify response format as json
		toSearch += "&alt=json";
 
		// specify starting result number
		toSearch += "&start=" + start;
 
		// specify the number of results you need from the starting position
		toSearch += "&num=" + numOfResults;
 
		System.out.println("Seacrh URL: " + toSearch);
		return toSearch;
	}
 
 
	public static void main(String[] args) throws Exception {
 
		String url = buildSearchString("BasicsBehind", 1, 10);
		String result = search(url);
		System.out.println(result);
 
	}
}