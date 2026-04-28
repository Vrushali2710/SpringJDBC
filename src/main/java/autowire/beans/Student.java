package autowire.beans;

public class Student {

    private int rollNo;

    private String name;

    private Address address;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        System.out.println("address------------->"+address);
        this.address = address;
    }

    public void display() {
        System.out.println("Name"+name);
        System.out.println("Rollno"+rollNo);
        System.out.println("Address"+address);
    }
}
