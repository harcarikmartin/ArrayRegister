public class TestTea {

	public static void main(String[] args) {
		Tea[] caje = new Tea[22];
		
		for (int i = 0; i < caje.length; i++) {
			if(i % 2 != 0) {
				caje[i] = new Tea();
			}
			else if(i % 3 == 0) {
				caje[i] = new Tea(TeaFlavour.ASSAM);
			}
			else if(i % 7 == 0) {
				caje[i] = new Tea(TeaFlavour.EARL_GREY);
			}
			else {
				caje[i] = new Tea(TeaFlavour.ENGLISH_BREAKFAST);
			}
		}
		
		for (int i = 0; i < caje.length; i++) {
			caje[i].drink();
		}
		
	}
}
