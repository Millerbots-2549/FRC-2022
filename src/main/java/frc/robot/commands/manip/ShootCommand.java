// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.manip;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;

public class ShootCommand extends CommandBase {
  /** Creates a new ShootCommand. */
  public ShootCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.manip.shootStart(1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {Robot.manip.shootEnd();}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
