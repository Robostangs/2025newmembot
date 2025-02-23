// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.Drive_Train;
import frc.robot.subsystems.ExampleSubsystem;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Autos extends Command{
  
  public Autos(double kautodrivetime, double kautodrivespeed, double kautoturnspeed) {
    // Constructor
  }

  private Double drivetime;
  private Double rightspeed;
  private Double leftspeed;
  private double current;

  private Double startime;
  private Double mDrive_Train;
  private Double difference;
  //true false variable
  private boolean finished;

  static Drive_Train mDrivetrain;
  public Autos(Double drivetime, Double rightspeed, double leftspeed, double kautoturnspeed, double mDrive_Train){
    
    this.mDrive_Train = mDrive_Train;
    this.drivetime = drivetime;
    this.rightspeed = rightspeed;
    this.leftspeed = leftspeed;

    mDrivetrain =  Drive_Train.getInstance();
    addRequirements(mDrivetrain);
  }
  @Override
  public void initialize() {
    startime = Timer.getFPGATimestamp();
  }

  @Override
  public void execute() {
    current = Timer.getFPGATimestamp();
    //formula: Difference = current - starttime}
    difference = current - startime;
      mDrivetrain.setSpeed(Constants.kAutoDrive.kAutoDriveSpeed, Constants.kAutoDrive.kAutoDriveSpeed);
    }

  @Override
  public boolean isFinished() {
    return finished;
  }

  @Override
  public void end(boolean interrupted) {
    mDrivetrain.setSpeed(0, 0);
  }
}
