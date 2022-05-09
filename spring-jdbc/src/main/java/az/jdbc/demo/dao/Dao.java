package az.jdbc.demo.dao;


import java.util.List;

public interface Dao<T> {

    void insert(T t);

    void delete(int id);

    T getById(int id);

    List<T> getAll();

    void update(T t);

    long count();

}
