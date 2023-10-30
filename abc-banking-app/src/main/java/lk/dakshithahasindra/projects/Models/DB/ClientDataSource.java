package lk.dakshithahasindra.projects.Models.DB;

import lk.dakshithahasindra.projects.Models.*;

import java.sql.*;
import java.util.ArrayList;

public class ClientDataSource {
    private static Connection connection = SingleDataConnection.getInstance().getConnection();
    public static int nextCustomerId() throws SQLException {
        Statement statement1 = connection.createStatement();
        statement1.executeUpdate("INSERT INTO clients (f_name, l_name) VALUES ('dhgfch','kjbdk')");

        Statement statement = connection.createStatement();
//        ResultSet rst = statement.executeQuery("SELECT `auto_increment` FROM INFORMATION_SCHEMA.TABLES\n" +
//                "WHERE table_name = 'clients'");

        ResultSet rst = statement.executeQuery("SELECT AUTO_INCREMENT\n" +
                "FROM information_schema.tables\n" +
                "WHERE table_name = 'clients'\n" +
                "AND table_schema = DATABASE( )");
        rst.next();
        int lastID = rst.getInt("AUTO_INCREMENT");
        return lastID;
    }

    public static int insertCustomer(String fname, String lname,String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO clients(f_name, l_name,password) VALUES (?,?,?)");
        preparedStatement.setString(1,fname);
        preparedStatement.setString(2,lname);
        preparedStatement.setString(3,password);
        int affetedRows = preparedStatement.executeUpdate();
        if(affetedRows==1){
            Statement statement = connection.createStatement();
            ResultSet rst = statement.executeQuery("SELECT last_insert_id()");
            rst.next();
            return rst.getInt(1);
        }else {
            return -1;
        }
    }

    public static ArrayList<Client> loadAllClients() throws SQLException {
        ArrayList<Client> allClients = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet rst = statement.executeQuery("SELECT * FROM clients");
        while (rst.next()){
            int id = rst.getInt("id");
            String firstName = rst.getString("f_name");
            String lastName = rst.getString("l_name");
//            System.out.println(id);
            try {
                ArrayList<Account> accounts = loadAccounts(id);
                SavingsAccount savingsAccount = (SavingsAccount) accounts.get(0);
                CheckingAccount checkingAccount = (CheckingAccount) accounts.get(1);
                Client client = new Client(firstName,lastName,checkingAccount,savingsAccount,null);
                allClients.add(client);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Load Account failed");
            }
        }
        return allClients;
    }

    private static ArrayList<Account> loadAccounts(int id) throws SQLException {
        ArrayList<Account> accounts = new ArrayList<>();
        accounts.add(null);
        accounts.add(null);
        Statement statement = connection.createStatement();
        String sql = String.format("SELECT * FROM account WHERE client_id='%d'",id);
        ResultSet rst = statement.executeQuery(sql);
        while (rst.next()){
//            System.out.println("Run Through here");
            String accountNumber = rst.getString("account_number");
            String owner = rst.getString("name");
            Double balance = rst.getDouble("balance");
            if(rst.getBoolean("is_saving_acc")){
                SavingsAccount savingsAccount = new SavingsAccount(owner,id,accountNumber,balance,100000.00);
                accounts.add(0,savingsAccount);

            }
            if(!rst.getBoolean("is_saving_acc")) {
                CheckingAccount checkingAccount = new CheckingAccount(owner, id, accountNumber, balance, 100000.00);
                accounts.add(1,checkingAccount);
                continue;
            }
        }


        return accounts;
    }
}
