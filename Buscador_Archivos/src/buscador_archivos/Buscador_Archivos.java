/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscador_archivos;

import java.io.File;
import java.util.Scanner;

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

        System.out.println("¿En qué ruta quieres buscar los archivos");
        String path = sc.nextLine();

        System.out.println("Que tipo de archivos quiers buscar");
        String extension = sc.nextLine();

        String files;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();

        System.out.println("Resultados de la busqueda: ");

        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {
                files = listOfFiles[i].getName();
                if (files.endsWith(extension) || files.endsWith(extension)) {
                    System.out.println(files);
                }
            }
        }
        System.out.println("Fin");
    }
}
