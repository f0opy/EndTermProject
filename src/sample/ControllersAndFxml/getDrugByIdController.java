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

public class getDrugByIdController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackButton;

    @FXML
    private Button SearchButton;

    @FXML
    private TextField idField;

    @FXML
    private Label nameLabel;

    @FXML
    void initialize() {
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'UserMenu.fxml'.";
        assert SearchButton != null : "fx:id=\"SearchButton\" was not injected: check your FXML file 'UserMenu.fxml'.";


        BackButton.setOnAction(actionEvent -> {  //setting action to the button back to go back to UserMenu
            this.back(BackButton); //calling method back with Button value BackButton
        });
        SearchButton.setOnAction(actionEvent -> {  //setting action to the button search
            this.start();  //calling method start
        });

    }

    public void back(Button button){
        button.getScene().getWindow().hide(); //hiding current window
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
    public void start(){
        PostgresDB db= new PostgresDB(); //CREATING OBJECTS OF CLASSES
        IAdminMenu adminRepositories = new AdminMenu(db);
        IMenu MenuRepositories=new Menu(db);
        IUserMenu UserRepositories=new UserMenu(db);
        Controller controller=new Controller(adminRepositories,MenuRepositories,UserRepositories);
        String idText=idField.getText(); //getting value of Id field
        int id=Integer.parseInt(idText);  //converting value of text Field to the integer number


            String res= controller.getDrugById(id); //setting result of calling method get drug by id of object controller
            nameLabel.setText(res);  //setting ToString value of drug to the name Label




    }
}
