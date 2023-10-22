package lk.dakshithahasindra.projects.Controllers.Admin;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import lk.dakshithahasindra.projects.Models.CheckingAccount;
import lk.dakshithahasindra.projects.Models.Client;
import lk.dakshithahasindra.projects.Models.SavingsAccount;
import lk.dakshithahasindra.projects.Views.ClientCellFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ClientsController implements Initializable {
    public AnchorPane rootAdminClients;
    public ListView<AnchorPane> lvClients;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    private void addDummyClient(){
        SavingsAccount sa = new SavingsAccount("Dakshitha hasindra","1234567891234567",10000,100000);
        CheckingAccount ca = new CheckingAccount("Dakshitha hasindra","1234567891234567",10000,100000);
        Client cl1 = new Client("Dakshitha","Hasindra",ca,sa, LocalDate.now());
        Platform.runLater(()->{
//            lvClients.setCellFactory(param->new ClientCellFactory());
            FXMLLoader clientsFxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Admin/ClientCell.fxml"));
            ClientCellController clientCellController1 =new ClientCellController(cl1);
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
