package lk.dakshithahasindra.projects.Views;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.dakshithahasindra.projects.Controllers.Admin.AdminMenuController;
import lk.dakshithahasindra.projects.Controllers.Client.ClientMenuController;

import java.io.IOException;


public class ViewFactory {
    private AnchorPane dashboardView;
    private AnchorPane transactionView;
    private AnchorPane accountsView;
//    private final StringProperty CLIENT_SELECTED_ITEM;

    private final ObjectProperty<ClientMenuOptions> CLIENT_SELECTED_MENU_OPTION;


    /* Admin variables - views */
    private AnchorPane creatClientView;
//    private final StringProperty ADMIN_SELECTED_ITEM;
    private final ObjectProperty<AdminMenuOptions> ADMIN_SELECTED_MENU_OPTION;
    private AnchorPane clientView;


    public  ViewFactory() {
        this.CLIENT_SELECTED_MENU_OPTION = new SimpleObjectProperty<>();
//        this.CLIENT_SELECTED_ITEM = new SimpleStringProperty("Dashboard");
        this.ADMIN_SELECTED_MENU_OPTION = new SimpleObjectProperty<>();

    }

    /* String property returns */

//    public String getCLIENT_SELECTED_ITEM() {
//        return CLIENT_SELECTED_ITEM.get();
//    }
    public ObjectProperty<ClientMenuOptions> getCLIENT_SELECTED_MENU_OPTION() {
        return CLIENT_SELECTED_MENU_OPTION;
    }
    public ObjectProperty<AdminMenuOptions> getADMIN_SELECTED_MENU_OPTION() {
        return ADMIN_SELECTED_MENU_OPTION;
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


    public void showAdminWindow(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Admin/Admin.fxml"));
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


    /* Admin views Section */
    public AnchorPane getCreatClientView() {
        if(creatClientView==null){
            try {
                creatClientView = new FXMLLoader(getClass().getResource("/Fxml/Admin/CreateClient.fxml")).load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return creatClientView;
    }


    public AnchorPane getClientsView() {
        if(clientView==null){
            try {
                clientView=new FXMLLoader(getClass().getResource("/Fxml/Admin/Clients.fxml")).load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return clientView;
    }
}
