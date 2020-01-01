package Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaConfig extends JFrame implements ActionListener {

    Container container;
    JLabel usuario, host, puerto;
    JTextField txtusuario, txthost, txtpuerto;
    JButton btnAceptar;
    JPanel pCentro;

    public void initGUI() {
        instancias();
        configGridBag();
        acciones();
        this.setSize(new Dimension(250, 300));
        this.setTitle("Registro");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //this.pack();
    }

    private void configGridBag() {
        container.add(configurarCentro(), BorderLayout.CENTER);
    }

    private JPanel configurarCentro() {
        pCentro.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 0, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        pCentro.add(usuario, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        pCentro.add(host, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        pCentro.add(puerto, constraints);

        constraints.ipadx = 100;
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 1;
        constraints.gridy = 0;
        pCentro.add(txtusuario, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        pCentro.add(txthost, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        pCentro.add(txtpuerto, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(20, 20, 20, 20);
        pCentro.add(btnAceptar, constraints);

        return pCentro;
    }

    private void acciones() {
        btnAceptar.addActionListener(this);
    }

    private void instancias() {
        container = this.getContentPane();
        pCentro = new JPanel();

        usuario = new JLabel("Usuario: ");
        host = new JLabel("Host: ");
        puerto = new JLabel("Puerto: ");

        txtusuario = new JTextField();
        txthost = new JTextField("LocalHost");
        txtpuerto = new JTextField("7823");

        btnAceptar = new JButton("Aceptar");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        btnAceptar.setVisible(false);
        if (e.getSource() == btnAceptar){
            VentanaChat vChat = new VentanaChat();
            vChat.initGUI();
        }
    }
}
