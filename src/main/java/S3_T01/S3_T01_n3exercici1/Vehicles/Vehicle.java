package S3_T01.S3_T01_n3exercici1.Vehicles;

public class Vehicle {

    private String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public void start(){
        System.out.println("Starting the " + name);
    }

    public void brake() {
        System.out.println("The " + name + " is braking.");
    }

    public void accelerate() {
        System.out.println("Accelerating the " + name);
    }
}
