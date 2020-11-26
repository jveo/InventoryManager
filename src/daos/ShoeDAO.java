package daos;

import pojo.Shoe;

import java.util.ArrayList;

public interface ShoeDAO {
    public ArrayList<Shoe> getAllShoes();
    public Shoe getShoe(int id);
}
