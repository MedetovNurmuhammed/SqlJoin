package dao;

import databasa.Databasa;
import model.Animal;
import model.enums.Gender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnimalDAOImpl implements DAO<Animal> {
    private final Databasa databasaAnimal;

    public AnimalDAOImpl(Databasa databasaAnimal) {
        this.databasaAnimal = databasaAnimal;
    }

    @Override
    public void add(Animal animal) {

        Databasa.databasaAnimal.add(animal);
    }

    @Override
    public Animal getById(Long id) {
        if (id > 0 && id < 6) {
            List<Animal> animalList = databasaAnimal.getallAnimal();
            for (Animal animal : animalList) {
                if (id == animal.getAnimalid()) {
                    return animal;
                }
            }
        } else {
            System.err.println("Должен быть меньще 6");
        }
        return null;
    }

    @Override
    public List<Animal> getAll() {
        return databasaAnimal.getallAnimal();
    }

    @Override
    public List<Animal> sortByName(String askordesk) {
        List<Animal> animalList = databasaAnimal.getallAnimal();
        Comparator<Animal> comparator = Comparator.comparing(Animal::getAnimalname);
        if (askordesk.equalsIgnoreCase("ask")) {
            Collections.sort(animalList, comparator);
            return animalList;
        } else if (askordesk.equalsIgnoreCase("desk")) {
            comparator = comparator.reversed();
            Collections.sort(animalList, comparator);
            return animalList;
        } else {
            System.err.println("Вы что-то введи не так!");
            return null;
        }
    }

    @Override
    public List<Animal> filterByGender(int num) {
        List<Animal> animalList = databasaAnimal.getallAnimal();
        List<Animal> list = new ArrayList<>();
        List<Animal> list1 = new ArrayList<>();
        if (num < 3 && num > 0) {
            if (num == 1) {
                for (Animal animal : animalList) {
                    if (animal.getAnimalgender().equals(Gender.FEMALE)) {
                        list.add(animal);

                    }
                }
                return list;

            } else if (num == 2) {
                for (Animal animal : animalList) {
                    if (animal.getAnimalgender().equals(Gender.MALE)) {
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
    public List<Animal> clear() {

        List<Animal>animalList = databasaAnimal.getallAnimal();
        databasaAnimal.getallAnimal().clear();
        return databasaAnimal.getallAnimal();

    }


}