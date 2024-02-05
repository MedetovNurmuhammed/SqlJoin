package dao;

import java.util.List;

public interface GenericDao<T> {
    String add(Long  hospitalId, List<T> t);

    void removeById(Long id);

    String updateById(Long id, T t);
}
