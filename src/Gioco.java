public class Gioco {
	/*@spec_public@*/ int[] mano;
	private /*@spec_public@*/ int[] vincitori;
	private /*@spec_public@*/ int vittoria;
	private /*@spec_public@*/ int controllo;
	
	//@public invariant  mano!=null;
	//@public invariant vincitori!=null;
	//@public invariant (\forall int x; 0<=x &&  x<vincitori.length; vincitori[x]>=-1 && vincitori[x]<=1);
	
	
	//In input voglio almeno un giocatore
		//@requires giocatori > 0 && giocatori < 1000;
	
	//Inserisco anche qua le stesse condizioni dell'invariante in quanto l'invariante funziona dopo il costruttore
		//@ensures mano!= null;
		//@ensures vincitori!=null;
	
	//Controllo che vittoria venga impostata a -1;
		//@ensures vittoria == -1;
	
	//Controllo che i vettori mano e vincitori siano della lunghezza corretta
		//@ensures (mano.length == giocatori) && (vincitori.length == giocatori);
	//Controllo che i vettori mano e vincitori siano inizializzati a zero
		//@ensures (\forall int x; 0<=x &&  x<giocatori; mano[x]==0 && vincitori[x]==0);
	public Gioco(int giocatori) {
		//All'inizio nessuno ha vinto
		this.vittoria = -1;
		this.mano = new int[giocatori];
		this.vincitori = new int[giocatori];
		//@loop_invariant (\forall int x; 0<=x &&  x<i; mano[x]==0 && vincitori[x]==0);
		//@loop_invariant i >= 0;
		for(int i = 0; i < giocatori; i++) {
			this.mano[i] = 0;
			this.vincitori[i] = 0;
		}
	}
	
	
	
	//@diverges true;
	
	//Richiedo che il vettore delle pescate sia lungo uguale al numero di giocatori
		//@requires pescate.length == mano.length;
	
	//Richiedo che il vettore delle pescate abbia numeri positivi, compresi tra uno e sette
		//@requires (\forall int x; 0<=x &&  x<pescate.length; pescate[x]>0 && pescate[x]<8);
	
	//Controllo che la mano piu la pescate non superi il numero 20
		//@requires (\forall int x; 0<=x &&  x<mano.length; (mano[x]+pescate[x])>=0 && (mano[x]+pescate[x])<=20);
	
	//Controllo che vittoria sia un numero compreso tra -1 (nessuno ha ancora vinto) e il numero dei giocatori
		//@ensures (vittoria >=-1) && (vittoria<=mano.length);
	
	//Controllo che in mano non abbia piu di 14
		//@ensures (\forall int x; 0<=x &&  x<mano.length; mano[x]>=0 && mano[x]<=14);
	
	//Controllo che il risultato sia compreso tra -1 ed il numero di giocatori
		//@ensures (\result >=-1) && (\result<=mano.length);
	public int giocata(int[] pescate) {
		if(vittoria == -1) {
			int i = 0;
			//@loop_invariant i>=0 && i<=mano.length;
			//@loop_invariant (\forall int x; 0<=x && x<i; mano[x]>=0 && mano[x]<=20);
			for(i = 0; i < mano.length; i++) {
				//Se non si ha ancora perso ne vinto allora si puo pescare
				if(vincitori[i] == 0)
					mano[i] = mano[i] + pescate[i];
			}
			primoControllo();
			//@assert (vittoria >=-1) && (vittoria<=mano.length);
			secondoControllo();
			//@assert (vittoria >=-1) && (vittoria<=mano.length);
		}
		return vittoria;
	}
	
	
	//@diverges true;
	
	//Tutti devono avere o vinto o perso o possono continuare a giocare
		//@ensures (\forall int x; 0<=x && x<vincitori.length; (vincitori[x]==-1) || (vincitori[x]==0) || (vincitori[x]==1));
	public void primoControllo() {
		this.controllo = 0;
		int i = 0;
		//Chi ha in mano piu di otto ha perso
			//@loop_invariant (\forall int x; 0<=x && x<i; (mano[x]>8) ==> (vincitori[x]==-1));
		//Chi ha in mano esattamente otto ha vinto
			//@loop_invariant (\forall int x; 0<=x && x<i; (mano[x]==8) ==> (vincitori[x]==1));
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
	

	//Tutti devono avere o vinto o perso o possono continuare a giocare
		//@ensures (\forall int x; 0<=x && x<mano.length; (vincitori[x]==-1) || (vincitori[x]==0) || (vincitori[x]==1));
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
				System.out.println("Giocatore " + i + " ha in mano: " + mano[i] + "-> LOSE!");
		}
		System.out.println("\n");
	}
}
