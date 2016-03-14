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
		boolean b = Robot.oi.joystickOperator.getRawButton(1);
		boolean x = Robot.oi.joystickOperator.getRawButton(2);
		
		if (b) {
			RobotMap.shooterSolenoid1.set(Value.kForward);
			RobotMap.shooterSolenoid2.set(Value.kForward);
		}
		if (x) {
			RobotMap.shooterSolenoid1.set(Value.kReverse);
			RobotMap.shooterSolenoid2.set(Value.kReverse);
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
