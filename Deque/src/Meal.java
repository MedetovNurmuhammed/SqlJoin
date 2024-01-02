public class Meal {
    private  String name;
    private String nationalCusine;

    public Meal(String name, String nationalCusine) {
        this.name = name;
        this.nationalCusine = nationalCusine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationalCusine() {
        return nationalCusine;
    }

    public void setNationalCusine(String nationalCusine) {
        this.nationalCusine = nationalCusine;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "name='" + name + '\'' +
                ", nationalCusine='" + nationalCusine + '\'' +
                '}';
    }
}
