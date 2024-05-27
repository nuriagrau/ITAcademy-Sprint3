package n3exercici1.Commands;

import n3exercici1.Vehicles.Vehicle;

public class AccelarateVehicleCommand implements VehicleCommand {

    private Vehicle vehicle;

    public AccelarateVehicleCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute(){
        vehicle.accelerate();
    }
}
