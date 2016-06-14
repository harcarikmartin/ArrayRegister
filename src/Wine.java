public class Wine implements Drinkable {
	private WineType type;
	private int rocnik;
	private String vineyard;
	
	public Wine() {
		this(2016, "Tokaj", WineType.ROSE);
	}
	
	public Wine(int rocnik, String vineyard, WineType type) {
		this.setRocnik(rocnik);
		this.setVineyard(vineyard);
		this.setType(type);
	}

	@Override
	public void drink() {
		System.out.println("Mmmm, this " + getRocnik() + " wine from " + getVineyard() + " is delicious!");
		
	}

	public int getRocnik() {
		return rocnik;
	}

	public void setRocnik(int rocnik) {
		if(rocnik >= 1950 && rocnik <= 2016) {
			this.rocnik = rocnik;
		}
	}

	public String getVineyard() {
		return vineyard;
	}

	public void setVineyard(String vineyard) {
		this.vineyard = vineyard;
	}

	public WineType getType() {
		return type;
	}

	public void setType(WineType type) {
		this.type = type;
	}
}
