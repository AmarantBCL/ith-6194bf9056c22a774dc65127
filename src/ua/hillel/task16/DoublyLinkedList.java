package ua.hillel.task16;

import java.util.NoSuchElementException;
import java.util.Objects;

public class DoublyLinkedList<E> implements CustomList<E>, CustomDoublyList<E> {
    private int size;
    private Node<E> first;
    private Node<E> last;

    public CustomIterator<E> iterator() {
        return new DoublyListIterator();
    }

    public CustomReverseIterator<E> reverseIterator() {
        return new DoublyListReverseIterator();
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

    private void add(Node<E> node, E element) {
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
        Node<E> current;
        if (index <= size / 2) {
            current = first;
            for (int i = 1; i <= index; i++) {
                current = current.next;
            }
        } else {
            current = last;
            for (int i = size - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return current.value;
    }

    @Override
    public boolean remove(int index) {
        Objects.checkIndex(index, size);
        if (index == 0) return removeFirst();
        if (index == size - 1) return removeLast();
        Node<E> current = first;
        Node<E> prev = current;
        for (int i = 1; i <= index; i++) {
            prev = current;
            current = current.next;
        }
        current.previous = prev;
        prev.next = current.next;
        size--;
        return true;
    }

    public boolean removeFirst() {
        if (first == null) return false;
        first.previous = null;
        first = first.next;
        size--;
        return true;
    }

    public boolean removeLast() {
        if (last == null) return false;
        last = last.previous;
        last.next = null;
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

    private class DoublyListIterator implements CustomIterator<E> {
        private Node<E> current;

        private DoublyListIterator() {
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

    private class DoublyListReverseIterator implements CustomReverseIterator<E> {
        private Node<E> current;

        private DoublyListReverseIterator() {
            current = last;
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
            current = current.previous;
            return value;
        }
    }
}
