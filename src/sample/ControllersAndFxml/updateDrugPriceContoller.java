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

public class updateDrugPriceContoller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button adminMenuButton;

    @FXML
    private TextField IdTextField;

    @FXML
    private TextField PriceTextField;

    @FXML
    private Button UpdateButton;

    @FXML
    void initialize() {
        assert IdTextField != null : "fx:id=\"IdTextField\" was not injected: check your FXML file 'updateDrug.fxml'.";
        assert PriceTextField != null : "fx:id=\"PriceTextField\" was not injected: check your FXML file 'updateDrug.fxml'.";
        assert UpdateButton != null : "fx:id=\"UpdateButton\" was not injected: check your FXML file 'updateDrug.fxml'.";

        UpdateButton.setOnAction(actionEvent -> {  //setting action on button update
            System.out.println("Updating...");
            System.out.println(this.start());  //calling method start which will return some String value
        });

        adminMenuButton.setOnAction(actionEvent -> {  //setting action on button adminmenu button to go back to the adminMenu inner
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

        String idText= IdTextField.getText();
        int id = Integer.parseInt(idText);   //converting String text from field to the integer value

        String priceText=PriceTextField.getText();
        double price=Double.parseDouble(priceText);  //converting String text from field to the double value

        return controller.updateDrugPrice(price,id);  //calling method update drug price of object controller
    }
}