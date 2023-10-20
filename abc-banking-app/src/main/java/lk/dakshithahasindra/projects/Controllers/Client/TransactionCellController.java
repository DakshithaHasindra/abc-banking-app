package lk.dakshithahasindra.projects.Controllers.Client;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionCellController implements Initializable {
    public AnchorPane rootClientTransView;
    public FontAwesomeIconView iconIn;
    public FontAwesomeIconView iconOut;
    public Label lblTransDate;
    public Label lblOtherParty;
    public Label lblAmount;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
