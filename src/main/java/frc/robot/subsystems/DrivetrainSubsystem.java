package frc.robot.subsystems;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {

    // With eager singleton initialization, any static variables/fields used in the 
    // constructor must appear before the "INSTANCE" variable so that they are initialized 
    // before the constructor is called when the "INSTANCE" variable initializes.

    /**
     * The Singleton instance of this DrivetrainSubsystem. Code should use
     * the {@link #getInstance()} method to get the single instance (rather
     * than trying to construct an instance of this class.)
     */
    private final static DrivetrainSubsystem INSTANCE = new DrivetrainSubsystem();

    /**
     * Returns the Singleton instance of this DrivetrainSubsystem. This static method
     * should be used, rather than the constructor, to get the single instance
     * of this class. For example: {@code DrivetrainSubsystem.getInstance();}
     */
    @SuppressWarnings("WeakerAccess")
    public static DrivetrainSubsystem getInstance() {
        return INSTANCE;
    }

    /**
     * Creates a new instance of this DrivetrainSubsystem. This constructor
     * is private since this class is a Singleton. Code should use
     * the {@link #getInstance()} method to get the singleton instance.
     */
    private DrivetrainSubsystem() {

    }
}

