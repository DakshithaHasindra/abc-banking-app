package lk.dakshithahasindra.projects.Controllers.Client;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.dakshithahasindra.projects.Views.sharedData.SharedCurrentLoginData;

public class AccountsController {
    public AnchorPane rootClientProfile;
    public Label lblCAAccountNumber;
    public Label lblCATransactionLimit;
    public Label lblCACreatedDate;
    public Label lblCABalance;
    public Label lblSANumber;
    public Label lblSAWithdrawalLimit;
    public Label lblSACreatedDate;
    public Label lblSABalance;
    public TextField txtTransferAmountToSA;
    public Button btnTransferToSA;
    public Button btnTransferToCA;
    public TextField txtTransferAmountToCA;

    public void initialize(){
//        System.out.println(SharedCurrentLoginData.getInstance().loginID);
    }

    public void btnTransferToSAOnAction(ActionEvent actionEvent) {
    }

    public void btnTransferToCAOnAction(ActionEvent actionEvent) {

    }
}
