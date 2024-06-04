package S3_T02.S3_T02_n2exercici1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class app {
    static Scanner scanner = new Scanner(System.in);
    static ShoeShop shoeShop = new ShoeShop();
    static ArrayList<Shoe> basket = new ArrayList<>();

    static {
        shoeShop.getStock().add(new Shoe("Samba", "Adidas", 69.90));
        shoeShop.getStock().add(new Shoe("Stan Smith", "Adidas", 64.95));
        shoeShop.getStock().add(new Shoe("Camp", "Camper", 125.95));
    }
    public static void menuDisplay() {

        int option = 0;
        String message = null;
        do {
            option = inputInt("""
                    Select an option:
                    0. Exit
                    1. Select shoes
                    2. Pay
                    """);
            switch (option) {
                case 0:
                    message = "Hej Hej";
                    break;
                case 1:
                    basket = selectShoes(basket);
                    break;
                case 2:
                    if (!basket.isEmpty()) {
                        message = payBasket(basket);
                    } else {
                        message= "The basket is empty. There must be some items in the basket to pay.";
                    }
                    break;
            }
            System.out.println(message);
        } while (option != 0);
    }

    private static String payBasket(ArrayList<Shoe> basket) {
        String message = "", paymentMethodId;
        double amount = 0d;
        int paymentMethodOption;
        if (!basket.isEmpty()) {
            for (Shoe shoe : basket) {
                amount += shoe.getPrice();
            }
            do {
                paymentMethodOption = inputInt("""
                        Select the payment method option:
                        0. Exit
                        1. Bank Account
                        2. Credit Card
                        3. PayPal
                        """);
                switch (paymentMethodOption) {
                    case 0:
                        message = "The items will be kept in the basket for future payment.";
                        break;
                    case 1:
                        paymentMethodId = inputString("Enter your IBAN number: ");
                        shoeShop.buyShoes(new BankAccountPayment(paymentMethodId, amount));
                        break;
                    case 2:
                        paymentMethodId = inputString("Enter your credit card number: ");
                        shoeShop.buyShoes(new CreditCardPayment(paymentMethodId, amount) );
                        break;
                    case 3:
                        paymentMethodId = inputString("Enter your PayPal account name: ");
                        shoeShop.buyShoes(new PayPalPayment(paymentMethodId, amount));
                        break;
                }
            } while (paymentMethodOption <= 0 || paymentMethodOption > 3);
        } else message = "Your basket is empty.";
        return message;
    }

    private static ArrayList<Shoe> selectShoes(ArrayList<Shoe> basket) {
        String model, reply;
        boolean keepBuying = false;
        int shoeIndex = -1;
        do {
            System.out.println(showShoes());
            model = inputString("Enter the model you want to buy: ");
            shoeIndex = shoeIndex(model);
            if (shoeIndex != -1) {
                basket.add(shoeShop.getStock().get(shoeIndex));
            } else {
                System.out.println("This model does not exist.");
            }
            reply = inputString("Do you want to add more shoes in the basket (Y/N) ? ");
            if (reply.equalsIgnoreCase("Y")) {
               keepBuying = true;
            } else if ( reply.equalsIgnoreCase("N")) {
               keepBuying = false;
            } else {
                System.out.println("Answer must be Y or N.");
            }
        } while (keepBuying);
        if (!basket.isEmpty()) {
            System.out.println("Your order is in the basket.");
        } else {
            System.out.println("Your basket is empty.");
        }
        return basket;
    }

    public static int shoeIndex(String model) {
        int index =  -1;
        for (int i = 0; i < shoeShop.getStock().size() ; i++) {
            if (shoeShop.getStock().get(i).getModel().equalsIgnoreCase(model)) {
                index = i;
            }
        }
        return index;
    }

    public static int inputInt(String request){
        int input = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.println(request);
            try {
                input =  scanner.nextInt();
                isValid = true;
            } catch(InputMismatchException e) {
                System.err.println("Format Error. Please enter a valid integer.");
            } finally {
                scanner.nextLine();
            }
        }
        return input;
    }

    public static String inputString(String missatge){
        boolean isValid  = false;
        String userInput = "";
        do {
            try {
                System.out.println(missatge);
                userInput = scanner.nextLine();
                isValid = true;
            } catch (Exception e) {
                System.out.println("Format Error. Introduce a String.");
            }
        } while (!isValid);
        return userInput;
    }

    public static String showShoes() {
        String shoesStock = "";
        if (!shoeShop.getStock().isEmpty()) {
            for (Shoe shoe: shoeShop.getStock()) {
                shoesStock = shoesStock + shoe.toString() + "\n";
            }
        } else {
            shoesStock = "There are no shoes in the shop.";
        }
        return shoesStock;
    }

}
