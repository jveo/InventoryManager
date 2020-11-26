package database;

public class DBConst {

    // ITEM TABLE
    public static final String TABLE_ITEM = "item";
    public static final String ITEM_COLUMN_ID = "id";
    public static final String ITEM_COLUMN_BRAND = "brand";
    public static final String ITEM_COLUMN_TYPE = "type";
    public static final String ITEM_COLUMN_SIZE = "size";
    public static final String ITEM_COLUMN_COLOR = "color";

    // SHOE TABLE
    public static final String TABLE_SHOE = "shoe";
    public static final String SHOE_COLUMN_ID = "id";
    public static final String SHOE_COLUMN_NAME = "name";

    // TYPE TABLE
    public static final String TABLE_TYPE = "type";
    public static final String TYPE_COLUMN_ID = "id";
    public static final String TYPE_COLUMN_SHOE_TYPE = "name";

    // SIZE TABLE
    public static final String TABLE_SIZE = "size";
    public static final String SIZE_COLUMN_ID = "id";
    public static final String SIZE_COLUMN_SHOE_SIZE = "name";
    public static final String SIZE_COLUMN_SHOE_GENDER = "name";

    // create Tables
    public static final String CREATE_TABLE_SHOE =
            "CREATE TABLE " + TABLE_SHOE + "(" +
                    SHOE_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
                    SHOE_COLUMN_NAME + " VARCHAR(20), " +
                    "PRIMARY KEY(" + SHOE_COLUMN_ID + ")" +
                    ")";

    public static final String CREATE_TABLE_SHOE_TYPE =
            "CREATE TABLE " + TABLE_TYPE + "(" +
                    TYPE_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
                    TYPE_COLUMN_SHOE_TYPE + " VARCHAR(20), " +
                    "PRIMARY KEY(" + TYPE_COLUMN_ID + ")" +
                    ")";

    public static final String CREATE_TABLE_SHOE_SIZE =
            "CREATE TABLE " + TABLE_SIZE + "(" +
                    SIZE_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
                    SIZE_COLUMN_SHOE_SIZE + " Double, " + // find what value to use here
                    SIZE_COLUMN_SHOE_GENDER + " VARCHAR(10), " +
                    "PRIMARY KEY(" + SIZE_COLUMN_ID + ")" +
                    ")";

    //create Item table
    public static final String CREATE_TABLE_ITEMS =
            "CREATE TABLE " + TABLE_ITEM + " (" +
                    ITEM_COLUMN_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY, "  +
                    ITEM_COLUMN_BRAND + " int NOT NULL"  +
                    ITEM_COLUMN_TYPE + " int NOT NULL"  +
                    ITEM_COLUMN_SIZE + " int NOT NULL"  +
                    ITEM_COLUMN_COLOR + " int NOT NULL" ;
                    //"FOREIGN KEY ("


}
