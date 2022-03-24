// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.climb.ClimbPiston;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class ClimbSubsystem extends SubsystemBase {

  private WPI_VictorSPX climbExtend;
  private WPI_TalonSRX climbRetract;
  private WPI_VictorSPX climbSpin;

  private DoubleSolenoid climbPiston, climbPistonTwo;

  public ClimbSubsystem() {
    climbExtend = new WPI_VictorSPX(Constants.CLIMBEXTENDER);
    climbRetract = new WPI_TalonSRX(Constants.CLIMBRETRACTOR);
    climbSpin = new WPI_VictorSPX(Constants.CLIMBVCTOR);
    
    // climbPiston = new DoubleSolenoid(0, PneumaticsModuleType.CTREPCM, Constants.CLIMBNOIDOUT, Constants.CLIMBNOIDIN);
    // climbPistonTwo = new DoubleSolenoid(1, PneumaticsModuleType.CTREPCM, Constants.CLIMBNOIDTWOOUT,Constants.CLIMBNOIDTWOIN);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void extend(double speed){
    climbExtend.set(speed);
  }

  public void retract(double speed){
    climbRetract.set(speed);
  }

  public void climbSpinFwd(){
    climbSpin.set(-1);
  }
  public void climbSpinBck(){
    climbSpin.set(1);
  }
  public void climbEnd() {
    climbSpin.set(0);
  }

  public void climbExtendPiston(int choose){
    switch (choose) {
      case 1: climbPiston.set(Value.kForward);
      case 2: climbPistonTwo.set(Value.kForward);
    }
  }

  public void climbRetractPiston(int choose){
    switch (choose) {
      case 1: climbPiston.set(Value.kReverse);
      case 2: climbPistonTwo.set(Value.kReverse);
    }
  }
  
  public void climbPistonOff(int choose){
    switch (choose) {
      case 1: climbPiston.set(Value.kOff);
      case 2: climbPistonTwo.set(Value.kOff);
    }
  }
}
