package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Data.PostgresDB;
import sample.Data.interfaces.IDB;
import sample.Menu.AdminMenu;
import sample.Menu.Menu;
import sample.Menu.UserMenu;
import sample.Menu.interfaces.IAdminMenu;
import sample.Menu.interfaces.IMenu;
import sample.Menu.interfaces.IUserMenu;
import sample.controller.Controller;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ControllersAndFxml/sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IUserMenu repo= new UserMenu(db);
        IMenu repo1= new Menu(db);
        IAdminMenu repo2= new AdminMenu(db);
        Controller controller=new Controller(repo2,repo1,repo);
        launch(args);
    }
}


