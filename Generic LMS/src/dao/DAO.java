package dao;

import java.util.List;

public interface DAO<T> {
    void add(T t);
    T getById(Long id);
    List<T> getAll();
    List<T> sortByName(String askordesk); //1 ди басканда ascending, 2 ни басканда descending кылып сорттосун
     List<T> filterByGender(int num); //1 ди басканда female, 2 ни басканда male кылып фильтрлесин
     List<T> clear();
}
