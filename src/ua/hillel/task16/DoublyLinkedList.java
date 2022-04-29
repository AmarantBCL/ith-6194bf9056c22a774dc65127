package ua.hillel.task16;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class DoublyLinkedList<E> implements CustomList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    public DoublyListIterator iterator() {
        return new DoublyListIterator();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        if (first == null) {
            first = new Node<>(element);
            last = first;
            size++;
            return;
        }
        add(first, element);
    }

    public void add(Node<E> node, E element) {
        Node<E> current = node;
        for (int i = 0; i < size; i++) {
            if (current.next == null) {
                last = new Node<>(element);
                current.next = last;
                last.previous = current;
                size++;
                return;
            }
            current = current.next;
        }
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        if (index == 0) return first.value;
        if (index == size - 1) return last.value;
        Node<E> current = first;
        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        return current.value;
    }

    @Override
    public boolean remove(int index) {
        Objects.checkIndex(index, size);
        if (index == 0 || index == size - 1) {
            if (index == 0) {
                first = first.next;
                first.previous = null;
            } else {
                last = last.previous;
                last.next = null;
            }
            size--;
            return true;
        }
        Node<E> prev = null;
        Node<E> current = first;
        for (int i = 1; i <= index; i++) {
            prev = current;
            current = current.next;
        }
        current.previous = prev;
        prev.next = current.next;
        size--;
        return true;
    }

    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> previous;

        Node(E value) {
            this.value = value;
        }
    }

    private class DoublyListIterator implements Iterator<E> {
        private Node<E> current;

        public DoublyListIterator() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            Node<E> node = first;
            if (current == null) {
                throw new NoSuchElementException();
            }
            E value = current.value;
            current = current.next;
            return value;
        }
    }
}
