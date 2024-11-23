package Stack;

public class IntStack {
    private int[] stack;
    private int capacity;
    private int pointer;

    public static class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
        }
    }

    public static class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {
        }
    }

    public IntStack(int length) {
        pointer = 0;
        capacity = length;

        try {
            stack = new int[capacity];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public int push(int x) throws OverflowIntStackException {
        if (pointer >= capacity) throw new OverflowIntStackException();
        return stack[pointer++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if (pointer <= 0) throw new EmptyIntStackException();
        return stack[--pointer];
    }

    public int peek() throws EmptyIntStackException {
        if (pointer <= 0) throw new EmptyIntStackException();
        return stack[pointer - 1];
    }

    public void clear() {
        pointer = 0;
    }

    public int indexOf(int target) {
        for (int i = pointer - 1; i >= 0; i--) {
            if (stack[i] == target) return i;
        }

        return -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return pointer;
    }

    public boolean isEmpty() {
        return pointer <= 0;
    }

    public boolean isFull() {
        return pointer >= capacity;
    }

    public void dump() {
        if (pointer <= 0) {
            System.out.println("스택이 비어 있습니다.");
        } else {
            for (int i = 0; i < pointer; i++) {
                System.out.print(stack[i] + " ");
            }
            System.out.println();
        }
    }
}
