/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Cliente extends Conexion {

    Scanner sc = new Scanner(System.in);
    String respuesta, archivo;

    public Cliente() throws IOException {
        super("cliente");
    } //Se usa el constructor para cliente de Conexion

    public void startClient() //Método para iniciar el cliente
    {
        try {
            salidaServidor = new DataOutputStream(cs.getOutputStream());
            System.out.println("¿Quieres buscar algun archivo? (S/N)");
            respuesta = sc.next();

            if (respuesta == "S") {
                
                
                
            } else if (respuesta == "N"){
                cs.close();//Fin de la conexión
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
