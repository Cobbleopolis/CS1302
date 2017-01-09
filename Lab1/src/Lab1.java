//Class:      CS1301
//Term:       2017
//Name:       Logan Thompson
//Instructor: Monisha Verma
//Assignment: Lab 1

public class Lab1 {

    /** Stores the data for the lab. */
    private static int[] data = {
            2683, 2654, 3090, 3325, 4881, 3300, 7456, 3780,
            3232, 7270, 7773, 5553, 2850, 7619, 2762, 6965,
            4539, 3131, 6066, 5404, 4183, 6830, 2424, 4517,
            6599, 3714, 7351, 4243, 6688, 7819, 6449, 3781,
            5565, 3283, 7427
    };

    public static void main(String[] args) {
        System.out.println("Max value: " + getMax(data)); // Prints the max value found in data.
        System.out.println("Min value: " + getMin(data)); // Prints the min value found in data.
        System.out.println("Total: " + getTotal(data)); // Prints the total of data.
        System.out.println("Average: " + getAvg(data)); // Prints the average of data.
    }

    /**
     * Calculates the max found in the passed array.
     * @param data The array to find the max value of.
     * @return The max integer found in the passed array.
     */
    private static int getMax(int[] data) {
        int max = Integer.MIN_VALUE; // Stores the max integer w/ default of the max int.
        for (int i : data) // Loops over every int in data.
            max = Math.max(max, i); // Sets max to the smaller of the two numbers, max or the current int.
        return max; // Returns max.
    }

    /**
     * Calculates the min found in the passed array.
     * @param data The array to find the min value of.
     * @return The min integer found in the passed array.
     */
    private static int getMin(int[] data) {
        int min = Integer.MAX_VALUE; // Stores the min integer w/ default of the min int.
        for (int i : data) // Loops over every int in data.
            min = Math.min(min, i); // Sets min to the smaller of the two numbers, min or the current int.
        return min; // Returns min.
    }

    /**
     * Calculates the total value of the passed array.
     * @param data The array to get the total of.
     * @return The total of the passed array.
     */
    private static int getTotal(int[] data) {
        int total = 0; // Stores the total of the array.
        for (int i : data) // Loops over every int in data.
            total += i; // Adds every int to total.
        return total; // Returns total.
    }

    /**
     * Calculates the average of the passed array.
     * @param data The array to get the average of.
     * @return The average of the passed array.
     */
    private static double getAvg(int[] data) {
        return (double) getTotal(data) / data.length; // Gets the total of the array and divides it by the length of the array to get the average.
    }
}
