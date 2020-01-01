package Cliente;

import javax.swing.*;

public class MainCliente {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VentanaConfig vConfig = new VentanaConfig();
                vConfig.initGUI();

            }
        });
    }
}
