package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	
	private static int TIME_STARTINDEX = 11; 

	public static int toSeconds(String timestr) {
		
		int secs;
		int hr, min, sec;
		
		String[] splStrings = timestr.split("[T//Z]");
		String[] time = splStrings[1].split("[://.]");
		hr = Integer.parseInt(time[0]);
		min = Integer.parseInt(time[1]);
		sec = Integer.parseInt(time[2]);

		secs = hr*3600 + min*60 + sec;

		return secs;
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint = new GPSPoint(
			toSeconds(timeStr),
			Double.parseDouble(latitudeStr),
			Double.parseDouble(longitudeStr),
			Double.parseDouble(elevationStr));
		return gpspoint;
		
	}
	
}
