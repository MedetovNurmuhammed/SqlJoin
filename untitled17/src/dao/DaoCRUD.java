package dao;

import model.Laptop;

import java.util.List;

public interface DaoCRUD<T,ID> {
    boolean add(T type);
    boolean delete(T type);
    T findbyid(ID id);
    List<T> fibdall();
    String  update(ID id,T type);
    List<T>sort();
}
