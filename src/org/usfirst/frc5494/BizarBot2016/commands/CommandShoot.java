package org.usfirst.frc5494.BizarBot2016.commands;

import org.usfirst.frc5494.BizarBot2016.Robot;
import org.usfirst.frc5494.BizarBot2016.RobotMap;

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
		// 2 at the same time on same button
		
		// 2 others independently
		
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
