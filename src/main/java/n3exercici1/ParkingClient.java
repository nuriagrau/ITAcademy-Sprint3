package n3exercici1;

import n3exercici1.Commands.AccelarateVehicleCommand;
import n3exercici1.Commands.BrakeVehicleCommand;
import n3exercici1.Commands.StartVehicleCommand;
import n3exercici1.Invoker.VehicleCommandInvoker;
import n3exercici1.Vehicles.Ship;
import n3exercici1.Vehicles.Vehicle;

public class ParkingClient {

    public static void main(String[] args) {

        VehicleCommandInvoker vehicleCommandInvoker = new VehicleCommandInvoker();
        Vehicle car = new Vehicle("car");
        vehicleCommandInvoker.addCommand(new StartVehicleCommand(car));
        vehicleCommandInvoker.addCommand(new AccelarateVehicleCommand(car));
        vehicleCommandInvoker.addCommand(new BrakeVehicleCommand(car));
        vehicleCommandInvoker.executeCommand();

        vehicleCommandInvoker.addCommand(new StartVehicleCommand(new Vehicle("bicycle")));
        vehicleCommandInvoker.addCommand(new AccelarateVehicleCommand(new Vehicle("bicycle")));
        vehicleCommandInvoker.addCommand(new BrakeVehicleCommand(new Vehicle("bicycle")));
        vehicleCommandInvoker.executeCommand();

        VehicleCommandInvoker planeCommandInvoker = new VehicleCommandInvoker();
        Vehicle plane = new Vehicle("plane");
        planeCommandInvoker.addCommand(new StartVehicleCommand(plane));
        planeCommandInvoker.addCommand(new AccelarateVehicleCommand(plane));
        planeCommandInvoker.addCommand(new BrakeVehicleCommand(plane));
        vehicleCommandInvoker.executeCommand();

        Ship ship = new Ship("ship");
        vehicleCommandInvoker.addCommand(new StartVehicleCommand(ship));
        vehicleCommandInvoker.addCommand(new AccelarateVehicleCommand(ship));
        vehicleCommandInvoker.addCommand(new BrakeVehicleCommand(ship));
        vehicleCommandInvoker.executeCommand();


    }
}
