package Hash;

public class OpenHash<K, V> {

    enum Status {OCCUPIED, EMPTY, DELETED}

    static class Bucket<K, V> {
        private K key;
        private V data;
        private Status status;

        Bucket() {
            status = Status.EMPTY;
        }

        void set(K key, V data, Status status) {
            this.key = key;
            this.data = data;
            this.status = status;
        }

        void setStatus(Status status) {
            this.status = status;
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
    private Bucket<K, V>[] hashTable;

    public OpenHash(int size) {
        try {
            hashTable = new Bucket[size];
            for (int i = 0; i < size; i++) {
                hashTable[i] = new Bucket<K, V>();
            }
            this.size = size;
        } catch (OutOfMemoryError e) {
            this.size = 0;
        }
    }

    public int hashFunction(Object key) {
        return key.hashCode() % size;
    }

    public int reHashFunction(int hashValue) {
        return (hashValue + 1) % size;
    }

    private Bucket<K, V> searchNode(K key) {
        int hashValue = hashFunction(key);
        Bucket<K, V> pointer = hashTable[hashValue];

        for (int i = 0; pointer.status != Status.EMPTY && i < size; i++) {
            if (pointer.status == Status.OCCUPIED && pointer.getKey().equals(key)) return pointer;
            hashValue = reHashFunction(hashValue);
            pointer = hashTable[hashValue];
        }

        return null;
    }

    public V search(K key) {
        Bucket<K, V> pointer = searchNode(key);
        if (pointer != null) return pointer.getValue();
        else return null;
    }

    public int add(K key, V data) {
        if (search(key) != null) return 1; //이미 등록된 키

        int hashValue = hashFunction(key);
        Bucket<K, V> pointer = hashTable[hashValue];
        for (int i = 0; i < size; i++) {
            if (pointer.status == Status.EMPTY || pointer.status == Status.DELETED) {
                pointer.set(key, data, Status.OCCUPIED);
                return 0;
            }
            hashValue = reHashFunction(hashValue); //재해시
            pointer = hashTable[hashValue];
        }
        return 2; //해시 테이블이 가득 참
    }

    public int remove(K key) {
        Bucket<K, V> pointer = searchNode(key);
        if (pointer == null) return 1; //키 값이 등록되어 있지 않음

        pointer.setStatus(Status.DELETED);
        return 0;
    }

    public void dump() {
        for (int i = 0; i < size; i++) {
            System.out.printf("%02d  ", i);

            switch (hashTable[i].status) {
                case OCCUPIED:
                    System.out.printf("%s (%s)\n", hashTable[i].getKey(), hashTable[i].getValue());
                    break;

                case EMPTY:
                    System.out.println("-- 비어 있음 --");
                    break;

                case DELETED:
                    System.out.println("--삭제 마침--");
                    break;
            }
        }
    }
}