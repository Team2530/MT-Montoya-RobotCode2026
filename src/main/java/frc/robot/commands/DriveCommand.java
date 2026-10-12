package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants.XboxControllers;;

public class DriveCommand extends Command{
  /** Creates a new DriveCommand. */
  private final DriveTrain drivetrain;
  private final CommandXboxController driverXboxController;


  public DriveCommand(DriveTrain driveTrain, CommandXboxController driverXboxController) {
    this.drivetrain = driveTrain;
    this.driverXboxController = driverXboxController;

    addRequirements(this.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // Deadzone prevents robot from moving due to stick drift.
    double xPercent = MathUtil.applyDeadband(
        driverXboxController.getLeftY(), 
        XboxControllers.DEADZONE);
        
    double zPercent = MathUtil.applyDeadband(
        driverXboxController.getRightX(), 
        XboxControllers.DEADZONE);

    drivetrain.drive(xPercent, zPercent); // Drive at Deadbanded Percentages
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.drive(0, 0);
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false; 
  }
  
}
