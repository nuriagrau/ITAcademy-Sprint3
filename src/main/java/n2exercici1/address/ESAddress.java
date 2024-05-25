package n2exercici1.address;

public class ESAddress implements IAddress{
    private String street;
    private String streetNumber;
    private String floorNumber;
    private String doorNumber;
    private String cityTown;
    private String province;
    private String postCode;


    public ESAddress(String street, String streetNumber, String floorNumber, String doorNumber, String cityTown, String province, String postCode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.floorNumber = floorNumber;
        this.doorNumber = doorNumber;
        this.cityTown = cityTown;
        this.province = province;
        this.postCode = postCode;
    }

    @Override
    public String showAddress() {
        return (
                "Address     |    " + this.street + " " +this.streetNumber + " " + this.floorNumber + " " + this.doorNumber + "\n" +
                        "            |    " + this.postCode + " " + this.cityTown + "\n" +
                        "            |    " + this.province + " (SPAIN)\n");
    }
}
