package Cliente;

import javax.swing.*;
import java.awt.*;

public class VentanaChat extends JFrame {

    JButton btnprueba;

    public void initGUI() {
        instancias();
        this.setSize(new Dimension(250, 300));
        this.setTitle("Registro");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //this.pack();
    }

    private void instancias() {
        btnprueba = new JButton();
    }
}
