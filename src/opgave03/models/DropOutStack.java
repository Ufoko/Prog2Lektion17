package opgave03.models;

import opgave01.models.StackEaaa;

import java.util.NoSuchElementException;

public class DropOutStack<E> implements StackEaaa<E> {

    private int maxSize;
    private Node topNode;
    private Node botNode;

    public DropOutStack(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void push(E element) {
        Node newnode = new Node(element, null, null);
        if (topNode == null) {
            botNode = newnode;
            topNode = newnode;
        } else {
            topNode.next = newnode;
            newnode.previous = topNode;
            topNode = newnode;
        }

        if (size() > 3) {
            Node tempBot = botNode;
            botNode = tempBot.next;
            botNode.previous = null;
        }

    }

    @Override
    public E pop() {
        isEmptyExceptionThrow();
        Node prevTop = topNode;
        topNode = prevTop.previous;

        return (E) prevTop.element;
    }

    @Override
    public E peek() {
        isEmptyExceptionThrow();

        return (E) topNode.element;

    }


    private void isEmptyExceptionThrow() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stak er tom");
        }
    }

    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    @Override
    public void clear() {
        topNode = null;
        botNode = null;
    }

    @Override
    public int size() {
        int sizeOfStack = 1;

        Node curNode = botNode;

        while (curNode.next != null) {
            sizeOfStack++;
            curNode = curNode.next;
        }


        return sizeOfStack;
    }

    private class Node<T> {
        private T element;
        private Node<T> next;
        private Node<T> previous;

        private Node(T element, Node<T> next, Node<T> previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
    }
}
