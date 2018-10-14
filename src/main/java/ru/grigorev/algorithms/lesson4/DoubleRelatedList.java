package ru.grigorev.algorithms.lesson4;

import ru.grigorev.algorithms.lesson4.webinar.Cat;

import java.util.Iterator;

/**
 * @author Dmitriy Grigorev
 */
public class DoubleRelatedList implements Iterable<Cat> {

    private class Node {
        Cat cat;
        Node next;
        Node previous;

        public Node(Cat cat) {
            this.cat = cat;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node node = (Node) o;
            return cat.equals(node.cat);
        }

        @Override
        public String toString() {
            return cat.toString();
        }
    }

    private Node head;
    private int size;
    private Node tail;

    public DoubleRelatedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void insertHead(Cat c) {
        Node n = new Node(c);
        if (isEmpty()) tail = n;
        if (size > 0) head.previous = n; // !
        n.next = head;
        head = n;
        size++;
    }

    public void insertTail(Cat c) {
        Node n = new Node(c);
        if (isEmpty()) head = n;
        if (size > 0) tail.next = n;
        n.previous = tail;
        tail = n;
        size++;
    }

    public Cat removeHead() {
        if (isEmpty())
            return null;
        if (size == 1) head = tail;
        Cat c = head.cat;
        head = head.next;
        size--;
        return c;
    }

    public Cat removeTail() {
        if (isEmpty())
            return null;
        if (size == 1) tail = head;
        Cat c = tail.cat;
        tail = tail.previous;
        size--;
        return c;
    }

    public Cat getHead() {
        if (isEmpty()) return null;
        return head.cat;
    }

    public Cat getTail() {
        if (isEmpty()) return null;
        return tail.cat;
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder sb = new StringBuilder("[ ");
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append((current == null) ? " ]" : ", ");
        }
        return sb.toString();
    }

    public boolean contains(Cat c) {
        if (isEmpty())
            return false;
        Node current = head;
        while (!current.cat.equals(c)) {
            if (current.next == null)
                return false;
            else
                current = current.next;
        }
        return true;
    }

    public boolean delete(Cat c) {
        Node n = new Node(c);
        Node current = head;
        Node previous = head;
        while (!current.equals(n)) {
            if (current.next == null)
                return false;
            else {
                previous = current;
                current = current.next;
            }
        }
        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
        }
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Cat> iterator() {
        return new DRLIterator();
    }

    public DRLIterator getCustomIterator() {
        return new DRLIterator();
    }

    public class DRLIterator implements Iterator<Cat> {
        private Node current;
        private int counter;

        public DRLIterator() {
            this.current = head;
            this.counter = 0;
        }

        @Override
        public boolean hasNext() {
            if (isEmpty()) return false;
            if (!isEmpty() && counter == 0) return true;
            if (current.next == null) {
                counter = 0;
                return false;
            }
            return true;
        }

        @Override
        public Cat next() {
            if (isEmpty()) return null;
            if (counter == 0) {
                counter++;
                return current.cat;
            }
            current = current.next;
            counter++;
            return current.cat;
        }

        public boolean hasPrevious() {
            if (isEmpty()) return false;
            if (current.previous == null) {
                counter = 0;
                return false;
            }
            return true;
        }

        public Cat previous() {
            if (isEmpty()) return null;
            if (counter == 0) {
                counter--;
                return current.cat;
            }
            current = current.previous;
            counter--;
            return current.cat;
        }

        public void remove() {
            delete(current.cat);
        }

        public boolean isEnd() {
            if (hasNext()) return false;
            return true;
        }

        public boolean isStart() {
            if (hasPrevious()) return false;
            return true;
        }

        public Cat current() {
            return current.cat;
        }

        public void reset() {
            current = head;
            counter = 0;
        }

        public void insertAfter(Cat cat) {
            Node n = new Node(cat);
            if (isEmpty()) {
                insertTail(cat);
            } else {
                n.previous = current;
                n.next = current.next;
                current.next = n;
                size++;
                if (n.next == null) {
                    tail = n;
                }
            }
        }

        public void insertBefore(Cat cat) {
            Node n = new Node(cat);
            if (isEmpty()) {
                insertHead(cat);
            } else {
                n.next = current;
                n.previous = current.previous;
                current.previous = n;
                if (n.previous == null) {
                    head = n;
                }
                size++;
            }
        }
    }
}
