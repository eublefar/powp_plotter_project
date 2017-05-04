package factory;

import java.util.Arrays;

import edu.iis.powp.command.ComplexCommand;
import edu.iis.powp.command.DrawLineToCommand;
import edu.iis.powp.command.SetPositionCommand;

public class TriangleCommandFactory implements CommandFactory {

	private int x1,x2,x3,y1,y2,y3;
	
	public TriangleCommandFactory(int x1, int x2, int x3, int y1, int y2, int y3) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.x3 = x3;
		this.y1 = y1;
		this.y2 = y2;
		this.y3 = y3;
	}

	@Override
	public ComplexCommand getCommand() {
		
		
		ComplexCommand cc = new ComplexCommand();
		cc.addAll( Arrays.asList(	new SetPositionCommand(x1,y1),
									new DrawLineToCommand(x2,y2),
									new DrawLineToCommand(x3,y3),
									new DrawLineToCommand(x1,y1)));
		return cc;
	}

}
