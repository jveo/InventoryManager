package tables;

import daos.ConditionDAO;
import database.DBConst;
import database.Database;
import pojo.Brand;
import pojo.Condition;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ConditionTable implements ConditionDAO {

    Database database = Database.getInstance();
    ArrayList<Condition> conditions;

    @Override
    public ArrayList<Condition> getAllConditions() {
        String query = "SELECT * FROM " + DBConst.TABLE_CONDITION;
        conditions = new ArrayList<Condition>();
        try {
            Statement getConditions = database.getConnection().createStatement();
            ResultSet data = getConditions.executeQuery(query);

            while(data.next()) {
                conditions.add(new Condition(data.getInt(DBConst.CONDITION_COLUMN_ID),
                        data.getString(DBConst.CONDITION_COLUMN_SHOE_CONDITION)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conditions;
    }

    @Override
    public Condition getCondition(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_CONDITION + " WHERE " + DBConst.CONDITION_COLUMN_ID + " = " + id;
        Condition condition = null;
        try {
            Statement getConditions = database.getConnection().createStatement();
            ResultSet data = getConditions.executeQuery(query);
            while(data.next()) {
                condition = new Condition(data.getInt(DBConst.CONDITION_COLUMN_ID),
                        data.getString(DBConst.CONDITION_COLUMN_SHOE_CONDITION));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return condition;
    }
}
