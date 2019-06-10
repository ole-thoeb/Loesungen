import java.util.List;

public interface StackList<T> extends List<T> {

	void push(T element);
	
	T pop();
}