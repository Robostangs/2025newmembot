package frc.robot.subsystems;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonSRX;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.kDrivetrain;

import com.revrobotics.servohub.ServoHub.ResetMode;
import com.revrobotics.sim.SparkMaxSim;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkBase;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.config.SparkMaxConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import java.util.ResourceBundle.Control;

import org.opencv.dnn.Model;



public class Drive_Train extends SubsystemBase {
  /**
   * This function is run when the robot is first started up and should be used
   * for any
   * initialization code.
   */
  double kResetSafeParameters;
  static Drive_Train mDrivetrain;
  SparkMax leftmaster;
  SparkMax rightmaster;
  SparkMax leftslave;
  SparkMax rightslave;

  // SparkMax leftMotor;
  // SparkMax rightMotor;

  // private DifferentialDrive drive = new DifferentialDrive(leftMotor1,
  // rightMotor1);

  // unit conversion
  private final double kDriveTick2Feet = 1.0 / 4096 * 6 * Math.PI / 12;
  private final double kArmTick2Deg = 360.0 / 512 * 26 / 42 * 18 / 60 * 18 / 84;//

  public Drive_Train() {
    leftmaster = new SparkMax(0, MotorType.kBrushless);
    rightmaster = new SparkMax(1, MotorType.kBrushless);
    leftslave = new SparkMax(2, MotorType.kBrushless);
    rightslave = new SparkMax(3, MotorType.kBrushless);
    // leftslave.follow(leftmaster);
    SparkMaxConfig config = new SparkMaxConfig();
    config.follow(leftmaster);
    leftslave.configure(config,com.revrobotics.spark.SparkBase.ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
    config.follow(rightmaster);
    rightslave.configure(config,com.revrobotics.spark.SparkBase.ResetMode.kResetSafeParameters,PersistMode.kPersistParameters);
    

  }

  @Override
  public void periodic() {

  }

  final DifferentialDrive drive = new DifferentialDrive(leftmaster, rightmaster);

  // initialize the drivetrain

  private void enablemotor(boolean enable) {
    // enable the motor to brake or coast
    IdleMode mode;
    if (enable) {
      mode = IdleMode.kBrake;// brake mode
    } else {
      mode = IdleMode.kCoast;// coast mode
    }

  }

  public static Drive_Train getInstance() {
    if (mDrivetrain == null) {
      mDrivetrain = new Drive_Train();
    }
    return mDrivetrain;
  }

  public void setSpeed(double leftSpeed, double rightSpeed) {
    // set the speed of the left and right motors
    leftmaster.set(leftSpeed * kDrivetrain.driveMulti);
    rightmaster.set(rightSpeed * kDrivetrain.driveMulti);
  }
}
