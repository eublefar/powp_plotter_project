package factory;

import java.util.List;

import edu.iis.powp.command.DrawLineToCommand;
import edu.iis.powp.command.PlotterCommand;
import edu.iis.powp.command.SetPositionCommand;

public class CommandPool {
	DrawLineToCommand drawTo;
	SetPositionCommand setPosition;
	
	
	public CommandPool() {
		super();
		drawTo = new DrawLineToCommand(0, 0);
		setPosition = new SetPositionCommand(0, 0);
	}

	public PlotterCommand getDrawTo(int x, int y){
		drawTo.setX(x);
		drawTo.setY(y);
		return drawTo;
	}
	
	public PlotterCommand getSetPosition(int x, int y){
		setPosition.setX(x);
		setPosition.setY(y);
		return setPosition;
	}
}
