package tables;

import daos.BrandDAO;
import database.DBConst;
import database.Database;
import pojo.Brand;
import pojo.Shoe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BrandTable implements BrandDAO {

    Database database = Database.getInstance();
    ArrayList<Brand> brands;

    @Override
    public ArrayList<Brand> getAllBrands() {
        String query = "SELECT * FROM " + DBConst.TABLE_BRAND;
        brands = new ArrayList<Brand>();
        try {
            Statement getBrands = database.getConnection().createStatement();
            ResultSet data = getBrands.executeQuery(query);

            while(data.next()) {
                brands.add(new Brand(data.getInt(DBConst.BRAND_COLUMN_ID),
                        data.getString(DBConst.BRAND_COLUMN_SHOE_BRAND)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brands;
    }

    @Override
    public Brand getBrand(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_BRAND + " WHERE " + DBConst.BRAND_COLUMN_ID + " = " + id;
        Brand brand = null;
        try {
            Statement getBrands = database.getConnection().createStatement();
            ResultSet data = getBrands.executeQuery(query);
            while(data.next()) {
                brand = new Brand(data.getInt(DBConst.BRAND_COLUMN_ID),
                        data.getString(DBConst.BRAND_COLUMN_SHOE_BRAND));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brand;
    }
}
