package lk.dakshithahasindra.projects.Controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class DepositeController implements Initializable {
    public AnchorPane rootAdminDeposits;
    public TextField txtSearch;
    public Button btnSearch;
    public ListView lvSearchedList;
    public TextField txtAmount;
    public Button btnDeposit;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnDepositOnAction(ActionEvent actionEvent) {
    }
}
