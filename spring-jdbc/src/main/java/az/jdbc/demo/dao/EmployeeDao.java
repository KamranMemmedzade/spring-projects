package az.jdbc.demo.dao;

import az.jdbc.demo.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmployeeDao implements Dao<Employee> {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Employee employee) {
        String query = "insert into employee(id,name,surname,age,salary) values(?,?,?,?,?)";
        jdbcTemplate.update(query, employee.getId(), employee.getName(), employee.getSurname(), employee.getAge(), employee.getSalary());
    }

    @Override
    public void delete(int id) {
        String query = "delete from employee where id=?";
        jdbcTemplate.update(query, id);
    }

    @Override
    public Employee getById(int id) {
        String query = "Select * from employee where id=?";
        Employee employee = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Employee.class), id);
        return employee;
    }

    @Override
    public List<Employee> getAll() {
        String query = "Select * from employee";
        List<Employee> employees = jdbcTemplate.query(query, new EmployeeRowMapper());
        return employees;
    }

    @Override
    public void update(Employee employee) {
        String query = "update employee set name=?,surname=?,age=?,salary=? where id =?";


        /*
        String query = "update employee set name=:name,surname=:surname,age=:age,salary=:salary where id =?";
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(employee);

        SqlParameterSource parameters = new MapSqlParameterSource().addValue("name", employee.getName())
                .addValue("surname", employee.getSurname())
                .addValue("age", employee.getAge())
                .addValue("salary", employee.getSalary());
        jdbcTemplate.update(query, parameters);
        */
        jdbcTemplate.update(query, employee.getName(), employee.getSurname(), employee.getAge(), employee.getSalary(), employee.getId());
    }

    @Override
    public long count() {
        String query = "select count(*) from employee";
        long count = jdbcTemplate.queryForObject(query, Long.class);
        return count;
    }

    private static class EmployeeRowMapper implements RowMapper<Employee> {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Employee(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("surname"),
                    rs.getInt("age"),
                    rs.getDouble("salary")
            );
        }
    }
}
