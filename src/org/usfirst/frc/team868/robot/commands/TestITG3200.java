package org.usfirst.frc.team868.robot.commands;

import org.usfirst.frc.team868.robot.OI;
import org.usfirst.frc.team868.robot.RobotMap;

import com.techhounds.sensors.ITG3200;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A command that allows you to test the Gyro component on the ITG-3200 sensor.
 * 
 * <p>When this command is run, it will get access to the ITG-3200 sensor and
 * start dumping diagnostic information about the sensor to the dashboard. The
 * user can control how much information is displayed via the smart dashboard
 * verbosity level setting.</p>
 */
public final class TestITG3200 extends Command {
	
	private static ITG3200 sensor = null;

	public TestITG3200() {
	}

	@Override
	protected void initialize() {
		if (sensor == null) {
			sensor  = new ITG3200(RobotMap.ITG3200_PORT, RobotMap.ITG3200_JUMPERED);
		}
		sensor.start();
	}

	@Override
	protected void execute() {
		int verbosity = OI.getInstance().getVerbosity();
		sensor.updateDashboard("ITG-3200", verbosity > 5);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		sensor.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
