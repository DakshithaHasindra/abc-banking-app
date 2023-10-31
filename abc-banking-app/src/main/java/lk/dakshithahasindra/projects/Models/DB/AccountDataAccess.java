package lk.dakshithahasindra.projects.Models.DB;

import lk.dakshithahasindra.projects.Models.Account;
import lk.dakshithahasindra.projects.Models.CheckingAccount;
import lk.dakshithahasindra.projects.Models.SavingsAccount;
import lk.dakshithahasindra.projects.Models.SingleDataConnection;

import java.sql.*;
import java.util.ArrayList;

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

    public static boolean insertCheckingAccount(CheckingAccount newCheckingAccount) throws SQLException {
        PreparedStatement preparedStatement = dbConnection.prepareStatement("INSERT INTO account(account_number, client_id, name, is_saving_acc, balance) VALUES (?,?,?,?,?)");
        preparedStatement.setString(1,newCheckingAccount.accountNumberProperty().get());
        preparedStatement.setInt(2,newCheckingAccount.getOwnerId());
        preparedStatement.setString(3,newCheckingAccount.ownerProperty().get());
        preparedStatement.setBoolean(4,false);
        preparedStatement.setDouble(5,newCheckingAccount.balanceProperty().get());
        int i = preparedStatement.executeUpdate();
        return (i==-1)?false:true;
    }

    public static ArrayList<Account> loadAllAccounts() throws SQLException {
        ArrayList<Account> accountList = new ArrayList<>();
        Statement statement = dbConnection.createStatement();
        ResultSet rst = statement.executeQuery("SELECT * FROM account");
        while (rst.next()){
            String accountNumber = rst.getString("account_number");
            int clientID = rst.getInt("client_id");
            String name = rst.getString("name");
            boolean isSavingAccount = rst.getBoolean("is_saving_acc");
            double balance = rst.getDouble("balance");

            if (isSavingAccount){
                SavingsAccount savingsAccount = new SavingsAccount(name, clientID, accountNumber, balance, 100000);
                accountList.add(savingsAccount);
                continue;
            }else {
                CheckingAccount checkingAccount = new CheckingAccount(name, clientID, accountNumber, balance, 100000);
                accountList.add(checkingAccount);
                continue;
            }
        }

        return accountList;

    }
}
