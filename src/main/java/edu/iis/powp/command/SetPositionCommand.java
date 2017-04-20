package edu.iis.powp.command;

import edu.iis.client.plottermagic.IPlotter;

public class SetPositionCommand implements PlotterCommand {

	private int x,y;
	
	 public SetPositionCommand(int x_p, int y_p) {
		x = x_p;
		y = y_p;
	}
	
	@Override
	public void execute(IPlotter plotter) {
		plotter.setPosition(x, y);
	}

}
