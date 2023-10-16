package lk.dakshithahasindra.projects.Controllers.Client;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.skin.TableHeaderRow;
import javafx.scene.layout.BorderPane;
import lk.dakshithahasindra.projects.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    public BorderPane clientParapet;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


            Model.getInstance().getViewFactory().clientSelectedItemProperty().addListener((o,old,ne)->{
                switch (ne){
                    case "Transaction":clientParapet.setCenter(Model.getInstance().getViewFactory().getTransactionView());
                        break;
                    case "Accounts":clientParapet.setCenter(Model.getInstance().getViewFactory().getAccountsView());
                        break;
                    default:clientParapet.setCenter(Model.getInstance().getViewFactory().getDashboardView());
                }
            });

    }
}