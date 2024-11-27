package LinkedList;

import java.util.Comparator;
import java.util.Scanner;

import static LinkedList.DoubleLinkedListTester.Data.*;

public class DoubleLinkedListTester {

    static Scanner sc = new Scanner(System.in);

    static class Data {
        static final int NO = 1;
        static final int NAME = 2;

        private Integer no;
        private String name;

        public String toString() {
            return "(" + no + ") " + name;
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

        public static final Comparator<Data> NO_ORDER = new NoOrderComparator();

        private static class NoOrderComparator implements Comparator<Data> {
            public int compare(Data data1, Data data2) {
                return data1.no.compareTo(data2.no);
            }
        }

        public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();

        private static class NameOrderComparator implements Comparator<Data> {
            public int compare(Data data1, Data data2) {
                return data1.name.compareTo(data2.name);
            }
        }
    }

    enum Menu {
        ADD_FIRST("머리에 노드를 삽입"),
        ADD_LAST("꼬리에 노드를 삽입"),
        ADD("선택 노드의 바라 뒤에 삽입"),
        REMOVE_FIRST("머리 노드를 삭제"),
        REMOVE_LAST("꼬리 노드를 삭제"),
        REMOVE_CURRENT("선택 노드를 삭제"),
        CLEAR("모든 노드를 삭제"),
        SEARCH_NO("번호로 검색"),
        SEARCH_NAME("이름으로 검색"),
        NEXT("선택 노드를 하나 뒤쪽으로 진행"),
        PREV("선택 노드를 앞쪽으로"),
        PRINT_CURRENT("선택 노드를 출력"),
        DUMP("모든 노드를 출력"),
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
                int ordinal = m.ordinal();
                System.out.printf("(%d) %-20s", ordinal, m.getMessage());
                if ((ordinal % 3) == 2) {
                    System.out.println();
                }
            }
            System.out.print("번호 입력: ");
            key = sc.nextInt();
        } while (key < Menu.ADD_FIRST.ordinal() || key > Menu.TERMINATE.ordinal());
        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu;
        Data data;
        Data pointer;
        Data temp = new Data();

        DoubleLinkedList<Data> list = new DoubleLinkedList<Data>();

        do {
            switch (menu = SelectMenu()) {

                case ADD_FIRST:
                    data = new Data();
                    data.scanData("머리에 삽입", NO | NAME);
                    list.addFirst(data);
                    break;

                case ADD_LAST:
                    data = new Data();
                    data.scanData("꼬리에 삽입", NO | NAME);
                    list.addLast(data);
                    break;

                case ADD:
                    data = new Data();
                    data.scanData("선택 노드 바로 뒤에 삽입", NO | NAME);
                    list.add(data);
                    break;

                case REMOVE_FIRST:
                    list.removeFirst();
                    break;

                case REMOVE_LAST:
                    list.removeLast();
                    break;

                case REMOVE_CURRENT:
                    list.removeCurrentNode();
                    break;

                case SEARCH_NO:
                    temp.scanData("검색", NO);
                    pointer = list.search(temp, NO_ORDER);
                    if (pointer == null) System.out.println("해당 데이터를 찾지 못했습니다.");
                    else System.out.println("검색 성공: " + pointer);
                    break;

                case SEARCH_NAME:
                    temp.scanData("검색", NAME);
                    pointer = list.search(temp, NAME_ORDER);
                    if (pointer == null) System.out.println("해당 데이터를 찾지 못했습니다.");
                    else System.out.println("검색 성공: " + pointer);
                    break;

                case NEXT:
                    list.next();
                    break;

                case PREV:
                    list.prev();
                    break;

                case PRINT_CURRENT:
                    list.printCurrentNode();
                    break;

                case DUMP:
                    list.dump();
                    break;

                case CLEAR:
                    list.clear();
                    break;
            }
        } while (menu != Menu.TERMINATE);
    }
}