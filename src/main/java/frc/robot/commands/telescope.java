package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.subsystems.Telescope;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;



public class telescope extends Command {
    private Telescope mTelescope = Telescope.getInstance();

    public telescope() {
        


        
        addRequirements(mTelescope);
    }
    @Override
    public void execute(){
        mTelescope.setSpeed(Constants.telescope_Constants.speedtelescope);
    }

    public void end(boolean interrupted){
        mTelescope.setSpeed(0);
    }

}
