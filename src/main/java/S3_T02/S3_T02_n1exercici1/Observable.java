package S3_T02.S3_T02_n1exercici1;

public interface Observable {

    void subscribe(Observer observer);

    void unsubscribe(Observer observer);

    void update(String message);

}
