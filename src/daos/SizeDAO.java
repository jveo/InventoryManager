package daos;

import pojo.Size;

import java.util.ArrayList;

public interface SizeDAO {
    public ArrayList<Size> getAllSizes();
    public Size getSize(int id);
}
