package Tree;

import java.util.Comparator;

public class BinarySearchTree<K, V> {

    static class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> left;
        private Node<K, V> right;

        Node(K key, V data, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.data = data;
            this.left = left;
            this.right = right;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return data;
        }

        void print() {
            System.out.println(data);
        }
    }

    private Node<K, V> root;
    private Comparator<? super K> comparator = null;


    public BinarySearchTree() {
        root = null;
    }

    public BinarySearchTree(Comparator<? super K> comparator) {
        this();
        this.comparator = comparator;
    }

    private int compare(K key1, K key2) {
        return (comparator == null) ? ((Comparable<K>) key1).compareTo(key2) : comparator.compare(key1, key2);
    }

    public V search(K targetKey) {
        Node<K, V> pointer = root;

        while (true) {
            if (pointer == null) return null;

            int result = compare(targetKey, pointer.getKey());
            if (result == 0) return pointer.getValue();
            else if (result < 0) pointer = pointer.left;
            else pointer = pointer.right;
        }
    }

    private void addNode(Node<K, V> node, K key, V data) {
        int result = compare(key, node.getKey());
        if (result == 0) {
            return;
        } else if (result < 0) {
            if (node.left == null) node.left = new Node<K, V>(key, data, null, null);
            else addNode(node.left, key, data);
        } else {
            if (node.right == null) node.right = new Node<K, V>(key, data, null, null);
            else addNode(node.right, key, data);
        }
    }

    public void add(K key, V data) {
        if (root == null) root = new Node<K, V>(key, data, null, null);
        else addNode(root, key, data);
    }

    public boolean remove(K key) {
        Node<K, V> pointer = root;
        Node<K, V> parent = null;
        boolean isLeftChild = true; //pointer가 왼쪽 자식 노드인 경우 true

        while (true) {
            if (pointer == null) {
                return false;
            }

            int result = compare(key, pointer.getKey());
            if (result == 0) { //검색 성공
                break;
            } else {
                parent = pointer;
                if (result < 0) {
                    isLeftChild = true;
                    pointer = pointer.left;
                } else {
                    isLeftChild = false;
                    pointer = pointer.right;
                }
            }
        }

        if (pointer.left == null) { //자식이 하나인 경우, 오른쪽 자식만 존재, 자식이 없는 경우도 포함
            if (pointer == root) root = pointer.right;
            else if (isLeftChild) parent.left = pointer.right;
            else parent.right = pointer.right;
        } else if (pointer.right == null) { //자식이 하나인 경우, 왼쪽 자식만 존재, 자식이 없는 경우도 포함
            if (pointer == root) root = pointer.left;
            else if (isLeftChild) parent.left = pointer.left;
            else parent.right = pointer.left;
        } else { //자식이 양쪽 모두 존재
            parent = pointer;
            Node<K, V> subPointer = pointer.left; //왼쪽 서브트리의 루트노드
            isLeftChild = true;

            while (subPointer.right != null) { //왼쪽 서브트리에서 가장 큰 값 찾기
                parent = subPointer;
                subPointer = subPointer.right;
                isLeftChild = false;
            }
            pointer.key = subPointer.key;
            pointer.data = subPointer.data;
            if (isLeftChild) parent.left = subPointer.left; //왼쪽 서브트리에서 가장 큰 값 제거
            else parent.right = subPointer.left; //왼쪽 서브트리에서 가장 큰 값 제거
        }
        return true;
    }

    private void printSubTree(Node node) {
        if (node != null) { //이진 검색 트리를 중위 순회해서 오름차순으로 출력
            printSubTree(node.left);
            System.out.println(node.key + " " + node.data);
            printSubTree(node.right);
        }
    }

    public void print() {
        printSubTree(root);
    }
}
