package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.hal.DIOJNI;

public class turrentSubSystem extends SubsystemBase{
    public final SparkMax turrent = new SparkMax(5, MotorType.kBrushed);
    public final TalonSRX cannonUpDown = new TalonSRX(6);

    public void fire() {
        DIOJNI.setDIO(1, true);
        new WaitCommand(.5);
        DIOJNI.setDIO(1, false);
    }

    /* 
     * turns cannon
     * @param turn Negative goes right, Postive goes left,
    */
    public void turnTurrent(double turn) {
        turrent.set(turn);
    }

    public void cannonGoUpDown(double upDown) {
        cannonUpDown.set(ControlMode.PercentOutput, upDown);
    }
}
