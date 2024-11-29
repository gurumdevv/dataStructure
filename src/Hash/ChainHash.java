package Hash;

public class ChainHash<K, V> {

    class Node<K, V> {
        private K key;
        private V data;
        private Node<K, V> next;

        Node(K key, V data, Node<K, V> next) {
            this.key = key;
            this.data = data;
            this.next = next;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return data;
        }

        public int hashCode() {
            return key.hashCode();
        }
    }

    private int size;
    private Node<K, V>[] hashTable;

    public ChainHash(int capacity) {
        try {
            hashTable = new Node[capacity];
            this.size = capacity;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

    public int hashFunction(Object key) {
        return key.hashCode() % size;
    }

    public V search(K targetKey) {
        int hashValue = hashFunction(targetKey); //키 값 -> 해시 함수 -> 해시 값
        Node<K, V> pointer = hashTable[hashValue]; //해시 값을 인덱스로 해시 테이블에 노드를 저장했기 때문에 저장된 노드를 불러옴

        while (pointer != null) {
            if (pointer.getKey().equals(targetKey)) return pointer.getValue();
            pointer = pointer.next; //연결 리스트를 순차적으로 선형 검색
        }

        return null;
    }

    public int add(K key, V data) {
        int hashValue = hashFunction(key);
        Node<K, V> pointer = hashTable[hashValue];

        while (pointer != null) {
            if (pointer.getKey().equals(key)) return 1; //이미 키 값이 존재함
            pointer = pointer.next;
        }

        Node<K, V> temp = new Node<K, V>(key, data, hashTable[hashValue]); //next에 버킷의 시작 노드를 저장
        hashTable[hashValue] = temp; //새로운 노드가 버킷의 시작 지점이 됨
        return 0;
    }

    public int remove(K targetKey) {
        int hashValue = hashFunction(targetKey);
        Node<K, V> pointer = hashTable[hashValue];
        Node<K, V> prePointer = null;

        while (pointer != null) {
            if (pointer.getKey().equals(targetKey)) {
                if (prePointer == null) hashTable[hashValue] = pointer.next;
                else prePointer.next = pointer.next;
                return 0;
            }
            prePointer = pointer;
            pointer = pointer.next;
        }
        return 1;
    }

    public void dump() {
        for (int i = 0; i < size; i++) {
            Node<K, V> pointer = hashTable[i];
            System.out.printf("%02d ", i);
            while (pointer != null) {
                System.out.printf("-> %s (%s)  ", pointer.getKey(), pointer.getValue());
                pointer = pointer.next;
            }
            System.out.println();
        }
    }
}
