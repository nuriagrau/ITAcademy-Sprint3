package n2exercici1;

import n2exercici1.address.IAddress;
import n2exercici1.phoneNumber.IPhoneNumber;

public class Contact implements Comparable {

    private String name;

    private String country;

    private IPhoneNumber phoneNumber;

    private IAddress address;


    public Contact(String name, String country, IAddress address, IPhoneNumber phoneNumber) {
        this.name = name;
        this.country = country;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getCountry() {
        return this.country;
    }

    public IPhoneNumber getPhoneNumber() {
        return this.phoneNumber;
    }

    public IAddress getAddress() {
        return this.address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPhoneNumber(IPhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(IAddress address) {
        this.address = address;
    }

    @Override
    public int compareTo(Object o) {
        Contact other = (Contact) o;
        if (this.getCountry().equalsIgnoreCase(other.getCountry())) {
            return this.getName().compareTo(other.getName());
        } else{
            return this.getCountry().compareTo(other.getCountry());
        }
    }

    public String toString() {
        return (
                "------------------------------------------------------------------------------------\n" +
                "Name        |    " + this.name + "\n"
                + this.address.showAddress()
                + this.phoneNumber.showPhoneNumber() +
                "------------------------------------------------------------------------------------");
    }
}
