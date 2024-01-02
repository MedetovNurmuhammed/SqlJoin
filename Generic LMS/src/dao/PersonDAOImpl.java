package dao;

import databasa.Databasa;
import model.Person;
import model.Person;
import model.enums.Gender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PersonDAOImpl implements DAO<Person> {
private final Databasa databasaPerson;

    public PersonDAOImpl(Databasa databasaPerson) {
        this.databasaPerson = databasaPerson;
    }

    @Override
    public void  add(Person person) {
Databasa.databasaPerson.add(person);
    }

    @Override
    public Person getById(Long id) {
        if (id>0&&id<6){
            List<Person> PersonList = databasaPerson.getallPerson();
            for (Person person : PersonList) {
                if (id == person.getPersonid()) {
                    return person;
                }}}else {
                System.err.println("Должен быть меньще 6");
            }return null;}





    @Override
    public List<Person> getAll() {
        return databasaPerson.getallPerson();
    }

    @Override
    public List<Person> sortByName(String askordesk) {
        List<Person>PersonList = databasaPerson.getallPerson();
        Comparator<Person> comparator = Comparator.comparing(Person::getPersonname);
        if (askordesk.equalsIgnoreCase("ask")){
            Collections.sort(PersonList,comparator);
            return PersonList;
        }else if (askordesk.equalsIgnoreCase("desk")){
            comparator = comparator.reversed();
            Collections.sort(PersonList,comparator);
            return  PersonList;
        }else {
            System.err.println("Вы что-то введи не так!");
            return null;
        }


    }

    @Override
    public List<Person> filterByGender(int num) {
        List<Person> animalList = databasaPerson.getallPerson();
        List<Person> list = new ArrayList<>();
        List<Person> list1 = new ArrayList<>();
        if (num < 3 && num > 0) {
            if (num == 1) {
                for (Person person : animalList) {
                    if (person.getPersongender().equals(Gender.FEMALE)) {
                        list.add(person);

                    }
                }
                return list;

            } else if (num == 2) {
                for (Person animal : animalList) {
                    if (animal.getPersongender().equals(Gender.MALE)) {
                        list1.add(animal);

                    }

                }
                return list1;
            }

        } else {
            System.out.println("Должен быть меньще 3");
        }
        return null;
    }



    @Override
    public List<Person> clear() {
        List<Person>personList = databasaPerson.getallPerson();
        personList.clear();
        return databasaPerson.getallPerson();
    }
}