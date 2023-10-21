package lk.dakshithahasindra.projects.Controllers.Admin;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.dakshithahasindra.projects.Models.CheckingAccount;
import lk.dakshithahasindra.projects.Models.Client;
import lk.dakshithahasindra.projects.Models.Model;
import lk.dakshithahasindra.projects.Models.SavingsAccount;
import lk.dakshithahasindra.projects.Views.ClientCellFactory;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class CreateClientController implements Initializable {
    public AnchorPane rootAdminCreateClient;
    public TextField txtFirstName;
    public TextField txtLastName;
    public TextField txtPassword;
    public CheckBox cbCheckingAccount;
    public Label lblCheckingAccNumber;
    public TextField txtCheckingDeposite;
    public CheckBox cbSavingsAccount;
    public Label lblSavingsAccNumber;
    public TextField txtSavingsAccDeposite;
    public Button btnCreateNewClient;
    public Label lblError;

    public void btnCreateNewClientOnAction(ActionEvent actionEvent) throws InterruptedException {



        SavingsAccount sa = new SavingsAccount("Dakshitha hasindra","1234567891234567",10000,100000);
        CheckingAccount ca = new CheckingAccount("Dakshitha hasindra","1234567891234567",10000,100000);
        Client cl1 = new Client("Dakshitha","Hasindra",ca,sa, LocalDate.now());
        ObservableList<Node> children = Model.getInstance().getViewFactory().getClientsView().getChildren();
        
        System.out.println(Model.getInstance().getViewFactory().getClientsView().getChildren());


        FXMLLoader clientsFxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Admin/ClientCell.fxml"));
        ClientCellController clientCellController1 =new ClientCellController(cl1);
//        Thread.sleep(100);
        clientsFxmlLoader.setController(clientCellController1);
        try {
            AnchorPane clientCellView = clientsFxmlLoader.load();
            Scene clientCellScene = new Scene(clientCellView);
            Stage clintCellStage = new Stage();
            clintCellStage.setScene(clientCellScene);
            clintCellStage.show();
            System.out.println("Done");
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR,"Failed to load Clients");
            e.printStackTrace();
        }

//    TODO : set the stage to the listview of clients
//        TODO : Delete dummy values set above and use values from GUI textBoxes
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
