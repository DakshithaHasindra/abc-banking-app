package lk.dakshithahasindra.projects.Controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import lk.dakshithahasindra.projects.Models.Model;
import lk.dakshithahasindra.projects.Views.AdminMenuOptions;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button btnCreateClient;
    public Button btnClients;
    public Button btnDeposite;
    public Button btnLogOut;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Model.getInstance().getViewFactory().getADMIN_SELECTED_MENU_OPTION().set(AdminMenuOptions.CREATE_NEW_CLIENT);
    }

    public void btnCreateClientOnAction(ActionEvent actionEvent) {
        Model.getInstance().getViewFactory().getADMIN_SELECTED_MENU_OPTION().set(AdminMenuOptions.CREATE_NEW_CLIENT);
    }

    public void btnClientsOnAction(ActionEvent actionEvent) {
        Model.getInstance().getViewFactory().getADMIN_SELECTED_MENU_OPTION().set(AdminMenuOptions.CLIENTS);
    }

    public void btnDepositeOnAction(ActionEvent actionEvent) {
        Model.getInstance().getViewFactory().getADMIN_SELECTED_MENU_OPTION().set(AdminMenuOptions.DEPOSIT);
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) {


    }
}
