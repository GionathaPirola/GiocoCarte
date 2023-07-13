import static org.junit.Assert.*;

import org.junit.Test;

public class TestGioco {

	@Test
	public void testIstruzioni() {

		//Test in cui qualcuno vince perchè gli altri hanno superato l'otto
		int result = 0;
		Gioco g1 = new Gioco(3);
		int[] pescata1 = {5,3,5};
		
		result = g1.giocata(pescata1);
		g1.print();
		assertEquals(-1,result);
		
		result = g1.giocata(pescata1);
		assertEquals(2,result);
		
		
		//Test in cui qualcuno vince perchè arriva ad otto preciso
		Gioco g2 = new Gioco(3);
		int[] pescata2 = {1,1,4};
		
		result = g2.giocata(pescata2);
		result = g2.giocata(pescata2);
		g2.print();
		assertEquals(3,result);
		
	}
	
	
	@Test
	public void testBranch() {
		int result = 0;
		Gioco g1 = new Gioco(3);
		int[] pescata1 = {5,3,5};
		
		result = g1.giocata(pescata1);
		g1.print();
		assertEquals(-1,result);
		
		result = g1.giocata(pescata1);
		assertEquals(2,result);
		
		
		Gioco g2 = new Gioco(3);
		int[] pescata2 = {1,1,4};
		
		result = g2.giocata(pescata2);
		result = g2.giocata(pescata2);
		g2.print();
		assertEquals(3,result);
		//Chiamato due volte per controllare il caso in cui il gioco è terminato
		result = g2.giocata(pescata2);
		assertEquals(3,result);
		
		
		/*	Test per coprire il caso in cui solo uno perde mentre gli altri possono giocare
			Siamo quindi nel caso in cui un giocatore non può pescare mentre gli altri possono	*/
		Gioco g3 = new Gioco(3);
		int[] pescata3 = {1,1,5};
		result = g3.giocata(pescata3);
		result = g3.giocata(pescata3);
		result = g3.giocata(pescata3);	
		assertEquals(-1,result);
	}
	
	
	//Il test delle condizioni in questo caso è identico al test del branch, 
	//tutte le condizioni all'interno dlel'if risultano vere e false
	@Test
	public void testCondizioni() {
		int result = 0;
		Gioco g1 = new Gioco(3);
		int[] pescata1 = {5,3,5};
		
		result = g1.giocata(pescata1);
		g1.print();
		assertEquals(-1,result);
		
		result = g1.giocata(pescata1);
		assertEquals(2,result);
		
		
		Gioco g2 = new Gioco(3);
		int[] pescata2 = {1,1,4};
		
		result = g2.giocata(pescata2);
		result = g2.giocata(pescata2);
		g2.print();
		assertEquals(3,result);
		
		result = g2.giocata(pescata2);
		assertEquals(3,result);
		
		
		Gioco g3 = new Gioco(3);
		int[] pescata3 = {1,1,5};
		result = g3.giocata(pescata3);
		result = g3.giocata(pescata3);	
		result = g3.giocata(pescata3);	
		assertEquals(-1,result);
	}
	
	
	@Test
	public void testMCDC()  {
		int result = 0;
		Gioco g1 = new Gioco(3);
		int[] pescata1 = {5,3,5};
		
		result = g1.giocata(pescata1);
		g1.print();
		assertEquals(-1,result);
		
		result = g1.giocata(pescata1);
		assertEquals(2,result);
		
		
		Gioco g2 = new Gioco(3);
		int[] pescata2 = {1,1,4};
		
		result = g2.giocata(pescata2);
		result = g2.giocata(pescata2);
		g2.print();
		assertEquals(3,result);
		
		result = g2.giocata(pescata2);
		assertEquals(3,result);
		
		
		Gioco g3 = new Gioco(3);
		int[] pescata3 = {1,1,5};
		result = g3.giocata(pescata3);
		result = g3.giocata(pescata3);
		result = g3.giocata(pescata3);	
		assertEquals(-1,result);
	}
}
