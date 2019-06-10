class R { }
class E extends R { }
class B extends R { }
class G extends B { }
class U { }

public class ex2 {

    public static <T> T bar(T x, T y) {
        return x;
    }

    public static void main(String[] args) {
        Object o;
        R r = new R();
        E e = new E();
        B b = new B();
        G g = new G();
        U u = new U();
        R[] x;
        E[] y;
        o = bar(new G[8], new U[5]);
    }
}

/*
    r = bar(r,b); -> wird akzeptiert, denn B ist Subclass von R, somit können B und R in den gleichen Typ <T> = R konvertiert werden, die Funktion returned R und r ist vom Typ R.
    r = bar(b,r); -> wird akzeptiert, siehe oben
    r = bar(e,g); -> wird akzeptiert, denn G<B<R und E<R  (mit "<" = "ist Subclass von"), also <T> = R und r ist vom Typ R-
    r = bar(b,g); -> wird akzeptiert, denn G<B. returns also B, was in R konvertiert werden kann, da B<R.
    e = bar(r,b); -> wird nicht akzeptiert, denn bar(r,b) returns R. R kann jedoch nicht zu R konvertiert werden.
    u = bar(u,r); -> wird nicht akzeptiert. Da U und R nicht verwandt sind, wird Typ Object returned. Dieser kann nicht zu U konvertiert werden.
    o = bar(e,u); -> wird akzeptiert, denn E und U sind nicht verwandt, returns Object -> o ist Objekt
    b = bar(e,g); -> wird nicht akzeptiert, E und G sind beide <R, also returns R, akann aber nicht zu B konvertiert werden.
    x = bar(new E[2],new B[4]); -> wird akzeptiert, bar() gibt ein Array aus R zurueck, da E<R und B<R
    y = bar(new E[4],new B[11]); -> wird nicht akzeptiert, Array von R kann nicht zur Subklasse E konvertiert werden
    o = bar(new G[8], new U[5]); -> wird akzeptiert, bar() gibt Array vom Typ Object zuück, da G und U nicht verwandt sind. Der Pointer auf 0 wird dann in Object geschrieben.

*/