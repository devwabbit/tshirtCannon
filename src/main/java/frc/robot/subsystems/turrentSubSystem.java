package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkAbsoluteEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;


import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;

public class turrentSubSystem extends SubsystemBase{
    
    public final SparkMax turrent = new SparkMax(5, MotorType.kBrushless);
    public final SparkMax cannonUpDown = new SparkMax(10, MotorType.kBrushed);
    private final Solenoid solenoid = new Solenoid(9, PneumaticsModuleType.CTREPCM, 2);
    
    public void fire() {
        solenoid.set(true);
        System.out.println("Debug message: Solenoid FIre ");
                new WaitCommand(.2)
            .andThen(new InstantCommand(() -> {
                solenoid.set(false);
                System.out.println("Solenoid fire end");
            }, this))
            .schedule();
    }

    /* 
     * turns cannon
     * @param turn Negative goes right, Postive goes left,
    */
    public void turnTurrent(double turn) {
        turrent.set(turn);
    }

    public double returnRotation() {
        return turrent.getEncoder().getPosition();
    }

    public void cannonGoUpDown(double upDown) {
       // cannonUpDown.set(ControlMode.PercentOutput, upDown);
        cannonUpDown.set(upDown);
        System.out.println("Cannon up down state: " + upDown);
    }
}
