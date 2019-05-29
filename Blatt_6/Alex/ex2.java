import java.io.*;
import java.io.IOException;


class Fastfood {
    void eat() throws IOException { }
}

class Hamburger extends Fastfood {
    //void eat() {}
        //Kompilierung möglich
    //void eat() throws Exception {}
        //nicht möglich, da Exception nicht kompatibel mit IO Exception aus der Superclass ist, denn IO Exception ist Subclass von Exception
    //void eat(int y) throws Exception {}
        //möglich, da durch veränderten Scope nicht die Funktion aus Fastfood überschrieben wird, sondern eat eine neue Funktion ist
    //void eat() throws FileNotFoundException { }
        //möglich, da FileNotFoundException kompatibel mit IOException ist, da sie eine Subclass ist
    //void eat() throws RuntimeException {}
        //möglich, denn RuntimeExceptions sind unchecked und werden somit nicht zur Kompilierzeit sondern erst zur Laufzeit ueberprueft
}





public class ex2 {
    public static void main(String[] args) throws IOException {
    Hamburger c=new Hamburger();
    c.eat();
    }
}