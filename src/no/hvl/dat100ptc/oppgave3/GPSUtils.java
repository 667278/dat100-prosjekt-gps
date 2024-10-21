package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.TODO;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min; 
		
		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		
		return min;
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {
		
		double [] latitudesArray = new double[gpspoints.length];

		for (int i = 0; i < gpspoints.length; i++) {
			latitudesArray[i] = gpspoints[i].getLatitude();
		}
		return latitudesArray;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {
		
		double [] longitudesArray = new double[gpspoints.length];

		for (int i = 0; i < gpspoints.length; i++) {
			longitudesArray[i] = gpspoints[i].getLongitude();
		}
		return longitudesArray;

	}

	private static final int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double latitude1 = Math.toRadians(gpspoint1.getLatitude());
		double longitude1 = Math.toRadians(gpspoint1.getLongitude());
		double latitude2 = Math.toRadians(gpspoint2.getLatitude());
		double longitude2 = Math.toRadians(gpspoint2.getLongitude());
		
		double diffLatitude = latitude2-latitude1;
		double diffLongitude = longitude2-longitude1;
		
		double a = compute_a(latitude1, latitude2, diffLatitude, diffLongitude);
		double c = compute_c(a);
		double d = R * c;
		return d;
	}
	
	private static double compute_a(double phi1, double phi2, double deltaphi, double deltadelta) {
		return Math.sin(deltaphi/2)*Math.sin(deltaphi/2)+
				Math.cos(phi1)*Math.cos(phi2)*
				Math.sin(deltadelta/2)*Math.sin(deltadelta/2);
	}

	private static double compute_c(double a) {
		return 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	}

	
	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {
		
		int secs = gpspoint2.getTime()-gpspoint1.getTime();
		double distance = distance(gpspoint1, gpspoint2);
		double speed = distance/secs;
		return speed;
	}

	public static String formatTime(int secs) {
		
		String TIMESEP = ":";
		int hours = secs / 3600;
		int minutes = (secs % 3600) / 60;
		int seconds = secs % 60;
		String timestr = String.format("  %02d%s%02d%s%02d", hours, TIMESEP, minutes, TIMESEP, seconds);
		return timestr;
		
	}
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {
		String str = String.format("%10.2f", d);
		System.out.println(str);
		return str;
	}
}
