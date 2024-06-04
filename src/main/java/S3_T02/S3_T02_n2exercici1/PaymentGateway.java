package S3_T02.S3_T02_n2exercici1;

import java.util.Random;

public class PaymentGateway {

    public void executePayment(PaymentMethod paymentMethod) {
        System.out.println("Executing payment...");
        System.out.println((new Random().nextBoolean())?
                paymentMethod.successfulPayment():
                paymentMethod.paymentCancelled());
    }

}
