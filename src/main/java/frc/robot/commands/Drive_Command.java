package frc.robot.commands;
import java.util.function.DoubleSupplier;


import frc.robot.subsystems.Drive_Train;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import edu.wpi.first.wpilibj2.command.Command;

public class Drive_Command extends Command {
    // xbox controller


    private Drive_Train mDrivetrain = Drive_Train.getInstance();


    // Variables used to store trigger and joystic values from controller
    private DoubleSupplier leftTrigger, rightTrigger, leftJoy;
    private double leftTriggerValue, rightTriggerValue, leftJoyValue;
    private double overallSpeed;
    private double leftSpeed, rightSpeed;
    private double leftspeedvalue, rightspeedvalue;


    public Drive_Command(DoubleSupplier leftTrigger, DoubleSupplier rightTrigger, DoubleSupplier leftJoy) {
        // Auto-generated constructor stub
        this.leftTrigger = leftTrigger;
        this.rightTrigger = rightTrigger;
        this.leftJoy = leftJoy;


        addRequirements(mDrivetrain);
    }


    // Called every time the scheduler runs while the command is scheduled.


    @Override
    public void execute() {




        // sending speed to drivetrain
        mDrivetrain.setSpeed(leftSpeed, rightSpeed);


        // print Certain variables to "SmartDashborad"
        SmartDashboard.putNumber("Overall Speed", overallSpeed);
        SmartDashboard.putNumber("Left Speed", leftSpeed);
        SmartDashboard.putNumber("Right Speed", rightSpeed);
    }


    // Called when the command is initially scheduled.


    public void initialize() {
    }


    // Called once the command ends or is interrupted.


    public void end(boolean interrupted) {
        mDrivetrain.setSpeed(0, 0);
    }
    //baja blast bottom drawer somewhere in the middle


    // Returns true when the command should end.


    public boolean isFinished() {
        return false;


    }

    
}
