package daos;

import pojo.Type;

import java.util.ArrayList;

public interface TypeDAO {
    public ArrayList<Type> getAllTypes();
    public Type getType(int id);
}
