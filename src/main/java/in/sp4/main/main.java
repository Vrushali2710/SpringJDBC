package in.sp4.main;

import in.sp4.beans.Student;
import in.sp4.config.SpringConfigFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
        Student std = context.getBean(Student.class);
        std.display();

    }
}
