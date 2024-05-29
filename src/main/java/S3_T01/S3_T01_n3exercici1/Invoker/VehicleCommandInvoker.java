package S3_T01.S3_T01_n3exercici1.Invoker;

import S3_T01.S3_T01_n3exercici1.Commands.VehicleCommand;

import java.util.ArrayList;
import java.util.List;

public class VehicleCommandInvoker {
    private final List<VehicleCommand> vehicleCommandList = new ArrayList<>();

    public void executeCommand() {
         vehicleCommandList.forEach(VehicleCommand::execute);
         vehicleCommandList.clear();

    }

    public void addCommand(VehicleCommand vehicleCommand) {
        vehicleCommandList.add(vehicleCommand);
    }


}
