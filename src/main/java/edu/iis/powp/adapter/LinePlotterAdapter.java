package edu.iis.powp.adapter;

import edu.iis.client.plottermagic.IPlotter;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.ILine;

public class LinePlotterAdapter implements IPlotter {
	
    public LinePlotterAdapter(DrawPanelController controller, ILine line) {
		super();
		this.controller = controller;
		this.line = line;
	}

	private DrawPanelController controller;
	private ILine line; 
	private int x = 0, y = 0;


	@Override
	public void drawTo(int x, int y) {
        line.setStartCoordinates(this.x, this.y);
        line.setEndCoordinates(x, y);
        controller.drawLine(line);
        this.setPosition(x, y);
	}

	@Override
	public void setPosition(int arg0, int arg1) {
		x=arg0;
		y=arg1;
	}
	
    public String toString()
    {
    	return "Line adapter driver";
    }

}
