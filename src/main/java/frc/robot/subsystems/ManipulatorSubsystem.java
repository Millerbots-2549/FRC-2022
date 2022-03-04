// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import java.security.CodeSigner;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class ManipulatorSubsystem extends SubsystemBase {

  public WPI_TalonFX spinTop, spinBot;
  public WPI_VictorSPX shoot;
  public DoubleSolenoid doubleNoid;
  public DoubleSolenoid ballNoid1;
  public DoubleSolenoid ballNoid2;
  
  public ManipulatorSubsystem() {

    //shooter motors
    spinTop = new WPI_TalonFX(Constants.TOPMANIPRIGHT);
    shoot = new WPI_VictorSPX(Constants.SHOOTER);
    spinBot = new WPI_TalonFX(Constants.BOTMANIP);

    // noid = new Solenoid(PneumaticsModuleType.CTREPCM, Constants.SINGLENOID);
    doubleNoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.DOUBLENOIDFRNT, Constants.DOUBLENOIDBACK);
    ballNoid1 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.SHOOTNOIDIN, Constants.SHOOTNOIDOUT);
    ballNoid2 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.SHOOTNOIDTWOIN, Constants.SHOOTNOIDTWOOUT);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }



  //shooter motor methods
  public void shootStart(int speed){
    shoot.set(speed);
  }
  public void shootEnd(){
    shoot.set(0);
  }
  public void spin(double speed){
    spinTop.set(speed);
    spinBot.set(speed);
  }

  //raise and lower manipulator methods
  public void manipUp(){
    // noid.set(true);
    doubleNoid.set(Value.kReverse);
  }
  public void manipDown(){
    // noid.set(false);
    doubleNoid.set(Value.kForward);
  }

  //Ball Noid 1 Methods
  public void ball1In(){
    ballNoid1.set(Value.kReverse);
  }
  public void ball1Off(){
    ballNoid1.set(Value.kOff);
  }
  public void ball1Out(){
    ballNoid1.set(Value.kForward);
  }
  //Ball Noid 2 Methods
  public void ball2In(){
    ballNoid2.set(Value.kReverse);
  }
  public void ball2Off(){
    ballNoid2.set(Value.kOff);
  }
  public void ball2Out(){
    ballNoid2.set(Value.kForward);
  }

  public void motorSafety(){
    spinTop.setSafetyEnabled(true);
    spinBot.setSafetyEnabled(true);
  }

  //get values
  public DoubleSolenoid.Value getManipUp(){
    return doubleNoid.get();
  }
}
