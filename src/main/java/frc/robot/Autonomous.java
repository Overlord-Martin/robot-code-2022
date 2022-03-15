package frc.robot;

class Autonomous extends Robot {

    int sec = 50; // amount of ticks in a second
    int tick; // tick counter

    /**
     * A detect whether an autonomous code sequence can run based on a tick interval
     */
    class PeriodicSequence {
        public int startTick; // which tick to start running
        public int lifespan; // amount of ticks to run after startTick

        public PeriodicSequence(int startTick, int lifespan) { // class constructor
            this.startTick = startTick;
            this.lifespan = lifespan;
        }

        public boolean canRun() { // run condition (based on startTick and lifespan)
            return tick >= startTick && tick < startTick + lifespan;
        }
    }

    PeriodicSequence startSequence = new PeriodicSequence(0, sec); // start sequence
    PeriodicSequence retreatSequence = new PeriodicSequence(sec * 3, sec * 3); // get out of there
    PeriodicSequence endSequence = new PeriodicSequence(sec * 6, 1);

    /**
     * This function is called at the beginning of autonomous.
     */
    @Override
    public void autonomousInit() {
        tick = 0; // reset tick counter
        System.out.println("Autonomous started");
    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
        if (startSequence.canRun()) {
            intakeMotor.setSpeed(-intakeShootSpeed);
        }

        if (retreatSequence.canRun()) {
            intakeMotor.setSpeed(0);
            setDriveMotors(-driveSlowSpeed, -driveSlowSpeed);
        }

        if (endSequence.canRun()) {
            setDriveMotors(0, 0);
        }

        tick++; // advance tick counter
    }
}
