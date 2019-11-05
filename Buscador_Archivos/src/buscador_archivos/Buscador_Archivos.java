/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscador_archivos;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.lang.Runnable;

/**
 *
 * @author Usuario DAM 2
 */
public class Buscador_Archivos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

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
                
                Thread hilolectura = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        
                     }
                });
                File archivo = archivos[i];
                System.out.println(String.format("%s // (%s) // %s - %s",
                        archivo.getName(),
                        archivo.isDirectory() ? "Carpeta" : "Archivo",
                        archivo.isHidden() ? "Oculto": "Visible",//dice si el archivo o directorio está oculto
                        sdf.format(archivo.lastModified())
                ));
            }
        }

    }
}
