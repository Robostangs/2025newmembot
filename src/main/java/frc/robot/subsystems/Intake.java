package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;



public class Intake extends SubsystemBase { 
    SparkMax intakeMotor;
    public static Intake mIntake;

    public Intake(){
        intakeMotor = new SparkMax(0, MotorType.kBrushless);
    }
    public void setSpeed(double speed){
        intakeMotor.set(-1*speed);
    }
    public static Intake getInstance(){
        if(mIntake == null) {
            mIntake = new Intake();
        }
        return mIntake;
    }
}
