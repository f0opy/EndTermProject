package sample.ControllersAndFxml;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class UserMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button getDrugAllButton;

    @FXML
    private Button BackButton;

    @FXML
    private Button getDrugByExpDateButton;

    @FXML
    private Button getDrugByIdButton;

    @FXML
    private Button getDrugByNameButton;

    @FXML
    private Button getDrugByTypeButton;

    @FXML
    private Button getDrugByDestinyButton;

    @FXML
    private Button getDrugByManufacturerButton;

    @FXML
    private Button getDrugByProDateButton;

    @FXML
    private Button getDrugByPriceButton;

    @FXML
    private Button getDrugByValidatyButton;

    @FXML
    private Button purchaseDrugButton;

    @FXML
    private Button usePromocodeButton;

    @FXML
    private Button giveFeedbackButton;

    @FXML
    private Button cancelOrderButton;

    @FXML
    void initialize() {
        assert getDrugAllButton != null : "fx:id=\"getDrugAllButton\" was not injected: check your FXML file 'UserMenu.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'UserMenu.fxml'.";
        assert getDrugByExpDateButton != null : "fx:id=\"getDrugByExpDateButton\" was not injected: check your FXML file 'UserMenu.fxml'.";
        assert getDrugByIdButton != null : "fx:id=\"getDrugByIdButton\" was not injected: check your FXML file 'UserMenu.fxml'.";
        assert getDrugByNameButton != null : "fx:id=\"getDrugByNameButton\" was not injected: check your FXML file 'UserMenu.fxml'.";
        assert getDrugByTypeButton != null : "fx:id=\"getDrugByTypeButton\" was not injected: check your FXML file 'UserMenu.fxml'.";
        assert getDrugByDestinyButton != null : "fx:id=\"getDrugByDestinyButton\" was not injected: check your FXML file 'UserMenu.fxml'.";
        assert getDrugByManufacturerButton != null : "fx:id=\"getDrugByManufacturerButton\" was not injected: check your FXML file 'UserMenu.fxml'.";
        assert getDrugByProDateButton != null : "fx:id=\"getDrugByProDateButton\" was not injected: check your FXML file 'UserMenu.fxml'.";
        assert getDrugByPriceButton != null : "fx:id=\"getDrugByPriceButton\" was not injected: check your FXML file 'UserMenu.fxml'.";
        assert getDrugByValidatyButton != null : "fx:id=\"getDrugByValidatyButton\" was not injected: check your FXML file 'UserMenu.fxml'.";
        assert purchaseDrugButton != null : "fx:id=\"purchaseDrugButton\" was not injected: check your FXML file 'UserMenu.fxml'.";
        assert usePromocodeButton != null : "fx:id=\"usePromocodeButton\" was not injected: check your FXML file 'UserMenu.fxml'.";
        assert giveFeedbackButton != null : "fx:id=\"giveFeedback\" was not injected: check your FXML file 'UserMenu.fxml'.";
        assert cancelOrderButton != null : "fx:id=\"cancelOrderButton\" was not injected: check your FXML file 'UserMenu.fxml'.";


        getDrugByIdButton.setOnAction(actionEvent -> this.move(getDrugByIdButton));    //setting action on Button to get drug by id
        getDrugAllButton.setOnAction(actionEvent -> this.move(getDrugAllButton));  //setting action on Button to get all drug list
        getDrugByNameButton.setOnAction(actionEvent -> this.move(getDrugByNameButton)); //setting action on Button to get drug by name
        getDrugByTypeButton.setOnAction(actionEvent-> this.move(getDrugByTypeButton)); //setting action on Button to get drug by type
        getDrugByDestinyButton.setOnAction(actionEvent-> this.move(getDrugByDestinyButton)); //setting action on Button to get drug by destiny
        getDrugByPriceButton.setOnAction(actionEvent->this.move(getDrugByPriceButton)); //setting action on Button to get drug by price
        getDrugByManufacturerButton.setOnAction(actionEvent->this.move(getDrugByManufacturerButton)); //setting action on Button to get drug by manufacturer
        getDrugByValidatyButton.setOnAction(actionEvent->this.move(getDrugByValidatyButton));  //setting action on Button to get drug by validaty
        getDrugByProDateButton.setOnAction(actionEvent->this.move(getDrugByProDateButton));  //setting action on Button to get drug by production date
        getDrugByExpDateButton.setOnAction(actionEvent->this.move(getDrugByExpDateButton));  //setting action on Button to get drug by expiration date
        purchaseDrugButton.setOnAction(actionEvent->this.move(purchaseDrugButton));  //setting action on Button to purchase drug
        usePromocodeButton.setOnAction(actionEvent->this.move(usePromocodeButton));  //setting action on Button to Use promocode which will give to user 10% off
        giveFeedbackButton.setOnAction(actionEvent->this.move(giveFeedbackButton)); //setting action on Button to leave a feedback about this drug or company
        cancelOrderButton.setOnAction(actionEvent->this.move(cancelOrderButton));  //setting action on Button to cancel order that user don't want to get

        BackButton.setOnAction(actionEvent -> {
            this.back(BackButton);  //calling back method which will go back to prev window
        });
    }

    public void move(Button button){

            button.getScene().getWindow().hide(); //Hiding window
            String path=button.getId().substring(0,button.getId().length()-6); //getting path from id of button
            FXMLLoader loader1=new FXMLLoader();

            loader1.setLocation(getClass().getResource("/sample/ControllersAndFxml/"+path+".fxml"));

            try {
                loader1.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root=loader1.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();  //showing needed window

    }
    public void back(Button button){
        FXMLLoader loader1=new FXMLLoader();
        button.getScene().getWindow().hide();
        loader1.setLocation(getClass().getResource("/sample/ControllersAndFxml/sample.fxml"));

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


