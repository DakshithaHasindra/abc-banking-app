package lk.dakshithahasindra.projects.Views;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import lk.dakshithahasindra.projects.Controllers.Admin.ClientCellController;
import lk.dakshithahasindra.projects.Models.Client;

import java.io.IOException;

public class ClientCellFactory extends ListCell<Client> {
    @Override
    protected void updateItem(Client client, boolean empty) {
        super.updateItem(client, empty);
        if(empty){
            setText(null);
            setGraphic(null);
        }else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Admin/ClientCell.fxml"));
            ClientCellController clientCellController = new ClientCellController(client);
//            setValuesInGUI(clientCellController,client);
            fxmlLoader.setController(clientCellController);
            setText(null);
            try {
                setGraphic(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void setValuesInGUI(ClientCellController clientCellController,Client client) {
        Platform.runLater(()->{
            clientCellController.lblFirstName.setText(client.firstNameProperty().get());
            clientCellController.lblLastName.setText(client.lastNameProperty().get());
            clientCellController.lblSavingsAccNo.setText(client.savingsAccountProperty().get().accountNumberProperty().get());
            clientCellController.lblCheckingAcNo.setText(client.checkingAccountProperty().get().accountNumberProperty().get());

        });
    }
}
