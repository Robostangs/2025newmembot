// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.Drive_Command;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.Drive_Train;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {
  public static final CommandXboxController xDrive = new CommandXboxController(0);
  private final Drive_Train drivetrain = Drive_Train.getInstance();

  Subsystem m_drivetrain;
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    configureDefaultCommands();
  }
  //Tammy is not him he black as hell, slow as hell,
 

  
  private void configureBindings() {
    drivetrain.setDefaultCommand(
      new Drive_Command(
          ()-> -m_driverController.getLeftX(),
          ()-> -m_driverController.getLeftY(),
          ()-> m_driverController.getRightX()));
        

    
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    
    m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
  }
 
  private void configureDefaultCommands() {
  

     
      // m_driverController.rightTrigger().whileTrue(new ShootCommand(m_shooter, () -> m_driverController.getRightTriggerAxis()));
  }

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}
