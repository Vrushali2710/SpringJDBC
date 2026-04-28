package autowireconst.main;

import autowireconst.beans.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");

        Student std = (Student) context.getBean("stdId2");
        std.display();

    }


}
