package lk.dakshithahasindra.projects;

import com.mysql.cj.conf.url.SingleConnectionUrl;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lk.dakshithahasindra.projects.Models.Model;
import lk.dakshithahasindra.projects.Models.SingleDataConnection;
import lk.dakshithahasindra.projects.Views.ViewFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        try(Connection connection = SingleDataConnection.getInstance().getConnection()){
            launch(args);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void start(Stage primaryStage)  {

        ViewFactory viewFactory = Model.getInstance().getViewFactory();
        viewFactory.showLoggingWindow();



//        ViewFactory viewFactory = new ViewFactory();
//        viewFactory.showLoggingWindow();

//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
//        AnchorPane root = fxmlLoader.load();
//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
//        primaryStage.show();
    }
}
