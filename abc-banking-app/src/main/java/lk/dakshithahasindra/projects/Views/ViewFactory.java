package lk.dakshithahasindra.projects.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.dakshithahasindra.projects.Controllers.Client.ClientMenuController;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.IOException;


public class ViewFactory {
    private AnchorPane dashboardView;

    public void ViewFactory() {


    }
    public AnchorPane getDashboardView(){
        if(dashboardView==null){
            try {
                dashboardView = new FXMLLoader(getClass().getResource("/Fxml/Client/Dashboard.fxml")).load();
            }catch (Exception e){
                throw new RuntimeException();
            }
        }
        return dashboardView;
    }

    public void showLoggingWindow(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Login.fxml"));
        createStage(fxmlLoader);
    }


    public void showClientWindow (){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Client/Client.fxml"));
        ClientMenuController clientMenuController  =new ClientMenuController();
        fxmlLoader.setController(clientMenuController);
        createStage(fxmlLoader);
    }

    private void createStage(FXMLLoader fxmlLoader) throws RuntimeException{
        Stage stage = new Stage();
        try {
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.setTitle("ABC Bank");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void closeStage(Stage stage) {
        stage.close();
    }
}
