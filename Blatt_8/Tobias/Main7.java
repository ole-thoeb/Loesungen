
public class Main7 {

	public static void main(String[] args) {
		//TierKaefig<Tier> kaefig= new TierKaefig<Katze>();
		
		//TierKaefig<Hund> kaefig= new TierKaefig<Tier>();
		//? wildcard - beliebiger Typ
		TierKaefig<?> kaefig= new TierKaefig<Katze>();
		((TierKaefig<Katze>) kaefig).setInsasse(new Katze());
		
		TierKaefig kaefig = new TierKaefig(); 
		kaefig.setInsasse(new Hund());
	}

}
