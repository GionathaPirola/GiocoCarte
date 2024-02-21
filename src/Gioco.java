public class Gioco {
	int[] mano;
	private int[] vincitori;
	private int vittoria;
	private  int controllo;
	
	
	public Gioco(int giocatori) {
		//All'inizio nessuno ha vinto
		this.vittoria = -1;
		this.mano = new int[giocatori];
		this.vincitori = new int[giocatori];
		for(int i = 0; i < giocatori; i++) {
			this.mano[i] = 0;
			this.vincitori[i] = 0;
		}
	}
	
	
	public int giocata(int[] pescate) {
		if(vittoria == -1) {
			int i = 0;
			
			for(i = 0; i < mano.length; i++) {
				//Se non si ha ancora perso ne vinto allora si puo pescare
				if(vincitori[i] == 0)
					mano[i] = mano[i] + pescate[i];
			}
			primoControllo();
			secondoControllo();
		}
		return vittoria;
	}
	
	
	public void primoControllo() {
		this.controllo = 0;
		int i = 0;
		
		for(i = 0; i < mano.length; i++) {
			//Se in mano si ha piu di otto si perde
			if(mano[i] > 8)
				vincitori[i] = - 1;
			//Se in mano si ha esattamente otto, si vince
			if(mano[i] == 8) {
				vincitori[i] = 1;
				vittoria = i + 1;
			}
			//Se in mano si ha meno di otto, si puo continuare a giocare a patto che nessuno abbia fatto esattamente otto (Controllato nel secondo metodo)
			if(mano[i] < 8)
				controllo = controllo + 1; 
		}
	}
	

	public void secondoControllo() {
		for(int i = 0; i < mano.length; i++) {
			//Se in mano si ha meno di 8, pero qualcuno ha gia vinto allora si ha perso
			if(mano[i] < 8 && vittoria!=-1)
				vincitori[i] = -1;
			//Se in mano si ha mano di otto, pero tutti gli altri hanno tutti superato l'otto, allora si ha vinto
			else if(mano[i] < 8 && controllo == 1) {
				vincitori[i] = 1;
				vittoria = i + 1;
			}
		}
	}

	//Il metodo print viene escluso da jml per problemi di efficenza da parte del solver z3_4_3
	public void print() {
		for(int i = 0; i < mano.length; i++) {
			if(vincitori[i] == 1)
				System.out.println("Giocatore " + i + " ha in mano: " + mano[i] + "-> WIN!");
			else if(vincitori[i] == 0)
				System.out.println("Giocatore " + i + " ha in mano: " + mano[i] + "-> PUO GIOCARE");
			else
				System.out.println("Giocatore lol " + i + " ha in mano: " + mano[i] + "-> LOSE!");
		}
		System.out.println("\n");
	}
}
