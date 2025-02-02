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
import com.revrobotics.sim.SparkMaxSim;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import java.util.ResourceBundle.Control;


public class Drive_Train extends SubsystemBase {
    /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  

   SparkMax leftmaster;
   SparkMax rightmaster;
   SparkMax leftslave;
   SparkMax rightslave;
   SparkMax leftMotor1;
   SparkMax rightMotor1;
   SparkMax leftMotor2;
   SparkMax rightMotor2;
   SparkMax armmotor;
   SparkMax armslave;
   SparkMax leftMotor;
   SparkMax rightMotor; 
  
  // private DifferentialDrive drive = new DifferentialDrive(leftMotor1, rightMotor1);



  //joysticks
  private Joystick driverJoystick = new Joystick(0);// chnage channel base on our driver station
  private Joystick operatorJoystick = new Joystick(1);// chnage channel base on our driver station

  // unit conversion
  private final double kDriveTick2Feet = 1.0 / 4096 * 6 * Math.PI / 12;
  private final double kArmTick2Deg = 360.0 / 512 * 26 / 42 * 18 / 60 * 18 / 84;//

  
@Override
  public void robotPeriodic() {
    SmartDashboard.putNumber("Arm encoder value",armmotor.getEncoder().getPosition() * kArmTick2Deg);//fix
    SmartDashboard.putNumber("Left driver value", armmotor.getEncoder().getPosition() * kDriveTick2Feet);
    SmartDashboard.putNumber("Right encode value",armmotor.getEncoder(). getPosition() * kDriveTick2Feet);

  
    class kDrivetrain {
      public static final int LEFT_MASTER_ID = 4;
      public static final int LEFT_FOLLOWER_ID = 6;
      public static final int RIGHT_MASTER_ID = 5;
      public static final int RIGHT_FOLLOWER_ID = 7;
    }

    final SparkMax leftmaster = new SparkMax(kDrivetrain.LEFT_MASTER_ID, MotorType.kBrushless);
    final SparkMax leftfollower = new SparkMax(kDrivetrain.LEFT_FOLLOWER_ID, MotorType.kBrushless);
    final SparkMax rightmaster = new SparkMax(kDrivetrain.RIGHT_MASTER_ID, MotorType.kBrushless);
    final SparkMax rightFollower = new SparkMax(kDrivetrain.RIGHT_FOLLOWER_ID, MotorType.kBrushless);
    DCMotor motor = DCMotor.getNEO(1);
    final SparkMaxSim leftMaxSim_master = new SparkMaxSim(leftmaster, motor);
    final SparkMaxSim rightMaxSim_master = new SparkMaxSim(rightmaster, motor);
    final SparkMaxSim leftMaxSim_follower = new SparkMaxSim(leftfollower, motor);
    final SparkMaxSim rightMaxSim_follower = new SparkMaxSim(rightFollower,motor);
  }
      final DifferentialDrive drive = new DifferentialDrive(leftmaster, rightmaster);
    
  
  //initialize the drivetrain
  public Drivetrain() {
    leftMotor = new SparkMax(0, MotorType.kBrushless);
    rightMotor = new SparkMax(1, MotorType.kBrushless);
  }
  @Override
  public void teleopPeriodic() {
    //driving
    double power = -driverJoystick.getRawAxis(1);
    double turn = driverJoystick.getRawAxis(4);
    drive.arcadeDrive(power*0.6, turn*0.3);//change based on our driver 


    //armcontrol
    double armpower = -operatorJoystick.getRawAxis(1);
    armmotor.set(armpower);
    if (Math.abs(armpower) < 0.05); {
      armmotor.set(0);
    }
    armmotor.set(armpower);
    armmotor.set(ControlMode.PercentOutput);
     
    // armmotor.configReverseSoftLimitEnable(true); // This method does not exist for SparkMax, fix using the docs
    // armroller
    double rollerpower = 0;
    if (operatorJoystick.getRawButton(1) == true) {
      rollerpower = 1;
    } else if (operatorJoystick.getRawButton(2)) {
      rollerpower = -1;
    }
    rollermotor.set(ControlMode.PercentOutput);

    //hatchintake 
    if (operatorJoystick.getRawButton(3)) { // opening hatch 
      hatchintake.set(DoubleSolenoid.Value.kReverse);
    } else if (operatorJoystick.getRawButton(4)) { // closing hatch
      hatchintake.set(DoubleSolenoid.Value.kForward);
    }
  }
  
  @Override
  public void robotInit() {
    //follow motors code if possible
  }
  @Override
  public void autonomousPeriodic() {
    //auto
    // getting the left and right encoder values
    double leftposition = leftmaster.getEncoder().getPosition() *kDefaultPeriod;
    double rightposition = rightmaster.getEncoder().getPosition() * kDefaultPeriod;

    // DISTANCE AVERAGE
    double distance = (leftposition + rightposition) / 2;
    if (distance < 10) { // if the average is less than 10 then the left motor speed is 0.6 and the rightspeed is 0.3
      drive.tankDrive(0.6, 0.3); 
    } else {
      drive.tankDrive(0, 0);
    }        
  }

  @Override
  public void testPeriodic() {
    // Add test code here
  }

  private void enablemotor(boolean enable) {
    // enable the motor to brake or coast
    IdleMode mode;
    if (enable) {
      mode = IdleMode.kBrake;//brake mode
    } else {
      mode = IdleMode.kCoast;//coast mode
    }
    



}
  public static Drivetrain getInstance() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getInstance'");
  }
}
