package in.sp.main;

import in.sp.beans.Student;
import in.sp.mappers.StudentRowMapper;
import in.sp.resources.SpringConfigFile;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfigFile.class);
        JdbcTemplate template = context.getBean(JdbcTemplate.class);
        int std_id = 101;
        String std_name = "Vrushali";
        float marks = 91.6f;


        String insert_sql_query = "INSERT INTO Student VALUES(?,?,?)";
        int count =  template.update(insert_sql_query, std_id,std_name,marks);
        System.out.println("insertion succes"+count);
        String select_query ="SELECT * from STUDENT";
        List<Student> stdList = template.query(select_query, new StudentRowMapper());
        for(Student std: stdList){
            System.out.println("Name="+std.getName());
            System.out.println("Roll No"+std.getRollNo());
            System.out.println("marks"+std.getMarks());
            System.out.println("--------------------");
        }

        String update_sql_query = "UPDATE Student SET marks=? WHERE id=101";
        int count2 =  template.update(update_sql_query,marks);
        System.out.println("updation success"+ count2);
        String select_query2 ="SELECT * from STUDENT";
        List<Student> stdList2 = template.query(select_query2, new StudentRowMapper());
        for(Student std: stdList2){
            System.out.println("Name="+std.getName());
            System.out.println("Roll No"+std.getRollNo());
            System.out.println("marks"+std.getMarks());
            System.out.println("--------------------");
        }
        String delete_sql_query = "DELETE from STUDENT where id=?";
        int count3 =  template.update(delete_sql_query, std_id);
        System.out.println("deletion succes"+ count2);
        String select_query3 ="SELECT * from STUDENT";
        List<Student> stdList3 = template.query(select_query2, new StudentRowMapper());
        for(Student std: stdList3){
            System.out.println("Name="+std.getName());
            System.out.println("Roll No"+std.getRollNo());
            System.out.println("marks"+std.getMarks());
            System.out.println("--------------------");
        }

    }
}
