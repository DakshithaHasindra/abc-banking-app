package lk.dakshithahasindra.projects.Controllers.Client;

import lk.dakshithahasindra.projects.Views.ClientMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import lk.dakshithahasindra.projects.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    public BorderPane clientParapet;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


            Model.getInstance().getViewFactory().getCLIENT_SELECTED_MENU_OPTION().addListener((o, old, ne)->{

                switch (ne){
                    case TRANSACTION:clientParapet.setCenter(Model.getInstance().getViewFactory().getTransactionView());
                        break;
                    case ACCOUNT:clientParapet.setCenter(Model.getInstance().getViewFactory().getAccountsView());
                        break;
                    default:clientParapet.setCenter(Model.getInstance().getViewFactory().getDashboardView());
                }
            });

    }
}
