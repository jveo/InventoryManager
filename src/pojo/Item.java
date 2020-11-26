package pojo;

public class Item {
    private int id;
    private int type;
    private int brand;
    private int size;

    public Item(int id, int type, int brand, int size) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.size = size;
    }

    public Item(int type, int brand, int size) {
        this.type = type;
        this.brand = brand;
        this.size = size;
    }

    public Item() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getBrand() {
        return brand;
    }

    public void setBrand(int brand) {
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return getBrand() + "";
    }
}
