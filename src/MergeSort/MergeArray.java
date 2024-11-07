package MergeSort;

public class MergeArray {

    static void merge(int[] a, int sizeA, int[] b, int sizeB, int[] c) {
        int pointerA = 0;
        int pointerB = 0;
        int pointerC = 0;

        while (pointerA < sizeA && pointerB < sizeB) {
            c[pointerC++] = (a[pointerA] <= b[pointerB]) ? a[pointerA++] : b[pointerB++];
        }

        while (pointerA < sizeA) c[pointerC++] = a[pointerA++];
        while (pointerB < sizeB) c[pointerC++] = b[pointerB++];
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 6, 8, 11, 13};
        int[] b = {1, 2, 3, 4, 9, 6, 21};
        int[] c = new int[13];

        System.out.println("두 배열을 병합");
        merge(a, a.length, b, b.length, c);

        System.out.println("배열 a와 배열 b를 병합하여 배열 c에 저장했습니다.");
        System.out.print("배열 a: ");
        for(int num: a){
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("배열 b: ");
        for(int num: b){
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("배열 c: ");
        for(int num: c){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
