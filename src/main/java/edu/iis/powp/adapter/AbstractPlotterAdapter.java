package edu.iis.powp.adapter;

import edu.iis.client.plottermagic.AbstractPlotter;
import edu.iis.client.plottermagic.IPlotter;

public class AbstractPlotterAdapter extends AbstractPlotter implements IPlotter {

//	Teraz pozycja jest synchronizowana ze stanem wewnętrznym obiektu AbstractPlotter za każdym wywołaniem drawTo()
//	Ten adapter w takiej implementacji jest adapterem obiektu, ponieważ zawiera
//  instancję obiektu adaptowanego(jest kompozytem) i polega na tej zależności
	IPlotter adaptee;
	
	public AbstractPlotterAdapter(int x, int y, IPlotter adaptee) {
		super(x, y);
		this.adaptee = adaptee;
		adaptee.setPosition(x, y);
	}

	@Override
	public void drawTo(int arg0, int arg1) {
		// TODO Auto-generated method stub
		adaptee.setPosition(super.getX(), super.getY());
		adaptee.drawTo(arg0, arg1);
		super.setPosition(arg0, arg1);
	}
	
}
