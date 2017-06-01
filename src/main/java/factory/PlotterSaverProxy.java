package factory;

import java.util.ArrayList;
import java.util.List;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.command.DrawLineToCommand;
import edu.iis.powp.command.PlotterCommand;
import edu.iis.powp.command.SetPositionCommand;

public class PlotterSaverProxy implements IPlotter {

	private List<PlotterCommand> executed;

	
	public PlotterSaverProxy() {
		super();
		executed = new ArrayList<>();
	}
	
	@Override
	public void drawTo(int arg0, int arg1) {
		// TODO Auto-generated method stub
		executed.add(new DrawLineToCommand(arg0, arg1));
		System.out.println("drawTO" + arg0 + " " + arg1);
	}

	@Override
	public void setPosition(int arg0, int arg1) {
		// TODO Auto-generated method stub
		executed.add(new SetPositionCommand(arg0, arg1));
		System.out.println("setpos" + arg0 + " " + arg1);
	}

	public List<PlotterCommand> getExecuted() {
		return executed;
	}



}
