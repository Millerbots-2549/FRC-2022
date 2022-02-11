// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class ManipulatorSubsystem extends SubsystemBase {

  public WPI_TalonSRX spinTop, spinBot;
  public WPI_VictorSPX shoot;
  // public Solenoid noid;
  public DoubleSolenoid doubleNoid;
  
  public ManipulatorSubsystem() {

    //shooter motors
    spinTop = new WPI_TalonSRX(Constants.TOPMANIPRIGHT);
    shoot = new WPI_VictorSPX(Constants.SHOOTER);
    spinBot = new WPI_TalonSRX(Constants.BOTMANIP);

    // noid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.SINGLENOID);
    doubleNoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.DOUBLENOIDFRNT, Constants.DOUBLENOIDBACK);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void spin(double speed){
    spinTop.set(speed);
    spinBot.set(speed);
  }

  public void shootStart(int speed){
    shoot.set(speed);
  }
  public void shootEnd(){
    shoot.set(0);
  }

  public void manipUp(){
    // noid.set(true);
    doubleNoid.set(Value.kReverse);
  }

  public void manipDown(){
    // noid.set(false);
    doubleNoid.set(Value.kForward);
  }

  public void motorSafety(){
    spinTop.setSafetyEnabled(true);
    spinBot.setSafetyEnabled(true);
  }
}
