package pojo;

public class Shoe {
    //properties
    private int id;
    private String type;

    //constructors
    public Shoe(int id, String type) {
        this.id = id;
        this.type = type;
    }

    //getters and setters
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

    @Override
    public String toString() {
        return this.type;
    }
}
