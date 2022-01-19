package frc.robot.subsystems;

import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotContainer;
import frc.robot.commands.DrivePeriodic;


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

    //motors
    private static WPI_TalonSRX driveRFront;
    private static WPI_TalonSRX driveRBack ;
    private static WPI_TalonSRX driveLFront;
    private static WPI_TalonSRX driveLBack ;

    //motor control groups
    private MotorControllerGroup driveRight;
    private MotorControllerGroup driveLeft ;

    //drivetrain object
    public static DifferentialDrive drivetrain;


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
    public DrivetrainSubsystem() {

        driveRFront = new WPI_TalonSRX(Constants.DRIVEFRONTRIGHT);
        driveRBack = new WPI_TalonSRX(Constants.DRIVEBACKRIGHT);
        driveLFront = new WPI_TalonSRX(Constants.DRIVEFRONTLEFT);
        driveLBack = new WPI_TalonSRX(Constants.DRIVEBACKLEFT);

        driveRight = new MotorControllerGroup(driveRFront, driveRBack);
        driveLeft = new MotorControllerGroup(driveLFront, driveLBack);

        drivetrain = new DifferentialDrive(driveLeft, driveRight);


    }

    public static void motorSafety(){
        driveRFront.setSafetyEnabled(true);
        driveRBack.setSafetyEnabled(true);
        driveLFront.setSafetyEnabled(true);
        driveLBack.setSafetyEnabled(true);
    }

    public static void driveTeleop(){
        drivetrain.arcadeDrive(RobotContainer.dCtrl.getLeftX(), RobotContainer.dCtrl.getLeftY());
    }
}

