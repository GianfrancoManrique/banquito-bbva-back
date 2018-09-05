package com.prueba.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestSMS {
	
	public static void main(String[] args) {
		 sendSms();
	}
	
	public static String sendSms() {
		try {
			// Construct data
			String user = "username=" + "arbarrios0216@gmail.com";
			String hash = "&hash=" + "02647dce28373d0c1a3e7d71bdb877d06ea2de20c6f96f8d644839a35fc7040d";
			String message = "&message=" + "Ven y Ayude a tus amigos con la jalaton mas grande";
			String sender = "&sender=" + "Mi BANQUITO";
			String numbers = "&numbers=" + "51991271814";

			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("http://api.txtlocal.com/send/?").openConnection();
			String data = user + hash + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();

			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}
