package xjtlu.cpt108.complexity;

import xjtlu.cpt108.util.sort.*;

import java.util.*;

public class SortingHelper {
    public static int max_len;


    private static final List<Sort> sorts = new ArrayList<>(List.of(new BubbleSort(), new SelectionSort(), new MergeSort(), new HeapSort()));
    private static final List<String> names = new ArrayList<>(List.of("Bubble", "Selection", "Merge", "Heap"));

    //      Listener is not used in the project
/*    private static class SortingEventListener implements EventListener {
        private static final long serialVersionUID = 1L;

        private Class<?> clazz;

        public SortingEventListener(Class<?> clazz) {
            this.clazz = clazz;
        }

        @Override
        public void onMessage(MessageType messageType, String message, Object... arguments) {
            System.out.printf("%s [%s]: %s\n", clazz.getName(), messageType, message);

            SortingMessageType msgType = SortingMessageType.valueOf(messageType.getMessageType());
            switch (msgType) {
                case SORTING_START:
                    // the "arguments" variable will contain an object,
                    // i.e., the input items to be sorted
                    Utilities.printItems("  inputs: ", (Object[]) arguments[0]);
                    break;
                case SORTING_END:
                    // the "arguments" variable will contain two objects,
                    // i.e., the input items to be sorted, and the sorted items
                    Utilities.printItems("  inputs : ", (Object[]) arguments[0]);
                    Utilities.printItems("  outputs: ", (Object[]) arguments[1]);
                    break;
                default:
            }
            ;
        }

        @Override
        public void onErrorMessage(MessageType messageType, String message, Throwable e, Object... arguments) {
            System.err.printf("%s [%s]: %s\n", clazz.getName(), messageType, message);
        }

    }*/


    public static Map<String, List<Long>> ascending() {

        Map<String, List<Long>> returnMap = new HashMap<>();

        for (int i = 3; i >= 0; i--) {

            Sort sorter = sorts.get(i);
            List<Long> list = new ArrayList<>();

//            timeOfSort(sorter, DataPre.ascendingList(10));

            // The iteration time `j` could be revised for various cases

            for (int j = 1; j < 150; j += 5) {
                List<Integer> origin_data = DataPre.ascendingList(j);

                list.add(timeOfSort(sorter, origin_data));
            }
            returnMap.put(names.get(i), list);
        }

        return returnMap;

    }

    public static Map<String, List<Long>> descending() {

        Map<String, List<Long>> returnMap = new HashMap<>();

        for (int i = 3; i >= 0; i--) {

            Sort sorter = sorts.get(i);
            List<Long> list = new ArrayList<>();

            for (int j = 1; j < 25000; j += 1000) {
                List<Integer> origin_data = DataPre.descendingList(j);

                list.add(timeOfSort(sorter, origin_data));
            }
            returnMap.put(names.get(i), list);
        }

        return returnMap;

    }

    public static Map<String, List<Long>> random() {

        Map<String, List<Long>> returnMap = new HashMap<>();

        for (int i = 3; i >= 0; i--) {

            Sort sorter = sorts.get(i);
            List<Long> list = new ArrayList<>();

            for (int j = 1; j < 25000; j += 1000) {
                List<Integer> origin_data = DataPre.randomList(j);

                list.add(timeOfSort(sorter, origin_data));
            }
            returnMap.put(names.get(i), list);
        }

        return returnMap;

    }

    public static Map<String, List<Long>> repeated() {

        Map<String, List<Long>> returnMap = new HashMap<>();

        for (int i = 3; i >= 0; i--) {

            Sort sorter = sorts.get(i);
            List<Long> list = new ArrayList<>();

            for (int j = 1; j < 25000; j += 1000) {
                List<Integer> origin_data = DataPre.repeatedList(j);

                list.add(timeOfSort(sorter, origin_data));
            }
            returnMap.put(names.get(i), list);
        }

        return returnMap;

    }

    public static Map<String, List<Long>> randomString() {

        Map<String, List<Long>> returnMap = new HashMap<>();

        for (int i = 3; i >= 0; i--) {

            Sort sorter = sorts.get(i);
            List<Long> list = new ArrayList<>();

            for (int j = 1; j < 25000; j += 1000) {
                List<String> origin_data = DataPre.stringList(j);

                list.add(timeOfSort(sorter, origin_data));
            }
            returnMap.put(names.get(i), list);
        }

        return returnMap;

    }


    private static <T extends Comparable<? super T>> long timeOfSort(Sort sorter, Collection<T> input) {
        System.nanoTime();
        System.out.println("Start Sorting : " + input.size());
        long start = System.nanoTime();
        sorter.sort(input);
        long end = System.nanoTime();
        System.out.println("Sorting success");
        return (end - start) / 1000000;
    }

    public static void heapOverflowTest() {
        Sort sorter = new HeapSort();
        int num = 33554432;     // the size of list data
        while (true) {
            num = num + 1000000;
            List<Integer> input = DataPre.randomList(num);
            System.out.println("Generated : scale of " + input.size());

        }

    }

    public static void mergeOverflowTest() {
        Sort sorter = new MergeSort();
//        int num = 1;
        int num = 33554432;
        while (true) {
            num = num + 1000000;
            List<Integer> input = DataPre.randomList(num);
            System.out.println("Generated : scale of " + input.size());

        }

    }

    public static void bubbleOverflowTest() {
        Sort sorter = new BubbleSort();
//        int num = 1;
        int num = 33554432;
        while (true) {
            num = num + 1000000;
            List<Integer> input = DataPre.ascendingList(num);
            System.out.println("Generated : scale of " + input.size());

        }

    }

    public static void selectionOverflowTest() {
        Sort sorter = new SelectionSort();
//        int num = 1;
        int num = 32768;
        while (true) {
            num = num * 2;
            List<Integer> input = DataPre.randomList(num);
            System.out.println("Generated : scale of " + input.size());

        }

    }

    public static void main(String[] args) {
        System.out.println("Ascending : " + ascending());
    }

}
