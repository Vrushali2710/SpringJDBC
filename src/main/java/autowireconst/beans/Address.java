package autowireconst.beans;

public class Address {


    private int houseNo;

    private String City;

    private int pincode;

    public Address(int houseNo, String city, int pincode) {
        this.houseNo = houseNo;
        this.City = city;
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "house no"+houseNo+"\nCity"+City+"\nPincode"+pincode;
    }
}
