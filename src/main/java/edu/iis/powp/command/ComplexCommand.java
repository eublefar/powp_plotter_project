package edu.iis.powp.command;

import java.util.ArrayList;

import edu.iis.client.plottermagic.IPlotter;

public class ComplexCommand extends ArrayList<PlotterCommand> implements PlotterCommand {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	public void execute(IPlotter plotter) {
		// TODO Auto-generated method stub
		for(PlotterCommand c : this) {
			c.execute(plotter);
		}
	}

}
