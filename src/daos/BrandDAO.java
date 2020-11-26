package daos;

import pojo.Brand;

import java.util.ArrayList;

public interface BrandDAO {
    public ArrayList<Brand> getAllBrands();
    public Brand getBrand(int id);
}
