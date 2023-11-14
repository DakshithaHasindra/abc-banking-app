package lk.dakshithahasindra.projects.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.dakshithahasindra.projects.Models.Client;
import lk.dakshithahasindra.projects.Views.sharedData.SharedCurrentLoginData;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class DashboardController implements Initializable {
    public Text lblUserName;
    public Label lblDate;
    public Label lblCheckingBalance;
    public Label lblCheckingAccNum;
    public Label lblSavingBalance;
    public Label lblSavingAccNum;
    public Text lblIncome;
    public Text lblExpense;
    public ListView lvTransaction;
    public TextField txtPayeeAccountNum;
    public TextField txtAmount;
    public TextArea txtDescription;
    public Button btnTransfer;
    public AnchorPane anchorpaneCheckingAccount;
    public AnchorPane anchorpaneSavingsAccount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblDate.setText(String.valueOf(LocalDate.now()));
        displayClientData();

    }

    private void displayClientData() {
        Client client = SharedCurrentLoginData.loggedInClient;
        System.out.println(SharedCurrentLoginData.loggedInClient.checkingAccountProperty().get());
        if(client.checkingAccountProperty().get()!=null){
            lblCheckingBalance.setText("Rs. "+String.valueOf(client.checkingAccountProperty().get().balanceProperty().get()));
            lblCheckingAccNum.setText(client.checkingAccountProperty().get().accountNumberProperty().get().substring(12));
            anchorpaneCheckingAccount.setVisible(true);
        }else {
            anchorpaneCheckingAccount.setVisible(false);
        }
        if(client.savingsAccountProperty().get()!=null){
            lblSavingBalance.setText("Rs. "+String.valueOf(client.savingsAccountProperty().get().balanceProperty().get()));
            lblSavingAccNum.setText(client.savingsAccountProperty().get().accountNumberProperty().get().substring(12));
            anchorpaneSavingsAccount.setVisible(true);
        }else {
            anchorpaneSavingsAccount.setVisible(false);
        }

        /* Display Client Name */
        String displayName = SharedCurrentLoginData.loggedInClient.firstNameProperty().get()+" "+SharedCurrentLoginData.loggedInClient.lastNameProperty().get().substring(0,1).toUpperCase()+".";
        lblUserName.setText(displayName);

        /*TODO : Load transactions and last income and outgoing */

    }
}
