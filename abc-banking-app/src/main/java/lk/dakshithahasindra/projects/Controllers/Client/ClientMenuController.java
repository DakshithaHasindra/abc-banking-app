package lk.dakshithahasindra.projects.Controllers.Client;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import lk.dakshithahasindra.projects.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable {
    public VBox btnProfile;
    public Button btnDashboard;
    public Button tbnTransaction;
    public Button btnAccounts;
    public Button btnLogout;
    public Button btnReportBug;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(()->{
            addListeners();
        });



    }

    private void addListeners(){
        btnDashboard.setOnAction(actionEvent -> onDashboard());
        tbnTransaction.setOnAction(actionEvent -> onTransaction());
    }

    private void onTransaction() {
        System.out.println("Hi");
        Model.getInstance().getViewFactory().clientSelectedItemProperty().set("Transaction");
        System.out.println(Model.getInstance().getViewFactory().getClientSelectedItem());
    }

    private void onDashboard() {
        System.out.println("Hi");
        Model.getInstance().getViewFactory().clientSelectedItemProperty().set("Dashboard");
    }


}
