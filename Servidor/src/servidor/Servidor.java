/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.*;
import java.net.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Servidor {

    public static void main(String args[]) {
        ServerSocket servidor;
        Socket socket;
        //Cliente cliente = null;
        try {
            servidor = new ServerSocket(5005);
            System.out.println("Iniciando Conexion...");
            while (true) {
                socket = servidor.accept();
                System.out.println("Conexion Entrante");
                OutputStream flujoSalida = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(flujoSalida);

                InputStream flujoEntrada = socket.getInputStream();
                DataInputStream dis = new DataInputStream(flujoEntrada);

                //Lectura y listado del directorio
                String sDirectorio = "./";
                String listadoFicheros = "";
                File f = new File(sDirectorio);
                File[] ficheros = f.listFiles();

                for (int x = 0; x < ficheros.length; x++) {
                    if (listadoFicheros.equals("")) {
                        listadoFicheros = ficheros[x].getName();
                    } else {
                        listadoFicheros = listadoFicheros + ";" + ficheros[x].getName();
                    }

                }
                dos.writeUTF(listadoFicheros);//<- "directorio1;directorio2;directorio3"
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
