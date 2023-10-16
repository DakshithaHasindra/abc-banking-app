package lk.dakshithahasindra.projects.Controllers.Client;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

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
}
