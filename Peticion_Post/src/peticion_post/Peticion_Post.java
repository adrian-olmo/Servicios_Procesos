/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peticion_post;

import java.net.*;
import java.io.*;
import java.util.*;

public class Peticion_Post {
	public static void main(String[] args){
	try
	{
		String data = "nombre=Hello+World!&edad=23";
		URL url = new URL("https://adridominio.000webhostapp.com/index.php?valor=sfsfafas&hora=fegwre");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.getOutputStream().write(data.getBytes("UTF-8"));
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String linea;
		while ((linea = reader.readLine()) != null) {
			System.out.println(linea);
		}
		reader.close();// cerrar flujo

		} catch (MalformedURLException me) {
			System.err.println("MalformedURLException: " + me);
		} catch (IOException ioe) {
			System.err.println("IOException:  " + ioe);
		}
	}
}
