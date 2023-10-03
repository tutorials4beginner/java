import java.util.*;

public class Stack {
    private List<Object> items;

    public Stack(int size) {
        items = new ArrayList<Object>();
    }

    public void push(Object item) {
        items.add(item);
    }

    public Object pop() {
      if (items.size() == 0)
          throw new EmptyStackException();
      return items.remove(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
