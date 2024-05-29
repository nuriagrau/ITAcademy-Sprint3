package S3_T01.S3_T01_n2exercici1.phoneNumber;

public class DKPhoneNumber implements IPhoneNumber {
    private final String PREFIX = "(+45)";

    private String phoneNumber;

    public DKPhoneNumber(String phoneNumber ) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String showPhoneNumber() {
        return ("Telephone   |    " + this.PREFIX + " " + this.phoneNumber + "\n");
    }
}
