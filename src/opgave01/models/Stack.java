package opgave01.models;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Stack<T> implements StackEaaa<T> {

    private ArrayList<T> stack = new ArrayList<T>();


    @Override
    public void push(T element) {
        stack.add(element);
    }

    @Override
    public T pop() {
        if (stack.isEmpty()) {
            throw new NoSuchElementException("Stak er tom");
        } else {
            T temp = stack.get(size());
            stack.removeLast();
            return temp;
        }

    }

    @Override
    public T peek() {
        return stack.get(size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.getLast() == null;
    }

    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
