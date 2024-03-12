package xjtlu.cpt108.complexity;

import xjtlu.cpt108.util.sort.StringDataGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataPre {

    public static List<Integer> ascendingList(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(2 * i + 11);
        }
        return list;
    }

    public static List<Integer> descendingList(int num) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(Integer.MAX_VALUE - 2 * i - 1);
        }
        return list;
    }

    public static List<Integer> randomList(int num) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random(42);
        for (int i = 0; i < num; i++) {
            int a = random.nextInt(0, Integer.MAX_VALUE);
            list.add(a);
        }

        return list;
    }

    public static List<Integer> repeatedList(int num) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random(42);
        if (num % 2 == 1) num = num + 1;
        for (int i = 0; i < num / 2; i++) {
            int a = 51;     // half of the list is 49
            list.add(a);
        }
        for (int i = 0; i < num / 2 - 1; i++) {
            int a = 49;     // half of the list is 51
            list.add(a);
        }
        return list;
    }

    public static List<String> stringList(int num) {
        return (List<String>) StringDataGenerator.generateFixLengthRandomString(num, 10);
    }

    public static void main(String[] args) {
        System.out.println(stringList(100));
    }

}
