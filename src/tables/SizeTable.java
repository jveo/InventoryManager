package tables;

import daos.SizeDAO;
import database.DBConst;
import database.Database;
import pojo.Size;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SizeTable implements SizeDAO {

    Database database = Database.getInstance();
    ArrayList<Size> sizes;

    @Override
    public ArrayList<Size> getAllSizes() {
        String query = "SELECT * FROM " + DBConst.TABLE_SIZE;
        sizes = new ArrayList<Size>();
        try {
            Statement getSizes = database.getConnection().createStatement();
            ResultSet data = getSizes.executeQuery(query);

            while(data.next()) {
                sizes.add(new Size(data.getInt(DBConst.SIZE_COLUMN_ID),
                        data.getString(DBConst.SIZE_COLUMN_SHOE_SIZE),
                        data.getString(DBConst.SIZE_COLUMN_SHOE_GENDER)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sizes;
    }

    @Override
    public Size getSize(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_SIZE + " WHERE " + DBConst.SIZE_COLUMN_ID + " = " + id;
        Size size = null;
        try {
            Statement getSizes = database.getConnection().createStatement();
            ResultSet data = getSizes.executeQuery(query);
            while(data.next()) {
                size = new Size(data.getInt(DBConst.SIZE_COLUMN_ID),
                        data.getString(DBConst.SIZE_COLUMN_SHOE_SIZE),
                        data.getString(DBConst.SIZE_COLUMN_SHOE_GENDER));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return size;
    }
}
