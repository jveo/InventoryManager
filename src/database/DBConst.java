package database;

public class DBConst {

    // ITEM TABLE
    public static final String TABLE_ITEM = "item";
    public static final String ITEM_COLUMN_ID = "id";
    public static final String ITEM_COLUMN_TYPE = "type";
    public static final String ITEM_COLUMN_BRAND = "brand";
    public static final String ITEM_COLUMN_SIZE = "size";

    // SHOE TABLE
    public static final String TABLE_SHOE = "shoe";
    public static final String SHOE_COLUMN_ID = "id";
    public static final String SHOE_COLUMN_NAME = "name";

    // BRAND TABLE
    public static final String TABLE_BRAND = "type";
    public static final String BRAND_COLUMN_ID = "id";
    public static final String BRAND_COLUMN_SHOE_BRAND = "brand";

    // SIZE TABLE
    public static final String TABLE_SIZE = "size";
    public static final String SIZE_COLUMN_ID = "id";
    public static final String SIZE_COLUMN_SHOE_SIZE = "size";
    public static final String SIZE_COLUMN_SHOE_GENDER = "gender";

    // create Tables
    public static final String CREATE_TABLE_SHOE =
            "CREATE TABLE " + TABLE_SHOE + "(" +
                    SHOE_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
                    SHOE_COLUMN_NAME + " VARCHAR(20), " +
                    "PRIMARY KEY(" + SHOE_COLUMN_ID + ")" +
                    ")";

    public static final String CREATE_TABLE_SHOE_BRAND =
            "CREATE TABLE " + TABLE_BRAND + "(" +
                    BRAND_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
                    BRAND_COLUMN_SHOE_BRAND + " VARCHAR(20), " +
                    "PRIMARY KEY(" + BRAND_COLUMN_ID + ")" +
                    ")";

    public static final String CREATE_TABLE_SHOE_SIZE =
            "CREATE TABLE " + TABLE_SIZE + "(" +
                    SIZE_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
                    SIZE_COLUMN_SHOE_SIZE + " VARCHAR, " +
                    SIZE_COLUMN_SHOE_GENDER + " VARCHAR(10), " +
                    "PRIMARY KEY(" + SIZE_COLUMN_ID + ")" +
                    ")";

    //create Item table
    public static final String CREATE_TABLE_ITEMS =
            "CREATE TABLE " + TABLE_ITEM + " (" +
                    ITEM_COLUMN_ID + " int NOT NULL AUTO_INCREMENT PRIMARY KEY, "  +
                    ITEM_COLUMN_TYPE + " int NOT NULL"  +
                    ITEM_COLUMN_BRAND + " int NOT NULL"  +
                    ITEM_COLUMN_SIZE + " int NOT NULL"  +
                    "FOREIGN KEY (" + ITEM_COLUMN_BRAND + ")" +
                    " REFERENCES " + TABLE_BRAND + "(" + BRAND_COLUMN_ID + "),"+
                    "FOREIGN KEY (" + ITEM_COLUMN_SIZE + ")" +
                    " REFERENCES " + TABLE_SIZE + "(" + SIZE_COLUMN_ID + "),"+
                    "FOREIGN KEY (" + SHOE_COLUMN_NAME + ")" +
                    " REFERENCES " + TABLE_SHOE + "(" + SHOE_COLUMN_ID + "))";


}
