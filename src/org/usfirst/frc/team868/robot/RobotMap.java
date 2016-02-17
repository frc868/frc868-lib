package org.usfirst.frc.team868.robot;

import com.techhounds.lib.sensors.BNO055;

import edu.wpi.first.wpilibj.I2C;

/**
 * Constants indicating how the various sensors supported by the library are
 * connected and configured (only used when sensors are tested).
 */
public class RobotMap {

	/*
	 * BNO055 connection options.
	 */

	// The I2C port the BNO055 sensor is connected to
	public static final I2C.Port BNO055_PORT = I2C.Port.kOnboard;

	// The I2C address of the BNO055 sensor connected to the robot.
	public static final int BNO055_ADDR = BNO055.BNO055_ADDRESS_A;

	/*
	 * ITG-3200 connection options.
	 */

	// Which I2C bus the ITG-3200 is connected to
	public static final I2C.Port ITG3200_PORT = I2C.Port.kMXP;

	// Set to true if you have added a jumper to the ITG-3200 to change its I2C
	// address
	public static final boolean ITG3200_JUMPERED = false;
}
