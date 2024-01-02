package model;

public class Phone extends Mymodels{
    private  long id;
    private String model;

    public Phone(long id, String model) {
        this.id = id;
        this.model = model;
    }

    public Phone() {
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
        return "Phone{" +
                "id=" + id +
                ", model='" + model + '\'' +
                '}';
    }
}
