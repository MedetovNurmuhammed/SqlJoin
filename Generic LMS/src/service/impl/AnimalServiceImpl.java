package service.impl;

import dao.AnimalDAOImpl;
import databasa.Databasa;
import model.Animal;
import service.GenericService;

import java.util.List;

public class AnimalServiceImpl implements GenericService <Animal>{
 private final AnimalDAOImpl animalDAO;

    public AnimalServiceImpl(AnimalDAOImpl animalDAO) {
        this.animalDAO = animalDAO;
    }


    @Override
    public String add(List<Animal> t) {

for (Animal animal:t){
        animalDAO.add(animal) ;
        }
        System.out.println(Databasa.databasaAnimal);
        return "Успешно сохранен";
    }

    @Override
    public Animal getById(Long id) {
        if (!Databasa.databasaAnimal.isEmpty())return animalDAO.getById(id);
        System.out.println("Пусто!");
        return null;
    }

    @Override
    public List<Animal> getAll() {
      return   animalDAO.getAll();

    }

    @Override
    public List<Animal> sortByName(String askordesk) {
        if (!Databasa.databasaAnimal.isEmpty()){
animalDAO.sortByName(askordesk);
        return Databasa.databasaAnimal;}
        System.out.println("Пусто!");
        return Databasa.databasaAnimal;
        }


    @Override
    public List<Animal> filterByGender(int num) {
        if (!Databasa.databasaAnimal.isEmpty()){
          return   animalDAO.filterByGender(num);

        }
        return Databasa.databasaAnimal;
    }

    @Override
    public List<Animal> clear() {
        if (!Databasa.databasaAnimal.isEmpty()){
            System.out.println("Успешно удален!");
           return animalDAO.clear();
        }else {
            System.out.println("Пусто!");
        return Databasa.databasaAnimal;
    }
}}

