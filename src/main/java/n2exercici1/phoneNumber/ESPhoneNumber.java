package n2exercici1.phoneNumber;

public class ESPhoneNumber implements IPhoneNumber{
    private final String PREFIX = "(+34)";

    private String phoneNumber;

    public ESPhoneNumber(String phoneNumber ) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String showPhoneNumber() {
        return ("Telephone   |    " + this.PREFIX + " " + this.phoneNumber + "\n");
    }
}
