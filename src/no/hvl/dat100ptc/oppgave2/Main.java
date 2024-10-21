package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class Main {

	
	public static void main(String[] args) {
		
		GPSPoint point1 = new GPSPoint(1, 2.3, 3.4, 5.6);
		GPSPoint point2 = new GPSPoint(6, 5.4, 4.3, 2.1);
		
		GPSData gpsData = new GPSData(2);
		gpsData.insertGPS(point1);
		gpsData.insertGPS(point2);
		gpsData.print();
	}
}
