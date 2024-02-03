// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.tower;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.TowerConstants;
import frc.robot.subsystems.TowerSubsystem;

public class TowerIntake extends Command {

  /**
   * Creates a new TowerIntake.
   */

  private final TowerSubsystem tower;

  public TowerIntake(TowerSubsystem tower) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.tower = tower;
    addRequirements(tower);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (tower.getIsBallInTop()) {
      tower.setTopMotorOutputManual(0);
      if (tower.getIsBallInBottom()) {
        tower.setBottomMotorOutputManual(0);
      } else {
        tower.setBottomMotorOutputManual(TowerConstants.towerMotorSpeed);
      }
    } else {
      tower.setTopMotorOutputManual(TowerConstants.towerMotorSpeed);
      tower.setBottomMotorOutputManual(TowerConstants.towerMotorSpeed);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    tower.setTopMotorOutputManual(0);
    tower.setBottomMotorOutputManual(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
