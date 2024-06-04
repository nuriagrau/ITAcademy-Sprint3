package S3_T02.S3_T02_n2exercici1;

public class BankAccountPayment implements PaymentMethod{

    private String IBAN;

    private double amount;


    public BankAccountPayment(String IBAN, double amount) {
        this.IBAN = IBAN;
        this.amount = amount;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String successfulPayment() {
        return "The payment of " + this.amount + " € has been deducted from account no. " + this.IBAN;
    }

    @Override
    public String paymentCancelled() {
        return "The bank account does not have enough funds.";
    }
}
