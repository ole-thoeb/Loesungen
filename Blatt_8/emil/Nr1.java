public class Nr1 {

	public static void main(String[] args) {
		//a) nicht compelierbar
		//TierKaefig<Tier> kaefig = new TierKaefig<Katze>();

		//b) nicht compelierbar
		//TierKaefig<Hund> kaefig = new TierKaefig<Tier>();

		//c) nicht compelierbar
		//TierKaefig<?> kaefig = new TierKaefig<Katze>();
		//kaefig.setInsasse(new Katze());
		
		//d) warnung
		//TierKaefig kaefig = new TierKaefig();
		//kaefig.setInsasse(new Hund());
		
	}

	static class TierKaefig<E> {
		private E insasse;

		public void setInsasse(E x){
			insasse= x;
		}

		public E getInsasse(){
			return insasse;
		}
	}

	static public class Tier {}
	static public class Hund extends Tier {}
	static public class Katze extends Tier {}
}