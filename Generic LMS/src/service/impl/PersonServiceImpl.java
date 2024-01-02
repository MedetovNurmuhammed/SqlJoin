package service.impl;

import dao.PersonDAOImpl;
import databasa.Databasa;
import model.Person;
import service.GenericService;

import java.util.List;

public class PersonServiceImpl implements GenericService<Person> {
    private  final PersonDAOImpl personDAO;

    public PersonServiceImpl(PersonDAOImpl personDAO) {
        this.personDAO = personDAO;
    }


    @Override
    public String add(List<Person> t) {
        for (Person person : t) {
            personDAO.add(person);
        }
        System.out.println(Databasa.databasaPerson);

        return "Успешно сохранен!";
    }

    @Override
    public Person getById(Long id) {
        if (!Databasa.databasaPerson.isEmpty())return personDAO.getById(id);System.out.println("Пусто!");return null;


    }



    @Override
    public List<Person> getAll() {
        return personDAO.getAll();
    }

    @Override
    public List<Person> sortByName(String ask) {
        if (!Databasa.databasaPerson.isEmpty()){
            personDAO.sortByName(ask);
            return Databasa.databasaPerson;
        }
        System.out.println("Пусто!");
        return Databasa.databasaPerson;
    }

    @Override
    public List<Person> filterByGender(int num) {

        if (!Databasa.databasaPerson.isEmpty()){
            return   personDAO.filterByGender(num);

        }
        return Databasa.databasaPerson;
    }

    @Override
    public List<Person> clear() {
        if (!Databasa.databasaPerson.isEmpty()){
            System.out.println("Успешно удален!");
          return   personDAO.clear();
        }else {
            System.out.println("Пусто!");
        return Databasa.databasaPerson;
    }}
}
