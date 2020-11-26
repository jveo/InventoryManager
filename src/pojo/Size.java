package pojo;

public class Size {

    private int id;
    private String size;
    private String gender;

    public Size(int id, String size, String gender) {
        this.id = id;
        this.size = size;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return getSize();
    }
}
