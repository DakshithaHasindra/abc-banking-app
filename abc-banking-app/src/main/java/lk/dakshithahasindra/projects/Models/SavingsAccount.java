package lk.dakshithahasindra.projects.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class SavingsAccount extends Account{
    private final DoubleProperty withdrawalLimit;

    public SavingsAccount(String owner, String accountNumber, double balance,double withdrawalLimit) {
        super(owner, accountNumber, balance);
        this.withdrawalLimit = new SimpleDoubleProperty(this,"WithdrawalLimit",withdrawalLimit);
    }

    public DoubleProperty withdrawalLimitProperty() {
        return withdrawalLimit;
    }
}
