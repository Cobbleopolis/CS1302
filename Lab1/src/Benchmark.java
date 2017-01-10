public class Benchmark {

    public static void main(String[] args) {
        System.out.println("Normal Run Output:");
        long normalStartTime = System.currentTimeMillis();
        Lab1.main(null);
        long normalEndTime = System.currentTimeMillis();
        System.out.println("\nStream Run Output:");
        long streamStartTime = System.currentTimeMillis();
        Lab1Stream.main(null);
        long streamEndTime = System.currentTimeMillis();
        System.out.println();
        System.out.printf("Normal Runtime: %dms %n", normalEndTime - normalStartTime);
        System.out.printf("Stream Runtime: %dms %n", streamEndTime - streamStartTime);
    }
}
