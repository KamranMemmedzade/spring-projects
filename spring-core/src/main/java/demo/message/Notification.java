package demo.message;


import demo.model.Employee;

public class Notification {

//    @Autowired
    private Message message;
    private Employee employee;

    public Notification() {
    }

    public Notification(Message message, Employee employee) {
        this.message = message;
        this.employee = employee;
    }

    public void setMessage(Message message){
        this.message=message;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void alert() {
        System.out.println(employee);
        System.out.println("Notification in progress...");
        message.send();
    }
}
