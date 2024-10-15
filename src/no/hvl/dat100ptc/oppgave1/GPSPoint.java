package no.hvl.dat100ptc.oppgave1;

public class GPSPoint {
	private int time;
	private double latitude;
	private double longitude;
	private double elevation;
	
	public GPSPoint(int time, double latitude, double longitude, double elevation) {
		this.time = time;
		this.latitude = latitude;
		this.longitude = longitude;
		this.elevation = elevation;
	}

	public int getTime() {
		return this.time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getElevation() {
		return this.elevation;
	}

	public void setElevation(double elevation) {
		this.elevation = elevation;
	}
	
	@Override public String toString() {
		
		String str = "";

		//opggave 1c format
		str += time + " ";
		str += "("+this.latitude+","+this.longitude+") ";
		str += this.elevation+"\n";

		//csv format
		//str = this.time + "," + this.latitude+ "," + this.longitude + "," + this.elevation;
		return str;

		// TODO andre format?
		
	}
}
