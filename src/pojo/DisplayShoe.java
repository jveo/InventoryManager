package pojo;

public class DisplayShoe {

    private int id;
    private String type;
    private String brand;
    private String size;
    private String condition;

    public DisplayShoe(int id, String type, String brand, String size, String condition) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.size = size;
        this.condition = condition;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
