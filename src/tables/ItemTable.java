package tables;

import daos.ItemDAO;
import database.DBConst;
import database.Database;
import pojo.Item;
import pojo.Size;

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
        return null;
    }

    @Override
    public void createItem(Item item) {

    }

    @Override
    public void deleteItem(int id) {

    }
}
