package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

public class Spit extends Command {
    private Intake mIntake = Intake.getInstance();

    public Spit(){

        addRequirements(mIntake);
    }

    @Override
    public void execute(){
        mIntake.setSpeed(Constants.Intake_Constants.kSpitdutycycle);
        

    }

    public void end(boolean interrupted) {
        mIntake.setSpeed(0);

    }

    public boolean isFinished() {
        return false;
    }
}
