package org.usfirst.frc.team868.robot.commands;

import org.usfirst.frc.team868.robot.OI;
import org.usfirst.frc.team868.robot.RobotMap;

import com.techhounds.lib.sensors.ITG3200;

import edu.wpi.first.wpilibj.GyroBase;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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

	// Smartdashboard labels for Gyro angles
	private static final String GYROX_ANGLE = "ITG-3200 GyroX Angle";
	private static final String GYROY_ANGLE = "ITG-3200 GyroY Angle";
	private static final String GYROZ_ANGLE = "ITG-3200 GyroZ Angle";

	// Single instance of sensor (constructed first time required)
	private static ITG3200 sensor = null;
	
	// Used to demo Gyro implementation provided by sensor
	private GyroBase gyrox;
	private GyroBase gyroy;
	private GyroBase gyroz;

	@Override
	protected void initialize() {
		// Construct instance on first invocation
		if (sensor == null) {
			sensor = new ITG3200(RobotMap.ITG3200_PORT,
					RobotMap.ITG3200_JUMPERED);
			// Check to see if gyro objects show up in test mode
			String group = "ITG-3200";
			LiveWindow.addSensor(group, "Gyro (x)", sensor.createGyroX());
			LiveWindow.addSensor(group, "Gyro (y)", sensor.createGyroY());
			LiveWindow.addSensor(group, "Gyro (z)", sensor.createGyroZ());
		}
		sensor.start();
		
		// Demo of Gyro implementation
		gyrox = sensor.createGyroX();
		gyroy = sensor.createGyroY();
		gyroz = sensor.createGyroZ();
	}

	@Override
	protected void execute() {
		int verbosity = OI.getInstance().getVerbosity();
		sensor.updateDashboard("ITG-3200", verbosity > 5);
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
		sensor.clearDashboard("ITG-3200");
		NetworkTable nt = NetworkTable.getTable("SmartDashboard");
		nt.delete(GYROX_ANGLE);
		nt.delete(GYROY_ANGLE);
		nt.delete(GYROZ_ANGLE);
		sensor.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}

}
