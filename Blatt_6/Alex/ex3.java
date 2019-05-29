import java.util.Scanner;

class NumberTooBigException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public String toString() {
        return "Number too big!";
    }
}

class NumberTooSmallException extends Exception {
    private static final long serialVersionUID = 1L+1;

    public String toString() {
        return "Number too small!";
    }
}

public class ex3 {
    public static void main (String[] args) throws NumberTooSmallException { //NumberTooBigException muss nicht genannt sein
        System.out.println("Bitte geben Sie eine Zahl ein: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.close();
        //int input = 5;
        if(input > 5) throw new NumberTooBigException();
        if(input < 5) throw new NumberTooSmallException();
    }
}

// gepruefte Ausnahmen werden zur Kompilierzeit überprüft und müssen per catch Block abgefangen werden
// insbesondere muessen checked Exceptions im Header einer Funktion angegeben werden, Unchecked Exceptions hingegen nicht
// ungepruefte Ausnahmen, hier NumberTooBigException, da RuntimeException, treten unvorhergesehen bei der Ausfuehrung auf
// und werden somit nicht zur Kompilierzeit ueberprueft