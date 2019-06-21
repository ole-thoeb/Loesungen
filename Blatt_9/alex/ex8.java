import java.util.ArrayList;

public class ex8 {
    public static void main(String[] args) {
        ArrayList<?> list=new ArrayList<Pikachu>();//kein Problem
        ArrayList<? extends Printable> list2=new ArrayList<Pikachu>();//kein Problem
        //ArrayList<? super Printable> list3=new ArrayList<Pikachu>();//funktioniert nicht, da Pikachu nicht Superclass von Printable ist
        ArrayList<? super Pikachu> list4=new ArrayList<Pikachu>();//kein Problem
        //ArrayList<? super Object> list5=new ArrayList<Pichu>();//funktioniert nicht, da Pichu nicht Superclass von Object ist
        ArrayList<? extends Object> list6=new ArrayList<Pichu>();//kein Problem
        ArrayList<? extends Raichu> list7=new ArrayList<Pichu>();//kein Problem
        ArrayList<? super Raichu> list8=new ArrayList<Raichu>();//kein Problem
        ArrayList<? super Pikachu> list9=new ArrayList<Raichu>();//kein Problem
        ArrayList<? super Raichu> list10=new ArrayList<Object>();//kein Problem
    }
}
    
public interface Printable {
    public void print();
}

class Raichu { }

class Pikachu extends Raichu implements Printable{
    public void print() { }
}

class Pichu extends Pikachu { }