package edu.iis.powp.events.predefine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Function;

import edu.iis.client.plottermagic.AbstractPlotter;
import edu.iis.client.plottermagic.IPlotter;
import edu.iis.client.plottermagic.preset.FiguresJoe;
import edu.iis.powp.adapter.AbstractPlotterAdapter;
import edu.iis.powp.app.Application;
import edu.iis.powp.app.DriverManager;
import edu.iis.powp.command.PlotterCommand;

public class SelectTestFigureOptionListener implements ActionListener
{
	
	Method figure;
	PlotterCommand command;
	
	public SelectTestFigureOptionListener( Method method) {
		// TODO Auto-generated constructor stub
		command =null;
		this.figure = method;
	}
	
	public SelectTestFigureOptionListener(PlotterCommand c) throws NoSuchMethodException, SecurityException {
		this.figure = PlotterCommand.class.getMethod("execute", IPlotter.class);
		this.command = c;
	}
	
    @Override
    public void actionPerformed(ActionEvent e)
    {
			try {
				//handle all the adaptations here
				HashSet<Class> parameterSet = new HashSet<>(Arrays.asList(figure.getParameterTypes()));
				IPlotter plotter = Application.getComponent(DriverManager.class).getCurrentPlotter();
				if(parameterSet.contains(AbstractPlotter.class)){
					plotter.setPosition(0, 0);
					figure.invoke(null, new AbstractPlotterAdapter(0,0,plotter));
				} else if(parameterSet.contains(IPlotter.class)){
					if(command == null) {
						figure.invoke(null, Application.getComponent(DriverManager.class).getCurrentPlotter());
					} else {
						figure.invoke(command, Application.getComponent(DriverManager.class).getCurrentPlotter());
					}
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
