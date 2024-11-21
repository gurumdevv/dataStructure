package BinarySearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {

    static class PhysicalData {
        private String name;
        private int height;
        private double vision;

        public PhysicalData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return name + " " + height + " " + vision;
        }

        public static final Comparator<PhysicalData> HEIGHT_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhysicalData> {
            public int compare(PhysicalData d1, PhysicalData d2) {
                return Integer.compare(d1.height, d2.height);
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        PhysicalData[] x = {
                new PhysicalData("강민하", 162, 0.3),
                new PhysicalData("이수연", 168, 0.4),
                new PhysicalData("황지안", 169, 0.8),
                new PhysicalData("유서범", 171, 1.5),
                new PhysicalData("김찬우", 173, 0.7),
                new PhysicalData("장경오", 174, 1.2),
                new PhysicalData("박준서", 175, 2.0),
        };

        System.out.print("키가 몇 cm인 사람을 찾고 있나요?: ");
        int height = stdIn.nextInt();
        int result = Arrays.binarySearch(
                x, new PhysicalData("", height, 0.0), PhysicalData.HEIGHT_ORDER
        );

        if (result < 0) System.out.println(height + "cm 키를 가진 사람을 발견하지 못했습니다");
        else {
            System.out.println(height + "cm 키를 가진 사람은 x[" + result + "]에 있습니다.");
            System.out.println("찾은 데이터: " + x[result]);
        }
    }
}
