// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.climb.ClimbExtend;
import frc.robot.commands.climb.ClimbPiston;
import frc.robot.commands.climb.ClimbRetract;
import frc.robot.commands.drive.DrivePeriodic;
import frc.robot.commands.manip.ManipulatorCommand;
import frc.robot.commands.manip.RaiseManip;
import frc.robot.commands.manip.ShootCommand;
import frc.robot.commands.manip.ShootInverse;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer
{
   public static final XboxController dCtrl = new XboxController(0);

    double getAxis = dCtrl.getRawAxis(Constants.DRIVEAXIS);
    JoystickButton A = new JoystickButton(dCtrl, 1);
    JoystickButton B = new JoystickButton(dCtrl, 2);
    JoystickButton X = new JoystickButton(dCtrl, 3);
    JoystickButton Y = new JoystickButton(dCtrl, 4);
    JoystickButton SELECT = new JoystickButton(dCtrl, 7);
    POVButton UP = new POVButton(dCtrl, 180);
    POVButton RIGHT = new POVButton(dCtrl, 90);
    POVButton DOWN = new POVButton(dCtrl, 0);
    POVButton LEFT = new POVButton(dCtrl, 270);
    int shootInvert= 0;
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
        //TODO: test robot without this binding

        //toggle binds
        A.toggleWhenPressed(new RaiseManip());
        SELECT.toggleWhenPressed(new ClimbPiston());
        //while binds
        B.whileHeld(new ShootCommand());
        X.whileHeld(new ShootInverse());
        UP.whileHeld(new ClimbExtend());
        DOWN.whileHeld(new ClimbRetract());



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
