/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictac;

/**
 *
 * @author Usuario DAM 2
 */
public class Tic extends Thread {

    //Propiedades --------------------------------
    private int hilo;

    //Constructor --------------------------------
    public Tic(int hilo) {
        this.hilo = hilo;
    }//fin constructor

    //Método Run -----------------------------------
    public void run() {
        while (true) {
            System.out.println("TIC");
            //sleep(1000);
            try {
                // Pause for 4 seconds
                this.sleep(2000);
            } catch (InterruptedException e) {
            }

        }
    }//fin run
}
