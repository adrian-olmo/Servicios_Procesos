package cliente;

import java.io.*;
import javax.net.ssl.*;

public class Cliente {

    public void conexionCliente(int puerto) {
        try {
            String Host = "localhost";

            // Propiedades JSSE)
            System.setProperty("javax.net.ssl.trustStore", "src/AlmacenSrv");
            System.setProperty("javax.net.ssl.trustStorePassword", "1234567");

            System.out.println("PROGRAMA CLIENTE INICIADO....");

            SSLSocketFactory sfact = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket cliente = (SSLSocket) sfact.createSocket(Host, puerto);


            // CREO FLUJO DE SALIDA AL SERVIDOR
            DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

            // ENVIO UN SALUDO AL SERVIDOR
            flujoSalida.writeUTF("Saludos al SERVIDOR DESDE EL CLIENTE");

            // CREO FLUJO DE ENTRADA AL SERVIDOR
            DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());


            // EL servidor ME ENVIA UN MENSAJE
            exportarTXT("C:\\Users\\Usuario DAM 2\\Documents\\NetBeansProjects\\PSP\\ServidorWeb\\src\\web_recibida\\recibo.html", flujoEntrada.readUTF());

            ProcessBuilder pb = new ProcessBuilder();
            pb.command("powershell.exe", "/c", "cd ./src/web_salida/\n" +
                    "start salida.html");
            pb.start();


            // CERRAR STREAMS Y SOCKETS
            flujoEntrada.close();
            flujoSalida.close();
            cliente.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void exportarTXT(String ruta, String paginaWeb) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(ruta);
            pw = new PrintWriter(fichero);

            pw.println(paginaWeb);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }


}

/*            // EL servidor ME ENVIA UN MENSAJE
            exportarTXT("../paginaWeb.html", flujoEntrada.readUTF());
            Thread openWeb = new Thread(initWeb());
            openWeb.start();*/
