// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc5494.BizarBot2016.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5494.BizarBot2016.Robot;
import org.usfirst.frc5494.BizarBot2016.RobotMap;

/**
 *
 */
public class CommandFlippers extends Command {

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public CommandFlippers() {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
		requires(Robot.flippers);

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		double Lt = Robot.oi.joystickDriver.getRawAxis(2); // left trigger axis
		double Rt = Robot.oi.joystickDriver.getRawAxis(3); // right trigger axis

		if (Lt != 0.0) {
			// left trigger is being pressed
			//RobotMap.flippersRobotDrive21.tankDrive(Lt, -Lt);
			RobotMap.flippersFlipperLeft.set(Lt);
		}
		else if (Rt != 0) {
			// right trigger is being pressed
			//RobotMap.flippersRobotDrive21.tankDrive(-Rt, Rt);
			RobotMap.flippersFlipperRight.set(-Rt);
		}
		else {
			// both or being pressed, let's not break anything
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
