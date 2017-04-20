package edu.iis.powp.command;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.adapter.MyAdapter;
import edu.kis.powp.drawer.panel.DefaultDrawerFrame;
import edu.kis.powp.drawer.panel.DrawPanelController;
import factory.CommandFactory;
import factory.SquareCommandFactory;

public class CommandTest {
	public static void main(String[] args) {
		  DrawPanelController controller = new DrawPanelController();
	      DefaultDrawerFrame.getDefaultDrawerFrame().setVisible(true);
	      IPlotter myPlotter = new MyAdapter(controller);
	      CommandFactory factory = new SquareCommandFactory(10, 10, 100, 100);
	      ComplexCommand cc = factory.getCommand();
	      cc.execute(myPlotter);
	}
}
