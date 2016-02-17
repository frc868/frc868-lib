package org.usfirst.frc.team868.robot.commands;

import org.usfirst.frc.team868.robot.OI;

import com.techhounds.sensors.BNO055;

import edu.wpi.first.wpilibj.GyroBase;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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

	// Smartdashboard labels for Gyro angles
	private static final String GYROX_ANGLE = "BNO055 GyroX Angle";
	private static final String GYROY_ANGLE = "BNO055 GyroY Angle";
	private static final String GYROZ_ANGLE = "BNO055 GyroZ Angle";

	// Private single instance to BNO0555 sensor
	private static BNO055 sensor = null;
	
	// Used to demo Gyro implementation provided by sensor
	private GyroBase gyrox;
	private GyroBase gyroy;
	private GyroBase gyroz;

	@Override
	protected void initialize() {
		// Construct instance on first invocation
		if (sensor == null) {
			sensor = BNO055.getInstance(I2C.Port.kOnboard);

			// Check to see if gyro objects show up in test mode
			String group = "BNO055";
			LiveWindow.addSensor(group, "Gyro (x)", sensor.createGyroX());
			LiveWindow.addSensor(group, "Gyro (y)", sensor.createGyroY());
			LiveWindow.addSensor(group, "Gyro (z)", sensor.createGyroZ());
		}
		
		// Demo of Gyro implementation
		gyrox = sensor.createGyroX();
		gyroy = sensor.createGyroY();
		gyroz = sensor.createGyroZ();
	}

	@Override
	protected void execute() {
		int verbosity = OI.getInstance().getVerbosity();
		sensor.updateDashboard(verbosity);
		SmartDashboard.putNumber(GYROX_ANGLE, gyrox.getAngle());
		SmartDashboard.putNumber(GYROY_ANGLE, gyroy.getAngle());
		SmartDashboard.putNumber(GYROZ_ANGLE, gyroz.getAngle());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		NetworkTable nt = NetworkTable.getTable("SmartDashboard");
		nt.delete(GYROX_ANGLE);
		nt.delete(GYROY_ANGLE);
		nt.delete(GYROZ_ANGLE);
		sensor.clearDashboard();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
