package lk.dakshithahasindra.projects.Views;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
    private AnchorPane transactionView;

    private AnchorPane accountsView;

    private final StringProperty clientSelectedItem;

    public  ViewFactory() {
        this.clientSelectedItem = new SimpleStringProperty("Dashboard");

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
//        fxmlLoader.setController(clientMenuController);
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

    public AnchorPane getTransactionView() {
        if(transactionView==null){
            try {
                transactionView = new FXMLLoader(getClass().getResource("/Fxml/Client/Transaction.fxml")).load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return transactionView;
    }

    public String getClientSelectedItem() {
        return clientSelectedItem.get();
    }

    public StringProperty clientSelectedItemProperty() {
        return clientSelectedItem;
    }

    public AnchorPane getAccountsView() {
        if(accountsView==null){
            try {
                accountsView = new FXMLLoader(getClass().getResource("/Fxml/Client/Accounts.fxml")).load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return accountsView;
    }
}
