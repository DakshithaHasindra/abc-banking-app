package lk.dakshithahasindra.projects.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import lk.dakshithahasindra.projects.Controllers.Admin.ClientCellController;
import lk.dakshithahasindra.projects.Controllers.Client.TransactionCellController;
import lk.dakshithahasindra.projects.Models.Transaction;

import java.io.IOException;

public class TransactionCellFactory extends ListCell<Transaction> {
    @Override
    protected void updateItem(Transaction transaction, boolean empty) {
        super.updateItem(transaction, empty);
        if(empty){
            setText(null);
            setGraphic(null);
        }else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Client/Transaction.fxml"));
            TransactionCellController transactionCellController = new TransactionCellController(transaction);
            fxmlLoader.setController(transactionCellController);
            setText(null);

            try {
                setGraphic(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
