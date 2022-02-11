// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class ClimbSubsystem extends SubsystemBase {

  private WPI_VictorSPX climbExtend;
  private WPI_TalonSRX climbSpin;

  private DoubleSolenoid climbPiston;

  public ClimbSubsystem() {
    climbExtend = new WPI_VictorSPX(Constants.CLIMBVICTOR);
    climbSpin = new WPI_TalonSRX(Constants.CLIMBTALON);
    
    climbPiston = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.CLIMBNOIDOUT, Constants.CLIMBNOIDIN);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void extendMotor(double speed){
    climbExtend.set(speed);
  }

  public void extendMotorStop(){
    climbExtend.set(0);
  }

  public void climbExec(double speed){
    climbSpin.set(speed);
  }

  public void climbEnd() {
    climbSpin.set(0);
  }

  public void climbExtendPiston(){
    climbPiston.set(Value.kForward);
  }

  public void climbRetractPiston(){
    climbPiston.set(Value.kReverse);
  }
  
  public void climbPistonOff(){
    climbPiston.set(Value.kOff);
  }
}
