package Tree;

import LinkedList.LinkedList;
import LinkedList.LinkedListTester;

import java.util.Comparator;
import java.util.Scanner;

public class BinarySearchTreeTester {


    static Scanner sc = new Scanner(System.in);

    static class Data {
        static final int NO = 1;
        static final int NAME = 2;

        private Integer no;
        private String name;

        Integer keyCode() {
            return no;
        }

        public String toString() {
            return name;
        }

        void scanData(String guide, int sw) {
            System.out.println(guide + "할 데이터를 입력하세요.");

            if ((sw & NO) == NO) {
                System.out.print("번호: ");
                no = sc.nextInt();
            }
            if ((sw & NAME) == NAME) {
                System.out.print("이름: ");
                name = sc.next();
            }
        }
    }

    enum Menu {
        ADD("삽입"),
        REMOVE("삭제"),
        SEARCH("검색"),
        PRINT("출력"),
        TERMINATE("종료");

        private final String message;

        static Menu MenuAt(int index) {
            for (Menu m : Menu.values()) {
                if (m.ordinal() == index) return m;
            }
            return null;
        }

        Menu(String string) {
            message = string;
        }

        String getMessage() {
            return message;
        }
    }

    static Menu SelectMenu() {
        int key;

        do {
            for (Menu m : Menu.values()) {
                System.out.printf("(%d) %-3s", m.ordinal(), m.getMessage());
            }
            System.out.print(" : ");
            key = sc.nextInt();
        } while (key < Menu.ADD.ordinal() || key > Menu.TERMINATE.ordinal());
        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu;
        Data data;
        Data pointer;
        Data temp = new Data();
        BinarySearchTree<Integer, Data> tree = new BinarySearchTree<Integer, Data>();

        do {
            switch (menu = SelectMenu()) {

                case ADD:
                    data = new Data();
                    data.scanData("삽입", Data.NO | Data.NAME);
                    tree.add(data.keyCode(), data);
                    break;

                case REMOVE:
                    temp.scanData("삭제", Data.NO);
                    tree.remove(temp.keyCode());
                    break;

                case SEARCH:
                    temp.scanData("검색", Data.NO);
                    pointer = tree.search(temp.keyCode());
                    if (pointer != null) System.out.println("해당하는 번호의 이름은 " + pointer + "입니다.");
                    else System.out.println("해당 데이터가 없습니다.");
                    break;

                case PRINT:
                    tree.print();
                    break;
            }
        } while (menu != Menu.TERMINATE);
    }
}
