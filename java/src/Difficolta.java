
public class Difficolta {
	private double celleCoperte; //valore normalizzato (0.0 - 1.0)
	private int erroriMax;
	
	public Difficolta(double celleCoperte, int erroriMax) {
		this.celleCoperte = celleCoperte;
		this.erroriMax = erroriMax;
	}
	
	public double getCelleCoperte() {
		return celleCoperte;
	}
	
	public void setCelleCoperte(double celleCoperte) {
		this.celleCoperte = celleCoperte;
	}
	
	public int getErroriMax() {
		return erroriMax;
	}
	
	public void setErroriMax(int erroriMax) {
		this.erroriMax = erroriMax;
	}
	
	
}
