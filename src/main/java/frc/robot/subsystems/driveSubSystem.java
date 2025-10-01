package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class driveSubSystem extends SubsystemBase {

    public final SparkMax right1 = new SparkMax(1, MotorType.kBrushless);
    public final SparkMax right2 = new SparkMax(2, MotorType.kBrushless);
    // public final SparkMax right3 = new SparkMax(3, MotorType.kBrushless);
    // public final SparkMax right4 = new SparkMax(4, MotorType.kBrushless);

    public final SparkMax left1 = new SparkMax(3, MotorType.kBrushless);
    public final SparkMax left2 = new SparkMax(4, MotorType.kBrushless);
    // public final SparkMax left3 = new SparkMax(7, MotorType.kBrushless);
    // public final SparkMax left4 = new SparkMax(8, MotorType.kBrushless);    

    // public driveSubSystem(XboxController xboxController) {
    // }

    public void leftDrive(double speed) {
        left1.set(speed);
        left2.set(speed);
        // left3.set(speed);
        // left4.set(speed);
    }

    public void rightDrive(double speed) {
        right1.set(speed);
        right2.set(speed);
        // right3.set(speed);
        // right4.set(speed);
    }
    // public void drive(double left, double right) {
    //     // Add logic to control motors based on left and right stick inputs
    //     System.out.println("Driving: Left=" + left + ", Right=" + right);
    // }
}
