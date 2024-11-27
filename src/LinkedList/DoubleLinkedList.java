package LinkedList;

import java.util.Comparator;

public class DoubleLinkedList<E> {

    class Node<E> {

        private E data;
        private Node<E> prev;
        private Node<E> next;

        Node() {
            data = null;
            prev = next = this;
        }

        Node(E object, Node<E> prev, Node<E> next) {
            data = object;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> selectedNode;

    public DoubleLinkedList() {
        head = selectedNode = new Node<E>();
    }

    public boolean isEmpty() {
        return head.next == head;
    }

    public E search(E object, Comparator<? super E> comparator) {
        Node<E> pointer = head.next; //헤드가 가리키는 더미 노드의 다음 노드가 실제 머리 노드

        while (pointer != head) {
            if (comparator.compare(object, pointer.data) == 0) {
                selectedNode = pointer;
                return pointer.data;
            }
            pointer = pointer.next;
        }

        return null;
    }

    public void printCurrentNode() {
        if (isEmpty()) System.out.println("선택된 노드가 없습니다.");
        else System.out.println(selectedNode.data);
    }

    public void dump() {
        Node<E> pointer = head.next;

        while (pointer != head) {
            System.out.println(pointer.data);
            pointer = pointer.next;
        }
    }

    public void dumpReverse() {
        Node<E> pointer = head.prev;

        while (pointer != head) {
            System.out.println(pointer.data);
            pointer = pointer.prev;
        }
    }

    public boolean next() {
        if (isEmpty() || selectedNode.next == head) {
            return false;
        }
        selectedNode = selectedNode.next;
        return true;
    }

    public boolean prev() {
        if (isEmpty() || selectedNode.prev == head) {
            return false;
        }
        selectedNode = selectedNode.prev;
        return true;
    }

    public void add(E object) {
        Node<E> node = new Node<E>(object, selectedNode, selectedNode.next);
        selectedNode.next = selectedNode.next.prev = node;
        selectedNode = node;
    }

    public void addFirst(E object) {
        selectedNode = head;
        add(object);
    }

    public void addLast(E object) {
        selectedNode = head.prev;
        add(object);
    }

    public void removeCurrentNode() {
        if (!isEmpty()) {
            selectedNode.prev.next = selectedNode.next;
            selectedNode.next.prev = selectedNode.prev;
            selectedNode = selectedNode.prev;
            if (selectedNode == head) selectedNode = head.next;
        }
    }

    public void remove(Node target) {
        Node<E> pointer = head.next;

        while (pointer != head) {
            if (pointer == target) {
                selectedNode = target;
                removeCurrentNode();
                break;
            }
            pointer = pointer.next;
        }
    }

    public void removeFirst() {
        selectedNode = head.next;
        removeCurrentNode();
    }

    public void removeLast() {
        selectedNode = head.prev;
        removeCurrentNode();
    }

    public void clear() {
        while (!isEmpty()) {
            removeFirst();
        }
    }
}
