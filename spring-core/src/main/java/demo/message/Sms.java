package demo.message;

public class Sms implements Message {

    @Override
    public void send(){
        System.out.println("Sms was sent successfully");
    }
}
