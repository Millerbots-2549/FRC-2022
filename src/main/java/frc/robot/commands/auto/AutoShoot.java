// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoShoot extends CommandBase {
  /** Creates a new AutoShoot. */
  public final int m_case;
  double spin = 0.385;
  double shoot = 0.8;
  public AutoShoot(int which) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_case = which;
    addRequirements(Robot.manip);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {Robot.manip.manipUp();}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    switch(m_case){
      case 0: {Robot.manip.spin(spin); break;}
      case 1: {Robot.manip.spin(spin); Robot.manip.shootStart(shoot); break;}
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) { Robot.manip.spin(0); Robot.manip.shootEnd();}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
