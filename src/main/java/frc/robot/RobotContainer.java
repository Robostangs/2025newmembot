// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.Drive_Command;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Intake_Command;
import frc.robot.subsystems.Drive_Train;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.XboxController;


public class RobotContainer {
  // The robot's subsystems and commands are defined here
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  private final Drive_Train m_drivetrain = new Drive_Train();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }


  
  private void configureBindings() {
    m_drivetrain.setDefaultCommand(
    new Drive_Command(
        ()-> -m_driverController.getLeftX(),
        ()-> -m_driverController.getLeftY(), 
        ()-> m_driverController.getRightX()));
    new Intake_Command(
    );
    

    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }

  
  public Command getAutonomousCommand() {

    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
