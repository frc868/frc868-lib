package org.usfirst.frc.team868.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * Standard Robot class for a Command based WPILIB robot.
 * 
 * <p>
 * This implementation is minimal - and only does enough work to provide testing
 * of the library code.
 * </p>
 */
public class Robot extends IterativeRobot {

	/**
	 * Run when robot code is first loaded and started up (initialization).
	 */
	public void robotInit() {
		// Initialize controls and buttons
		OI.getInstance();
	}

	/**
	 * Code to run when robot first enters the disabled state.
	 */
	public void disabledInit() {

	}

	/**
	 * Code to run while the robot is in the disabled state.
	 */
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * Autonomous initialization code.
	 */
	public void autonomousInit() {
		// Do nothing autonomous
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * Operator control initialization.
	 */
	public void teleopInit() {
		// Nothing special to do
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
