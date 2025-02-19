package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.telescope;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Telescope extends SubsystemBase {
    static TalonSRX telescopemotor;
    static Telescope mTelescope;
    public Telescope() {
        telescopemotor = new TalonSRX(12);//changge based on phoneix tunerx
    }
    public static Runnable zerotelescope = () -> {
        telescopemotor.setSelectedSensorPosition(0);
    };
   

    public static Telescope getInstance(){
        if(mTelescope == null) {
            mTelescope = new Telescope();
        }
        return mTelescope;
    }
    public void setSpeed(double speed) {
        telescopemotor.set(TalonSRXControlMode.PercentOutput,speed);
    }

    public double getPosition() {
        return telescopemotor.getSelectedSensorPosition();
    }public void setPosition(double postion) {
        telescopemotor.setSelectedSensorPosition(postion);
    }
    @Override
  public void periodic() {
    SmartDashboard.putNumber("telescope postion",getPosition());
    
}


}
