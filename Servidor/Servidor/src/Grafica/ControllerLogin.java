package Grafica;

import clases.LoginSQL;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerLogin implements Initializable {

    @FXML
    Button login, salir;
    @FXML
    TextField usuario, contrasenia;


    private LoginSQL log = new LoginSQL();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        login.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String user = usuario.getText();
                String contra = contrasenia.getText();
                String contrahash = log.SHA512(contra, "negroo"); //HASEA LA CONTRASEÑA CON SHA512 CON LA SEMILLA NEGROO
                String puerto = log.login(user, contrahash);

                if(puerto == null){

                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setContentText("usuario o contraseña incorrecta");
                    alert.showAndWait();
                }else{
                    //LOGICA DEL SOCKET SEGURO DEL CLIENTE CON EL PUERTO 5555
                    System.out.println(puerto);
                    System.exit(0);
                }
            }
        });
        salir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
    }
}
