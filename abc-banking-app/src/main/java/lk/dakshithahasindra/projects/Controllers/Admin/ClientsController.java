package lk.dakshithahasindra.projects.Controllers.Admin;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import lk.dakshithahasindra.projects.Models.Client;
import lk.dakshithahasindra.projects.Models.DB.ClientDataSource;

import java.io.IOException;
import java.lang.ref.Cleaner;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ClientsController implements Initializable {
    public AnchorPane rootAdminClients;
    public ListView<AnchorPane> lvClients;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        Load all clients to the list
            loadAllClients();
//            addDummyClient();
    }

    private void loadAllClients() {
        try {
            ArrayList<Client> allClients = ClientDataSource.loadAllClients();
            System.out.println(allClients.size());
            addDummyClient(allClients);
        } catch (SQLException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to load Clients");
        }

    }

    private void addDummyClient(ArrayList<Client> allClients){
//        SavingsAccount sa = new SavingsAccount("Dakshitha hasindra","1234567891234567",10000,100000);
//        CheckingAccount ca = new CheckingAccount("Dakshitha hasindra","1234567891234567",10000,100000);
//        Client cl1 = new Client("Dakshitha","Hasindra",ca,sa, LocalDate.now());
        for(int i = 0 ; i < allClients.size();i++) {
            Client client = allClients.get(i);
            Platform.runLater(() -> {

//            lvClients.setCellFactory(param->new ClientCellFactory());
                FXMLLoader clientsFxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Admin/ClientCell.fxml"));

            ClientCellController clientCellController1 =new ClientCellController(client);
//        Thread.sleep(100);
            clientsFxmlLoader.setController(clientCellController1);
                try {
                    AnchorPane root = clientsFxmlLoader.load();
                    lvClients.getItems().add(root);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


            });
        }
    }
}
