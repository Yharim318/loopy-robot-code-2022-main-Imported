package frc.robot.commands.testing;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ClimbSubsystem;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;

@Deprecated
public class ClimbManualSolenoidControl extends Command {

  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ClimbSubsystem m_climbSubsystem;

  private final BooleanSupplier m_setVertical, m_setAngled;
  /**
   *
   *
   * @param subsystem The climb subsystem used by this command.
   */
  public ClimbManualSolenoidControl(ClimbSubsystem subsystem, BooleanSupplier vertical, BooleanSupplier angled) {
    m_climbSubsystem = subsystem;
    addRequirements(m_climbSubsystem);  // Use addRequirements() to declare subsystem dependencies.

    m_setVertical = vertical;
    m_setAngled = angled;
  }

  @Override
  public void initialize() {
    m_climbSubsystem.setClimbAngled();
  }

  @Override
  public void execute() {
    if (m_setAngled.getAsBoolean()) {
      m_climbSubsystem.setClimbAngled();
    }
    if (m_setVertical.getAsBoolean()){
      m_climbSubsystem.setClimbVertical();
    }
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
