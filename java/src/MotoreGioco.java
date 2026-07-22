
public class MotoreGioco {
	private Griglia griglia;
	private Griglia grigliaIrrisolta;
	private Difficolta difficolta;
	private int[] numMancanti;

	public MotoreGioco() {
		griglia = new Griglia();
		grigliaIrrisolta = new Griglia();
		numMancanti = new int[9];
		difficolta = new Difficolta(0, 0);
	}

	public Griglia getGriglia() {
		return griglia;
	}
	
	public Difficolta getDifficolta() {
		return difficolta;
	}

	public Griglia getGrigliaIrrisolta() {
		return grigliaIrrisolta;
	}
	
	public Griglia generaSudoku() {
		int rig, col;
		boolean trovato;
		int tentativi;
		int nuovaCella;
		int i;
		int inizioR, inizioC;
		int x, y;
		final int DIM = griglia.getDIM();
		
        for (rig=0; rig<DIM; rig++) {
        	for (col=0; col<DIM; col++) {
        		griglia.setValoreCella(0, rig, col);
        	}
        }
        
        for (rig=0; rig<DIM; rig++) {
        	for (col=0; col<DIM; col++) {
        		
        		tentativi = 0;
        		
        		do {
        			trovato = false;
        			nuovaCella = (int)(Math.random()*9+1); //STEP 4
        			
        			//ricerca sulle righe
        			i=0; while(i<col && !trovato) {
        				if (nuovaCella == griglia.getValoreCella(rig, i)) {
        					trovato = true;
        				}
        				i++;
        			}
        			
        			//ricerca sulle colonne
	    			i=0; while(i<rig && !trovato) {
	    				if (nuovaCella == griglia.getValoreCella(i, col)) {
	    					trovato = true;
	    				}
	    				i++;
	    			}
        			
	    			inizioR = rig - (rig % 3);
	    			inizioC = col - (col % 3);
	    			
	    			x = inizioR;
	    			while (x < inizioR + 3 && !trovato) {
	    			    y = inizioC;
	    			    while (y < inizioC + 3 && !trovato) {
	    			        if (nuovaCella == griglia.getValoreCella(x, y)) {
	    			            trovato = true;
	    			        }
	    			        y++;
	    			    }
	    			    x++;
	    			}
	    			tentativi++;
        		} while (trovato && tentativi < 50);
        		
        		if (tentativi < 50) {
        			griglia.setValoreCella(nuovaCella, rig, col);
        		} else {
        			for (i=0; i<DIM; i++) {
        				griglia.setValoreCella(0, rig, i);
        			}
        			
        			rig--; if (rig < 0) rig = 0;
    				col = -1;
        		}
        		
        	} //fine for colonne
        	
        } //fine for righe
        
        return griglia;
	}
	
	public void generaSudokuIrrisolto(int livelloDiff) {
		switch (livelloDiff) {
    	case 1:
    		difficolta.setCelleCoperte(0.4);
    		difficolta.setErroriMax(5);
    		break;
    	
    	case 2:
    		difficolta.setCelleCoperte(0.5);
    		difficolta.setErroriMax(3);
    		break;
    	
    	case 3:
    		difficolta.setCelleCoperte(0.7);
    		difficolta.setErroriMax(2);
    		break;
    	
    	case 4:
    		difficolta.setCelleCoperte(0.8);
    		difficolta.setErroriMax(1);
    		break;
		
		default:
			break;
		}
		
		irrisolutore();
	}
	
	public void generaSudokuIrrisolto(double percentualeCelleCoperte, int erroriMax) {
		percentualeCelleCoperte = percentualeCelleCoperte / 100;
		difficolta = new Difficolta(percentualeCelleCoperte, erroriMax);
		irrisolutore();
	}
	
	private void irrisolutore() {
		int rig, col;
		int i;
		final int DIM = griglia.getDIM();
		
		for (rig=0; rig<DIM; rig++) {
        	for (col=0; col<DIM; col++) {
        		grigliaIrrisolta.setValoreCella(griglia.getValoreCella(rig, col), rig, col);
        		grigliaIrrisolta.getCella(rig, col).setFixed(true);
        	}
        }
        
        int celleCoperte = (int)(DIM*DIM*difficolta.getCelleCoperte());
        
        for(i=0; i<celleCoperte; i++) {
			do {
				rig = (int)(Math.random()*9);
				col = (int)(Math.random()*9);
			} while(grigliaIrrisolta.getValoreCella(rig, col) == 0);
			
			grigliaIrrisolta.setValoreCella(0, rig, col);
			grigliaIrrisolta.getCella(rig, col).setFixed(false);
		}
	}
	
	public int[] calcolaNumMancati() {
		int i, rig, col, valore;
		final int DIM = griglia.getDIM();
		
		for (i=0; i<9; i++) {
	        numMancanti[i] = 9;
	    }
		
		for (rig=0; rig<DIM; rig++) {
        	for (col=0; col<DIM; col++) {
        		valore = grigliaIrrisolta.getValoreCella(rig, col);
        		//se la cella non è vuota posso contarla
        		if (valore > 0) {
        			numMancanti[valore-1]--;
        		}
        	}
    	}
		
		return numMancanti;
	}
	
	public String numMancantiToString() {
		int i;
		String s = "";
		
		s += "Numeri:  ";
    	for (i=1; i<=9; i++) s += String.format("%2d", i);
    	s += "\n";
    	
    	numMancanti = calcolaNumMancati();
    	
    	s += "Mancanti:";
    	for (i=0; i<9; i++) {
    		s += String.format("%2d", numMancanti[i]);
    	}
    	
    	return s;
	}
}
