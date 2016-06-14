
public class WineTest {

	public static void main(String[] args) {
		Wine[] vina = new Wine[22];
				
		for (int i = 0; i < vina.length; i++) {
			if(i % 2 != 0) {
				vina[i] = new Wine();
			}
			else if(i % 3 == 0) {
				vina[i] = new Wine(2011,"Raca", WineType.WHITE);
			}
			else if(i % 7 == 0) {
				vina[i] = new Wine(2004,"Pezinok", WineType.RED);
			}
			else {
				vina[i] = new Wine(2012,"Modra", WineType.RED);
			}
		}

		for (int i = 0; i < vina.length; i++) {
			vina[i].drink();
		}
		
			}

}
