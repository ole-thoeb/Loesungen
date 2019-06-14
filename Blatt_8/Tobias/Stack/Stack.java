package Stack;

import java.util.List;

public interface Stack <E> extends List {
	//E für Element, T für Typ
	 E pop();
	 void push();
}
