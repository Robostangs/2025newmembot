package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Intake extends SubsystemBase {
    double is;
    TalonSRX Intakemotor;
    static Intake mIntake;
    
        public Intake(){
            Intakemotor = new TalonSRX(15);
        }

        public static Intake getInstance() {
            
           if (mIntake == null) {
           mIntake = new Intake();
        }
        
        return mIntake;
      }
        public void setSpeed(double speed) {
           Intakemotor.set(TalonSRXControlMode.PercentOutput, speed);
           
        }
}
