package lk.dakshithahasindra.projects.Controllers.Client;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.dakshithahasindra.projects.Models.Client;
import lk.dakshithahasindra.projects.Views.sharedData.SharedCurrentLoginData;

import java.math.BigDecimal;

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
        loadAccountData();

    }

    private void loadAccountData() {
        Client loggedClient = SharedCurrentLoginData.loggedInClient;
        lblCAAccountNumber.setText(loggedClient.checkingAccountProperty().get().accountNumberProperty().get());
        lblCATransactionLimit.setText("Rs. 100,000.00");
//        lblCACreatedDate.setText(); TODO: SetCreatedDate
        lblCABalance.setText("Rs. "+loggedClient.checkingAccountProperty().get().balanceProperty().get());

        lblSANumber.setText(loggedClient.savingsAccountProperty().get().accountNumberProperty().get());
        lblSAWithdrawalLimit.setText("Rs. 100,000.00");
//        lblSACreatedDate.setText(); TODO: SetCreatedDate
        lblSABalance.setText("Rs. "+loggedClient.savingsAccountProperty().get().balanceProperty().get());
    }

    public void btnTransferToSAOnAction(ActionEvent actionEvent) {
        if(!isValidAmount(txtTransferAmountToSA.getText().strip())){
            txtTransferAmountToSA.selectAll();
            return;
        }
//        BigDecimal transferAmount = new BigDecimal(txtTransferAmountToSA.getText());
//        System.out.println(transferAmount);

    }

    private boolean isValidAmount(String amount) {
        boolean isValid;
        isValid= amount.matches("^[1-9][0-9]*0{2}(.00)?$");
        return isValid;
    }

    public void btnTransferToCAOnAction(ActionEvent actionEvent) {

    }


}
