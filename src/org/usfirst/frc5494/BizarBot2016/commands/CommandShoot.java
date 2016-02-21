package org.usfirst.frc5494.BizarBot2016.commands;

import org.usfirst.frc5494.BizarBot2016.Robot;

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
		//RobotMap.shooterSolenoid1;
		//RobotMap.shooterSolenoid2;
		//RobotMap.shooterSolenoid3;
		//RobotMap.shooterSolenoid4;
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
