// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;

public class DriveWithJoystick extends CommandBase {
  /** Creates a new DriveWithJoystick. */
  DriveSystem drive;
  Joystick joy;

  public DriveWithJoystick(DriveSystem drive, Joystick joy) {
    this.drive = drive;
    this.joy = joy;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() 
  {
    double x = MathUtil.applyDeadband(joy.getX(), 0.15);
    double y = MathUtil.applyDeadband(joy.getY(), 0.15);
    double z = MathUtil.applyDeadband(joy.getZ(), 0.15);
    drive.drive(x, y, z);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
