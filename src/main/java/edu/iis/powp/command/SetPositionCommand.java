package edu.iis.powp.command;

import edu.iis.client.plottermagic.IPlotter;

public class SetPositionCommand implements PlotterCommand {

	private int x,y;
	
	 public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public SetPositionCommand(int x_p, int y_p) {
		x = x_p;
		y = y_p;
	}
	
	@Override
	public void execute(IPlotter plotter) {
		plotter.setPosition(x, y);
	}

}
