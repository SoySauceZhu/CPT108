package xjtlu.cpt108.complexity;

import xjtlu.cpt108.util.sort.BubbleSort;
import xjtlu.cpt108.util.sort.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    //-------------random one------------
    public static Integer[] generateRandom(int size) {

        Integer[] randomArr = new Integer[size];
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            int num = random.nextInt(10000);
            randomArr[i] = num;

        }
        return randomArr;
    }

    //-------------ascending one--------------
    public static Integer[] ascending(int size) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    //-----------descending one---------------
    public static Integer[] descending(int size) {
        Integer[] arr = new Integer[size];
        for (int i = size; i > 0; i--) {
            arr[i] = i;
        }
        return arr;
    }

    //-----------repeated one------
    public static Integer[] generateRepeated() {

        Integer[] randomArr = new Integer[10];
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int num = random.nextInt(6);
            randomArr[i] = num;

        }
        return randomArr;
    }

    //-------------------------
    public static void main(String[] arguments) {
        //Integer[] sampleInputs = new Integer[] { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };


        List<Integer[]> list = new ArrayList<>();
        for (int i = 1; i < 10000; i += 1000) {
            Integer[] Inputs = generateRandom(i);
            list.add(Inputs);
        }
        for (int i = 0; i < 10; i++) {
            Integer[] sampleInputs = list.get(i);
            long startTime = System.currentTimeMillis();
            Sort sorter = new BubbleSort();
            long endTime = System.currentTimeMillis();
//            sorter.addListener(new SortingEventListener(sorter.getClass()));
            sorter.sort(sampleInputs);
            System.out.println("The length of array is " + sampleInputs.length + "\nFor" + sorter.getClass().getSimpleName() + ", t" +
                    "he running time is " + (endTime - startTime));
        }
//		Sort sorter = null;
//		// sorter = new BubbleSort();
//		// sorter = new HeapSort();
//		sorter = new InsertionSort();
//		// sorter = new MergeSort();
//		// sorter = new QuickSort();
//		// sorter = new SelectionSort();
//		// sorter = new ShellSort();
//
//		sorter.addListener(new SortingEventListener(sorter.getClass()));
//
//		sorter.sort(sampleInputs);
//
//		System.out.println("==\n== Test completed!\n==");
    }

}
