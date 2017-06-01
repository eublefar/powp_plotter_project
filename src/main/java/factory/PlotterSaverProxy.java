package factory;

import java.util.ArrayList;
import java.util.List;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.command.PlotterCommand;

public class PlotterSaverProxy implements IPlotter {

	private List<PlotterCommand> executed;
	private static CommandPool commandPool = new CommandPool();
	
	public PlotterSaverProxy() {
		super();
		executed = new ArrayList<>();
	}
	
	@Override
	public void drawTo(int arg0, int arg1) {
		// TODO Auto-generated method stub
		executed.add(commandPool.getDrawTo(arg0, arg1));
		System.out.println("drawTO" + arg0 + " " + arg1);
	}

	@Override
	public void setPosition(int arg0, int arg1) {
		// TODO Auto-generated method stub
		executed.add(commandPool.getSetPosition(arg0, arg1));
		System.out.println("setpos" + arg0 + " " + arg1);
	}

	public List<PlotterCommand> getExecuted() {
		return executed;
	}



}
