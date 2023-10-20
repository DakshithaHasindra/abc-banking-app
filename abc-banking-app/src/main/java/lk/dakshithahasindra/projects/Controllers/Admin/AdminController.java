package lk.dakshithahasindra.projects.Controllers.Admin;

import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;
import lk.dakshithahasindra.projects.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public BorderPane adminRoot;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getADMIN_SELECTED_MENU_OPTION().addListener((o,prev,cur)->{
            switch (cur){
                case CREATE_NEW_CLIENT: adminRoot.setCenter(Model.getInstance().getViewFactory().getCreatClientView());
                break;
                case CLIENTS:adminRoot.setCenter(Model.getInstance().getViewFactory().getClientsView());
//                default:adminRoot.setCenter(Model.getInstance().getViewFactory().getCreatClientView());
            }
        });
    }


}
