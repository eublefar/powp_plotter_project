package factory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import edu.iis.powp.command.ComplexCommand;

public class ComplexPatternFactory implements CommandFactory {
	Method figure;
	
	
	
	public ComplexPatternFactory(Method figure) {
		super();
		this.figure = figure;
	}



	@Override
	public ComplexCommand getCommand() {
		PlotterSaverProxy plotter = new PlotterSaverProxy();
		try {
			figure.invoke(null, plotter);
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			return new ComplexCommand();
		}
		ComplexCommand cc = new ComplexCommand();
		cc.addAll(plotter.getExecuted());
		return cc;
	}

}

