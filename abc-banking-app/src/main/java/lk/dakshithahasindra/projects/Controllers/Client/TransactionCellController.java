package lk.dakshithahasindra.projects.Controllers.Client;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.dakshithahasindra.projects.Models.Transaction;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionCellController implements Initializable {
    public AnchorPane rootClientTransView;
    public FontAwesomeIconView iconIn;
    public FontAwesomeIconView iconOut;
    public Label lblTransDate;
    public Label lblOtherParty;
    public Label lblAmount;
    private final Transaction transaction;
    public TransactionCellController(Transaction transaction){
        this.transaction = transaction;

        Platform.runLater(()->{
            lblTransDate.setText(transaction.dateProperty().get().toString());
            lblAmount.setText("Rs. "+transaction.amountProperty().get());

        });

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
