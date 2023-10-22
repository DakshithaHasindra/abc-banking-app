package lk.dakshithahasindra.projects.Models;

import lk.dakshithahasindra.projects.Controllers.Admin.CreateClientController;

public class ValidateData {
    public static boolean validateClient(CreateClientController createClientController){
        if(!createClientController.txtFirstName.getText().strip().matches("^[A-Za-z .]{2,}$")){
            createClientController.txtFirstName.requestFocus();
            createClientController.txtFirstName.selectAll();
            return false;
        } else if (!createClientController.txtLastName.getText().strip().matches("^[A-Za-z .]{2,}$")) {
            createClientController.txtLastName.requestFocus();
            createClientController.txtLastName.selectAll();
            return false;
        } else if (createClientController.txtPassword.getText().strip().isBlank()) {
            createClientController.txtPassword.requestFocus();
            createClientController.txtPassword.requestFocus();
            return false;
        } else if (!(createClientController.cbSavingsAccount.isSelected() || createClientController.cbCheckingAccount.isSelected())) {
            createClientController.lblError.setText("Select account type");
            return false;
        }

        if (createClientController.cbCheckingAccount.isSelected()) {
            String checkDeposit = createClientController.txtCheckingDeposite.getText().strip();
            if(!(checkDeposit.matches("^[1-9][0-9]+(.00|.|.0)?$")&&Double.valueOf(checkDeposit)>100)){
                createClientController.lblError.setText("Enter correct amount");
                createClientController.txtCheckingDeposite.requestFocus();
                createClientController.txtCheckingDeposite.selectAll();
                return false;

            }
        }

        if (createClientController.cbSavingsAccount.isSelected()) {
            String checkDeposit = createClientController.txtSavingsAccDeposite.getText().strip();
            if(!(checkDeposit.matches("^[1-9][0-9]+(.00|.|.0)?$")&&Double.valueOf(checkDeposit)>100)){
                createClientController.lblError.setText("Enter correct amount");
                createClientController.txtSavingsAccDeposite.requestFocus();
                createClientController.txtSavingsAccDeposite.selectAll();
                return false;

            }
        }

        return true;
        
    }
}
