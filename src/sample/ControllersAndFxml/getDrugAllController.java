package sample.ControllersAndFxml;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.Data.PostgresDB;
import sample.Menu.AdminMenu;
import sample.Menu.Menu;
import sample.Menu.UserMenu;
import sample.Menu.interfaces.IAdminMenu;
import sample.Menu.interfaces.IMenu;
import sample.Menu.interfaces.IUserMenu;
import sample.controller.Controller;

public class getDrugAllController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackButton;



    @FXML
    private Label textArea;

    @FXML
    private Button prevButton;

    @FXML
    private Button NextButton;

    @FXML
    void initialize() {
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'UserMenu.fxml'.";
        assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'UserMenu.fxml'.";
        assert prevButton != null : "fx:id=\"prevButton\" was not injected: check your FXML file 'UserMenu.fxml'.";
        assert NextButton != null : "fx:id=\"NextButton\" was not injected: check your FXML file 'UserMenu.fxml'.";

        BackButton.setOnAction(actionEvent -> {  //setting action to button back to go back to the User Menu
            this.back(BackButton);
        });


            PostgresDB db= new PostgresDB(); //CREATING OBJECTS OF CLASSES
            IAdminMenu adminRepositories = new AdminMenu(db);
            IMenu MenuRepositories=new Menu(db);
            IUserMenu UserRepositories=new UserMenu(db);
            Controller controller=new Controller(adminRepositories,MenuRepositories,UserRepositories);


            List drugs=controller.GetAllDrugs();  //creating new list to save result of executing method get all drugs of object controller
            textArea.setText(drugs.get(0).toString());  //putting 1st element of list to text area
            AtomicInteger num= new AtomicInteger(); //creating new Atomic Integer to work in lambda

            prevButton.setOnAction(event -> { //setting action to button prev

                String res=drugs.get(num.getAndDecrement()-1).toString();  //if user presses button prev program will show decrement current index of element of list
                textArea.setText(res);  //setting value to the text area
            });

            NextButton.setOnAction(event -> { //setting action to button next

                String res=drugs.get(num.getAndIncrement()+1).toString();  //if user presses button prev program will show increment current index of element of list
                textArea.setText(res); //setting value to the text area
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

}
