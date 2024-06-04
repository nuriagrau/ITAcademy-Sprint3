package S3_T02.S3_T02_n2exercici1;

public class CreditCardPayment implements PaymentMethod {

    private String cardNumber;

    private double amount;

    public CreditCardPayment(String cardNumber, double amount) {
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String successfulPayment() {
        return "The payment of " + amount + " €, has been charged to credit card no. " + cardNumber;
    }

    @Override
    public String paymentCancelled() {
        return "Credit card no. " + cardNumber + " does not have enough credit.";
    }
}
