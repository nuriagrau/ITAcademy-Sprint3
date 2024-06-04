package S3_T02.S3_T02_n2exercici1;

public class Payment {

    private String paymentMethod;

    private String paymentMethodId;

    private double amount;

    public Payment(String paymentMethod, String paymentMethodId, double amount) {
        this.paymentMethod = paymentMethod;
        this.paymentMethodId = paymentMethodId;
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(String paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
