package ua.hillel.task16;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<E> implements CustomList<E> {
    private int size;
    private Node<E> first;

    public CustomIterator<E> iterator() {
        return new SinglyListIterator();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        if (first == null) {
            first = new Node<>(element);
            size++;
            return;
        }
        add(first, element);
    }

    private void add(Node<E> current, E value) {
        if (current.next == null) {
            current.next = new Node<>(value);
            size++;
            return;
        }
        add(current.next, value);
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> current = first;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public boolean remove(int index) {
        Objects.checkIndex(index, size);
        Node<E> prev = null;
        Node<E> current = first;
        for (int i = 1; i <= index; i++) {
            prev = current;
            current = current.next;
        }
        if (prev == null) {
            size--;
            if (current.next == null) {
                first = null;
                return true;
            }
            first = current.next;
            return true;
        }
        prev.next = current.next;
        size--;
        return true;
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        Node(E value) {
            this.value = value;
        }
    }

    private class SinglyListIterator implements CustomIterator<E> {
        private Node<E> current;

        private SinglyListIterator() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E value = current.value;
            current = current.next;
            return value;
        }
    }
}
