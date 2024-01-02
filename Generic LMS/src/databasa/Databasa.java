package databasa;

import model.Animal;
import model.Person;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Databasa{
    public static List <Animal>databasaAnimal = new ArrayList<>();
    public  static List<Person>databasaPerson = new ArrayList<>();
    public List<Animal>getallAnimal(){
        return databasaAnimal;
    }
    public List<Person> getallPerson(){
        return  databasaPerson;
    }

}

