package az.spring.hibernate.dao;

import org.springframework.stereotype.Repository;

import java.util.List;

public interface Dao<T> {

    void insert(T t);

    void delete(long id);

    void update(T t);

    T getById(long id);

    List<T> getAll();
}
