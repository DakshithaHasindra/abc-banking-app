package lk.dakshithahasindra.projects.DB;

import lk.dakshithahasindra.projects.Models.SavingsAccount;
import lk.dakshithahasindra.projects.Models.SingleDataConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDataAccess {
    private static Connection dbConnection = SingleDataConnection.getInstance().getConnection();
    private  static String INSERT_SAVINGS_ACCOUNT;


    public static boolean insertSavingsAccount(SavingsAccount savingsAccount) throws SQLException {
        System.out.println("called");
        System.out.println(savingsAccount.ownerProperty().get());
        PreparedStatement preparedStatement = dbConnection.prepareStatement("INSERT INTO account(account_number, client_id, name, is_saving_acc, balance) VALUES (?,?,?,?,?)");
        preparedStatement.setString(1,savingsAccount.accountNumberProperty().get());
        preparedStatement.setInt(2,savingsAccount.getOwnerId());
        preparedStatement.setString(3,savingsAccount.ownerProperty().get());
        preparedStatement.setBoolean(4,true);
        preparedStatement.setDouble(5,savingsAccount.balanceProperty().get());
        int i = preparedStatement.executeUpdate();
        return (i==-1)?false:true;



    }
}
