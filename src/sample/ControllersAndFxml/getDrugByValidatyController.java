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
import javafx.scene.control.CheckBox;
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

public class getDrugByValidatyController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackButton;

    @FXML
    private Button SearchButton;

    @FXML
    private Label textArea;

    @FXML
    private Button prevButton;

    @FXML
    private Button NextButton;

    @FXML
    private CheckBox validatyCheck;

    @FXML
    void initialize() {
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'getDrugByManufacturer.fxml'.";
        assert SearchButton != null : "fx:id=\"SearchButton\" was not injected: check your FXML file 'getDrugByManufacturer.fxml'.";
        assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'getDrugByManufacturer.fxml'.";
        assert prevButton != null : "fx:id=\"prevButton\" was not injected: check your FXML file 'getDrugByManufacturer.fxml'.";
        assert NextButton != null : "fx:id=\"NextButton\" was not injected: check your FXML file 'getDrugByManufacturer.fxml'.";
        assert validatyCheck != null : "fx:id=\"validatyCheck\" was not injected: check your FXML file 'getDrugByManufacturer.fxml'.";
        BackButton.setOnAction(actionEvent -> {   //setting action to button back to go back to the User Menu
            this.back(BackButton);
        });
        PostgresDB db= new PostgresDB(); //CREATING OBJECTS OF CLASSES
        IAdminMenu adminRepositories = new AdminMenu(db);
        IMenu MenuRepositories=new Menu(db);
        IUserMenu UserRepositories=new UserMenu(db);
        Controller controller=new Controller(adminRepositories,MenuRepositories,UserRepositories);
        AtomicInteger num= new AtomicInteger();

        SearchButton.setOnAction(event -> {  //setting action to the button search
            System.out.println("Searching...");
            List drug=controller.getDrugByValidaty(validatyCheck.isSelected());  //creating new list to save result of calling method of controller
            String res=drug.get(0).toString();  //by default text area will show first element of list
            textArea.setText(res);  //setting value of res to the Text Area

        });


        prevButton.setOnAction(event -> {  //setting action to button prev
            List drugs=controller.getDrugByValidaty(validatyCheck.isSelected());  //creating new list to save result of calling method of controller
            String res=drugs.get(num.getAndDecrement()-1).toString();  //if user presses button prev program will show decrement current index of element of list
            textArea.setText(res);
            System.out.println("Previous one");
        });

        NextButton.setOnAction(event -> { //setting action to button next
            List drugs2=controller.getDrugByValidaty(validatyCheck.isSelected());  //creating new list to save result of calling method of controller
            String res=drugs2.get(num.getAndIncrement()+1).toString();  //if user presses button prev program will show increment current index of element of list
            textArea.setText(res);
            System.out.println("Next one");
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
}
