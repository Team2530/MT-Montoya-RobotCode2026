// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import frc.robot.Constants.Drive;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix6.signals.InvertedValue;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveTrain extends SubsystemBase {
  
  // Motor Declarations
  public final WPI_VictorSPX frontRightMotor = new WPI_VictorSPX(Drive.CAN_IDs.FRONT_RIGHT);
  public final WPI_VictorSPX rearRightMotor = new WPI_VictorSPX(Drive.CAN_IDs.REAR_RIGHT);
  public final WPI_VictorSPX frontLeftMotor = new WPI_VictorSPX(Drive.CAN_IDs.FRONT_LEFT);
  public final WPI_VictorSPX rearLeftMotor = new WPI_VictorSPX(Drive.CAN_IDs.REAR_LEFT);

  // Create Motor Controllers
  public final MotorController rightMotors = frontRightMotor;
  public final MotorController leftMotors = frontLeftMotor;

  // Create a Diffential Drive Object
  public final DifferentialDrive driveOutputs = new DifferentialDrive(rightMotors, leftMotors);

  /** Creates a new DriveTrain. */
  public DriveTrain() {

    rearRightMotor.follow(frontRightMotor);
    rearLeftMotor.follow(frontLeftMotor);

    // Invert the left side motors as they will be backwards
    frontLeftMotor.setInverted(false);
    frontRightMotor.setInverted(true);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    // Log Motor Outputs, Useful for Debugging
    SmartDashboard.putNumber("Drive/Front_Left_Motor_Output", frontLeftMotor.get());
    SmartDashboard.putNumber("Drive/Front_Right_Motor_Output", frontRightMotor.get());
    SmartDashboard.putNumber("Drive/Rear_Left_Motor_Output", rearLeftMotor.get());
    SmartDashboard.putNumber("Drive/Rear_Right_Motor_Output", rearRightMotor.get());
  }

  

  /**
   * Drive using aracdeDrive at the given x and z percentages.
   */
  public void drive(double xPercent, double zPercent) {
    driveOutputs.arcadeDrive(
      -xPercent * Constants.Drive.MAX_SPEED,
      -zPercent * Constants.Drive.MAX_ROTATION
    );
  }


}
