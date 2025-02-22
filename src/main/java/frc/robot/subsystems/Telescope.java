package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.Telescope_Command;

import com.ctre.phoenix6.hardware.TalonFX;


public class Telescope extends SubsystemBase {
    static TalonFX telescopemotor;
    static Telescope mTelescope;
    public Telescope() {
        telescopemotor = new TalonFX(12);//changge based on phoneix tunerx
    }
    public static Runnable zerotelescope = () -> {
        telescopemotor.setPosition(0);
    };
   

    public static Telescope getInstance(){
        if(mTelescope == null) {
            mTelescope = new Telescope();
        }
        return mTelescope;
    }
    public void setSpeed(double speed) {
        telescopemotor.set(speed);
    }

    public double getPosition() {
        return telescopemotor.getPosition().getValueAsDouble();
    }public void setPosition(double postion) {
        telescopemotor.setPosition(postion);
    }
    @Override
  public void periodic() {
    SmartDashboard.putNumber("telescope postion",getPosition());
    
}


}
