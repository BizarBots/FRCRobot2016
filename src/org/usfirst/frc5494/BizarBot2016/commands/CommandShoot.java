package org.usfirst.frc5494.BizarBot2016.commands;

import org.usfirst.frc5494.BizarBot2016.Robot;
import org.usfirst.frc5494.BizarBot2016.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Timer;
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
		boolean ob1 = Robot.oi.joystickOperator.getRawButton(1);
		boolean ob2 = Robot.oi.joystickOperator.getRawButton(2);
		Value cv = RobotMap.shooterSolenoid1.get(); // solenoid current value;
		
		// if solenoids are off, set them to reverse position
		if (cv == Value.kOff) {
			RobotMap.shooterSolenoid1.set(Value.kReverse);
			RobotMap.shooterSolenoid2.set(Value.kReverse);
		}
		
		// solenoids are in reverse
		if (cv == Value.kReverse) { // a
			// if the on button is being pressed
			if (ob1) {
				RobotMap.shooterVacuum1.set(0);
				RobotMap.shooterVacuum2.set(0);
				RobotMap.shooterVacuum3.set(0);
				RobotMap.shooterSolenoid3.set(true);
				Timer.delay(0.5);
				RobotMap.shooterSolenoid1.set(Value.kForward);
				RobotMap.shooterSolenoid2.set(Value.kForward);
			}
		}
		
		// solenoids are forward
		if (cv == Value.kForward) { // b
			// if the off button is being pressed
			if (ob2) {
				RobotMap.shooterSolenoid1.set(Value.kReverse);
				RobotMap.shooterSolenoid2.set(Value.kReverse);
				Timer.delay(0.2);
				RobotMap.shooterSolenoid3.set(false);
				RobotMap.shooterVacuum1.set(1);
				RobotMap.shooterVacuum2.set(1);
				RobotMap.shooterVacuum3.set(1);
			}
		}
		
		// angle adjuster
		//double distance = RobotMap.encoder.getDistance();
		
		
		
		
		double oa2 = Robot.oi.joystickOperator.getRawAxis(2); // operator left trigger
		double oa3 = Robot.oi.joystickOperator.getRawAxis(3); // operator right trigger
		
		if (oa2 > 0) {
			RobotMap.shooterAngler.set(oa2);
		}
		else if (oa3 > 0) {
			RobotMap.shooterAngler.set(-oa3);
		}
		else {
			RobotMap.shooterAngler.set(0);
		}
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
