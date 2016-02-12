package org.usfirst.frc.team868.robot;

import org.usfirst.frc.team868.robot.commands.TestBNO055;
import org.usfirst.frc.team868.robot.commands.TestITG3200;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	// Single instance of the OI object
	private static OI instance;

	// Key used to for dashboard field allowing user to set diagnostic verbosity
	// level
	private static final String VERBOSITY_KEY = "Verbosity";

	/**
	 * Constructs a new instance of the OI and sets up controls.
	 */
	private OI() {
		// Add control so user can control how much information is dumped out
		SmartDashboard.putNumber(VERBOSITY_KEY, 0.0);

		// Add buttons to test the various sensors
		SmartDashboard.putData("Test BNO055", new TestBNO055());
		SmartDashboard.putData("Test ITG-3200", new TestITG3200());
	}

	/**
	 * Get access to the single instance of the OI class.
	 * 
	 * @return Reference to the OI singleton.
	 */
	public static OI getInstance() {
		if (instance == null) {
			instance = new OI();
		}
		return instance;
	}

	/**
	 * Used by commands that want to control how much verbose output to display.
	 * 
	 * @return A verbosity level the user can adjust (where larger values means
	 *         more junk on your dash board).
	 */
	public int getVerbosity() {
		Number verbosity = SmartDashboard.getNumber(VERBOSITY_KEY, 0);
		return verbosity.intValue();
	}
}
