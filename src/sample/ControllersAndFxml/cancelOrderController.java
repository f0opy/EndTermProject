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
import javafx.scene.shape.Arc;
import javafx.stage.Stage;
import sample.Data.PostgresDB;
import sample.Menu.AdminMenu;
import sample.Menu.Menu;
import sample.Menu.UserMenu;
import sample.Menu.interfaces.IAdminMenu;
import sample.Menu.interfaces.IMenu;
import sample.Menu.interfaces.IUserMenu;
import sample.controller.Controller;

public class cancelOrderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button BackButton;

    @FXML
    private TextField idField;

    @FXML
    private Label resultLabel;

    @FXML
    private Button cancelOrderButton;

    @FXML
    private Arc nothing;

    @FXML
    private Button pacmanButton;

    @FXML
    private Button pacmanButton1;

    @FXML
    void initialize() {
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'purchaseDrug.fxml'.";
        assert idField != null : "fx:id=\"idField\" was not injected: check your FXML file 'purchaseDrug.fxml'.";
        assert resultLabel != null : "fx:id=\"resultLabel\" was not injected: check your FXML file 'purchaseDrug.fxml'.";
        assert cancelOrderButton != null : "fx:id=\"cancelOrderButton\" was not injected: check your FXML file 'purchaseDrug.fxml'.";
        assert nothing != null : "fx:id=\"nothing\" was not injected: check your FXML file 'purchaseDrug.fxml'.";
        assert pacmanButton != null : "fx:id=\"pacmanButton\" was not injected: check your FXML file 'purchaseDrug.fxml'.";
        assert pacmanButton1 != null : "fx:id=\"pacmanButton1\" was not injected: check your FXML file 'purchaseDrug.fxml'.";
        BackButton.setOnAction(actionEvent -> { //setting action to the button back to go back to  the User Menu
            this.back(BackButton);
        });

        cancelOrderButton.setOnAction(event -> {
            PostgresDB db= new PostgresDB();
            IAdminMenu adminRepositories = new AdminMenu(db);
            IMenu MenuRepositories=new Menu(db);
            IUserMenu UserRepositories=new UserMenu(db);
            Controller controller=new Controller(adminRepositories,MenuRepositories,UserRepositories);
            String idText=idField.getText();
            int orderid=Integer.parseInt(idText);

            controller.cancelOrder(orderid);
            resultLabel.setText("Order with ID: "+orderid+" was removed successfully!");
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
