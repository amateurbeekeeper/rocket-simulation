package net.sf.openrocket.montecarlo;

import org.slf4j.LoggerFactory;
import net.sf.openrocket.util.Coordinate;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

import net.sf.openrocket.document.Simulation;
import net.sf.openrocket.models.wind.PinkNoiseWindModel;
import org.slf4j.Logger;
import net.sf.openrocket.models.wind.WindModel;
import net.sf.openrocket.simulation.SimulationConditions;
import net.sf.openrocket.simulation.SimulationEngine;
import net.sf.openrocket.simulation.FlightData;
import net.sf.openrocket.simulation.SimulationOptions;
import net.sf.openrocket.simulation.exception.SimulationException;


public class MonteCarloSimulationModel implements WindModel
{

	public static class WindSpecs
	{
	    public final double altitude;
	    public final double speed;
	    public final double direction;
	    
	    
	    public WindSpecs(final double a, final double s, final double d) {
	        this.altitude = a;
	        this.speed = s;
	        this.direction = d;
	    }
	}

	private static final Logger log;
    private PinkNoiseWindModel mainWindModel;
    private List<MonteCarloSimulationModel.WindSpecs> windSpecs;
    
    public MonteCarloSimulationModel(final List<MonteCarloSimulationModel.WindSpecs> winds) {
        this.mainWindModel = new PinkNoiseWindModel(10);
        this.windSpecs = null;
        this.windSpecs = new ArrayList<MonteCarloSimulationModel.WindSpecs>();
        for (final MonteCarloSimulationModel.WindSpecs windSpec : winds) {
            this.windSpecs.add(new MonteCarloSimulationModel.WindSpecs(windSpec.altitude, windSpec.speed, windSpec.direction));
        }
        this.mainWindModel.setAverage(this.windSpecs.get(0).speed);
        this.mainWindModel.setDirection(this.windSpecs.get(0).direction);
    }
    
    public int getModID() {
        return 0;
    }
    
    public void setStandardDeviation(final double standardDeviation) {
        this.mainWindModel.setStandardDeviation(standardDeviation);
    }
    
    public void setTurbulenceIntensity(final double intensity) {
        this.mainWindModel.setTurbulenceIntensity(intensity);
    }
    
    public Coordinate getWindVelocity(final double time, final double altitude) {
        MonteCarloSimulationModel.WindSpecs last_m = null;
        for (final MonteCarloSimulationModel.WindSpecs m : this.windSpecs) {
            if (m.altitude >= altitude) {
                return this.interpolateWindVelocity(time, altitude, last_m, m);
            }
            last_m = m;
        }
        final Coordinate ret = this.interpolateWindVelocity(time, altitude, last_m, null);
        return ret;
    }
    
    private double interpolate(final double v1, final double v2, final double w) {
        return v1 + (v2 - v1) * w;
    }
    
    private String modelToString(final MonteCarloSimulationModel.WindSpecs m) {
        if (m == null) {
            return "(null)";
        }
        return String.format("%dft %ddegrees %dspeed", Math.round(m.altitude), Math.round(m.direction * 180.0 / 3.141592653589793), Math.round(m.speed));
    }
    
    private Coordinate interpolateWindVelocity(final double time, final double altitude, final MonteCarloSimulationModel.WindSpecs m1, final MonteCarloSimulationModel.WindSpecs m2) {
        double speed = 0.0;
        double direction = 0.0;
        if (m1 == null) {
            speed = m2.speed;
            direction = m2.direction;
        }
        else if (m2 == null) {
            speed = m1.speed;
            direction = m1.direction;
        }
        else {
            final double a = (altitude - m1.altitude) / (m2.altitude - m1.altitude);
            speed = this.interpolate(m1.speed, m2.speed, a);
            final double sinSum = (1.0 - a) * Math.sin(m1.direction) + a * Math.sin(m2.direction);
            final double cosSum = (1.0 - a) * Math.cos(m1.direction) + a * Math.cos(m2.direction);
            direction = Math.atan2(sinSum, cosSum);
        }
        this.mainWindModel.setAverage(speed);
        this.mainWindModel.setDirection(direction);
        final Coordinate ret = this.mainWindModel.getWindVelocity(time, altitude);
        MonteCarloSimulationModel.log.debug(String.format("interpolating alt %f between layers %s and %s returning %s", altitude, this.modelToString(m1), this.modelToString(m2), ret.toString()));
        return ret;
    }
    
    static {
        log = LoggerFactory.getLogger((Class)MonteCarloSimulationModel.class);
    }
    
    
    /**
     * Main class for running the OpenRocket simulation x amount of times
     * 
     * Currently returns error as we need to link up the run button with this class
     * so that  the input values can be included as currently null when run through the console. 
     */
    
    //Initialize
    static SimulationEngine simulator;
    static FlightData flightData;
    static SimulationConditions simulationCondition;
    
    //Array list for the user input data from initial OpenRocket simulation 
    static ArrayList<FlightData> dataList = new ArrayList<FlightData>();
    
    public static void main(String args[]) {
		int numSimRuns = 10;
		
		//runs simulation X times
		for (int i=0; i<numSimRuns; i++) {
			
		
			try {
				flightData = simulator.simulate(simulationCondition);
				dataList.add(flightData);
				System.out.println("SimNumber " + i + " " + flightData);
			} catch (SimulationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			System.out.println("Simulation starting...");
			
			while(!(flightData ==null)) {     
			    try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
    
    
}
