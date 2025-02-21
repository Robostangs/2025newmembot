package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.subsystems.Telescope;

import java.util.function.DoubleSupplier;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
public class Telescope_Command_Down extends Command{
    DoubleSupplier leftTrigger;
    private Telescope mTelescope = Telescope.getInstance();
   public Telescope_Command_Down(DoubleSupplier leftTrigger)
   {
    this.leftTrigger = leftTrigger;

    
        addRequirements(mTelescope);
   }
   @Override
   public void execute(){
    mTelescope.setSpeed(Constants.telescope_Constants.speedtelescopedown);
    mTelescope.setSpeed(leftTrigger.getAsDouble());


   }

   public void end(boolean interrupted){

    mTelescope.setSpeed(0);
   }
   public boolean isFinished(){
        return false;
   }


}
