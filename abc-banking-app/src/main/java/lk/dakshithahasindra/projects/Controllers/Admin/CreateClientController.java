package lk.dakshithahasindra.projects.Controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateClientController implements Initializable {
    public AnchorPane rootAdminCreateClient;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtPassword;
    public CheckBox cbCheckingAccount;
    public Label lblCheckingAccNumber;
    public TextField txtCheckingDeposite;
    public CheckBox cbSavingsAccount;
    public Label lblSavingsAccNumber;
    public TextField txtSavingsAccDeposite;
    public Button btnCreateNewClient;
    public Label lblError;

    public void btnCreateNewClientOnAction(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
