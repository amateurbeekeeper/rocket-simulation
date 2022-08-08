package net.sf.openrocket.montecarlo;

import net.sf.openrocket.plugin.Plugin;
import net.sf.openrocket.simulation.extension.AbstractSimulationExtensionProvider;

/**
 * 
 * The simulation extension provider.  This is the OpenRocket
 * plugin, which defines the simulation extension class and where
 * it is displayed in the menu.
 */
@Plugin
public class MCSimulationProvider extends AbstractSimulationExtensionProvider {
	
	public MCSimulationProvider() {
		super(MCSimulationExtension.class, "Monte Carlo Simulator", "Monte Carlo");
	}
	
}
