package S3_T02.S3_T02_n2exercici1;

import java.util.ArrayList;
import java.util.List;

public class ShoeShop {
    private final List<Shoe> stock = new ArrayList<>();

    private PaymentGateway paymentGateway = new PaymentGateway();

    public List<Shoe> getStock() {
        return stock;
    }



    public void buyShoes(PaymentMethod paymentMethod) {
        paymentGateway.executePayment(paymentMethod);
    }



}
