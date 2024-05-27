package n3exercici1.Commands;

import n3exercici1.Vehicles.Vehicle;

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
