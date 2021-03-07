package sample.ControllersAndFxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Data.PostgresDB;
import sample.Menu.AdminMenu;
import sample.Menu.Menu;
import sample.Menu.UserMenu;
import sample.Menu.interfaces.IAdminMenu;
import sample.Menu.interfaces.IMenu;
import sample.Menu.interfaces.IUserMenu;
import sample.controller.Controller;

public class purchaseDrugController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackButton;

    @FXML
    private Button purchaseDrugButton;

    @FXML
    private TextField NameField;

    @FXML
    private TextField drugNameField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private Label resultLabel;

    @FXML
    void initialize() {
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'purchaseDrug.fxml'.";
        assert purchaseDrugButton != null : "fx:id=\"purchaseDrugButton\" was not injected: check your FXML file 'purchaseDrug.fxml'.";
        assert NameField != null : "fx:id=\"NameField\" was not injected: check your FXML file 'purchaseDrug.fxml'.";
        assert drugNameField != null : "fx:id=\"drugNameField\" was not injected: check your FXML file 'purchaseDrug.fxml'.";
        assert addressField != null : "fx:id=\"addressField\" was not injected: check your FXML file 'purchaseDrug.fxml'.";
        assert emailField != null : "fx:id=\"emailField\" was not injected: check your FXML file 'purchaseDrug.fxml'.";
        assert phoneNumberField != null : "fx:id=\"phoneNumberField\" was not injected: check your FXML file 'purchaseDrug.fxml'.";
        assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file 'purchaseDrug.fxml'.";

        BackButton.setOnAction(actionEvent -> {
            this.back(BackButton);
        });

        purchaseDrugButton.setOnAction(event -> {
            resultLabel.setText(this.buy());
        });
    }

    public void back(Button button){
        button.getScene().getWindow().hide();
        FXMLLoader loader1=new FXMLLoader();

        loader1.setLocation(getClass().getResource("/sample/ControllersAndFxml/UserMenu.fxml"));

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

    public String buy(){
        PostgresDB db= new PostgresDB();
        IAdminMenu adminRepositories = new AdminMenu(db);
        IMenu MenuRepositories=new Menu(db);
        IUserMenu UserRepositories=new UserMenu(db);
        Controller controller=new Controller(adminRepositories,MenuRepositories,UserRepositories);


       return controller.purchaseDrug(NameField.getText(),drugNameField.getText(),addressField.getText(),emailField.getText(),phoneNumberField.getText());
    }
}
