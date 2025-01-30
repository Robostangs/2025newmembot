package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkBaseConfig;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase{

    SparkMax Rightfront, Rightback, Leftfront, Leftback;
    SparkBaseConfig Rightfrontconfig, Rightbackconfig, Leftfrontconfig, Leftbackconfig;
    DifferentialDrive m_drive;
    public Drivetrain () {
        Rightfront = new SparkMax(1, MotorType.kBrushless);
        Rightback = new SparkMax(2, MotorType.kBrushless);
        Leftfront = new SparkMax(3, MotorType.kBrushless);
        Leftback = new SparkMax(4, MotorType.kBrushless);
        m_drive = new DifferentialDrive(Leftfront, Rightfront);

        
       

    }
    public DifferentialDrive setMotorsPower(double Rightfrontpower, double Rightbackpower) {
        Rightfront.set(Rightfrontpower);
        Rightback.set(Rightbackpower);

        m_drive.arcadeDrive(Rightfrontpower, Rightbackpower);

        return m_drive;

    }


    
}
