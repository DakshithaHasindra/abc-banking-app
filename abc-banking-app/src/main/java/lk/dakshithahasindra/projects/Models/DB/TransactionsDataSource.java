package lk.dakshithahasindra.projects.Models.DB;

import lk.dakshithahasindra.projects.Models.SingleDataConnection;

import java.sql.*;

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
}
