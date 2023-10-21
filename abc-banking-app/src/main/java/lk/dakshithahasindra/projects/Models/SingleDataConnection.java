package lk.dakshithahasindra.projects.Models;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SingleDataConnection {
    private static SingleDataConnection instance;
    private final Connection connection;


    private SingleDataConnection()  {
        Properties properties = new Properties();
        try {
            properties.load(getClass().getResourceAsStream("/database/Application.properties"));
            String url = properties.getProperty("app.datasource.url");
            String userName = properties.getProperty("app.datasource.username");
            String password = properties.getProperty("app.datasource.password");
            connection = DriverManager.getConnection(url,userName,password);
            createDataTables();
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static SingleDataConnection getInstance() {
        return (instance == null) ? instance = new SingleDataConnection() : instance;
    }

    public Connection getConnection(){
        return connection;
    }

    private void createDataTables() throws Exception {
        Path path = Paths.get(SingleDataConnection.class.getResource("/database/database.sql").toURI());
        String script = Files.readAllLines(path).stream().reduce(( prev, cur) -> prev + cur).get();
        connection.createStatement().execute(script);
    }
}
