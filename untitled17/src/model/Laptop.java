package model;

public class Laptop extends Mymodels {
    private  long id;
    private String model;

    public Laptop(long id, String model) {
        this.id = id;
        this.model = model;
    }

    public Laptop() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", model='" + model + '\'' +
                '}';
    }
}
