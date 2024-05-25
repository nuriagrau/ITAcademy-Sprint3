package n2exercici1.phoneNumber;

public class UKPhoneNumber implements IPhoneNumber{
    private final String PREFIX = "(+44)";

    private String phoneNumber;

    public UKPhoneNumber(String phoneNumber ) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String showPhoneNumber() {
        return ("Telephone   |    " + this.PREFIX + " " + this.phoneNumber + "\n");
    }
}
