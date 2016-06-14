public class Tea implements Drinkable {
	private TeaFlavour flavour;
	
	public Tea(TeaFlavour flavour) {
		this.flavour = flavour;
	}
	
	public Tea() {
		this(TeaFlavour.MINT);
	}

	public TeaFlavour getFlavour() {
		return flavour;
	}

	public void setFlavour(TeaFlavour flavour) {
		this.flavour = flavour;
	}
	
	private String getFlavourString(TeaFlavour flavour) {
		String flavourString;
		switch (flavour) {
			case ASSAM:
				flavourString = "Assam";
				break;
			case ENGLISH_BREAKFAST:
				flavourString = "English Breakfast";
				break;
			case EARL_GREY:
				flavourString = "Earl Grey";
				break;
			case HERBAL:
				flavourString = "Herbal";
				break;
			case MINT:
				flavourString = "Mint";
				break;
			case ROOIBOS:
				flavourString = "Rooibos";
				break;
			case PIGI:
				flavourString = "Pigi";
				break;
			default:
				flavourString = "Water";
				break;
		}
		return flavourString;
	}
	
	@Override
	public void drink() {
		System.out.println("Mmmm, this " + getFlavourString(getFlavour()) + " tea is delicious!");
	}
}
