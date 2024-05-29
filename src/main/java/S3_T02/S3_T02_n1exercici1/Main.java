package S3_T02.S3_T02_n1exercici1;

public class Main {
    // TODO Design a system in which a Stock Exchange Agent (Observable) notifies various Stock Exchange agencies (Observers) of changes when the Stock Exchange goes up or down.

    public static void main(String[] args) {

        Stock GOOGStock = new Stock("GOOG");
        Stock AMZNStock = new Stock("AMZN");

        StockExchange nasdaq = new StockExchange("Nasdaq");
        StockExchange euronet = new StockExchange("Euronet");


        GOOGStock.setStock(178.02);
        AMZNStock.setStock(182.15);

        GOOGStock.subscribe(nasdaq);
        AMZNStock.subscribe(nasdaq);

        GOOGStock.subscribe(euronet);
        AMZNStock.subscribe(euronet);


        AMZNStock.unsubscribe(nasdaq);
        GOOGStock.setStock(180.02);

        AMZNStock.setStock(185.15);

        GOOGStock.setStock(179.02);

        System.out.println("GOOG subscribers are : ");
        GOOGStock.showSubscribers();

        System.out.println("AMZN subscribers are : ");
        AMZNStock.showSubscribers();

    }

}
