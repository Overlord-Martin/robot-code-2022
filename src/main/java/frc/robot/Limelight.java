package frc.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {
    boolean ledStatus = true, driveCamMode = false;
    public NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

    public Limelight() {

    }

    /**
     * Toggles limelight’s operation mode (Vision Processor/Driver Camera)
     */
    public void toggleCamMode() {
        table.getEntry("camMode").setNumber(driveCamMode ? 1 : 0);
        driveCamMode = !driveCamMode;
        System.out.println("Cam Mode Toggled");
    }

    /**
     * Toggles limelight’s led mode (On/Off)
     */
    public void toggleLED() {
        table.getEntry("ledMode").setNumber(ledStatus ? 3 : 1);
        ledStatus = !ledStatus;
        System.out.println("LED Toggled");
    }
}
