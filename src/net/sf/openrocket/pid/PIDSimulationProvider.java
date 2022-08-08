package net.sf.openrocket.pid;

import net.sf.openrocket.montecarlo.MCSimulationExtension;
import net.sf.openrocket.plugin.Plugin;
import net.sf.openrocket.simulation.extension.AbstractSimulationExtensionProvider;

/**
 * The simulation extension provider.  This is the OpenRocket
 * plugin, which defines the simulation extension class and where
 * it is displayed in the menu.
 */
@Plugin
public class PIDSimulationProvider extends AbstractSimulationExtensionProvider {
	
	public PIDSimulationProvider() {
		//what if change String "Monte Carlo" to "PID Controller"?
		super(MCSimulationExtension.class, "PID Controller", "PID Controller");
	}
	
}
