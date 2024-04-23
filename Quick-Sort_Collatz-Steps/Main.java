import java.util.*;
import java.util.concurrent.*;

public class Main {
    private static final int MAX_NUM = 100000; // Define the range of numbers to process
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    // Calculate Collatz steps for a number
    private static int collatzSteps(int n) {
        int steps = 0;
        while (n != 1) {
            if (n % 2 == 0) n = n / 2;
            else n = 3 * n + 1;
            steps++;
        }
        return steps;
    }

    // QuickSort implementation to sort by the Collatz steps
    private static void quickSort(int[] array, int[] steps, int low, int high) {
        if (low < high) {
            int pi = partition(array, steps, low, high);
            quickSort(array, steps, low, pi - 1);
            quickSort(array, steps, pi + 1, high);
        }
    }

    // Partition the array using the last element as the pivot
    private static int partition(int[] array, int[] steps, int low, int high) {
        int pivot = steps[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (steps[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                temp = steps[i];
                steps[i] = steps[j];
                steps[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        temp = steps[i + 1];
        steps[i + 1] = steps[high];
        steps[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();
        List<Future<Integer>> futures = new ArrayList<>();
        Map<Integer, Integer> map = new ConcurrentHashMap<>();

        // Submit Collatz calculations to executor
        for (int i = 1; i <= MAX_NUM; i++) {
            final int num = i;
            futures.add(executor.submit(() -> collatzSteps(num)));
        }

        // Wait for all futures to complete and collect results
        for (int i = 0; i < MAX_NUM; i++) {
            map.put(i + 1, futures.get(i).get());
        }

        // Create array of numbers and their corresponding Collatz steps
        int[] numbers = new int[MAX_NUM];
        int[] steps = new int[MAX_NUM];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            numbers[index] = entry.getKey();
            steps[index] = entry.getValue();
            index++;
        }

        // Sort numbers by their Collatz steps using QuickSort
        quickSort(numbers, steps, 0, numbers.length - 1);

        // Output sorted numbers by their steps
        System.out.println("Sorted numbers by Collatz steps:");
        for (int number : numbers) {
            System.out.println("Number: " + number + ", Steps: " + map.get(number));
        }
        System.out.println("Time taken: " + (System.currentTimeMillis() - startTime) + "ms");

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }
}
