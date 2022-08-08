package net.sf.openrocket.montecarlo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import net.sf.openrocket.document.Simulation;
import net.sf.openrocket.gui.SpinnerEditor;
import net.sf.openrocket.gui.adaptors.DoubleModel;
import net.sf.openrocket.gui.components.BasicSlider;
import net.sf.openrocket.gui.components.UnitSelector;
import net.sf.openrocket.plugin.Plugin;
import net.sf.openrocket.simulation.exception.SimulationException;
import net.sf.openrocket.simulation.extension.AbstractSwingSimulationExtensionConfigurator;
import net.sf.openrocket.simulation.extension.SimulationExtension;
import net.sf.openrocket.unit.UnitGroup;

/**
 * The Swing configuration dialog for the extension.
 * 
 * 
 * The abstract implementation provides a ready JPanel using MigLayout
 * to which you can build the dialog. 
 */
@Plugin
public class MCSimulationConfigurator extends AbstractSwingSimulationExtensionConfigurator<MCSimulationExtension> {
	
	public MCSimulationConfigurator() {
		super(MCSimulationExtension.class);
	}
	
	@Override
	protected JComponent getConfigurationComponent(MCSimulationExtension extension, Simulation simulation, JPanel panel) {
		extension.setGlobalWindDirection(simulation.getOptions().getWindDirection());
		extension.setGlobalWindSpeed(simulation.getOptions().getWindSpeedAverage());
		
		double existingFlightTime = simulation.getSimulatedData().getFlightTime();

		final JLabel test = new JLabel();
//		JLabel message = new JLabel();
//		JLabel message1 = new JLabel();
//		JLabel message2 = new JLabel();
//		JLabel message3 = new JLabel();
//		JLabel message4 = new JLabel();
//		JLabel message5 = new JLabel();
//		JLabel message6 = new JLabel();
//		JLabel message7 = new JLabel();
//		JLabel message8 = new JLabel();
//		JLabel message9 = new JLabel();
		test.setText("Initial flight time: " + existingFlightTime);
//		panel.add(message);
//		panel.add(message1);
//		panel.add(message2);
//		panel.add(message3);
//		panel.add(message4);
//		panel.add(message5);
//		panel.add(message6);
//		panel.add(message7);
//		panel.add(message8);
//		panel.add(message9);
		
		final Simulation sim = simulation;		
		
		final MCSimulationExtension ex = extension;
		
		JButton simButton = new JButton("Simulate");
		simButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	           // test.setText("Ok Button is clicked here");
	            try {
	            	 // Gets all possible values for the simulated data
	            	sim.simulate(new MCSimulationListener(ex));
					double ft = sim.getSimulatedData().getFlightTime();
//					int branchCount = sim.getSimulatedData().getBranchCount();
//					double deployVel = sim.getSimulatedData().getDeploymentVelocity();
//					double groundVel = sim.getSimulatedData().getGroundHitVelocity();
//					double launchRodVel = sim.getSimulatedData().getLaunchRodVelocity();
//					double maxAcc = sim.getSimulatedData().getMaxAcceleration();
//					double maxAlt = sim.getSimulatedData().getMaxAltitude();
//					double maxMach = sim.getSimulatedData().getMaxMachNumber();
//					double maxVel = sim.getSimulatedData().getMaxVelocity();
//					double timetoApogee = sim.getSimulatedData().getTimeToApogee();
//					
//					//add to text window (ignore horrible string names...)
//					JLabel message = new JLabel("New flight time: " + ft);
//					JLabel message1 = new JLabel("New branch count: " + branchCount);
//					JLabel message3 = new JLabel("New ground velocity: " + groundVel);
//					JLabel message4 = new JLabel("New launch rod velocity: " + launchRodVel);
//					JLabel message5 = new JLabel("New max acceleration: " + maxAcc);
//					JLabel message6 = new JLabel("New max altitude: " + maxAlt);
//					JLabel message7 = new JLabel("New max Mach Number: " + maxMach);
//					JLabel message8 = new JLabel("New max velocity: " + maxVel);
//					JLabel message9 = new JLabel("New time to apogee: " + timetoApogee);
//					
//					panel.add(message);
//					panel.add(message1);
//					panel.add(message2);
//					panel.add(message3);
//					panel.add(message4);
//					panel.add(message5);
//					panel.add(message6);
//					panel.add(message7);
//					panel.add(message8);
//					panel.add(message9);
					
					test.setText("New Flight Time: " + sim.getSimulatedData().getFlightTime());
				} catch (SimulationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	         }

			
	      });
		panel.add(simButton);
		
		return panel;
	}
	

	
}
