package org.usfirst.frc.team868.robot.commands;

import org.usfirst.frc.team868.robot.OI;

import com.techhounds.sensors.BNO055;

import edu.wpi.first.wpilibj.command.Command;

/**
 * A command that allows you to test the Gyro component on the BNO055 sensor.
 * 
 * <p>When this command is run, it will get access to the BNO055 sensor and
 * start dumping diagnostic information about the sensor to the dashboard. The
 * user can control how much information is displayed via the smart dashboard
 * verbosity level setting.</p>
 */
public final class TestBNO055 extends Command {
	
	private static BNO055 sensor = null;

	public TestBNO055() {
	}

	@Override
	protected void initialize() {
		if (sensor == null) {
			sensor  = BNO055.getInstance(BNO055.opmode_t.OPERATION_MODE_NDOF, BNO055.vector_type_t.VECTOR_GYROSCOPE);
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
	}

	@Override
	protected void interrupted() {
	}

}
