package lk.dakshithahasindra.projects.Models;

import javafx.beans.property.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private final StringProperty thirdParty;             //Payee or beneficiary
    private final StringProperty receiver;
    private final DoubleProperty amount;
    private final ObjectProperty<LocalDate> date;
    private final StringProperty message;

    public Transaction(String thirdPartyName, String receiver, BigDecimal amount, LocalDate date, String message) {
        this.thirdParty = new SimpleStringProperty(this, "ThirdParty", thirdPartyName);
        this.receiver = new SimpleStringProperty(this, "Receiver", receiver);
        this.amount = new SimpleDoubleProperty(this, "Amount", amount.doubleValue());
        this.date = new SimpleObjectProperty<>(this, "Date", date);
        this.message = new SimpleStringProperty(this, "Message", message);
    }

    public StringProperty thirdPartyProperty() {
        return thirdParty;
    }


    public StringProperty receiverProperty() {
        return receiver;
    }


    public DoubleProperty amountProperty() {
        return amount;
    }


    public ObjectProperty<LocalDate> dateProperty() {
        return date;
    }


    public StringProperty messageProperty() {
        return message;
    }
}
