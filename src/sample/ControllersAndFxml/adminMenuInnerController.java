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

public class adminMenuInnerController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private Button BackButton;

    @FXML
    private Button CreateDrugButton;

    @FXML
    private Button updateDrugButton;

    @FXML
    private Button updateManufacturerButton;

    @FXML
    private Button deleteDrugButton;

    @FXML
    void initialize() {
        assert CreateDrugButton != null : "fx:id=\"CreateDrugButton\" was not injected: check your FXML file 'adminMenuInner.fxml'.";
        assert updateDrugButton != null : "fx:id=\"updateDrugButton\" was not injected: check your FXML file 'adminMenuInner.fxml'.";
        assert updateManufacturerButton != null : "fx:id=\"updateManufacturerButton\" was not injected: check your FXML file 'adminMenuInner.fxml'.";
        assert deleteDrugButton != null : "fx:id=\"deleteDrugButton\" was not injected: check your FXML file 'adminMenuInner.fxml'.";
        BackButton.setOnAction(actionEvent -> { //setting action to the button back to go back to  the User Menu
            this.back(BackButton);
        });

        CreateDrugButton.setOnAction(actionEvent -> {  //setting action on Button which will open another FXML and hide itself's window
            CreateDrugButton.getScene().getWindow().hide();

            FXMLLoader loader1=new FXMLLoader();
            loader1.setLocation(getClass().getResource("/sample/ControllersAndFxml/createDrug.fxml"));

            try {
                loader1.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root=loader1.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        updateManufacturerButton.setOnAction(actionEvent -> { //setting action on Button which will open another FXML and hide itself's window
            updateManufacturerButton.getScene().getWindow().hide();

            FXMLLoader loader1=new FXMLLoader();
            loader1.setLocation(getClass().getResource("/sample/ControllersAndFxml/updateDrug.fxml"));

            try {
                loader1.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root=loader1.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

        updateDrugButton.setOnAction(actionEvent -> {  //setting action on Button which will open another FXML and hide itself's window
            updateDrugButton.getScene().getWindow().hide();
            FXMLLoader loader1=new FXMLLoader();
            loader1.setLocation(getClass().getResource("/sample/ControllersAndFxml/updateDrugPrice.fxml"));

            try {
                loader1.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root=loader1.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();

        });

        deleteDrugButton.setOnAction(actionEvent -> {  //setting action on Button which will open another FXML and hide itself's window
            deleteDrugButton.getScene().getWindow().hide();
            FXMLLoader loader1=new FXMLLoader();
            loader1.setLocation(getClass().getResource("/sample/ControllersAndFxml/deleteDrug.fxml"));

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
    public void back(Button button){
        button.getScene().getWindow().hide(); //hiding current window
        FXMLLoader loader1=new FXMLLoader();

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
