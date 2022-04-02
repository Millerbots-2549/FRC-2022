package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import frc.robot.RobotContainer;


public class DrivetrainSubsystem extends SubsystemBase {

    //motorcontrollers
    private static WPI_TalonSRX driveRFront, driveRBack, driveLFront, driveLBack;

    //motor control groups
    private MotorControllerGroup driveRight, driveLeft;

    //drivetrain object
    public static DifferentialDrive drivetrain;

    public DrivetrainSubsystem() {

      //initializing all drivetrain objects
       driveRFront = new WPI_TalonSRX(Constants.DRIVEFRONTRIGHT);
       driveRBack = new WPI_TalonSRX(Constants.DRIVEBACKRIGHT);
       driveLFront = new WPI_TalonSRX(Constants.DRIVEFRONTLEFT);
       driveLBack = new WPI_TalonSRX(Constants.DRIVEBACKLEFT);

       driveRight = new MotorControllerGroup(driveRFront, driveRBack);
       driveLeft = new MotorControllerGroup(driveLFront, driveLBack);

       drivetrain = new DifferentialDrive(driveLeft, driveRight);

      }
      
    public void motorSafety(){
       driveRFront.setSafetyEnabled(true);
       driveRBack.setSafetyEnabled(true);
       driveLFront.setSafetyEnabled(true);
       driveLBack.setSafetyEnabled(true);

    }

    public void driveTeleop(){
      if(RobotContainer.dCtrl.getRightTriggerAxis() > .3) {
        drivetrain.arcadeDrive(RobotContainer.dCtrl.getLeftX() * 0.7, -RobotContainer.dCtrl.getLeftY() * 0.7);
      }
      else{
        drivetrain.arcadeDrive(RobotContainer.dCtrl.getLeftX() * 0.9, -RobotContainer.dCtrl.getLeftY() * 0.9);
      }
    }

    public void driveTimed(double speed,double rotation){
      drivetrain.tankDrive(-speed, speed);
    }
}

