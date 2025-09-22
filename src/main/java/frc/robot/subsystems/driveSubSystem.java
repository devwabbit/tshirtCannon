package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class driveSubSystem extends SubsystemBase {

    public final SparkMax right1 = new SparkMax(1, MotorType.kBrushed);
    public final SparkMax right2 = new SparkMax(2, MotorType.kBrushed);
    public final SparkMax left1 = new SparkMax(3, MotorType.kBrushed);
    public final SparkMax left2 = new SparkMax(4, MotorType.kBrushed);


    // public driveSubSystem(XboxController xboxController) {
    // }

    public void leftDrive(double speed) {
        left1.set(speed);
        left2.set(speed);
    }

    public void rightDrive(double speed) {
        right1.set(speed);
        right2.set(speed);
    }
    // public void drive(double left, double right) {
    //     // Add logic to control motors based on left and right stick inputs
    //     System.out.println("Driving: Left=" + left + ", Right=" + right);
    // }
}
