package frc.robot;

//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class ControlStick extends XboxController {
    
    public ControlStick(int port) {
        super(port);
    }

    /**
     * Read the value of a button on the joystick.
     * @param button The button number to be read (starting at 1)
     * @return true if Pressed, false if Released
     */
    public boolean getButton(int button) {
        return getRawButton(button) && getRawButtonReleased(button);
    }
}
