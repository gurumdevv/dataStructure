package LinkedList;

import java.util.Comparator;

public class LinkedList<E> {

    class Node<E> {
        private E data;
        private Node<E> next;

        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> selectedNode;

    public LinkedList() {
        head = selectedNode = null;
    }

    public E search(E target, Comparator<? super E> comparator) {
        Node<E> pointer = head;

        while (pointer != null) {
            if (comparator.compare(target, pointer.data) == 0) {
                selectedNode = pointer;
                return pointer.data;
            }
            pointer = pointer.next;
        }
        return null;
    }

    public void addFirst(E object) {
        Node<E> pointer = head;
        head = selectedNode = new Node<E>(object, pointer);
    }

    public void addLast(E object) {
        if (head == null) {
            addFirst(object);
        } else {
            Node<E> pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = selectedNode = new Node<E>(object, null);
        }
    }

    public void removeFirst() {
        if (head != null) {
            head = selectedNode = head.next;
        }
    }

    public void removeLast() {
        if (head != null) {
            if (head.next == null) {
                removeFirst();
            } else {
                Node<E> pointer = head;
                Node<E> preNode = head;

                while (pointer.next != null) { //pointer.next에 유의하자, 마지막 노드의 next는 null
                    preNode = pointer; //마지막 노드의 전 노드를 새로 참조
                    pointer = pointer.next; //마지막 노드를 새로 참조
                }
                preNode.next = null;
                selectedNode = preNode;
            }
        }
    }

    public void remove(Node target) {
        if (head != null) {
            if (target == head) {
                removeFirst();
            } else {
                Node<E> pointer = head;

                while (pointer.next != target) {
                    pointer = pointer.next;
                    if (pointer == null) return;
                }
                pointer.next = target.next;
                selectedNode = pointer;
            }
        }
    }

    public void removeCurrentNOde(){
        remove(selectedNode);
    }

    public void clear(){
        while(head != null){
            removeFirst();
        }
        selectedNode = null;
    }

    public boolean next(){
        if(selectedNode == null || selectedNode.next == null){
            return false;
        }
        selectedNode = selectedNode.next;
        return true;
    }

    public void printCurrentNode(){
        if(selectedNode == null) System.out.println("선택된 노드가 없습니다.");
        else System.out.println(selectedNode.data);
    }

    public void dump(){
        Node<E> pointer = head;

        while(pointer != null){
            System.out.println(pointer.data);
            pointer = pointer.next;
        }
    }
}
