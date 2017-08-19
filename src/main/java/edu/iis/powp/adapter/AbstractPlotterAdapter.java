package edu.iis.powp.adapter;

import edu.iis.client.plottermagic.AbstractPlotter;
import edu.iis.client.plottermagic.IPlotter;

public class AbstractPlotterAdapter extends AbstractPlotter implements IPlotter {

	IPlotter adaptee;
	
	public AbstractPlotterAdapter(int x, int y, IPlotter adaptee) {
		super(x, y);
		this.adaptee = adaptee;
		adaptee.setPosition(x, y);
	}

	@Override
	public void drawTo(int arg0, int arg1) {
		// TODO Auto-generated method stub
		adaptee.drawTo(arg0, arg1);
	}
	

}
