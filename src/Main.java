
public class Main {

	public static void main(String[] args) {
		
		Gioco g = new Gioco(6);
		int[] pescate = {1,5,3,3,3,3};
		 
		g.giocata(pescate);
		g.print();
		
		g.giocata(pescate);
		g.print();
		
		g.giocata(pescate);
		g.print();
		
		g.giocata(pescate);
		g.print();
		 
		
		
		Gioco g1 = new Gioco(3);
		int[] pescate1 = {1,2,3};
		
		//Violo la precondizione
		//int[] pescate1 = {1,22,3};
		
		g1.giocata(pescate1);
		g1.print();
		g1.giocata(pescate1);
		g1.print();
		g1.giocata(pescate1);
		g1.print();
		g1.giocata(pescate1);
		g1.print();
	}

}
