import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Lab1Stream {

    private static IntSummaryStatistics stats = IntStream.of(
            2683, 2654, 3090, 3325, 4881, 3300, 7456, 3780,
            3232, 7270, 7773, 5553, 2850, 7619, 2762, 6965,
            4539, 3131, 6066, 5404, 4183, 6830, 2424, 4517,
            6599, 3714, 7351, 4243, 6688, 7819, 6449, 3781,
            5565, 3283, 7427
    ).summaryStatistics();

    public static void main(String[] args) {
        System.out.println("Max value: " + stats.getMax()); // Prints the max value found in data.
        System.out.println("Min value: " + stats.getMin()); // Prints the min value found in data.
        System.out.println("Total: " + stats.getSum()); // Prints the total of data.
        System.out.println("Average: " + stats.getAverage()); // Prints the average of data.
    }
}
