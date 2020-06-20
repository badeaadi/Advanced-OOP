package Services;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;


public class DatabaseConnection {


    private static DatabaseConnection instance;

    private final String url = "jdbc:postgresql://localhost:5432/pao?createDatabaseIfNotExist=true";

    private final String username = "postgres";
    private final String password = "3838";

    private final Connection connection;

    private DatabaseConnection() throws SQLException {

        this.connection = DriverManager.getConnection(url, username, password);
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }

        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    }
