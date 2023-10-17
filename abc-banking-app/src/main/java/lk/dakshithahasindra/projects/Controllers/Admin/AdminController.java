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
        Model.getInstance().getViewFactory().ADMIN_SELECTED_ITEMProperty().addListener((o,prev,cur)->{
            switch (cur){
                case "Create New Client": adminRoot.setCenter(Model.getInstance().getViewFactory().getCreatClientView());
                break;
//                default:adminRoot.setCenter(Model.getInstance().getViewFactory().getCreatClientView());
            }
        });
    }


}
