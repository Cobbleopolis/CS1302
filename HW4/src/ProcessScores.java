//Class:      CS1302/08
//Term:       Spring 2017
//Name:       Logan Thompson
//Instructor: Monisha Verma
//Assignment: HW4-ProcessScores

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class ProcessScores {

    private static File scoreFile = new File("Scores");

    private static URL scoreURL;

    public static void main(String[] args) {
        try {
            scoreURL = new URL("http://cs.armstrong.edu/liang/data/Scores.txt");
        } catch (MalformedURLException e) {
            System.err.println("Unable to read URL");
            e.printStackTrace();
            System.exit(-1);
        }
        System.out.println("Score results from text file:");
        printStats(readFile(scoreFile));
        System.out.println("\nScore results from url:");
        printStats(readURL(scoreURL));
    }

    private static double[] readFile(File file) {
        ArrayList<Double> doubleList = new ArrayList<>();
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(file);
            while (fileScanner.hasNext())
                doubleList.add(fileScanner.nextDouble());
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Unable to find file");
            e.printStackTrace();
        }
        double[] out = new double[doubleList.size()];
        for (int i = 0; i < out.length; i++)
            out[i] = doubleList.get(i);
        return out;
    }

    private static double[] readURL(URL url) {
        ArrayList<Double> doubleList = new ArrayList<>();
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(url.openStream());
            while (urlScanner.hasNext())
                doubleList.add(urlScanner.nextDouble());
            urlScanner.close();
        } catch (IOException e) {
            System.err.println("Unable to read URL");
            e.printStackTrace();
        }
        double[] out = new double[doubleList.size()];
        for (int i = 0; i < out.length; i++)
            out[i] = doubleList.get(i);
        return out;
    }

    private static void printStats(double[] data) {
        double total = 0.0;
        double average = 0.0;
        for (double d : data) {
            total++;
            average += d;
        }
        average /= total;
        System.out.println("Total is " + total);
        System.out.println("Average is " + average);
    }

}