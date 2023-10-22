package lk.dakshithahasindra.projects.DB;

import lk.dakshithahasindra.projects.Models.SingleDataConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
