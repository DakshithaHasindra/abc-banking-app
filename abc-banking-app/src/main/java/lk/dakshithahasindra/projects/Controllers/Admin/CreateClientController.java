package lk.dakshithahasindra.projects.Controllers.Admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.dakshithahasindra.projects.Models.DB.AccountDataAccess;
import lk.dakshithahasindra.projects.Models.DB.ClientDataSource;
import lk.dakshithahasindra.projects.Models.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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

    public void btnCreateNewClientOnAction(ActionEvent actionEvent) throws InterruptedException, SQLException {
        System.out.println("Is Checking Accoount Selected : "+cbCheckingAccount.isSelected());
        if (!ValidateData.validateClient(this)) {
            return;
        }

        lblError.setText(null);

//        int newID ;
//        try {
//            newID = ClientDataSource.insertCustomer("Dakshitha","Hasindra");
//
//        } catch (SQLException e) {
//            new Alert(Alert.AlertType.ERROR,"Failed to save the CLient");
//            return;
//        }
        int newId = createClient();
        if(newId==-1){
            new Alert(Alert.AlertType.ERROR,"Failed to save Client, Please Retry!");
            return;
        }
//        TODO : CREATE two accounts and instance of client
        System.out.println(newId);
//        SingleDataConnection.getInstance().getConnection().setAutoCommit(false));
        try {
            SingleDataConnection.getInstance().getConnection().setAutoCommit(false);
            if(cbSavingsAccount.isSelected()) {
                createSavingsAccount(newId);
            }
            if(cbCheckingAccount.isSelected()){
                createCheckingAccount(newId);
            }
            System.out.println("Create Ne Customer");
            SingleDataConnection.getInstance().getConnection().commit();
        } catch (SQLException e) {
            SingleDataConnection.getInstance().getConnection().rollback();
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR,"Failed to save the Account");
        }
        SingleDataConnection.getInstance().getConnection().setAutoCommit(true);

//        TODO : Create account instances, Create client, Input data to DB
//        TODO : Add Client anchorpane to admin clients view


//    TODO : set the stage to the listview of clients
//        TODO : Delete dummy values set above and use values from GUI textBoxes
    }

    private void createCheckingAccount(int newId) throws SQLException {
        Account newCheckingAccount = new CheckingAccount(txtFirstName.getText()+" "+txtLastName.getText(),newId, lblCheckingAccNumber.getText(), Double.valueOf(txtCheckingDeposite.getText()),100000.00);
        boolean b = AccountDataAccess.insertCheckingAccount((CheckingAccount) newCheckingAccount);
        System.out.println(b);
    }

    private void createSavingsAccount(int newId) throws SQLException {
        Account newSavingAccount = new SavingsAccount(txtFirstName.getText()+" "+txtLastName.getText(),newId, lblSavingsAccNumber.getText(), Double.valueOf(txtSavingsAccDeposite.getText()),100000.00);
        boolean b = AccountDataAccess.insertSavingsAccount((SavingsAccount) newSavingAccount);
        System.out.println(b);
    }

    private int createClient() {
        try {
            String hashedPassword   = DigestUtils.sha256Hex(txtPassword.getText());
            int newId = ClientDataSource.insertCustomer(txtFirstName.getText().strip(), txtLastName.getText().strip(),hashedPassword);
            return newId;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private void addDummyClient(){

//        SavingsAccount sa = new SavingsAccount("Dakshitha hasindra","1234567891234567",10000,100000);
//        CheckingAccount ca = new CheckingAccount("Dakshitha hasindra","1234567891234567",10000,100000);
//        Client cl1 = new Client("Dakshitha","Hasindra",ca,sa, LocalDate.now());
//        ObservableList<Node> children = Model.getInstance().getViewFactory().getClientsView().getChildren();

//        System.out.println(Model.getInstance().getViewFactory().getClientsView().getChildren());


        FXMLLoader clientsFxmlLoader = new FXMLLoader(getClass().getResource("/Fxml/Admin/ClientCell.fxml"));
//        ClientCellController clientCellController1 =new ClientCellController(cl1);
//        Thread.sleep(100);
//        clientsFxmlLoader.setController(clientCellController1);
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
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtCheckingDeposite.setEditable(false);
        txtSavingsAccDeposite.setEditable(false);
        lblError.setText(null);

        cbCheckingAccount.selectedProperty().addListener(observable -> {
            if(cbCheckingAccount.isSelected()){
                lblCheckingAccNumber.setText(GenerateAccountNumber.generateAccNumber());
                txtCheckingDeposite.setEditable(true);
            }else {
                lblCheckingAccNumber.setText("");
            }
        });

        cbSavingsAccount.selectedProperty().addListener(observable -> {
            if(cbSavingsAccount.isSelected()){
                lblSavingsAccNumber.setText(GenerateAccountNumber.generateAccNumber());
                txtSavingsAccDeposite.setEditable(true);
            }
            else {
                lblSavingsAccNumber.setText("");
            }
        });
    }


}
