package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


public class Telescope extends SubsystemBase {
    TalonSRX telescopemotor;
    static Telescope mTelescope;
    public Telescope() {
        telescopemotor = new TalonSRX(0);//changge based on phoneix tunerx
    }
   

    public static Telescope getInstance(){
        if(mTelescope == null) {
            mTelescope = new Telescope();
        }
        return mTelescope;
    }
    public void setSpeed(double speed) {
        telescopemotor.set(TalonSRXControlMode.PercentOutput,speed);
    }

}
