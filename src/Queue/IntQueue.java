package Queue;

public class IntQueue {

    private int[] queue;
    private int capacity;
    private int front;
    private int rear;
    private int num;

    public static class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {
        }
    }

    public static class OverflowQueueException extends RuntimeException {
        public OverflowQueueException() {
        }
    }

    public IntQueue(int length) {
        num = front = rear = 0;
        capacity = length;

        try {
            queue = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public int enque(int x) throws OverflowQueueException {
        if (num >= capacity) throw new OverflowQueueException();

        queue[rear++] = x;
        num++;
        if (rear == capacity) rear = 0;
        return x;
    }

    public int deque() throws EmptyIntQueueException {
        if (num <= 0) throw new EmptyIntQueueException();

        int x = queue[front++];
        num--;
        if (front == capacity) front = 0;
        return x;
    }

    public int peek() throws EmptyIntQueueException {
        if (num <= 0) throw new EmptyIntQueueException();
        return queue[front];
    }

    public void clear() {
        num = front = rear = 0;
    }

    public int indexOf(int x) {
        for (int i = 0; i < num; i++) {
            int index = (front + i) % capacity;
            if (queue[index] == x) return index;
        }
        return -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return num;
    }

    public boolean isEmpty() {
        return num <= 0;
    }

    public boolean isFull() {
        return num >= capacity;
    }

    public void dump() {
        if (num <= 0) {
            System.out.println("큐가 비어 있습니다.");
        } else {
            for (int i = 0; i < num; i++) {
                System.out.print(queue[(front + i) % capacity] + " ");
            }
            System.out.println();
        }
    }
}
