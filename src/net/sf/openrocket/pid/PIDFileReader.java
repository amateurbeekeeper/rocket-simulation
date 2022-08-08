package net.sf.openrocket.pid;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PIDFileReader {
	static String COMMA_DELIMITER = ",";

	
	
	//csv
	public static void main(String[] args) {
		ArrayList<PIDParameters> instance = new ArrayList<PIDParameters>();
		// CSV file path need to improve
		//File csv = new File(csv); 
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("csv"));
			String line;
			try {
				while ((line = br.readLine()) != null) {
					String[] values = line.split(COMMA_DELIMITER);
					PIDParameters p = null;
					System.out.print(values.toString());
					if (values.length == 21 && values!=null) {
						p.LaunchInfo.setLaunchLatitude(Double.parseDouble(values[0]));
						p.LaunchInfo.setLaunchLongitude(Double.parseDouble(values[1]));
						p.weatherParameters.setWindSpeed(Double.parseDouble(values[2]));
						p.weatherParameters.setWindSpeedStdDev(Double.parseDouble(values[3]));
						p.LaunchInfo.setLaunchAngle(Double.parseDouble(values[4]));
						p.LaunchInfo.setLaunchAngleStdDev(Double.parseDouble(values[5]));
						p.LaunchInfo.setLaunchDirection(Double.parseDouble(values[6]));
						p.LaunchInfo.setLaunchDirectionStdDev(Double.parseDouble(values[7]));
						p.LaunchInfo.setLaunchTemperature(Double.parseDouble(values[8]));
						p.LaunchInfo.setTemperatureStdDev(Double.parseDouble(values[9]));
						p.LaunchInfo.setLaunchAltitude(Double.parseDouble(values[10]));
						p.LaunchInfo.setLaunchPressure(Double.parseDouble(values[11]));
						p.LaunchInfo.setPressureStdDev(Double.parseDouble(values[12]));
						p.LaunchInfo.setLaunchRodLength(Double.parseDouble(values[13]));
						p.weatherParameters.setWindTurbulenceIntensity(Double.parseDouble(values[14]));
						p.LaunchInfo.setMotorPerformanceMean(Double.parseDouble(values[15]));
						p.LaunchInfo.setMotorPerformanceStdDev(Double.parseDouble(values[16]));
						p.LaunchInfo.setNumSims(Double.parseDouble(values[17]));
						p.LaunchInfo.setTimeToOpenParachuteStdDev(Double.parseDouble(values[18]));
						p.weatherParameters.setWindDirectionStdDev(Double.parseDouble(values[19]));
						p.weatherParameters.setWindDirection(Double.parseDouble(values[20]));
						
						
						instance.add(p);

					}
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(instance);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
	}

}
