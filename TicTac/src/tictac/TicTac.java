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
public class TicTac {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tic tic = null;
        Tac tac = null;
        tic = new Tic(1); //creo hilo
        tac = new Tac(1); //creo hilo
        tic.start();
        tac.start(); //iniciar hilo

    } //fin main

}
