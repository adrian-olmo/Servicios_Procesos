/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.*;
import java.net.*;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class Cliente {

    public static void main(String args[]) {
        InetAddress direccion;
        Socket servidor;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Conexion con el servidor establecida");

        try {
            direccion = InetAddress.getByName("127.0.0.1");
            servidor = new Socket(direccion, 5005);

            System.out.println("Que carpeta quieres listar: ");
            String ruta = sc.nextLine();

            File carpeta = new File(ruta);
            System.out.println("//// LISTADO COMPLETO");

            File[] archivos = carpeta.listFiles();
            if (archivos == null || archivos.length == 0) {
                System.out.println("No hay elementos dentro de la carpeta actual");
                return;
            } else {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                for (int i = 0; i < archivos.length; i++) {
                    File archivo = archivos[i];
                    System.out.println(String.format("%s // (%s) // %s - %s",
                            archivo.getName(),
                            archivo.isDirectory() ? "Carpeta" : "Archivo",
                            archivo.isHidden() ? "Oculto" : "Visible",//dice si el archivo o directorio está oculto
                            sdf.format(archivo.lastModified())
                    ));
                }
            }
            servidor.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
