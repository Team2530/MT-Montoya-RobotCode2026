// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import com.ctre.phoenix.motorcontrol.TalonFXControlMode;


public final class Constants {
  public static final class XboxControllers {
    public static final int driverPort = 0;
    public static final int operatorPort = 1;

    /** Controller Deadzones */
    public static final double DEADZONE = 0.05;
    public static final int X_DUMPER_ROTATE = 6;
  }
  public static final class ArmConstants {

    public static class ArmMotor {
      public static final int CAN_ID = 9; //TODO: CAN_ID is placeholder for now 
      public static final boolean INVERTED = false; 
    } //TODO: Below is only placeholder - Eli
    public static final double kP = 0;
    public static final double kI = 0;
    public static final double kD = 0;
    //TODO: Below is only placeholder - Eli
    public static final double kS = 0;
    public static final double kV = 0;
    public static final double kA = 0;
    public static final double kg = 0;

  }

  /** Drive Constants and Drive related simulation constants */
  public static final class Drive {

    public static final class CAN_IDs {
      public static final int FRONT_RIGHT = 2;
      public static final int REAR_RIGHT = 3;
      public static final int REAR_LEFT = 0;
      public static final int FRONT_LEFT = 1;
    }

    public static final double MAX_SPEED = 0.65;
    public static final double MAX_ROTATION = 0.75;

    // Information Below is not Required \\
    //but is useful for simulation and autonomous calculations \\
    
    /** Wheel Diameter in Meters */
    public static final double WHEEL_DIAMETER = .1524;

    /** Robot Mass in kgs (currently at 100lbs) */
    public static final double ROBOT_MASS = 45.3;

    /**
     * Distance between the robot perpendicular to the wheel's axis of rotation in
     * meters
     */
    public static final double ROBOT_TRACK_WIDTH = .3;

    /** Moment of inertia */
    public static final double MOMENT_OF_INERTIA = 2.0;

    /** DriveTrain gear ratio as output / input */
    public static final double GEAR_RATIO = 8;
  }

}
