package frc.robot.commands;

import java.util.function.DoubleSupplier;

import frc.robot.Constants;
import frc.robot.subsystems.Drive_Train;


import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;

import frc.robot.subsystems.Intake;


public class Deploy extends Command {
 

    private Intake mIntake = Intake.getInstance();

    public Deploy(){


        
        addRequirements(mIntake);
    }

    @Override
    public void execute(){
        mIntake.setSpeed(Constants.Intake_Constants.kIntakedutycycle);
        

    }

    public void end(boolean interrupted) {
        mIntake.setSpeed(0);

    }

    public boolean isFinished() {
        return false;
    }






    



}
