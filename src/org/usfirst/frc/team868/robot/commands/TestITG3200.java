package org.usfirst.frc.team868.robot.commands;

import org.usfirst.frc.team868.robot.OI;
import org.usfirst.frc.team868.robot.RobotMap;

import com.techhounds.sensors.ITG3200;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * A command that allows you to test the Gyro component on the ITG-3200 sensor.
 * 
 * <p>
 * When this command is run, it will construct an instance of {@class ITG3200}
 * (on first invocation) and then start dumping diagnostic information about the
 * sensor to the dashboard. The user can control how much information is
 * displayed via the smart dashboard verbosity level setting.
 * </p>
 */
public final class TestITG3200 extends Command {

	// Single instance of sensor (constructed first time required)
	private static ITG3200 sensor = null;

	@Override
	protected void initialize() {
		// Construct instance on first invocation
		if (sensor == null) {
			sensor = new ITG3200(RobotMap.ITG3200_PORT,
					RobotMap.ITG3200_JUMPERED);
			// Check to see if gyro objects show up in test mode
			String group = "ITG-3200";
			LiveWindow.addSensor(group, "Gyro (x)", sensor.getGyroX());
			LiveWindow.addSensor(group, "Gyro (y)", sensor.getGyroY());
			LiveWindow.addSensor(group, "Gyro (z)", sensor.getGyroZ());
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
		sensor.clearDashboard("ITG-3200");
		sensor.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
