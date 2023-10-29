package lk.dakshithahasindra.projects.Controllers.Admin;

import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import lk.dakshithahasindra.projects.Models.Client;
import lk.dakshithahasindra.projects.Models.Transaction;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientCellController implements Initializable {
    private final Client client;
    public AnchorPane rootAdminClientCell;
    public Label lblFirstName;
    public Label lblLastName;
    public Label lblCheckingAcNo;
    public Label lblSavingsAccNo;
    public Button btnDelete;

    public ClientCellController(Client client) {
        this.client = client;
        Platform.runLater(()-> {
            lblFirstName.setText(client.firstNameProperty().get());
            lblLastName.setText(client.lastNameProperty().get());
            if(client.checkingAccountProperty().get()!=null){
                lblCheckingAcNo.setText(client.checkingAccountProperty().get().accountNumberProperty().get());
            }
            if(client.savingsAccountProperty().get()!=null){
                lblSavingsAccNo.setText(client.savingsAccountProperty().get().accountNumberProperty().get());
            }
        });
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnDelete.setOnAction(actionEvent -> {
            System.out.println("Deleted");
        });
    }


}
