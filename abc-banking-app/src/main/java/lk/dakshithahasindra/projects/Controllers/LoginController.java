package lk.dakshithahasindra.projects.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lk.dakshithahasindra.projects.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController  implements Initializable {

    public ChoiceBox acc_selector;
    public Label lblPayeeAdress;
    public TextField txtUsername;
    public TextField txtPassword;
    public Button btnLogin;
    public Label lblError;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblError.setText(null);
//        lblError.setVisible(false);
        btnLogin.setOnAction(actionEvent -> onLogin());
    }

    private void onLogin() {
        Model.getInstance().getViewFactory().showAdminWindow();
//        Model.getInstance().getViewFactory().showClientWindow();
        Stage loginStage =(Stage) lblError.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(loginStage);
    }
}
