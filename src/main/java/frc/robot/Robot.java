/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

    public static Motor leftMotors, rightMotors, leftBackMotor, rightBackMotor, intakeMotor, climbMotor;
    
    // defines the voltage output for the motor controllers
    // based on a 12V system
    static double driveSlowSpeed = 0.3;
    static double driveMediumSpeed = 0.5;
    static double driveFastSpeed = 0.8;

    static double intakeNormalSpeed = 0.5;
    static double intakeShootSpeed = 1;

    static double climbSpeed = 1;

    public static ControlStick leftStick, rightStick;
    public static Limelight limelight = new Limelight();
    public static Controller driveController, otherController;

    int count = 0;

    /**
     * Set the speed of both drive motor sides
     * 
     * @param left  Speed to set leftMotors. Double between -1.0 and 1.0, with 0.0
     *              as stopped.
     * @param right Speed to set rightMotors. Double between -1.0 and 1.0, with 0.0
     *              as stopped.
     */
    public static void setDriveMotors(double left, double right) {
        leftMotors.setSpeed(left);
        rightMotors.setSpeed(-right);
    }

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     * <p>
     * Instantiate our {@link RobotContainer}. This will perform all our button
     * bindings, and put our autonomous chooser on the dashboard.
     */
    @Override
    public void robotInit() {
        leftMotors = new Motor(2);
        leftBackMotor = new Motor(3);
        rightMotors = new Motor(4);
        rightBackMotor = new Motor(5);
        intakeMotor = new Motor(6);
        climbMotor = new Motor(7);

        leftBackMotor.follow(leftMotors);
        rightBackMotor.follow(rightMotors);

        driveController = new Controller(0);
        otherController = new Controller(1);

        limelight.table.getEntry("ledMode").setNumber(3);
    }

    /**
     * This function is called every robot packet, no matter the mode. Use this for
     * items like diagnostics that you want ran during disabled, autonomous,
     * teleoperated and test.
     *
     * <p>
     * This runs after the mode specific periodic functions, but before LiveWindow
     * and SmartDashboard integrated updating.
     * <p>
     * Runs the Scheduler. This is responsible for polling buttons, adding
     * newly-scheduled commands, running already-scheduled commands, removing
     * finished or interrupted commands, and running subsystem periodic() methods.
     * This must be called from the robot's periodic block in order for anything in
     * the Command-based framework to work.
     */
    @Override
    public void robotPeriodic() {
        CommandScheduler.getInstance().run();
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     */
    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
    }

    @Override
    public void testInit() {
        CommandScheduler.getInstance().cancelAll();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    }
}
