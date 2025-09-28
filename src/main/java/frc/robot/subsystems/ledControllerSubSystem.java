package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ledControllerSubSystem extends SubsystemBase {

    public final PWMSparkMax setlights = new PWMSparkMax(1);

    public ledControllerSubSystem() {
        lights(0.61);
    }

    public void lights(double pwmOutput) {
        setlights.set(pwmOutput);
    }

    
}
