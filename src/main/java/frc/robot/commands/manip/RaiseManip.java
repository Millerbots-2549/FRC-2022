// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.manip;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class RaiseManip extends CommandBase {
  public RaiseManip() {
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (Robot.manip.getManipUp() != DoubleSolenoid.Value.kReverse) {
      Robot.manip.manipUp();
    }
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {} 

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) { Robot.manip.manipDown();  SmartDashboard.putString("manipulator down", "WE shit"); }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
