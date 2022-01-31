package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class ManipulatorCommand extends CommandBase {
  /** Creates a new ManipulatorCommand. */
  boolean toggle;
  public ManipulatorCommand() {
    addRequirements(Robot.manip);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    SmartDashboard.putBoolean("isrunning", false);
    Robot.manip.motorSafety();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    //Toggles the A button by checking boolean "toggle"
    if(RobotContainer.dCtrl.getAButtonPressed() && toggle) {toggle = false;}
    else if(RobotContainer.dCtrl.getAButtonPressed() && toggle == false) {toggle = true;}

    SmartDashboard.putBoolean("A Toggle Check", toggle);

    // if(j == 1){Robot.manip.extend();}
    // else{Robot.manip.release();}


    double both = RobotContainer.dCtrl.getLeftTriggerAxis()-RobotContainer.dCtrl.getRightTriggerAxis();
    Robot.manip.shoot(both);

  }



  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
