package lk.dakshithahasindra.projects.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Client {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final ObjectProperty<Account> checkingAccount;
    private final ObjectProperty<Account> savingsAccount;
    private  ObjectProperty<LocalDate> dateCreated;

    public Client(String firstName,String lastName, Account checkingAccount, Account savingsAccount, LocalDate dateCreated){
        this.firstName = new SimpleStringProperty(this, "FirstName",firstName);
        this.lastName = new SimpleStringProperty(this, "LastName",lastName);
        this.checkingAccount = new SimpleObjectProperty<>(this, "CheckingAccount",checkingAccount);
        this.savingsAccount = new SimpleObjectProperty<>(this, "SavingsAccount",savingsAccount);
        this.dateCreated = new SimpleObjectProperty<>(this, "DateCreated",dateCreated);
    }

    public Client(String firstName,String lastName, Account checkingAccount, Account savingsAccount) {
        this.firstName = new SimpleStringProperty(this, "FirstName", firstName);
        this.lastName = new SimpleStringProperty(this, "LastName", lastName);
        this.checkingAccount = new SimpleObjectProperty<>(this, "CheckingAccount", checkingAccount);
        this.savingsAccount = new SimpleObjectProperty<>(this, "SavingsAccount", savingsAccount);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }


    public StringProperty lastNameProperty() {
        return lastName;
    }


    public ObjectProperty<Account> checkingAccountProperty() {
        return checkingAccount;
    }

    public ObjectProperty<Account> savingsAccountProperty() {
        return savingsAccount;
    }

    public ObjectProperty<LocalDate> dateCreatedProperty() {
        return dateCreated;
    }
}
