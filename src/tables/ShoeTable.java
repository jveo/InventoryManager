package tables;

import daos.ShoeDAO;
import database.DBConst;
import database.Database;
import pojo.Shoe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ShoeTable implements ShoeDAO {

    Database database = Database.getInstance();
    ArrayList<Shoe> shoes;

    @Override
    public ArrayList<Shoe> getAllShoes() {
        //create query statement to execute
        String query = "SELECT * FROM " + DBConst.TABLE_SHOE;
        shoes = new ArrayList<>();

        try {
            Statement getShoes = database.getConnection().createStatement();
            ResultSet data = getShoes.executeQuery(query);

            //while there is data add into the table
            while (data.next()) {
                shoes.add(new Shoe(data.getInt(DBConst.SHOE_COLUMN_ID), data.getString(DBConst.SHOE_COLUMN_NAME)));

            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        return shoes;
    }

    @Override
    public Shoe getShoe(int id) {
        //create query statement to execute
        String query = "SELECT * FROM " + DBConst.TABLE_SHOE + " WHERE " + DBConst.SHOE_COLUMN_ID + " = " + id;
        shoes = new ArrayList<>();

        try {
            Statement getShoes = database.getConnection().createStatement();
            ResultSet data = getShoes.executeQuery(query);

            //while there is data add into the table
            while (data.next()) {
                Shoe shoe = new Shoe(data.getInt(DBConst.SHOE_COLUMN_ID), data.getString(DBConst.SHOE_COLUMN_NAME));
                return shoe;

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
