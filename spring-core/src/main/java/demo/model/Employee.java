package demo.model;

import java.util.List;
import java.util.Map;

public class Employee {
    private String name;
    private String surname;
    private int age;
    private double salary;

    private List<String> phoneNumbers;
    private List<Device> devices;

    private Map<String ,Integer> address;


    public Employee() {
    }

    public Employee(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Employee(int age, double salary) {
        this.age = age;
        this.salary = salary;
    }

    public Employee(String name, String surname, int age, double salary, List<String> phoneNumbers, List<Device> devices, Map<String, Integer> address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
        this.phoneNumbers = phoneNumbers;
        this.devices = devices;
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", phoneNumbers=" + phoneNumbers +
                ", devices=" + devices +
                ", address=" + address +
                '}';
    }
}
