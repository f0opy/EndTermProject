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

public class getDrugByTypeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackButton;

    @FXML
    private Button SearchButton;

    @FXML
    private TextField typeField;

    @FXML
    private Label textArea;

    @FXML
    private Button prevButton;

    @FXML
    private Button NextButton;

    @FXML
    void initialize() {
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'getDrugByName.fxml'.";
        assert SearchButton != null : "fx:id=\"SearchButton\" was not injected: check your FXML file 'getDrugByName.fxml'.";
        assert typeField != null : "fx:id=\"typeField\" was not injected: check your FXML file 'getDrugByName.fxml'.";
        assert textArea != null : "fx:id=\"textArea\" was not injected: check your FXML file 'getDrugByName.fxml'.";
        assert prevButton != null : "fx:id=\"prevButton\" was not injected: check your FXML file 'getDrugByName.fxml'.";
        assert NextButton != null : "fx:id=\"NextButton\" was not injected: check your FXML file 'getDrugByName.fxml'.";
        BackButton.setOnAction(actionEvent -> {
            this.back(BackButton);
        });
        PostgresDB db= new PostgresDB();
        IAdminMenu adminRepositories = new AdminMenu(db);
        IMenu MenuRepositories=new Menu(db);
        IUserMenu UserRepositories=new UserMenu(db);
        Controller controller=new Controller(adminRepositories,MenuRepositories,UserRepositories);
        AtomicInteger num= new AtomicInteger();



        SearchButton.setOnAction(event -> {
            System.out.println("Searching...");
            List drug=controller.getDrugByType(typeField.getText());
            String res=drug.get(0).toString();
            textArea.setText(res);

        });


        prevButton.setOnAction(event -> {
            List drugs=controller.getDrugByType(typeField.getText());
            String res=drugs.get(num.getAndDecrement()-1).toString();
            textArea.setText(res);
            System.out.println("Previous one");
        });

        NextButton.setOnAction(event -> {
            List drugs2=controller.getDrugByType(typeField.getText());
            String res=drugs2.get(num.getAndIncrement()+1).toString();
            textArea.setText(res);
            System.out.println("Next one");
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