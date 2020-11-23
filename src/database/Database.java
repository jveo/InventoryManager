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
                        DBConst.DB_NAME + "?serverTimezone=UTC", DBConst.DB_USER, DBConst.DB_PASSWORD);
                System.out.println("Created connection!");
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
