/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package peticion_get;

import java.io.*;
import java.net.*;

public class Peticion_Get {
	public static void main(String[] args) {
		try {
			URL url = new URL("https://adridominio.000webhostapp.com/index.php?valor=Adri&hora=154");
			URLConnection conexion = url.openConnection();
			// LEER DE LA URL
			BufferedReader reader = new BufferedReader(new InputStreamReader(conexion.getInputStream()));
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
	}// main
}
