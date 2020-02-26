package servidor;

import clases.LoginSQL;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.*;

public class Servidor { //SOCKET SEGURO SERVIDOR
    //PUERTO = 5555

    public static void main(String[] args) throws IOException {
        LoginSQL loginSQL = new LoginSQL();

        int puerto = 5555;

        System.setProperty("javax.net.ssl.keyStore", "src/AlmacenSrv");
        System.setProperty("javax.net.ssl.keyStorePassword", "1234567");

        SSLServerSocketFactory sfact = (SSLServerSocketFactory) SSLServerSocketFactory
                .getDefault();
        SSLServerSocket servidorSSL = (SSLServerSocket) sfact.createServerSocket(puerto);
        SSLSocket clienteConectado = null;
        DataInputStream flujoEntrada = null;//FLUJO DE ENTRADA DE CLIENTE
        DataOutputStream flujoSalida = null;//FLUJO DE SALIDA AL CLIENTE

        int i = 0;

            System.out.println("Esperando al cliente " + i);
            clienteConectado = (SSLSocket) servidorSSL.accept();
            flujoEntrada = new DataInputStream(clienteConectado.getInputStream());

            // EL CLIENTE ME ENVIA UN MENSAJE
            System.out.println("Recibiendo del CLIENTE: " + i + " \n\t"
                    + flujoEntrada.readUTF());

            flujoSalida = new DataOutputStream(clienteConectado.getOutputStream());

            // ENVIO UN SALUDO AL CLIENTE
            flujoSalida.writeUTF(importarTXT("C:\\Users\\Usuario DAM 2\\Documents\\NetBeansProjects\\PSP\\ServidorWeb\\src\\web_salida\\salida.html").toString());

        // CERRAR STREAMS Y SOCKETS
        flujoEntrada.close();
        flujoSalida.close();
        clienteConectado.close();
        servidorSSL.close();

    }

    public static StringBuilder importarTXT(String ruta) {
        StringBuilder stringBuilder = new StringBuilder();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {

            fr = new FileReader(new File(ruta));
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                stringBuilder.append(linea);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return stringBuilder;
    }
}
