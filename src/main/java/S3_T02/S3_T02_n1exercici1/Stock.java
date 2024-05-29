package S3_T02.S3_T02_n1exercici1;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Observable {
    private double stock;
    private String symbol;

    public Stock(String symbol) {
        this.symbol = symbol;
    }

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        this.observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        this.observers.remove(observer);
    }

    public void setStock(Double stock) {
        String message = symbol + " price is still " + stock;
        if (stock > this.stock) {
            message = symbol + " price is climbing to " + stock;
        } else if (stock < this.stock) {
            message = symbol + " price has drop to " + stock;
        }
        this.stock = stock;
        update(message);
    }

    @Override
    public void update(String message) {
        for (Observer observer : this.observers) {
            String name = observer.update(this.stock);
            System.out.println("Hey " + name + ", " +  message);
        }
    }

    public void showSubscribers() {
        observers.stream()
                .map(observer -> (StockExchange) observer)
                .map(o -> o.getName()).toList()
                .forEach(System.out::println);
    }
}
