package sample.ControllersAndFxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

public class deleteDrugController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button adminMenuButton;

    @FXML
    private TextField IdTextField;

    @FXML
    private Button DeleteButton;

    @FXML
    void initialize() {
        assert adminMenuButton != null : "fx:id=\"adminMenuButton\" was not injected: check your FXML file 'deleteDrug.fxml'.";
        assert IdTextField != null : "fx:id=\"IdTextField\" was not injected: check your FXML file 'deleteDrug.fxml'.";
        assert DeleteButton != null : "fx:id=\"DeleteButton\" was not injected: check your FXML file 'deleteDrug.fxml'.";

        DeleteButton.setOnAction(event -> {
            System.out.println("Deleting...");
            System.out.println(this.start()); //calling method start when User press Delete button
        });


        adminMenuButton.setOnAction(actionEvent -> { //setting action on Button to move to admin menu inner
            adminMenuButton.getScene().getWindow().hide();

            FXMLLoader loader1=new FXMLLoader();
            loader1.setLocation(getClass().getResource("/sample/ControllersAndFxml/adminMenuInner.fxml"));

            try {
                loader1.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root=loader1.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

    }

    public String start(){
        PostgresDB db= new PostgresDB();
        IAdminMenu adminRepositories = new AdminMenu(db);
        IMenu MenuRepositories=new Menu(db);
        IUserMenu UserRepositories=new UserMenu(db);
        Controller controller=new Controller(adminRepositories,MenuRepositories,UserRepositories);

        int id=Integer.parseInt(IdTextField.getText());  //converting from String to Integer to work with it in controller

        return controller.deleteDrug(id);

    }
}
