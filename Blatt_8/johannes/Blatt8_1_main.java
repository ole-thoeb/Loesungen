
public class Blatt8_1_main {
	public static void main(String[] args) {
		//a:
		//TierKaefig<Tier> kaefig= new TierKaefig<Katze>();
		//Type mismatch, cannot convert...
		
		//b:
		//TierKaefig<Hund> kaefig= new TierKaefig<Tier>();
		//Type mismatch, cannot convert...

		//c:
		//TierKaefig<?> kaefig= new TierKaefig<Katze>();
		//kaefig.setInsasse(new Katze());
		//setInsasse not applicable for argument
		
		//d:
		TierKaefig kaefig = new TierKaefig();
		kaefig.setInsasse(new Hund());
		//Warnung: should be parameterized
	}
	public static class TierKaefig<E> {
		private E insasse;
		public void setInsasse(E x){
			insasse= x;
		}
		public E getInsasse(){
			return insasse;
		}
	}
	public static class Tier {}
	public static class Hund extends Tier {}
	public static class Katze extends Tier {}
}
