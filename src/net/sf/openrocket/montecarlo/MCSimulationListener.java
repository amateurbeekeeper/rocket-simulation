package net.sf.openrocket.montecarlo;

import net.sf.openrocket.simulation.SimulationStatus;
import net.sf.openrocket.simulation.exception.SimulationException;
import net.sf.openrocket.simulation.listeners.AbstractSimulationListener;

/**
 * 
 * The simulation listener that is attached to the simulation.
 * It is instantiated when the simulation run is started and the
 * methods are called at each step of the simulation.
 * I AM CHANGING THIS COMMENT AS A TEST
 */
public class MCSimulationListener extends AbstractSimulationListener {
	
	//private double multiplier;
	
//	public MCSimulationListener(double multiplier) {
//		super();
//		this.multiplier = multiplier;
//	}
	
	public MCSimulationListener(MCSimulationExtension mcsExtension) {
		 //TODO Auto-generated constructor stub
	}


//	@Override
//	public double postSimpleThrustCalculation(SimulationStatus status, double thrust) throws SimulationException {
//		return thrust * multiplier;
//	}
	
}
