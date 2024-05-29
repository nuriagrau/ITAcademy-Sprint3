package S3_T01.S3_T01_n3exercici1.Commands;

import S3_T01.S3_T01_n3exercici1.Vehicles.Vehicle;

public class StartVehicleCommand implements VehicleCommand {

    private Vehicle vehicle;

    public StartVehicleCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute(){
        vehicle.start();
    }
}
