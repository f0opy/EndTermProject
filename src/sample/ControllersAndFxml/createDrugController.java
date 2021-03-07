package sample.ControllersAndFxml;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
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

public class createDrugController {





        @FXML
        private Button adminMenuButton;

        @FXML
        private TextField NameTextField;

        @FXML
        private TextField typeTextField;

        @FXML
        private TextField DestinyTextField;

        @FXML
        private TextField PriceTextField;

        @FXML
        private TextField ManufacturerTextField;

        @FXML
        private CheckBox ValidatyCheckBox;

        @FXML
        private Button CreationButton;

        @FXML
        private DatePicker ProDateTextField1;

        @FXML
        private DatePicker ExpDateTextField1;





    @FXML
    void initialize() {
        assert NameTextField != null : "fx:id=\"NameTextField\" was not injected: check your FXML file 'createDrug.fxml'.";
        assert typeTextField != null : "fx:id=\"typeTextField\" was not injected: check your FXML file 'createDrug.fxml'.";
        assert DestinyTextField != null : "fx:id=\"DestinyTextField\" was not injected: check your FXML file 'createDrug.fxml'.";
        assert PriceTextField != null : "fx:id=\"PriceTextField\" was not injected: check your FXML file 'createDrug.fxml'.";
        assert ManufacturerTextField != null : "fx:id=\"ManufacturerTextField\" was not injected: check your FXML file 'createDrug.fxml'.";
        assert ValidatyCheckBox != null : "fx:id=\"ValidatyCheckBox\" was not injected: check your FXML file 'createDrug.fxml'.";
        assert CreationButton != null : "fx:id=\"CreationButton\" was not injected: check your FXML file 'createDrug.fxml'.";
        assert ProDateTextField1 != null : "fx:id=\"ProDateTextField1\" was not injected: check your FXML file 'createDrug.fxml'.";
        assert ExpDateTextField1 != null : "fx:id=\"ExpDateTextField1\" was not injected: check your FXML file 'createDrug.fxml'.";

        CreationButton.setOnAction(actionEvent -> { //setting action to button Create
            System.out.println(this.start() ); //calling method start if button pressed
        });

        adminMenuButton.setOnAction(actionEvent -> {  //setting action to button Admin menu to open Admin Menu Inner
            adminMenuButton.getScene().getWindow().hide();  //hiding current window

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
        PostgresDB db= new PostgresDB();  //CREATING OBJECTS OF CLASSES
        IAdminMenu adminRepositories = new AdminMenu(db);
        IMenu MenuRepositories=new Menu(db);
        IUserMenu UserRepositories=new UserMenu(db);
        Controller controller=new Controller(adminRepositories,MenuRepositories,UserRepositories);
        String priceText=PriceTextField.getText();
        double price=Double.parseDouble(priceText);


        LocalDate date= ProDateTextField1.getValue();
        Date date1=Date.valueOf(date);  //converting from LocalDate to the java.sql.Date

        LocalDate date2= ExpDateTextField1.getValue();
        Date date3=Date.valueOf(date2);  //converting from LocalDate to the java.sql.Date


        String res =controller.createDrug(NameTextField.getText(),typeTextField.getText(),DestinyTextField.getText(),price,ManufacturerTextField.getText(),
                date1,date3,ValidatyCheckBox.isSelected()); //calling method create drug of object controller
        return res; //returning some String value
    }
}
