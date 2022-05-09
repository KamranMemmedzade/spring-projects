package az.spring.hibernate.dao;

import az.spring.hibernate.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDao extends AbstractSessionFactory implements Dao<Employee> {

    public EmployeeDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Transactional
    @Override
    public void insert(Employee employee) {
        getSession().save(employee);
    }

    @Override
    public void delete(long id) {
        getSession().delete(getById(id));
    }

    @Transactional
    @Override
    public void update(Employee employee) {
        getSession().update(employee);
    }

    @Override
    public Employee getById(long id) {
        return getSession().get(Employee.class, id);
    }

    @Override
    public List<Employee> getAll() {
        return getSession().createQuery("select e from Employee e").list();
    }
}
