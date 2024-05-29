package S3_T01.S3_T01_n2exercici1.address;

public class UKAddress implements IAddress{
    private String street;
    private String streetNumber;
    private String floorNumber;
    private String doorNumber;
    private String cityTown;
    private String province;
    private String postCode;


    public UKAddress(String street, String streetNumber, String floorNumber, String doorNumber, String cityTown, String province, String postCode) {
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
                "Address     |    "  + this.streetNumber + " " + this.street + " " + this.floorNumber + " " + this.doorNumber + "\n" +
                        "            |    " + this.cityTown + " " + this.province + " " + this.postCode + "\n" +
                        "            |    " + "UNITED KINGDOM\n");
    }
}
