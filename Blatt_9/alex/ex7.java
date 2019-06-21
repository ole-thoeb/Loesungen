import java.util.ArrayList;

public class ex7 {

    public static void main(String[] args) {
        ArrayList<ArrayList <? extends Printable>> liste = new ArrayList<ArrayList <? extends Printable>>();
        ArrayList<Person> p = new ArrayList<>();
        p.add(new Person("Alfred","Wegener"));
        p.add(new Person("Max","Frisch"));
        p.add(new Person("Friedrich","Schiller"));
        ArrayList<Kartoffel> k = new ArrayList<>();
        k.add(new Kartoffel(0.2));
        k.add(new Kartoffel(0.3));
        k.add(new Kartoffel(0.4));
        ArrayList<Pikachu> pi = new ArrayList<>();
        pi.add(new Pikachu());
        pi.add(new Pikachu());
        pi.add(new Pikachu());

        liste.add(p);
        liste.add(k);
        liste.add(pi);

        ex7.printmixedList(liste);
    }

    public static void printmixedList(ArrayList<ArrayList <? extends Printable>> list) {
        for(ArrayList sublist : list) {
            if(sublist.get(0) instanceof Person ) {
                for(int i=0; i<sublist.size();i++) {
                    Person p =(Person) sublist.get(i);
                    p.print();
                }
            }
            else if (sublist.get(0) instanceof Kartoffel) {
                for(int i=0; i<sublist.size();i++) {
                    Kartoffel k =(Kartoffel) sublist.get(i);
                    k.print();
                }
            }
            else if (sublist.get(0) instanceof Pikachu) {
                for(int i=0; i<sublist.size();i++) {
                    Pikachu p =(Pikachu) sublist.get(i);
                    p.print();
                }
            }
        }
    }
}

public interface Printable {
    public void print();
}

class Person implements Printable {
    String vorname,nachname;

    public Person (String vorname, String nachname) {
        this.vorname = vorname;
        this.nachname = nachname;
    }
    public void print() {
        System.out.println("\nVorname: " + this.vorname + "\nNachname: "+ this.nachname);
    }
}

class Kartoffel implements Printable {
    double gewicht;

    public Kartoffel(double gewicht) {
        this.gewicht = gewicht;
    }

    public void print() {
        System.out.println("\nGewicht: " + this.gewicht);
    }
}

class Pikachu implements Printable {
    public void print() {
        System.out.println("\nPika Pika.");
    }
}