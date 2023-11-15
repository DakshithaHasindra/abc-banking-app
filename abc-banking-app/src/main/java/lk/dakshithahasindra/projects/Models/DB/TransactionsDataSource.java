package lk.dakshithahasindra.projects.Models.DB;

import lk.dakshithahasindra.projects.Models.SingleDataConnection;

import java.sql.*;
import java.time.LocalDate;
import java.util.Random;

public class TransactionsDataSource {
    private static Connection connection = SingleDataConnection.getInstance().getConnection();

    public static void updateAccountBalance(double amount, String accountNumber) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM account WHERE account_number=?");
        preparedStatement.setString(1,accountNumber);
        ResultSet rst = preparedStatement.executeQuery();
        rst.next();
        double accBalance = rst.getDouble("balance");
        accBalance = accBalance + amount;
        PreparedStatement updateStatement = connection.prepareStatement("UPDATE account SET balance=? WHERE account_number=?");
        updateStatement.setDouble(1,accBalance);
        updateStatement.setString(2,accountNumber);
        int i = updateStatement.executeUpdate();
    }

    public static void transactionsTableUpdate(String senderAccNo, String receiverAccNo,double amount) throws SQLException {

        String transID = generateTransID();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO transactions (trans_id, amount, sender_acc_no, receiver_acc_no) VALUES (?,?,?,?)");
        preparedStatement.setString(1,transID);
//        TODO: Above transaction ID has to unique
        preparedStatement.setDouble(2,amount);
        preparedStatement.setString(3,senderAccNo);
        preparedStatement.setString(4,receiverAccNo);
        preparedStatement.executeUpdate();

        PreparedStatement transactionCommonPreparedStatement = connection.prepareStatement("INSERT INTO accounts_transactions (account_number, trans_id) VALUES (?,?)");
        preparedStatement.setString(1,senderAccNo);
        preparedStatement.setString(2,transID);
//        TODO : reciever data to common
    }

    public static String generateTransID(){
        LocalDate currentDate = LocalDate.now();
        int randomNum = new Random().nextInt(1000);
        int randomNum2 = new Random().nextInt(1000);
        String transactionId = currentDate.toString() + "-" + randomNum+randomNum2;

        return transactionId;
    }
}
