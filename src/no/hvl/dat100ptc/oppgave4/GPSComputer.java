package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

import no.hvl.dat100ptc.TODO;

public class GPSComputer {
	
	private GPSPoint[] gpspoints;
	
	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}
	
	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}
	
	public double totalDistance() {
		double tDistance = 0;
		for (int i = 0; i < gpspoints.length-1; i++) {
			double nyDistance = GPSUtils.distance(gpspoints[i+1],gpspoints[i]);
			tDistance += nyDistance;
		}
		return tDistance;
	}

	public double totalElevation() {
		double tElevation = 0;
		for (int i = 0; i < gpspoints.length-1; i++) {
			double elevationDiffrence = gpspoints[i+1].getElevation()-gpspoints[i].getElevation();
			if (elevationDiffrence > 0){
				tElevation += elevationDiffrence;
			}
		}
		return tElevation;
	}

	public int totalTime() {
		int time = gpspoints[gpspoints.length-1].getTime()-gpspoints[0].getTime();
		return time;
			}
		

	public double[] speeds() {
		double[] speeds = new double[gpspoints.length-1];
		for (int i = 0; i < gpspoints.length-1; i++) {
			double lengde = GPSUtils.distance(gpspoints[i+1],gpspoints[i]);
			double tid = gpspoints[i+1].getTime()-gpspoints[i].getTime();
			speeds[i] = lengde/tid;
		}
		return speeds;
	}
	
	public double maxSpeed() {
		double maxspeed = 0;
		for (int i = 0; i < gpspoints.length-1; i++) {
			if (GPSUtils.speed(gpspoints[i], gpspoints[i+1])> maxspeed)  {
				maxspeed = GPSUtils.speed(gpspoints[i],gpspoints[i+1]);
			}
			
		}
		return maxspeed;
	}

	public double averageSpeed() {
		double average = totalDistance()/totalTime();
		return average;
		
	}


	// conversion factor m/s to miles per hour (mps)
	public static final double MS = 2.23;

	public double kcal(double weight, int secs, double speed) {
		double met = 0;
		double speedmph = speed * MS;
		if (speed<10) {
			met = 4.0;
		}
		else if (10 < speedmph && speedmph < 12) {
			met = 6.0;
		}
		else if (12 < speedmph && speedmph < 14) {
			met = 8.0;
		}
		else if (14 < speedmph && speedmph < 16) {
			met = 10.0;
		}
		else if (16 < speedmph && speedmph < 18) {
			met = 12.0;
		}
		else if (18 < speedmph && speedmph < 20) {
			met = 14.0;
		}
		else {
			met = 16.0;
		}		
		double hrs = (double) secs / (60 * 60);
		double kcal = met*weight*hrs;
		return kcal/secs;
		}

	public double totalKcal(double weight) {
		
		double totalkcal = 0;
		
		for (int i = 0; i < gpspoints.length-1; i++) {
			
		}
		return totalkcal;
	}
	
	private static double WEIGHT = 80.0;
	
	public void displayStatistics() {

		// TODO 
		throw new UnsupportedOperationException(TODO.method());
		
	}

}
