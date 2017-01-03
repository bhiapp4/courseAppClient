package com.jnit.app.client.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLConnectionDemo {

	public static void performGet() throws Exception {
		URL url = new URL("http://localhost:8080/courseApp/users");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		StringBuilder sb = new StringBuilder();
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			sb.append(output);
		}
		System.out.println(sb);
		conn.disconnect();
	}

	public static void main(String[] args) throws Exception {
		performGet();
	}

}
