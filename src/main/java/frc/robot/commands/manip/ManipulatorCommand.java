package frc.robot.commands.manip;

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

    SmartDashboard.putBoolean("A Toggle Check", toggle);

    double both = RobotContainer.dCtrl.getLeftTriggerAxis()-RobotContainer.dCtrl.getRightTriggerAxis();
    Robot.manip.spin(0.8*Math.pow(both, 3));

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