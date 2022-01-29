package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import frc.robot.RobotContainer;
import frc.robot.commands.DrivePeriodic;


public class DrivetrainSubsystem extends SubsystemBase {

    // With eager singleton initialization, any static variables/fields used in the 
    // constructor must appear before the "INSTANCE" variable so that they are initialized 
    // before the constructor is called when the "INSTANCE" variable initializes.

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

    public DrivetrainSubsystem() {

        driveRFront = new WPI_TalonSRX(Constants.DRIVEFRONTRIGHT);
       driveRBack = new WPI_TalonSRX(Constants.DRIVEBACKRIGHT);
       driveLFront = new WPI_TalonSRX(Constants.DRIVEFRONTLEFT);
       driveLBack = new WPI_TalonSRX(Constants.DRIVEBACKLEFT);

       driveRight = new MotorControllerGroup(driveRFront, driveRBack);
       driveLeft = new MotorControllerGroup(driveLFront, driveLBack);

       drivetrain = new DifferentialDrive(driveLeft, driveRight);
        int j = 1;

    }

    public void motorSafety(){
       driveRFront.setSafetyEnabled(true);
       driveRBack.setSafetyEnabled(true);
       driveLFront.setSafetyEnabled(true);
       driveLBack.setSafetyEnabled(true);
    }

    public void driveTeleop(){
       drivetrain.arcadeDrive(0.7 * RobotContainer.dCtrl.getLeftX(), -0.7 * RobotContainer.dCtrl.getLeftY());
    }
}

