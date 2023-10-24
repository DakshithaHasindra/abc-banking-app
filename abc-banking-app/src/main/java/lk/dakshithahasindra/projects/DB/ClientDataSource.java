package lk.dakshithahasindra.projects.DB;

import lk.dakshithahasindra.projects.Models.SingleDataConnection;

import java.sql.*;

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

    public static int insertCustomer(String fname, String lname) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO clients(f_name, l_name) VALUES (?,?)");
        preparedStatement.setString(1,fname);
        preparedStatement.setString(2,lname);
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
}
