package lk.dakshithahasindra.projects.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionController implements Initializable {
    public ListView lvTransactions;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadAllTransactionCells();
    }

    private void loadAllTransactionCells() {


    }
}
