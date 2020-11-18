
public class Shoe {
    private String type;
    private String brand;
    private Double size;
    private String color;

    // constructors
    public Shoe(String type, String brand, Double size, String color) {
        this.type = type;
        this.brand = brand;
        this.size = size;
        this.color = color;
    }

    public Shoe() {

    }

    // getters and setters
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

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
