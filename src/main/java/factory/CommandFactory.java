package factory;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.command.ComplexCommand;

public interface CommandFactory {
	ComplexCommand getCommand();
}
