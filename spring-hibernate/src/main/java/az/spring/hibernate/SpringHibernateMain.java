package az.spring.hibernate;

import az.spring.hibernate.config.HibernateConfig;
import az.spring.hibernate.dao.Dao;
import az.spring.hibernate.dao.EmployeeDao;
import az.spring.hibernate.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringHibernateMain {

    public static void main(String[] args) {
    ApplicationContext applicationContext=new AnnotationConfigApplicationContext(HibernateConfig.class);

    EmployeeDao employeeDao=applicationContext.getBean(EmployeeDao.class);

        Employee employee = new Employee();
        employee.setName("Kamran");
        employee.setSurname("Məmmədzadə");
        employee.setAge(23);
        employee.setSalary(9000);

        employeeDao.insert(employee);

        System.out.println(employeeDao.getById(employee.getId()));
    }
}
