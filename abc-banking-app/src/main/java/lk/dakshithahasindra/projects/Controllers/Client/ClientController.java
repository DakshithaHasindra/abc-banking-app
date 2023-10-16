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

        Platform.runLater(()->{
            Model.getInstance().getViewFactory().clientSelectedItemProperty().addListener((o,old,ne)->{
                System.out.println(ne);
                switch (ne){
                    case "Transaction":clientParapet.setCenter(Model.getInstance().getViewFactory().getTransactionView());
                        System.out.println(clientParapet.toString());
                        System.out.println("Transaction");
//                        break;
                    default:/*clientParapet.setCenter(Model.getInstance().getViewFactory().getDashboardView());*/
                        System.out.println("Dashboard");
                }
            });
        });

    }
}
