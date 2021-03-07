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

public class updateDrugContoller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;



    @FXML
    private TextField NameTextField;

    @FXML
    private TextField ManufacturerTextField;

    @FXML
    private Button UpdateButton;

    @FXML
    private Button adminMenuButton;

    @FXML
    void initialize() {
        assert NameTextField != null : "fx:id=\"NameTextField\" was not injected: check your FXML file 'updateDrug.fxml'.";
        assert ManufacturerTextField != null : "fx:id=\"ManufacturerTextField\" was not injected: check your FXML file 'updateDrug.fxml'.";
        assert UpdateButton != null : "fx:id=\"UpdateButton\" was not injected: check your FXML file 'updateDrug.fxml'.";

        UpdateButton.setOnAction(actionEvent -> {  //setting action on button when it will be pressed program will call method start()
            System.out.println(this.start());
        });

        adminMenuButton.setOnAction(actionEvent -> { //setting action on button adminmenu button to go back to the adminMenu inner
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

    public String  start() {
        PostgresDB db= new PostgresDB();
        IAdminMenu adminRepositories = new AdminMenu(db);
        IMenu MenuRepositories=new Menu(db);
        IUserMenu UserRepositories=new UserMenu(db);
        Controller controller=new Controller(adminRepositories,MenuRepositories,UserRepositories);

        String idText=NameTextField.getText();
        int id = Integer.parseInt(idText);     //converting String text from field to the integer value

        boolean res=adminRepositories.UpdateManufacturer(ManufacturerTextField.getText(),id); //calling method update manufacturer of object controller

        return (res==true?"Updated":"Not updated");  //returning String
    }
}
