package lk.dakshithahasindra.projects.Models;

import javafx.beans.property.*;

public abstract class Account {
    private final int ownerId;
    private final StringProperty owner;
    private final StringProperty accountNumber;
    private final DoubleProperty balance;

    public Account(String owner,int id, String accountNumber, double balance){
        this.ownerId = id;
        this.owner = new SimpleStringProperty(this,"Owner",owner);
        this.accountNumber = new SimpleStringProperty(this,"AccountNumber",accountNumber);
        this.balance = new SimpleDoubleProperty(this,"Balance",balance);
    }


    public StringProperty ownerProperty() {
        return owner;
    }

    public StringProperty accountNumberProperty() {
        return accountNumber;
    }

    public DoubleProperty balanceProperty() {
        return balance;
    }

    public int getOwnerId() {
        return ownerId;
    }
}

