/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {

    private final int PUERTO = 1234;
    private final String HOST = "localhost";
    protected String mensajeServidor;
    protected ServerSocket ss;
    protected Socket cs;
    protected DataOutputStream salidaServidor, salidaCliente;

    public Conexion(String tipo) throws IOException {
        if (tipo.equalsIgnoreCase("servidor")) {
            ss = new ServerSocket(PUERTO);
            cs = new Socket();
        } else {
            cs = new Socket(HOST, PUERTO);
        }
    }
}
