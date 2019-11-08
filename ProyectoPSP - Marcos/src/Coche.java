import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import java.util.Random;


public class Coche extends Thread { //Clase para crear el hilo
    //atributos de la clase

    String piloto;
    int meta;
    JLabel label;


    public Coche(String piloto, int meta, JLabel label){
        this.piloto=piloto;
        this.meta=meta;
        this.label=label;
    }


    @Override
    public void run (){ //Aqui vamos a ejecutar el hilo
        //objeto random
        Random correr = new Random();
        int n;
        int p=0;

        do{
            n = correr.nextInt(20);// Marcamos la velocidad
            p =n+p;

            try {
                label.setLocation(p,0);
                Thread.sleep(30);
            } catch (InterruptedException ex) {
                Logger.getLogger(Coche.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while(p<meta);


System.out.println(piloto+ " Carrera acabada ");
        System.out.println("----------------------------------------");



    }

}