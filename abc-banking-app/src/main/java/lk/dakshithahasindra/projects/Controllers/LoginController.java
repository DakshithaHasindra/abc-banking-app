package lk.dakshithahasindra.projects.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.dakshithahasindra.projects.Models.Client;
import lk.dakshithahasindra.projects.Models.DB.ClientDataSource;
import lk.dakshithahasindra.projects.Models.Model;
import lk.dakshithahasindra.projects.Views.AccountType;
import lk.dakshithahasindra.projects.Views.sharedData.SharedCurrentLoginData;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController  implements Initializable {

    public ChoiceBox<AccountType> acc_selector;
    public Label lblPayeeAdress;
    public TextField txtUsername;
    public TextField txtPassword;
    public Button btnLogin;
    public Label lblError;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        acc_selector.getItems().setAll(AccountType.CLIENT,AccountType.ADMIN);
        acc_selector.getSelectionModel().select(AccountType.CLIENT);
        lblError.setText(null);
        btnLogin.setOnAction(actionEvent -> onLogin());
    }

    private void onLogin() {

        if(acc_selector.getSelectionModel().getSelectedItem()==AccountType.ADMIN){
            SharedCurrentLoginData.getInstance().loginID = txtUsername.getText().strip();
            Model.getInstance().getViewFactory().showAdminWindow();
        }else {
            try {
                /*TODO : Check or validate login*/
                SharedCurrentLoginData.getInstance().loginID = txtUsername.getText().strip();
                Client loggingClient = ClientDataSource.loadLoggedInClient(Integer.valueOf(txtUsername.getText().strip()));
                SharedCurrentLoginData.loggedInClient= loggingClient;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Model.getInstance().getViewFactory().showClientWindow();
        }
        Stage loginStage =(Stage) lblError.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(loginStage);
    }
}
