package edu.iis.powp.events.predefine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.Function;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.client.plottermagic.preset.FiguresJoe;
import edu.iis.powp.app.Application;
import edu.iis.powp.app.DriverManager;
import edu.iis.powp.command.PlotterCommand;

public class SelectTestFigureOptionListener implements ActionListener
{
	
	Method figure;
	PlotterCommand c;
	
	public SelectTestFigureOptionListener( Method method) {
		// TODO Auto-generated constructor stub
		c =null;
		this.figure = method;
	}
	
	public SelectTestFigureOptionListener(PlotterCommand c) throws NoSuchMethodException, SecurityException {
		this.figure = PlotterCommand.class.getMethod("execute", IPlotter.class);
		this.c = c;
	}
	
    @Override
    public void actionPerformed(ActionEvent e)
    {
			try {
				if(c == null) {
					figure.invoke(null, Application.getComponent(DriverManager.class).getCurrentPlotter());
				} else {
					figure.invoke(c, Application.getComponent(DriverManager.class).getCurrentPlotter());
				}
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    }
}
