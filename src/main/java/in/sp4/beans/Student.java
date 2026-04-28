package in.sp4.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Student {

    private String name;
    private int rollNo;
    @Autowired  // no need to manually set Address provides dependency injection and loose coupling

    @Qualifier("createAddrObj2")  // ifthere are multiple beans then which bean is being used
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }



    public void display() {
        System.out.println("Name: "+name + "Roll No"+ rollNo + "Address:"+address);
    }
}
