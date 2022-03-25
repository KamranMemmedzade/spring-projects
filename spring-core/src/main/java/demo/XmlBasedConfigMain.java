package demo;

import demo.message.Notification;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBasedConfigMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        Notification notification = applicationContext.getBean(Notification.class);
        notification.alert();
    }
}
