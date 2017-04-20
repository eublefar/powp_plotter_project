package factory;

import java.util.Arrays;

import edu.iis.powp.command.ComplexCommand;
import edu.iis.powp.command.DrawLineToCommand;
import edu.iis.powp.command.SetPositionCommand;

public class SquareCommandFactory implements CommandFactory {

	private int x1,x2,y1,y2;
	public SquareCommandFactory(int x1_p,int y1_p,int x2_p,int y2_p) {
		x1 = x1_p;
		x2 = x2_p;
		y1 = y1_p;
		y2 = y2_p;
	}
	
	@Override
	public ComplexCommand getCommand() {
		ComplexCommand cc = new ComplexCommand();
		cc.addAll( Arrays.asList(	new SetPositionCommand(x1,y1),
									new DrawLineToCommand(x2,y1),
									new DrawLineToCommand(x2,y2),
									new DrawLineToCommand(x1,y2),
									new DrawLineToCommand(x1,y1)));
		return cc;
	}

}
