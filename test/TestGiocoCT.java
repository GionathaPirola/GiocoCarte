import static org.junit.Assert.*;

import org.junit.Test;

public class TestGiocoCT {

	@Test
	public void test() {
		//Combinatorial 1
		int result = 0;
		Gioco g1 = new Gioco(3);
		int[] pescata1 = {1,1,2};
		
		result = g1.giocata(pescata1);
		assertEquals(-1,result);
		
		//Combinatorial 31
		Gioco g2 = new Gioco(3);
		int[] pescata2 = {2,2,4};
				
		result = g2.giocata(pescata2);
		result = g2.giocata(pescata2);
		assertEquals(3,result);
		
		//Combinatorial 72
		Gioco g3 = new Gioco(3);
		int[] pescata3 = {4,5,4};
						
		result = g3.giocata(pescata3);
		result = g3.giocata(pescata3);
		assertEquals(3,result);
	}

}
