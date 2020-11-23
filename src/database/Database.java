package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private static Database instance = null;
    private Connection connection = null;

    // create constructor
    private Database() {
        if (connection == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://php.scweb.ca/" +
                        Login.DB_NAME + "?serverTimezone=UTC", Login.DB_USER, Login.DB_PASSWORD);
                System.out.println("Created connection!");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    // getInstance method
    public static Database getInstance() {
        if (instance == null){
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }


}
