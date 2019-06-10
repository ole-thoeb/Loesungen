public class TierKaefig<E> {
    private E insasse;

    public void setINsasse(E x) {
        insasse = x;
    }

    public E getInsasse() {
        return insasse;
    }
}

public class Tier {}

public class Hund extends Tier {}

public class Katze extends Tier {}

public class ex1 {
    public static void main(String[] args) {
        //Stelle 1
        
    }
}

/*
    a.) TierKaefig<Tier> kaefig = new TierKaefig<Katze>();
        Compilation Problem: Es kann nicht vom Typ TierKaefig<Katze> zu TierKaefig<Tier> konvertiert werden.

    b.) TierKaefig<Hund> kaefig = new TierKaefig<Tier>();
        Compilation Problem: cannot convert from TierKaefig<Tier> to TierKaefig<Hund>.

    c.) TierKaefig<?> kaefig = new TierKaefig<Katze>();
        kaefig.setInsasse(new Katze());
        Compilation Problem: setInsasse(Katze) ist nicht definiert für den statischen Typ TierKaefig<capture#1-of ?>


    d.) TierKaefig kaefig = new TierKaefig();
        kaefig.setInsasse(new Hund());
        Compilation Problem: setInsasse(Hund) ist nicht für den Typ Tierkaefig definiert.


*/