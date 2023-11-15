package lk.dakshithahasindra.projects.Controllers.Client;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import lk.dakshithahasindra.projects.Models.Client;
import lk.dakshithahasindra.projects.Models.DB.ClientDataSource;
import lk.dakshithahasindra.projects.Models.DB.TransactionsDataSource;
import lk.dakshithahasindra.projects.Models.SingleDataConnection;
import lk.dakshithahasindra.projects.Models.Transaction;
import lk.dakshithahasindra.projects.Views.sharedData.SharedCurrentLoginData;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;

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
    public Text lblCheckingAcc;
    public VBox VBoxChekingAcc;
    public Text lblSavingsAcc;
    public VBox VBoxSavingsAcc;

    public void initialize(){
//        System.out.println(SharedCurrentLoginData.getInstance().loginID);

        txtTransferAmountToCA.clear();
        txtTransferAmountToSA.clear();
        loadAccountData();
        Client loggedInClient = SharedCurrentLoginData.loggedInClient;
        if(loggedInClient.checkingAccountProperty().get()==null){
            for (Node node:
                    new Node[]{txtTransferAmountToCA,txtTransferAmountToSA,btnTransferToCA,btnTransferToSA}) {
                node.setDisable(true);
            }
            lblCheckingAcc.setVisible(false);
            VBoxChekingAcc.setVisible(false);
        }

        if(loggedInClient.savingsAccountProperty().get()==null){
            for (Node node:
                    new Node[]{txtTransferAmountToCA,txtTransferAmountToSA,btnTransferToCA,btnTransferToSA}) {
                node.setDisable(true);
            }
            lblSavingsAcc.setVisible(false);
            VBoxSavingsAcc.setVisible(false);
        }
    }

    private void loadAccountData() {
        Client loggedClient = SharedCurrentLoginData.loggedInClient;
        if (loggedClient.checkingAccountProperty().get()!=null){
            lblCAAccountNumber.setText(loggedClient.checkingAccountProperty().get().accountNumberProperty().get());
            lblCATransactionLimit.setText("Rs. 100,000.00");
//        lblCACreatedDate.setText(); TODO: SetCreatedDate
            lblCABalance.setText("Rs. "+loggedClient.checkingAccountProperty().get().balanceProperty().get());
        }

        if (loggedClient.savingsAccountProperty().get()!=null){
            lblSANumber.setText(loggedClient.savingsAccountProperty().get().accountNumberProperty().get());
            lblSAWithdrawalLimit.setText("Rs. 100,000.00");
//        lblSACreatedDate.setText(); TODO: SetCreatedDate
            lblSABalance.setText("Rs. "+loggedClient.savingsAccountProperty().get().balanceProperty().get());
        }
    }

    public void btnTransferToSAOnAction(ActionEvent actionEvent) {
        Client loggedClient = SharedCurrentLoginData.loggedInClient;
        if(!isValidAmount(txtTransferAmountToSA.getText().strip())){
            txtTransferAmountToSA.selectAll();
            txtTransferAmountToSA.requestFocus();
            return;
        }
        double transferAmount = Double.parseDouble(txtTransferAmountToSA.getText());
        if(transferAmount>loggedClient.checkingAccountProperty().get().balanceProperty().get()-1000){
            new Alert(Alert.AlertType.ERROR,"Insufficient Balance").show();
            return;
        }
        Connection connection = SingleDataConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);
            TransactionsDataSource.updateAccountBalance(-transferAmount,loggedClient.checkingAccountProperty().get().accountNumberProperty().get());
            TransactionsDataSource.updateAccountBalance(transferAmount,loggedClient.savingsAccountProperty().get().accountNumberProperty().get());


            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
               e.printStackTrace();
            }
            new Alert(Alert.AlertType.ERROR,"Unknown Error occurred").show();
            e.printStackTrace();
        }
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            SharedCurrentLoginData.loggedInClient = ClientDataSource.loadLoggedInClient(Integer.valueOf(SharedCurrentLoginData.loginID));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        initialize();
        new Alert(Alert.AlertType.INFORMATION,"Transaction Complete").show();


    }

    private boolean isValidAmount(String amount) {
        boolean isValid;
        isValid= amount.matches("^[1-9][0-9]*0{2}(.00)?$");
        return isValid;
    }

    public void btnTransferToCAOnAction(ActionEvent actionEvent) {

        Client loggedClient = SharedCurrentLoginData.loggedInClient;
        if(!isValidAmount(txtTransferAmountToCA.getText().strip())){
            txtTransferAmountToCA.selectAll();
            txtTransferAmountToCA.requestFocus();
            return;
        }
        double transferAmount = Double.parseDouble(txtTransferAmountToCA.getText());
        if(transferAmount>loggedClient.savingsAccountProperty().get().balanceProperty().get()-1000){
            new Alert(Alert.AlertType.ERROR,"Insufficient Balance").show();
            return;
        }
        Connection connection = SingleDataConnection.getInstance().getConnection();

        try {
            connection.setAutoCommit(false);
            TransactionsDataSource.updateAccountBalance(-transferAmount,loggedClient.savingsAccountProperty().get().accountNumberProperty().get());
            TransactionsDataSource.updateAccountBalance(+transferAmount,loggedClient.checkingAccountProperty().get().accountNumberProperty().get());


            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                e.printStackTrace();
            }
            new Alert(Alert.AlertType.ERROR,"Unknown Error occurred").show();
            e.printStackTrace();
        }
        try {
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            SharedCurrentLoginData.loggedInClient = ClientDataSource.loadLoggedInClient(Integer.valueOf(SharedCurrentLoginData.loginID));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        initialize();

        new Alert(Alert.AlertType.INFORMATION,"Transaction Complete").show();

    }


}
