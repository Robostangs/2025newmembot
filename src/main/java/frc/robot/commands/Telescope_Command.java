package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants;
import frc.robot.subsystems.Telescope;

import java.util.function.DoubleSupplier;


public class Telescope_Command extends Command {
    
    private Telescope mTelescope = Telescope.getInstance();
    DoubleSupplier rightTrigger;
public Telescope_Command(DoubleSupplier rightTrigger){
    this.rightTrigger = rightTrigger;
    addRequirements(mTelescope);
}
@Override
public void execute() {
    mTelescope.setSpeed(rightTrigger.getAsDouble());

}
public void end (boolean interrupted) {
    mTelescope.setSpeed(0);
}

public boolean isFinished() {
    return false;
}

// @Override
// public boolean isFinished() {
//     if()
// }

}
