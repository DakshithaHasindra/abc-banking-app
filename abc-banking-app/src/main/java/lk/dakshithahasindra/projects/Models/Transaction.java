package lk.dakshithahasindra.projects.Models;

import javafx.beans.property.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private final StringProperty senderAccNo;             //Payee or beneficiary
    private final StringProperty receiverAccNo;
    private final DoubleProperty amount;
    private final ObjectProperty<LocalDate> date;
    private final StringProperty message;

    public Transaction(String thirdPartyName, String receiver, BigDecimal amount, LocalDate date, String message) {
        this.senderAccNo = new SimpleStringProperty(this, "ThirdParty", thirdPartyName);
        this.receiverAccNo = new SimpleStringProperty(this, "Receiver", receiver);
        this.amount = new SimpleDoubleProperty(this, "Amount", amount.doubleValue());
        this.date = new SimpleObjectProperty<>(this, "Date", date);
        this.message = new SimpleStringProperty(this, "Message", message);
    }

    public StringProperty senderAccNoProperty() {
        return senderAccNo;
    }


    public StringProperty receiverAccNoProperty() {
        return receiverAccNo;
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
