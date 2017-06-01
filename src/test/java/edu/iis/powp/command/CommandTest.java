package edu.iis.powp.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.client.plottermagic.preset.FiguresJoe;
import edu.iis.powp.adapter.MyAdapter;
import edu.kis.powp.drawer.panel.DefaultDrawerFrame;
import edu.kis.powp.drawer.panel.DrawPanelController;
import factory.CommandFactory;
import factory.ComplexPatternFactory;
import factory.SquareCommandFactory;

public class CommandTest {
	public static void main(String[] args) throws IOException, NoSuchMethodException, SecurityException {
		  DrawPanelController controller = new DrawPanelController();
	      DefaultDrawerFrame.getDefaultDrawerFrame().setVisible(true);
	      IPlotter myPlotter = new MyAdapter(controller);
	      CommandFactory factory = new SquareCommandFactory(10, 10, 100, 100);
	      ComplexCommand cc = factory.getCommand();
	      cc.execute(myPlotter);
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	      br.readLine();
	      controller.clearPanel();
	      factory = new ComplexPatternFactory(FiguresJoe.class.getMethod("figureScript1", IPlotter.class));
	      cc = factory.getCommand();
	      cc.execute(myPlotter);
	}
}
