package lk.dakshithahasindra.projects.Controllers.Admin;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.dakshithahasindra.projects.Models.Account;
import lk.dakshithahasindra.projects.Models.Client;
import lk.dakshithahasindra.projects.Models.DB.AccountDataAccess;
import lk.dakshithahasindra.projects.Models.DB.ClientDataSource;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DepositController implements Initializable {
    public AnchorPane rootAdminDeposits;
    public TextField txtSearch;
    public Button btnSearch;
    public ListView<String> lvSearchedList;
    public TextField txtAmount;
    public Button btnDeposit;

    private ArrayList<Account> accountList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        ArrayList<Client> clientsList;

        txtSearch.focusedProperty().addListener(e->{
            accountList = loadAllAccounts();
        });

        txtSearch.textProperty().addListener(e->{
            filterAccounts(txtSearch.getText().strip());
        });

        lvSearchedList.getSelectionModel().selectedItemProperty().addListener((o,prev,curr)->{
            selectAccount(curr);
        });
    }

    private void selectAccount(String curr) {

    }

    private ArrayList<Account> loadAllAccounts() {
        ArrayList<Account> allAccounts = null;
        try {
            allAccounts = AccountDataAccess.loadAllAccounts();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(allAccounts.size());
        return allAccounts;
    }

    private void filterAccounts(String search) {
//        System.out.println(search);
        lvSearchedList.getItems().clear();
        search = search.toLowerCase();
        for (Account account :
                accountList) {
//            System.out.println(client.firstNameProperty().get().toLowerCase());

            System.out.println("GetClass()" +account.getClass().getSimpleName());

            if( account.ownerProperty().get().strip().toLowerCase().contains(search)){
                System.out.println(account.ownerProperty().get());
//                System.out.println("Found");
                lvSearchedList.getItems().add(account.ownerProperty().get().concat(" : ")
                        .concat((account.getClass().getSimpleName().equals("SavingsAccount")?"Savings Acc/No - ":"Checking Acc/No - "))
                        .concat(account.accountNumberProperty().get()));
            }
        }

    }

    private ArrayList<Client> loadAllClients() {
        ArrayList<Client> allClients = null;
        try {
            allClients = ClientDataSource.loadAllClients();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(allClients.size());
            return allClients;
//            addDummyClient(allClients);


    }



    public void btnSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnDepositOnAction(ActionEvent actionEvent) {
    }
}
