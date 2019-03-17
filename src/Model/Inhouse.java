package Model;

import javafx.beans.property.SimpleIntegerProperty;

public class Inhouse extends Part
{
    private SimpleIntegerProperty machineId;

    public Inhouse()
    {

    }

    public Inhouse (String partName, double partPrice, int partQuantity, int min, int max, int machineId)
    {
        super(partName, partPrice, partQuantity, min, max);

        this.machineId = new SimpleIntegerProperty(machineId);
    }

    public int getMachineId() {
        return machineId.get();
    }

    public SimpleIntegerProperty machineIdProperty() {
        return machineId;
    }

    public void setMachineId(int machineId) {
        this.machineId.set(machineId);
    }
}
