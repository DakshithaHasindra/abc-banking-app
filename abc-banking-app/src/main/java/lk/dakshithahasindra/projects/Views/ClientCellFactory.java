package lk.dakshithahasindra.projects.Views;

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
            fxmlLoader.setController(clientCellController);
            setText(null);
            try {
                setGraphic(fxmlLoader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
