// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSystem extends SubsystemBase {
  /** Creates a new DriveSystem. */
  WPI_TalonSRX frontLMotor;
  WPI_TalonSRX backLMotor;

  WPI_TalonSRX frontRMotor;
  WPI_TalonSRX backRMotor;
  
  MecanumDrive drive;

  double speedMultiplier = 0.75;

  public DriveSystem()
   {
     frontLMotor = new WPI_TalonSRX(1);
     frontRMotor = new WPI_TalonSRX(3);

     backLMotor = new WPI_TalonSRX(2);
     backRMotor = new WPI_TalonSRX(4);

   }

   public void drive(double xVelocity, double yVelocity, double rotation) 
   {
      double x = xVelocity * speedMultiplier;
      double y = yVelocity * speedMultiplier;
      double rotate = rotation * speedMultiplier;

      drive.driveCartesian(x, y, rotate);
   }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
