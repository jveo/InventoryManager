package tables;

import daos.ItemDAO;
import database.DBConst;
import database.Database;
import pojo.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ItemTable implements ItemDAO {

    Database database = Database.getInstance();
    ArrayList<Item> items;

    /**
     *
     * @return all items in the Item Database, (Brand,Shoe,Size)
     */
    @Override
    public ArrayList<Item> getAllItems() {
        String query = "SELECT * FROM " + DBConst.TABLE_ITEM;
        items = new ArrayList<Item>();
        try {
            Statement getItems = database.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);

            while(data.next()) {
                items.add(new Item(data.getInt(DBConst.ITEM_COLUMN_ID),
                        data.getInt(DBConst.ITEM_COLUMN_TYPE),
                        data.getInt(DBConst.ITEM_COLUMN_BRAND),
                        data.getInt(DBConst.ITEM_COLUMN_SIZE)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item getItem(int id) {
        String query = "SELECT FROM " + DBConst.TABLE_ITEM + " WHERE " + DBConst.ITEM_COLUMN_ID + " = " + id;
        Item item = new Item();
        try {
            Statement getItem = database.getConnection().createStatement();
            ResultSet data = getItem.executeQuery(query);
            data.next();
            items.add(new Item(data.getInt(DBConst.ITEM_COLUMN_ID),
                    data.getInt(DBConst.ITEM_COLUMN_TYPE),
                    data.getInt(DBConst.ITEM_COLUMN_BRAND),
                    data.getInt(DBConst.ITEM_COLUMN_SIZE),
                    data.getInt(DBConst.ITEM_COLUMN_CONDITION)));
        } catch (SQLException e){
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void createItem(Item item) {
        String query = "INSERT INTO " + DBConst.TABLE_ITEM +
                "(" + DBConst.ITEM_COLUMN_TYPE + "," +
                DBConst.ITEM_COLUMN_BRAND + "," +
                DBConst.ITEM_COLUMN_SIZE + "," +
                DBConst.ITEM_COLUMN_CONDITION + ") VALUES ('" +
                item.getType() + "','" + item.getBrand() + "','" +
                item.getSize() + "','" + item.getCondition() +
                "')";
        try {
            database.getConnection().createStatement().execute(query);
            System.out.println("Inserted Record");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteItem(int id) {
        String query  = "DELETE FROM " + DBConst.TABLE_ITEM + " WHERE " + DBConst.ITEM_COLUMN_ID + " = " + id;
        try {
            database.getConnection().createStatement().execute(query);
            System.out.println("Record Deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
