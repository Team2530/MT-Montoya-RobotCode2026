package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.DriveTrain;

public class AutonomousDrive extends Command{
  /** Creates a new AutonomousDrive Command. */
  private final DriveTrain drivetrain;
  private final double Speed;
  private final double turnSpeed;
  private final double Time;

  private final Timer timer = new Timer();

  public AutonomousDrive(DriveTrain driveTrain, double Speed, double turnSpeed, double Time)  {
    this.drivetrain = driveTrain;
    this.Speed = Speed;
    this.turnSpeed = turnSpeed;
    this.Time = Time;

    addRequirements(this.drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    timer.reset();
    timer.start();

    drivetrain.drive(Speed, turnSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.drive(Speed, turnSpeed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.drive(0, 0);
  }


  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return timer.hasElapsed(Time); // End when designated time has elapsed.
  }
  
}
