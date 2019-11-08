import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelCarrera extends JFrame{

    //

    JPanel[] paneles;
    JLabel[] label;
    String[] nombre={"Adri","Marcos","Arturo","Ivan"};
    int barrera = 1200;

    /** creamos el constructor de la clase que contiene las ventanas y la inicializacion de los hilos del programa*/


    public PanelCarrera(){
        setLayout(new GridLayout(0,1));
        paneles = new JPanel[5];
        label = new JLabel[5];
        JButton boton;

        for(int i=0;i<4;i++){
            paneles[i]= new JPanel();
            add(paneles[i]);
            label[i]= new JLabel(nombre[i]);
            label[i].setIcon(new ImageIcon(getClass().getResource(nombre[i]+".gif")));
            paneles[i].add(label[i]);
            label[i].setLocation(0, 0);
        }

        boton = new JButton("Comenzar carrera"); //Boton para dar comienzo al hilo
        boton.addActionListener(new ActionListener(){

            /*ahora creamos los objetos coche y despues la inicializacion de hilos*/
            @Override
            public void actionPerformed(ActionEvent e) {
                Coche Adri = new Coche("Adri",barrera - 0,label[0]);
                Coche Marcos = new Coche("Marcos",barrera - 0,label[1]);
                Coche Arturo = new Coche("Arturo",barrera - 0,label[2]);
                Coche Ivan = new Coche("Ivan",barrera - 0,label[3]);

                Adri.start();
                Marcos.start();
                Arturo.start();
                Ivan.start();


            }
        });

        add(boton);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(150,150);
        setSize(barrera,800);
        setVisible(true);
    }





    }
    //Finalizamos la clase PanelCarrera


