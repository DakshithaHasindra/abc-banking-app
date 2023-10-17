package lk.dakshithahasindra.projects.Controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import lk.dakshithahasindra.projects.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button btnCreateClient;
    public Button btnClients;
    public Button btnDeposite;
    public Button btnLogOut;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().ADMIN_SELECTED_ITEMProperty().set("Create New Client");
    }

    public void btnCreateClientOnAction(ActionEvent actionEvent) {
        Model.getInstance().getViewFactory().ADMIN_SELECTED_ITEMProperty().set("Create New Client");
    }

    public void btnClientsOnAction(ActionEvent actionEvent) {
        Model.getInstance().getViewFactory().ADMIN_SELECTED_ITEMProperty().set("Clients");
    }

    public void btnDepositeOnAction(ActionEvent actionEvent) {
        Model.getInstance().getViewFactory().ADMIN_SELECTED_ITEMProperty().set("Deposite");
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) {


    }
}
