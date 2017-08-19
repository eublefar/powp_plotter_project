package edu.iis.powp.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.iis.client.plottermagic.AbstractPlotter;
import edu.iis.client.plottermagic.ClientPlotter;
import edu.iis.client.plottermagic.IPlotter;
import edu.iis.client.plottermagic.preset.FiguresJane;
import edu.iis.client.plottermagic.preset.FiguresJoe;
import edu.iis.powp.adapter.LinePlotterAdapter;
import edu.iis.powp.adapter.MyAdapter;
import edu.iis.powp.app.Application;
import edu.iis.powp.app.Context;
import edu.iis.powp.app.DriverManager;
import edu.iis.powp.appext.ApplicationWithDrawer;
import edu.iis.powp.events.predefine.SelectChangeVisibleOptionListener;
import edu.iis.powp.events.predefine.SelectTestFigureOptionListener;
import edu.iis.powp.shape.line.MyLineFactory;
import edu.kis.powp.drawer.panel.DefaultDrawerFrame;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.LineFactory;
import edu.kis.powp.drawer.shape.line.SpecialLine;
import factory.SquareCommandFactory;
import factory.TriangleCommandFactory;


public class TestPlotSoftPatterns
{
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
		
    /**
	 * Setup test concerning preset figures in context.
	 * 
	 * @param context Application context.
     * @throws SecurityException 
     * @throws NoSuchMethodException 
	 */
	private static void setupPresetTests(Context context) throws NoSuchMethodException, SecurityException {		
		SelectTestFigureOptionListener listener = new SelectTestFigureOptionListener(FiguresJoe.class.getMethod("figureScript1", IPlotter.class));
		context.addTest("Figure Joe 1", listener);	
		SelectTestFigureOptionListener listener1 = new SelectTestFigureOptionListener(FiguresJoe.class.getMethod("figureScript2", IPlotter.class));
		context.addTest("Figure Joe 2", listener1);
		SelectTestFigureOptionListener listener2 = new SelectTestFigureOptionListener(new SquareCommandFactory(0, 0, 60, 60).getCommand());
		context.addTest("Square", listener2);
		SelectTestFigureOptionListener listener3 = new SelectTestFigureOptionListener(new TriangleCommandFactory(0, 0, 60, 60, 120, 0).getCommand());
		context.addTest("Triangle", listener3);
		
		SelectTestFigureOptionListener listener4 = new SelectTestFigureOptionListener(FiguresJane.class.getMethod("figureScript", AbstractPlotter.class));
		context.addTest("Figure Jane", listener4);
		
		
	}

	/**
	 * Setup driver manager, and set default IPlotter for application.
	 * 
	 * @param context Application context.
	 */
	private static void setupDrivers(Context context) {
		IPlotter clientPlotter = new ClientPlotter();
		context.addDriver("Client Plotter", clientPlotter);
		Application.getComponent(DriverManager.class).setCurrentPlotter(clientPlotter);
		
		IPlotter plotter = new MyAdapter();
		context.addDriver("Buggy Simulator", plotter);

		plotter = new LinePlotterAdapter(ApplicationWithDrawer.getDrawPanelController(),MyLineFactory.getSpecialLine());
		context.addDriver("Special line simulator", plotter);
		
		plotter = new LinePlotterAdapter(ApplicationWithDrawer.getDrawPanelController(),MyLineFactory.getBasicLine());
		context.addDriver("Basic line simulator", plotter);
		
		plotter = new LinePlotterAdapter(ApplicationWithDrawer.getDrawPanelController(),MyLineFactory.getDottedLine());
		context.addDriver("Dotted line simulator", plotter);
		
		context.updateDriverInfo();
	}

	/**
	 * Auxiliary routines to enable using Buggy Simulator.
	 * 
	 * @param context Application context.
	 */
	private static void setupDefaultDrawerVisibilityManagement(Context context) {
		DefaultDrawerFrame defaultDrawerWindow = DefaultDrawerFrame.getDefaultDrawerFrame();
        context.addComponentMenuElementWithCheckBox(DrawPanelController.class, "Default Drawer Visibility", 
        		new SelectChangeVisibleOptionListener(defaultDrawerWindow), false);
        defaultDrawerWindow.setVisible(false);
	}
	
	/**
	 * Setup menu for adjusting logging settings.
	 * 
	 * @param context Application context.
	 */
	private static void setupLogger(Context context) {
		Application.addComponent(Logger.class);
		context.addComponentMenu(Logger.class, "Logger", 0);
		context.addComponentMenuElement(Logger.class, "Clear log", (ActionEvent e) -> context.flushLoggerOutput());
		context.addComponentMenuElement(Logger.class, "Fine level", (ActionEvent e) -> LOGGER.setLevel(Level.FINE));
		context.addComponentMenuElement(Logger.class, "Info level", (ActionEvent e) -> LOGGER.setLevel(Level.INFO));
		context.addComponentMenuElement(Logger.class, "Warning level", (ActionEvent e) -> LOGGER.setLevel(Level.WARNING));
		context.addComponentMenuElement(Logger.class, "Severe level", (ActionEvent e) -> LOGGER.setLevel(Level.SEVERE));
		context.addComponentMenuElement(Logger.class, "OFF logging", (ActionEvent e) -> LOGGER.setLevel(Level.OFF));
	}
		
    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                ApplicationWithDrawer.configureApplication();
                Context context = Application.getComponent(Context.class);
                
                setupDefaultDrawerVisibilityManagement(context);
                
            	setupDrivers(context);
            	try {
					setupPresetTests(context);
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	setupLogger(context);
            }

        });
    }

}
