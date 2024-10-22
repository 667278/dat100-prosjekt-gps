package no.hvl.dat100ptc.oppgave1;

public class Main {

	public static void main(String[] args) {
		
		// TODO
		GPSPoint pungt = new GPSPoint(1, 2.0, 3.0, 5.0);

		System.out.println("høgde: " + pungt.getElevation());
		pungt.setTime(2);
		System.out.println(pungt.toString());
	}

}
