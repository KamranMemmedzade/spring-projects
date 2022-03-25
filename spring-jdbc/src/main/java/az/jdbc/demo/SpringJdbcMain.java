package az.jdbc.demo;

import az.jdbc.demo.config.SpringJdbcConfig;
import az.jdbc.demo.dao.EmployeeDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class SpringJdbcMain {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringJdbcConfig.class);
        EmployeeDao employeeDao = applicationContext.getBean(EmployeeDao.class);
        System.out.println(employeeDao.count());

    }
}
