public class User implements Service {
    private  int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void method() {
        System.out.println("Hello java 12");
    }
}
