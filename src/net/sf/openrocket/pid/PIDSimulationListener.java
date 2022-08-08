package net.sf.openrocket.pid;

import net.sf.openrocket.simulation.SimulationStatus;
import net.sf.openrocket.simulation.exception.SimulationException;
import net.sf.openrocket.simulation.listeners.AbstractSimulationListener;

/**
 * The simulation listener that is attached to the simulation.
 * It is instantiated when the simulation run is started and t
 * methods are called at each step of the simulation.
 * I AM CHANGING THIS COMMENT AS A TEST. Adam
 */
public class PIDSimulationListener extends AbstractSimulationListener {
	
	private double multiplier;
	
	public PIDSimulationListener(double multiplier) {
		super();
		this.multiplier = multiplier;
	}
	
	@Override
	public double postSimpleThrustCalculation(SimulationStatus status, double thrust) throws SimulationException {
		return thrust * multiplier;
	}
	
	
	
}
