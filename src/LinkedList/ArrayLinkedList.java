package LinkedList;

import java.util.Comparator;

public class ArrayLinkedList<E> {

    class Node<E> {
        private E data;
        private int next;
        private int freeListNext; //free list의 다음 노드를 가리키는 커서, free list는 삭제된 노드들을 관리

        void set(E data, int next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<E>[] arrayLinkedList;
    private int size;
    private int max; //free list에서 가장 꼬리 쪽에 있는 노드의 레코드 번호
    private int head;
    private int selectedNode;
    private int freeListHead; //free list의 머리 노드를 가리키는 커서(책에서는 deleted로 지칭)
    private static final int NULL = -1;

    public ArrayLinkedList(int capacity) {
        head = selectedNode = max = freeListHead = NULL;

        try {
            arrayLinkedList = new Node[capacity];
            for (int i = 0; i < capacity; i++) {
                arrayLinkedList[i] = new Node<E>();
            }
            size = capacity;
        } catch (OutOfMemoryError e) {
            size = 0;
        }
    }

    private int getInsertIndex() {
        if (freeListHead == NULL) { //삭제된 record가 없음
            if (max < size) return ++max; //새 record 사용
            else return NULL;
        } else {
            int record = freeListHead;
            freeListHead = arrayLinkedList[record].freeListNext; //free list의 head를 사용할 것이므로 head를 갱신
            return record;
        }
    }

    private void deleteIndex(int index) {
        if (freeListHead == NULL) {
            freeListHead = index; //free list의 head에 등록
            arrayLinkedList[index].freeListNext = NULL;
        } else {
            int record = freeListHead;
            freeListHead = index; //index를 free list의 head에 삽입
            arrayLinkedList[index].freeListNext = record;
        }
    }

    public E search(E object, Comparator<? super E> comparator) {
        int pointer = head;

        while (pointer != NULL) {
            if (comparator.compare(object, arrayLinkedList[pointer].data) == 0) {
                selectedNode = pointer;
                return arrayLinkedList[pointer].data;
            }
            pointer = arrayLinkedList[pointer].next;
        }

        return null;
    }

    public void addFirst(E object) {
        int pointer = head;
        int record = getInsertIndex();
        if (record != NULL) {
            head = selectedNode = record;
            arrayLinkedList[head].set(object, pointer);
        }
    }

    public void addLast(E object) {
        if (head == NULL) {
            addFirst(object);
        } else {
            int pointer = head;
            while (arrayLinkedList[pointer].next != NULL) {
                pointer = arrayLinkedList[pointer].next;
            }
            int record = getInsertIndex();
            if (record != NULL) {
                arrayLinkedList[pointer].next = selectedNode = record;
                arrayLinkedList[record].set(object, NULL);
            }
        }
    }

    public void removeFirst() {
        if (head != NULL) {
            int pointer = arrayLinkedList[head].next;
            deleteIndex(head);
            head = selectedNode = pointer;
        }
    }

    public void removeLast() {
        if (head != NULL) {
            if (arrayLinkedList[head].next == NULL) {
                removeFirst();
            } else {
                int pointer = head;
                int preNode = head;

                while (arrayLinkedList[pointer].next != NULL) {
                    preNode = pointer;
                    pointer = arrayLinkedList[pointer].next;
                }
                arrayLinkedList[preNode].next = NULL;
                deleteIndex(pointer);
                selectedNode = preNode;
            }
        }
    }

    public void remove(int target) {
        if (head != NULL) {
            if (target == head) {
                removeFirst();
            } else {
                int pointer = head;

                while (arrayLinkedList[pointer].next != target) {
                    pointer = arrayLinkedList[pointer].next;
                    if (pointer == NULL) return;
                }

                arrayLinkedList[pointer].next = NULL;
                deleteIndex(target);
                arrayLinkedList[pointer].next = arrayLinkedList[target].next;
                selectedNode = pointer;
            }
        }
    }

    public void removeCurrentNode() {
        remove(selectedNode);
    }

    public void clear() {
        while (head != NULL) {
            removeFirst();
        }
        selectedNode = NULL;
    }

    public boolean next() {
        if (selectedNode == NULL || arrayLinkedList[selectedNode].next == NULL) {
            return false;
        }
        selectedNode = arrayLinkedList[selectedNode].next;
        return true;
    }

    public void printCurrentNode() {
        if (selectedNode == NULL) System.out.println("선택된 노드가 없습니다.");
        else System.out.println(arrayLinkedList[selectedNode].data);
    }

    public void dump() {
        int pointer = head;

        while (pointer != NULL) {
            System.out.println(arrayLinkedList[pointer].data);
            pointer = arrayLinkedList[pointer].next;
        }
    }
}
