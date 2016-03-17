package org.usfirst.frc5494.BizarBot2016.commands;

import org.usfirst.frc5494.BizarBot2016.Robot;
import org.usfirst.frc5494.BizarBot2016.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class CommandShoot extends Command
{
	public CommandShoot()
	{
		requires(Robot.shooter);
	}
	
	@Override
	protected void interrupted()
	{
	}

	@Override
	protected void initialize()
	{
	}
		
	@Override
	protected void execute()
	{
		boolean b = Robot.oi.joystickOperator.getRawButton(1); // on  // a or b
		boolean x = Robot.oi.joystickOperator.getRawButton(2); // off // b or x
		Value cv = RobotMap.shooterSolenoid1.get(); // solenoid current value;
		
		// if solenoids are off, set them to reverse position
		if (cv == Value.kOff) {
			RobotMap.shooterSolenoid1.set(Value.kReverse);
			RobotMap.shooterSolenoid2.set(Value.kReverse);
		}
		
		// solenoids are in reverse
		if (cv == Value.kReverse) {
			// if the on button is being pressed
			if (b) {
				RobotMap.shooterVacuum.set(0);
				RobotMap.shooterSolenoid3.set(true);
				RobotMap.shooterSolenoid1.set(Value.kForward);
				RobotMap.shooterSolenoid2.set(Value.kForward);
			}
		}
		
		// solenoids are forward
		if (cv == Value.kForward) {
			// if the off button is being pressed
			if (x) {
				RobotMap.shooterSolenoid1.set(Value.kReverse);
				RobotMap.shooterSolenoid2.set(Value.kReverse);
				RobotMap.shooterSolenoid3.set(false);
				RobotMap.shooterVacuum.set(1);
			}
		}
		
		// angle adjuster
		//double distance = RobotMap.encoder.getDistance();
		RobotMap.shooterAngler.set(-Robot.oi.joystickOperator.getRawAxis(4)); // right j x axis
		
		
	}

	@Override
	protected boolean isFinished()
	{
		return false;
	}

	@Override
	protected void end() 
	{
	}
}
