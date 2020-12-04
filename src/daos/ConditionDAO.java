package daos;

import pojo.Condition;

import java.util.ArrayList;

public interface ConditionDAO {
    public ArrayList<Condition> getAllConditions();
    public Condition getCondition(int id);
}
