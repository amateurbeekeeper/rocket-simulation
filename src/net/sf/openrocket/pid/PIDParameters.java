package net.sf.openrocket.pid;

public class PIDParameters {
	//pid
	public launchInfo LaunchInfo;
	public weatherParameters weatherParameters;
	
	public PIDParameters(launchInfo LaunchInfo,weatherParameters weatherParameters) {
		this.setLaunchInfo(LaunchInfo);
		this.weatherParameters = weatherParameters;
	}
	
	
	public weatherParameters getWeatherParameters() {
		return weatherParameters;
	}

	public void setWeatherParameters(weatherParameters weatherParameters) {
		this.weatherParameters = weatherParameters;
	}


	public launchInfo getLaunchInfo() {
		return LaunchInfo;
	}


	public void setLaunchInfo(launchInfo launchInfo) {
		LaunchInfo = launchInfo;
	}


	public class launchInfo {
		private double launchLatitude;
		private double launchLongitude;
		private double launchAngle;
		private double launchAngleStdDev;
		private double launchDirection;
		private double launchDirectionStdDev;
		private double launchTemperature;
		private double temperatureStdDev;
		private double launchAltitude;
		private double launchPressure;
		private double pressureStdDev;
		private double launchRodLength;
		private double motorPerformanceMean;
		private double motorPerformanceStdDev;
		private double numSims;
		private double timeToOpenParachuteStdDev;




		public launchInfo(double launchLatitude,double launchLongitude,double launchAngle,double launchAngleStdDev,
				double launchDirection,double launchDirectionStdDev,double launchTemperature,double temperatureStdDev,
				double launchAltitude,double launchPressure,double pressureStdDev,double launchRodLength,double motorPerformanceMean,
				double motorPerformanceStdDev,double numSims,double timeToOpenParachuteStdDev) {
			
			this.launchLatitude = launchLatitude;
			this.launchLongitude = launchLongitude;
			this.launchAngle = launchAngle;
			this.launchAngleStdDev = launchAngleStdDev;
			this.launchDirection = launchDirection;
			this.launchAngleStdDev = launchAngleStdDev;
			this.launchTemperature = launchTemperature;
			this.temperatureStdDev = temperatureStdDev;
			this.launchAltitude = launchAltitude;
			this.launchPressure = launchPressure;
			this.pressureStdDev = pressureStdDev;
			this.launchRodLength = launchRodLength;
			this.motorPerformanceMean = motorPerformanceMean;
			this.motorPerformanceStdDev = motorPerformanceStdDev;
			this.numSims = numSims;
			this.timeToOpenParachuteStdDev = timeToOpenParachuteStdDev;
			

		}




		public double getLaunchLatitude() {
			return launchLatitude;
		}




		public void setLaunchLatitude(double launchLatitude) {
			this.launchLatitude = launchLatitude;
		}




		public double getLaunchLongitude() {
			return launchLongitude;
		}




		public void setLaunchLongitude(double launchLongitude) {
			this.launchLongitude = launchLongitude;
		}




		public double getLaunchAngle() {
			return launchAngle;
		}




		public void setLaunchAngle(double launchAngle) {
			this.launchAngle = launchAngle;
		}




		public double getLaunchAngleStdDev() {
			return launchAngleStdDev;
		}




		public void setLaunchAngleStdDev(double launchAngleStdDev) {
			this.launchAngleStdDev = launchAngleStdDev;
		}




		public double getLaunchDirection() {
			return launchDirection;
		}




		public void setLaunchDirection(double launchDirection) {
			this.launchDirection = launchDirection;
		}




		public double getLaunchDirectionStdDev() {
			return launchDirectionStdDev;
		}




		public void setLaunchDirectionStdDev(double launchDirectionStdDev) {
			this.launchDirectionStdDev = launchDirectionStdDev;
		}




		public double getLaunchTemperature() {
			return launchTemperature;
		}




		public void setLaunchTemperature(double launchTemperature) {
			this.launchTemperature = launchTemperature;
		}




		public double getTemperatureStdDev() {
			return temperatureStdDev;
		}




		public void setTemperatureStdDev(double temperatureStdDev) {
			this.temperatureStdDev = temperatureStdDev;
		}




		public double getLaunchAltitude() {
			return launchAltitude;
		}




		public void setLaunchAltitude(double launchAltitude) {
			this.launchAltitude = launchAltitude;
		}




		public double getLaunchPressure() {
			return launchPressure;
		}




		public void setLaunchPressure(double launchPressure) {
			this.launchPressure = launchPressure;
		}




		public double getPressureStdDev() {
			return pressureStdDev;
		}




		public void setPressureStdDev(double pressureStdDev) {
			this.pressureStdDev = pressureStdDev;
		}




		public double getLaunchRodLength() {
			return launchRodLength;
		}




		public void setLaunchRodLength(double launchRodLength) {
			this.launchRodLength = launchRodLength;
		}




		public double getMotorPerformanceMean() {
			return motorPerformanceMean;
		}




		public void setMotorPerformanceMean(double motorPerformanceMean) {
			this.motorPerformanceMean = motorPerformanceMean;
		}




		public double getMotorPerformanceStdDev() {
			return motorPerformanceStdDev;
		}




		public void setMotorPerformanceStdDev(double motorPerformanceStdDev) {
			this.motorPerformanceStdDev = motorPerformanceStdDev;
		}




		public double getNumSims() {
			return numSims;
		}




		public void setNumSims(double numSims) {
			this.numSims = numSims;
		}




		public double getTimeToOpenParachuteStdDev() {
			return timeToOpenParachuteStdDev;
		}




		public void setTimeToOpenParachuteStdDev(double timeToOpenParachuteStdDev) {
			this.timeToOpenParachuteStdDev = timeToOpenParachuteStdDev;
		}

		

	}

	public class weatherParameters {
		

		private double windSpeed;
		private double windSpeedStdDev;
		private double windTurbulenceIntensity;
		private double windDirectionStdDev;
		private double windDirection;

		public weatherParameters(double windSpeed,double windSpeedStdDev,double windTurbulenceIntensity,
				double windDirectionStdDev,double windDirection) {
			this.windSpeed = windSpeed;
			this.windSpeedStdDev = windSpeedStdDev;
			this.windTurbulenceIntensity = windTurbulenceIntensity;
			this.windSpeedStdDev = windSpeedStdDev;
			this.windDirection = windDirection;
			
			
		}
		
		public double getWindSpeed() {
			return windSpeed;
		}

		public void setWindSpeed(double windSpeed) {
			this.windSpeed = windSpeed;
		}

		public double getWindSpeedStdDev() {
			return windSpeedStdDev;
		}

		public void setWindSpeedStdDev(double windSpeedStdDev) {
			this.windSpeedStdDev = windSpeedStdDev;
		}

		public double getWindTurbulenceIntensity() {
			return windTurbulenceIntensity;
		}

		public void setWindTurbulenceIntensity(double windTurbulenceIntensity) {
			this.windTurbulenceIntensity = windTurbulenceIntensity;
		}

		public double getWindDirectionStdDev() {
			return windDirectionStdDev;
		}

		public void setWindDirectionStdDev(double windDirectionStdDev) {
			this.windDirectionStdDev = windDirectionStdDev;
		}

		public double getWindDirection() {
			return windDirection;
		}

		public void setWindDirection(double windDirection) {
			this.windDirection = windDirection;
		}

	}
}
