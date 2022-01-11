package frc.robot.subsystems;


import edu.wpi.first.wpilibj.SpeedControllerGroup;
import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


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

    private static final WPI_TalonSRX driveRFront = new WPI_TalonSRX(Constants.DRIVEFRONTRIGHT);
    private static final WPI_TalonSRX driveRBack = new WPI_TalonSRX(Constants.DRIVEBACKRIGHT);
    private static final WPI_TalonSRX driveLFront = new WPI_TalonSRX(Constants.DRIVEFRONTLEFT);
    private static final WPI_TalonSRX driveLBack = new WPI_TalonSRX(Constants.DRIVEBACKLEFT);

    private static final MotorControllerGroup driveRight = new MotorControllerGroup(driveRFront, driveRBack);
    private static final MotorControllerGroup driveLeft = new MotorControllerGroup(driveLFront, driveLBack);

    private static final DifferentialDrive drive = new DifferentialDrive(driveLeft, driveRight);
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

