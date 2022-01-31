// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class ManipulatorSubsystem extends SubsystemBase {

  private DoubleSolenoid doubleSolenoid;
  private Solenoid solenoid;
  
  public WPI_TalonSRX spinTop;
  private WPI_TalonSRX spinBot;
  
  public ManipulatorSubsystem() {

    //noid objects
    doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.DOUBLENOIDFRNT, Constants.DOUBLENOIDBACK);
    solenoid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.SINGLENOID);

    //shooter motors
    spinTop = new WPI_TalonSRX(Constants.TOPMANIP);
    spinBot = new WPI_TalonSRX(Constants.BOTMANIP);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void extend() {
    solenoid.set(true);
    doubleSolenoid.set(Value.kForward);
  }

  public void release(){
    doubleSolenoid.set(Value.kOff);
    solenoid.set(false);
  }

  public void shoot(double speed){
    spinTop.set(speed);
    spinBot.set(speed);
  }


  public void motorSafety(){
    spinTop.setSafetyEnabled(true);
    spinBot.setSafetyEnabled(true);
  }

}
