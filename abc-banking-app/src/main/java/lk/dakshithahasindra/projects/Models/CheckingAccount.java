package lk.dakshithahasindra.projects.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class CheckingAccount extends Account{

    private final DoubleProperty transactionLimit;
    public CheckingAccount(String owner,int ownerID, String accountNumber, double balance,double transactionLimit) {
        super(owner,ownerID, accountNumber, balance);
        this.transactionLimit = new SimpleDoubleProperty(this,"TransactionLimit",transactionLimit);
    }

    public DoubleProperty transactionLimitProperty() {
        return transactionLimit;
    }
}
