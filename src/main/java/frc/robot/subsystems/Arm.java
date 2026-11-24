package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.SparkClosedLoopController; 
import edu.wpi.first.units.measure.Distance; 

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class Arm extends SubsystemBase {
    private final SparkFlex m_arm;
    private final SparkClosedLoopController ArmController; 


    private Distance targetHeight;

    public Arm() {
        m_arm = new SparkFlex(
        ArmConstants.ArmMotor.CAN_ID,
        MotorType.kBrushless 
        ); 
        ArmController = m_arm.getClosedLoopController();
        SparkFlexConfig ArmConfig = new SparkFlexConfig();
        ArmConfig 
            .closedLoop
                .pid(ArmConstants.kP, ArmConstants.kI, ArmConstants.kD)
            .feedForward
                .svag(ArmConstants.kS, ArmConstants.kV, ArmConstants.kA, ArmConstants.kG);
    }

   
}
