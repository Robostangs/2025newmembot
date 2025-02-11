// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autos;
import frc.robot.commands.Deploy;
import frc.robot.commands.Drive_Command;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Spit;
import frc.robot.subsystems.Drive_Train;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;


//ADD TWO CONTROLLER STUFF


public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  
  Drive_Train mDrive_Train = Drive_Train.getInstance();
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final CommandXboxController m_maninpController =
      new CommandXboxController(OperatorConstants.kManinpControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {

    // Configure the trigger bindings
    configureBindings();

    mDrive_Train.setDefaultCommand(
      new Drive_Command(
        ()-> -m_driverController.getLeftY(),
        ()-> m_driverController.getRightY(), 
        ()-> m_driverController.getLeftX()));
  }
    
  //Tammy is not him he black as hell, slow as hell,
  

 
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));

    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.

    //telescope buttons 
    m_maninpController.getLeftY();
    m_maninpController.getRightY();
   
    //Intake buttons
    m_driverController.x().whileTrue(new Deploy());
    m_driverController.b().whileTrue(new Spit());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }
}