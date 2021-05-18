package application;

/**
 * Berechnet das Formelrad
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
	private double p;
	private double u;
	private double i;
	private double r;
	
	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.p = leistung;
		this.u = spannung;
		this.i = strom;
		this.r = widerstand;
	}
	
	public double getLeistung() {
		return p;
	}
	
	public double getSpannung() {
		return u;
	}

	public double getStrom() {
		return i;
	}

	public double getWiderstand() {
		return r;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + p +
				", spannung=" + u +
				", strom=" + i +
				", widerstand="	+ r + "]";
	}

	public void calculate() {
		/* Hier auf Grund der vorhanden Werte entscheiden
		 * welche Methode unten aufgerufen werden muss.
		 */
		int given = 0;
		if(p != 0.0) {
			given++;
		}
		if(u != 0.0) {
			given++;
		}
		if(r != 0.0) {
			given++;
		}
		if(i != 0.0) {
			given++;
		}
		if(given > 2) {
			System.out.println("Warnung: Mehr als 2 Parameter angegeben!");
		}

		if(p == 0.0) {
			if(u == 0.0) {
				u = UAusRUndI(r, i);
				p = pAusRundI(r, i);
			}
			else if(i == 0.0) {
				p = pAusUundR(u, r);
				i = iAusUundR(u, r);
			}
			else if(r == 0.0) {
				p = pAusUundI(u, i);
				r = RAusUUndI(u, i);
			}
			else {
				p = pAusRundI(r, i);
			}
		}
		if(u == 0.0) {
			if(i == 0.0) {
				u = UAusPUndR(p, r);
				i = iAusPundR(p, r);
			}
			else if(r == 0.0) {
				u = UAusPUndI(p, i);
				r = RAusPUndI(p, i);
			}
			else {
				u = UAusPUndR(p, r);
			}
		}
		if(i == 0.0) {
			if(r == 0.0) {
				i = iAusPundU(p, u);
				r = RAusUUndP(u, p);
			}
			else {
				i = iAusPundU(p, u);
			}
		}
		if(r==0.0) {
			r = RAusUUndP(u, p);
		}
	}
	public double pAusUundI(double u, double i) {
		return u*i;
	}
	public double pAusUundR(double u, double r) {
		return u*u/r;
	}
	public double pAusRundI(double r, double i) {
		return r*i*i;
	}
	/* Hier die Methoden mit den Formlen hinzuf�gen
	 */

	//Alle Methoden zur Berechnung der Spannung U aus zwei bekannten Grössen
	public double UAusRUndI(double r, double i){
		return r*i;
	}

	public double UAusPUndI(double p, double i){
		return p/i;
	}

	public double UAusPUndR(double p, double r){
		return Math.sqrt(p*r);
	}

	public double iAusPundR(double p, double r) {
		return Math.sqrt(p/r);
	}
	public double iAusPundU(double p, double u) {
		return p/u;
	}
	public double iAusUundR(double u, double r) {
		return u/r;
	}

	//Alle Methoden zur Berechnung des Widerstandes R aus zwei bekannten Grössen
	public double RAusUUndP(double u, double p){
		return Math.pow(u,2)/p;
	}

	public double RAusPUndI(double p, double i){
		return p/Math.pow(i,2);
	}

	public double RAusUUndI(double u, double i){
		return u/i;
	}

}
