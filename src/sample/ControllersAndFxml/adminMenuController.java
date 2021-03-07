package sample.ControllersAndFxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class adminMenuController {

    @FXML
    private Button BackButton;

    @FXML
    private Button adminMenuLoginButton;

    @FXML
    private TextField loginTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label warning;


    @FXML
    void initialize() {
        assert adminMenuLoginButton != null : "fx:id=\"adminMenuLoginButton\" was not injected: check your FXML file 'adminMenu.fxml'.";
        assert loginTextField != null : "fx:id=\"loginTextField\" was not injected: check your FXML file 'adminMenu.fxml'.";
        assert passwordTextField != null : "fx:id=\"passwordTextField\" was not injected: check your FXML file 'adminMenu.fxml'.";

        BackButton.setOnAction(actionEvent -> { //setting action to the button back to go back to  the User Menu
            this.back(BackButton);
        });
        adminMenuLoginButton.setOnAction(actionEvent -> {  //setting action to button LOGIN it will open window of admin if only if user typed correct password and login "admin" and "admin"
            if(loginTextField.getText().equals("admin") && passwordTextField.getText().equals("admin")){  //checking inserted login and password
                adminMenuLoginButton.getScene().getWindow().hide();  //hiding current window
                FXMLLoader loader=new FXMLLoader();
                loader.setLocation(getClass().getResource("/sample/ControllersAndFxml/adminMenuInner.fxml"));

                try {
                    loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Parent root=loader.getRoot();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();

            }
            else{  //if user inserted wrong password or login
                System.err.println("Wrong password or login. Try again!");
                warning.setText("Wrong password or login. Try again!");
            }
        });
    }
    public void back(Button button){
        button.getScene().getWindow().hide(); //hiding current window
        FXMLLoader loader1=new FXMLLoader();

        loader1.setLocation(getClass().getResource("/sample/ControllersAndFxml/sample.fxml"));

        try {
            loader1.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root=loader1.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
