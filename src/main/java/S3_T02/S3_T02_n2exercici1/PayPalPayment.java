package S3_T02.S3_T02_n2exercici1;

public class PayPalPayment implements PaymentMethod{

    private String accountName;

    private double amount;

    public PayPalPayment(String accountName, double amount) {
        this.accountName = accountName;
        this.amount = amount;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String successfulPayment() {
        return "PayPal payment to account " + accountName + " of " + amount + " € has been executed correctly.";
    }

    @Override
    public String paymentCancelled() {
        return "There is something wrong with PayPal account " + accountName;
    }
}
