// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */


//This is for declaring constants so the code is more clear. For instance, since each motor is
//identified by a integer, we just contain those integers here and assign them names so the code reads more clearly.

// Format for constants is ALLCAPS with no spaces

public final class Constants {

    // Motor Controllers
    public static int DRIVEFRONTRIGHT = 3;
    public static int DRIVEFRONTLEFT = 13;
    public static int DRIVEBACKRIGHT = 2;
    public static int DRIVEBACKLEFT = 12;

    public static int TOPMANIP = 14;
    public static int BOTMANIP = 15;

    //Motor groups
    public static int DRIVERIGHT = 0;
    public static int DRIVELEFT = 1;

    //PCM
    public static int DOUBLENOIDBACK = 0;
    public static int DOUBLENOIDFRNT = 1;
    public static int SINGLENOID = 2;


    //Controller
        //Axis
    public static int DRIVEAXIS = 0;


}
