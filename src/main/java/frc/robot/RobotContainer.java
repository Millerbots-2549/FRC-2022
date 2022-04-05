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
import frc.robot.commands.manip.shootpresets.ShootOneHigh;
import frc.robot.commands.manip.shootpresets.ShootOneLow;
import frc.robot.commands.manip.shootpresets.ShootTwoLow;
import frc.robot.commands.manip.shootsolenoid.ShootLeft;
import frc.robot.commands.manip.shootsolenoid.ShootRight;
import frc.robot.commands.drive.*;
import frc.robot.commands.auto.AutoComplex;
import frc.robot.commands.climb.*;
import frc.robot.commands.climb.climbspinner.ClimbSpinBck;
import frc.robot.commands.climb.climbspinner.ClimbSpinFwd;


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
    JoystickButton dSTART = new JoystickButton(dCtrl, 8);
    JoystickButton dLB = new JoystickButton(dCtrl, 5);
    JoystickButton dRB = new JoystickButton(dCtrl, 6);
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
    POVButton mUP = new POVButton(mCtrl, 180);
    POVButton mRIGHT = new POVButton(mCtrl, 90);
    POVButton mDOWN = new POVButton(mCtrl, 0);
    POVButton mLEFT = new POVButton(mCtrl, 270);


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
            //button on each controller to toggle the position of the manipulator
        // mA.toggleWhenPressed(new RaiseManip());
        dA.toggleWhenPressed(new RaiseManip());
            // controls the two pistons on the climb apendage with the same command
        dSELECT.toggleWhenPressed(new ClimbPiston());
        dSTART.toggleWhenPressed(new ClimbPiston());
        //while binds
            //two commands that spin the shooting churro in and out
        mRB.whileHeld(new ShootCommand());
        mLB.whileHeld(new ShootInverse());
            //Presets for shooting
            //TODO: make all of the presets run out of a single command
        mX.whileHeld(new ShootOneLow());
        mB.whileHeld(new ShootTwoLow());
        mY.whileHeld(new ShootOneHigh());
            //controls the pistons that push balls into the shooting mechanism
        mRIGHT.whileHeld(new ShootRight());
        mLEFT.whileHeld(new ShootLeft());
            //depricated commands that raised and lowered old climb
            //TODO:update this to work with the new climb system
        dDOWN.whileHeld(new ClimbExtend());
        dUP.whileHeld(new ClimbRetract());
            //controls the motors that spin the climb system
        dLB.whileHeld(new ClimbSpinBck());
        dRB.whileHeld(new ClimbSpinFwd());
    }

    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand(){
        return(new AutoComplex());
    }
}
