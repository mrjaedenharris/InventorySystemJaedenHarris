package Model;

import javafx.beans.property.SimpleIntegerProperty;

public class Inhouse extends Part
{
    private SimpleIntegerProperty machineId;

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
