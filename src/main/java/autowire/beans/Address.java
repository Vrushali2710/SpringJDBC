package autowire.beans;

public class Address {

    private int houseNo;

    private String City;

    private int pincode;

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        return "house no"+houseNo+"\nCity"+City+"\nPincode"+pincode;
    }
}
