/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comprobar_puertos;

import java.io.*;
import java.net.*;

public class Comprobar_Puertos {

    public static void main(String[] args) {
        int puerto = 2050;
        try {
            Socket clientSocket = new Socket("192.168.1.37", puerto);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            System.out.println("Puerto " + puerto + " abierto");
            out.close();
            clientSocket.close();
        } catch (UnknownHostException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println("Puerto " + puerto + " cerrado");
        }
    }
}
