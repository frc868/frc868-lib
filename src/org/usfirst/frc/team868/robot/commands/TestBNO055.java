package org.usfirst.frc.team868.robot.commands;

import org.usfirst.frc.team868.robot.OI;

import com.techhounds.sensors.BNO055;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * A command that allows you to test the Gyro component on the BNO055 sensor.
 * 
 * <p>
 * When this command is run, it will create a {@link BNO055} object (if not done
 * so by a prior invocation) and start dumping diagnostic information about the
 * sensor to the dashboard. The user can control how much information is
 * displayed via the smart dashboard verbosity level setting.
 * </p>
 */
public final class TestBNO055 extends Command {

	// Private single instance to BNO0555 sensor
	private static BNO055 sensor = null;

	@Override
	protected void initialize() {
		// Construct instance on first invocation
		if (sensor == null) {
			sensor = BNO055.getInstance(BNO055.opmode_t.OPERATION_MODE_NDOF,
					BNO055.vector_type_t.VECTOR_EULER);

			// Check to see if gyro objects show up in test mode
			String group = "BNO055";
			LiveWindow.addSensor(group, "Gyro (x)", sensor.getGyroX());
			LiveWindow.addSensor(group, "Gyro (y)", sensor.getGyroY());
			LiveWindow.addSensor(group, "Gyro (z)", sensor.getGyroZ());
		}
	}

	@Override
	protected void execute() {
		int verbosity = OI.getInstance().getVerbosity();
		sensor.updateDashboard(verbosity);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		sensor.clearDashboard();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
