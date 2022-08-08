package net.sf.openrocket.montecarlo;

import net.sf.openrocket.simulation.SimulationConditions;
import net.sf.openrocket.simulation.exception.SimulationException;
import net.sf.openrocket.simulation.extension.AbstractSimulationExtension;
import net.sf.openrocket.simulation.extension.SimulationExtension;

/**
 * The actual simulation extension.  A new instance is created for
 * each simulation it is attached to.
 * 
 * 
 * This class contains the configuration and is called before the
 * simulation is run.  It can do changes to the simulation, such
 * as add simulation listeners.
 * 
 * All configuration should be stored in the config variable, so that
 * file storage will work automatically.
 */
public class MCSimulationExtension extends AbstractSimulationExtension {
	
	@Override
	public String getName() {
		String label = "Monte Carlo Simulation";
	return label;
	}
	
	
	@Override
	public String getDescription() {
		// This description is shown when the user clicks the info-button on the extension
		return "This extension allows the user to run a Monte Carlo simulation with given parameters.";
	}
	
	private double globalWindSpeed = 0.0;
	private double globalWindDirection = 0.0;
	
	@Override
	public void initialize(SimulationConditions conditions) throws SimulationException {
		conditions.getSimulationListenerList().add(new MCSimulationListener(this));
		
		//doing?
		//conditions.getSimulation().simulate(arg0);
		
		System.out.println("LRA: " + conditions.getLaunchRodAngle());
		
		double randomAdj = Math.random();
		double newLaunchAngle = conditions.getLaunchRodAngle() + randomAdj;
		
		System.out.println("New LRA: " + newLaunchAngle);
		
		conditions.setLaunchRodAngle(newLaunchAngle);
	}
	
	
	//This is where we would add the 3 parameters!!??
	@Override
	public SimulationExtension clone() {
		MCSimulationExtension copy = (MCSimulationExtension) super.clone();
		copy.setGlobalWindSpeed(this.globalWindSpeed);
		copy.setGlobalWindDirection(this.globalWindDirection);
		return copy;
	}
	
	public void setGlobalWindSpeed(double val) {
		globalWindSpeed = val;
	}
	
	
	
	public void setGlobalWindDirection(double val) {
		globalWindDirection = val;
	}

}
