package S3_T02.S3_T02_n1exercici1;

public class StockExchange implements Observer {
    private double stock;

    private String name;

    public StockExchange(String name) {
        this.name = name;
    }

    public double getStock() {
        return this.stock;
    }

    public String getName() {
        return name;
    }

    public void setStock(double stock) {
        this.stock = stock;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String update(Object stock) {
        this.setStock((double) stock);
        return this.name;
    }
}
