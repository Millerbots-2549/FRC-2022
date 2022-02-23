// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.manip.*;
import frc.robot.commands.drive.*;
import frc.robot.commands.climb.*;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
   public static final XboxController dCtrl = new XboxController(0);
   public static final XboxController mCtrl = new XboxController(1);

   //dCtrl = drive controller
    double getAxis = dCtrl.getRawAxis(Constants.DRIVEAXIS);
    JoystickButton dA = new JoystickButton(dCtrl, 1);
    JoystickButton dY = new JoystickButton(dCtrl, 4);
    JoystickButton dSELECT = new JoystickButton(dCtrl, 7);
    POVButton dUP = new POVButton(dCtrl, 180);
    POVButton dRIGHT = new POVButton(dCtrl, 90);
    POVButton dDOWN = new POVButton(dCtrl, 0);
    POVButton dLEFT = new POVButton(dCtrl, 270);
    int shootInvert= 0;

    //mCtrl = manipulator controller
    JoystickButton mA = new JoystickButton(mCtrl, 1);
    JoystickButton mB = new JoystickButton(mCtrl, 2);
    JoystickButton mX = new JoystickButton(mCtrl, 3);
    JoystickButton mY = new JoystickButton(mCtrl, 4);
    JoystickButton mLB = new JoystickButton(mCtrl, 5);
    JoystickButton mRB = new JoystickButton(mCtrl, 6);


    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer()
    {
        //defualt commands
        Robot.drive.setDefaultCommand(new DrivePeriodic());
        Robot.manip.setDefaultCommand(new ManipulatorCommand());

        // do not delete
        configureButtonBindings();
    }
    
    
    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings()
    {
        //toggle binds
        mA.toggleWhenPressed(new RaiseManip());
        dA.toggleWhenPressed(new RaiseManip());
        dSELECT.toggleWhenPressed(new ClimbPiston());
        //while binds
        mRB.whileHeld(new ShootCommand());
        mLB.whileHeld(new ShootInverse());
        mX.whileHeld(new ShootOneLow());
        mB.whileHeld(new ShootTwoLow());
        mY.whileHeld(new ShootOneHigh());
        dUP.whileHeld(new ClimbExtend());
        dDOWN.whileHeld(new ClimbRetract());

    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand(){
        return null;
    }
}
