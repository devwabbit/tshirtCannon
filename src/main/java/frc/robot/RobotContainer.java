// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.driveSubSystem;
import frc.robot.subsystems.turrentSubSystem;


public class RobotContainer {
  public boolean slowmode = false;
  public double slowmodeval = 1;
  public boolean safetyFire = false;
  XboxController controller = new XboxController(0);

  public final driveSubSystem driveSystem = new driveSubSystem();
  public final turrentSubSystem turrentSubSystem = new turrentSubSystem();
  
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    turrentSubSystem.lights(0.61);
    
    //DRIVE
    new Trigger(() -> 
      Math.abs(controller.getLeftY()) > 0.1 || 
      Math.abs(controller.getRightY()) > 0.1)
    .whileTrue(Commands.run(() -> {
      double leftStick = controller.getLeftY();
      double rightStick = controller.getRightY();
      driveSystem.leftDrive(-leftStick);
      driveSystem.rightDrive(rightStick);

      // driveSystem.drive(leftStick, rightStick); // Call the subsystem's drive method
    }, driveSystem))
    .onFalse(
      Commands.run(() -> {
        driveSystem.leftDrive(0);
        driveSystem.rightDrive(0);
      })
    );

    new Trigger(() -> controller.getStartButtonPressed()).whileTrue(Commands.runOnce(() -> {
      slowmode = !slowmode;
      if (slowmode){
        slowmodeval = .5;
      } else {
        slowmodeval = 1;
      }
      System.out.println("slowmode: "+slowmode+" val: "+slowmodeval);
    }));

    //Turn Turrent Left & Right
    new Trigger(() -> controller.getRightBumperButton()).whileTrue(new InstantCommand(() -> 
    turrentSubSystem.turnTurrent(-.1)
    ));
    new Trigger(() -> controller.getLeftBumperButton()).whileTrue(new InstantCommand(() -> 
    turrentSubSystem.turnTurrent(.1)
    ));
    new Trigger(() -> controller.getRightBumperButtonReleased() || controller.getLeftBumperButtonReleased()).whileTrue(new InstantCommand(() -> 
    turrentSubSystem.turnTurrent(0)
    ));

    new Trigger(() -> controller.getLeftTriggerAxis() > .8 ).whileTrue(new InstantCommand(() -> {
      safetyFire = true;
      turrentSubSystem.lights(-0.11);
    }));
    new Trigger(() -> controller.getLeftTriggerAxis() < .8).whileTrue(new InstantCommand(() -> {
      safetyFire = false;
      turrentSubSystem.lights(0.61);
    }));
    new Trigger(() -> controller.getRightTriggerAxis() > .8).whileTrue(new InstantCommand(() -> {
      if (safetyFire == true) {
        turrentSubSystem.fire();
      }
    }));
    

    //FIRE CANNON trigger. TODO: Make a defined wait period to pervent rapid fire.
    // new Trigger(() -> controller.getYButton())
    // .whileTrue(
    //   new InstantCommand(() -> 
    //   turrentSubSystem.fire()
    // ));
    
    
    // Bring Controller Up & Down
    new Trigger(() -> controller.getXButton()).whileTrue(new InstantCommand(() -> 
    turrentSubSystem.cannonGoUpDown(1)
    ));

    new Trigger(() -> controller.getBButton()).whileTrue(new InstantCommand(() -> 
    turrentSubSystem.cannonGoUpDown(-1)
    ));

    new Trigger(() -> controller.getXButtonReleased() || controller.getBButtonReleased()).whileTrue(new InstantCommand(() -> 
    turrentSubSystem.cannonGoUpDown(0)
    ));
    // .whileFalse(new InstantCommand(()->turrentSubSystem.cannonGoUpDown(0)));




  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

  public Command getDrive(double stickLeft, double stickRight) {
    return Commands.run(() -> {
      // Example: Add logic to drive using stickLeft and stickRight xxxxxxxxvalues
      System.out.println("Driving with left stick: " + stickLeft + ", right stick: " + stickRight);
    });
  }
}
