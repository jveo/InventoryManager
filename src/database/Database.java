package database;

import java.sql.*;

public class Database {

    private static Database instance = null;
    private Connection connection = null;

    // create constructor
    private Database() {
        // check if there is a connection that exists
        if (connection == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/" + Login.DB_NAME + "?serverTimezone=UTC", Login.DB_USER, Login.DB_PASSWORD);
                System.out.println("Created Connection");
            } catch (Exception e){
                e.printStackTrace();
            }
            try {
                createTable(DBConst.TABLE_SHOE, DBConst.CREATE_TABLE_SHOE, connection);
                createTable(DBConst.TABLE_BRAND, DBConst.CREATE_TABLE_SHOE_BRAND, connection);
                createTable(DBConst.TABLE_CONDITION, DBConst.CREATE_TABLE_SHOE_CONDITION, connection);
                createTable(DBConst.TABLE_ITEM, DBConst.CREATE_TABLE_ITEMS, connection);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //createTable method
    public void createTable(String tableName, String tableQuery, Connection connection) throws SQLException {
        Statement createTables;
        DatabaseMetaData md = connection.getMetaData();
        ResultSet result = md.getTables(null, null, tableName, null);
        if (result.next()){
            System.out.println(tableName + " Table already exists!");
        } else {
            createTables = connection.createStatement();
            boolean inserted = createTables.execute(tableQuery);
            System.out.println("The " + tableName + " table has been inserted: " + !inserted);
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
