
public class Partita {
	private MotoreGioco motore;
	private int errori;
	
	public Partita() {
		motore = new MotoreGioco();
		this.errori = 0;
	}

	public int getErrori() {
		return errori;
	}

	public void setErrori(int errori) {
		this.errori = errori;
	}
	
	public MotoreGioco getMotoreGioco() {
		return motore;
	}
	
	//true non ho ancora perso
	//false se sono >=
	public boolean checkErrori() {
		return errori < motore.getDifficolta().getErroriMax();
	}
	
	public boolean areGriglieUguali() {
		final int DIM = motore.getGriglia().getDIM();
		for (int rig=0; rig < DIM; rig++) {
			for (int col=0; col < DIM; col++) {
				if (motore.getGriglia().getValoreCella(rig, col) != motore.getGrigliaIrrisolta().getValoreCella(rig, col)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public int mossa(int val, int rigSel, int colSel) {
		//se fuori range
		if ((rigSel < 1 || rigSel > 9) || (colSel < 1 || colSel > 9)) {
			return -2;
		}
		
		//se già occupata
		if (motore.getGrigliaIrrisolta().getCella(rigSel-1, colSel-1).isFixed()) { 
			return -1;
		}
		
		//se sbagliata
		if (motore.getGriglia().getValoreCella(rigSel-1, colSel-1) != val) {
			errori++;
			return 0;
		}
		
		//tutto ok
		motore.getGrigliaIrrisolta().setValoreCella(val, rigSel-1, colSel-1);
		return val;
	}
}
