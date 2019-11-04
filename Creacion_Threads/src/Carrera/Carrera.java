/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carrera;

/**
 *
 * @author Usuario DAM 2
 */
public class Carrera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TortugaThread tortuga = new TortugaThread();
        Thread liebre = new Thread(new LiebreThread());
        tortuga.start();
        liebre.start();
    }

}
