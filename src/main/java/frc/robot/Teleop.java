package frc.robot;

public class Teleop extends Autonomous {

    boolean babyMode = false, twoHanded = true;
    int driveInverted = 1;

    /**
     * This function is called at the beginning of teleop.
     */
    @Override
    public void teleopInit() {
        System.out.println("Teleop started");
    }

    /**
     * This function is called periodically during teleop.
     */
    @Override
    public void teleopPeriodic() {
        if (driveController.getButton("a")) {
            driveInverted = 1;
        } else if (driveController.getButton("b")) {
            driveInverted = -1;
        }

        // please work
        double driveFastSpeed = Robot.driveFastSpeed * driveInverted;
        double driveMediumSpeed = Robot.driveMediumSpeed * driveInverted;
        double driveSlowSpeed = Robot.driveSlowSpeed * driveInverted;

        if (driveController.getBumper("right")) {
            setDriveMotors(driveController.getLeftY() * driveFastSpeed, driveController.getRightY() * driveFastSpeed);
        } else if (driveController.getBumper("left")) {
            setDriveMotors(driveController.getLeftY() * driveSlowSpeed, driveController.getRightY() * driveSlowSpeed);
        } else {
            setDriveMotors(driveController.getLeftY() * driveMediumSpeed,
                    driveController.getRightY() * driveMediumSpeed);
        }

        // Hold a/b buttons to intake/shoot with intake motor
        // Hold right bumper to reverse
        if (otherController.getButton("a")) {
            intakeMotor.setSpeed(-intakeNormalSpeed);
        } else if (otherController.getButton("b")) {
            intakeMotor.setSpeed(-intakeShootSpeed);
        } else if (otherController.getBumper("right")) {
            intakeMotor.setSpeed(intakeNormalSpeed);
        } else {
            intakeMotor.setSpeed(0);
        }

        // Hold left bumper + x button to rev climb motor
        // Hold with rstick to invert motor
        if (otherController.getBumper("left") && otherController.getButton("x") && otherController.getButton("rstick")) {
            climbMotor.setSpeed(-climbSpeed);
        } else if (otherController.getBumper("left") && otherController.getButton("x")) {
            climbMotor.setSpeed(climbSpeed);
        } else {
            climbMotor.setSpeed(0);
        }

        // Press Start on Xbox to toggle limelight
        if (otherController.getButton("start")) {
            limelight.toggleCamMode();
            limelight.toggleLED();
        } else {

        }

        // Press Back on Xbox to shoot ball
        if (otherController.getButton("back")) {
            twoHanded = !twoHanded;
            System.out.println("Two Handed Toggled");
        } else {

        }
    }
}
