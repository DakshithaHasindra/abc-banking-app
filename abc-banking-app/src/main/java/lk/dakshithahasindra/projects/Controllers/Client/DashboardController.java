package lk.dakshithahasindra.projects.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;

import java.net.URL;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
