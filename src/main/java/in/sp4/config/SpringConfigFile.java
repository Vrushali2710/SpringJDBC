package in.sp4.config;

import in.sp4.beans.Address;
import in.sp4.beans.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringConfigFile {
    @Bean
    public Address createAddrObj() {
        Address addr = new Address();
        addr.setCity("Delhi");
        addr.setHouseNo(167);
        addr.setPincode(389350);

        return addr;
    }
    @Bean
    public Address createAddrObj2() {
        Address addr = new Address();
        addr.setCity("Jaipur");
        addr.setHouseNo(168);
        addr.setPincode(389351);

        return addr;
    }
    @Bean
    public Student createStudentObj() {
        Student std = new Student();
        std.setName("Herry");
//        std.setAddress(createAddrObj());
        std.setRollNo(25);
        return std;
    }
}



