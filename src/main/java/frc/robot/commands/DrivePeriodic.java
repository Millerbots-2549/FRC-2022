package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class DrivePeriodic extends CommandBase {


    public DrivePeriodic() {
        //requires drivetrain
        addRequirements(Robot.drive);
    }

    @Override
    public void initialize() {
        //runs motor safety method for drive Talons
       Robot.drive.motorSafety();
    }

    @Override
    public void execute() {
        //runs DrivetrainSubsystem method "driveTeleop" during cmd --> Robot always looking for drive input
       Robot.drive.driveTeleop();
    }

    @Override
    public boolean isFinished() {return false;}

    @Override
    public void end(boolean interrupted) {

    }
}
