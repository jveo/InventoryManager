package tables;

import daos.ItemDAO;
import database.DBConst;
import database.Database;
import pojo.DisplayShoe;
import pojo.Item;

import java.sql.PreparedStatement;
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
                        data.getInt(DBConst.ITEM_COLUMN_SIZE),
                        data.getInt(DBConst.ITEM_COLUMN_CONDITION)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item getItem(int itemId) {
        String query = "SELECT FROM " + DBConst.TABLE_ITEM + " WHERE " + DBConst.ITEM_COLUMN_ID + " = " + itemId;
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
                "(" + DBConst.ITEM_COLUMN_TYPE + ", " +
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

    public ArrayList<DisplayShoe> getPrettyItems(){
        ArrayList<DisplayShoe> items = new ArrayList<DisplayShoe>();
        String query = "SELECT item.id, shoe.name AS shoe_type, " +
                " item.size, shoe_condition.name as shoe_condition," +
                " brand.name as brand_name " +
                " from item " +
                "JOIN shoe on item.type = shoe.id " +
                "JOIN shoe_condition on item.shoe_condition = shoe_condition.id " +
                "JOIN brand ON item.brand = brand.id " +
                "ORDER BY item.id ASC";
        try {
            Statement getItems = database.getConnection().createStatement();
            ResultSet data = getItems.executeQuery(query);
            while(data.next()) {
                items.add(new DisplayShoe(data.getInt("id"),
                        data.getString("shoe_type"),
                        data.getString("brand_name"),
                        data.getString("size"),
                        data.getString("shoe_condition")));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return items;

    }


    public int getItemCount(int shoe) {
        int count = -1;
        try {
            PreparedStatement getCount = database.getConnection()
                    .prepareStatement("SELECT * FROM " + DBConst.TABLE_ITEM + " WHERE "
                                    + DBConst.ITEM_COLUMN_TYPE + " = '" + shoe + "'", ResultSet.TYPE_SCROLL_SENSITIVE,
                            ResultSet.CONCUR_UPDATABLE);
            ResultSet data = getCount.executeQuery();
            data.last();
            count = data.getRow();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return count;
    }
}
