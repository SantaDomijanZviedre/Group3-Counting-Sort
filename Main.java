
import java.util.Random;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
       Random rd = new Random();
        int[] myArray = new int [20000];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = rd.nextInt(20000);
        }
        {
            long startTime = System.currentTimeMillis();
            long counts = bubbleSort(myArray);
            long endTime = System.currentTimeMillis();
            System.out.println("Array was sorted in " + (endTime - startTime) + " miliseconds.");

            //System.out.println(Arrays.toString(myArray));
            System.out.println("There were " + counts + " loops used in the sorting process.");
        }
            printArray(myArray);
            bubbleSort(myArray);
            printArray(myArray);
            countSort(myArray);
            printArray(myArray);
        }

    static long bubbleSort(int[] myArray) {
        boolean sorted = false;
        long counter = 0;
        int temp;
        while (!sorted) {
            sorted = true;
            counter ++;
            for (int i = 0; i < myArray.length - 1; i++) {
                if (myArray[i] > myArray[i + 1]) {
                    temp = myArray[i];
                    myArray[i] = myArray[i + 1];
                    myArray[i + 1] = temp;
                    sorted = false;
                        }
                    }
                }
        return counter;
            }

    static void countSort(int[] myArray) {
        int max = Arrays.stream(myArray).max().getAsInt();
        int min = Arrays.stream(myArray).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[myArray.length];
        for (int i = 0; i < myArray.length; i++) {
            count[myArray[i] - min]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        for (int i = myArray.length - 1; i >=0; i--) {
           output[count[myArray[i] - min] - 1] = myArray[i];
           count[myArray[i] - min]--;
        }
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = output[i];
        }
    }
    static void printArray(int[] myArray) {
        for (int i = 0; i < myArray.length; i++){
        System.out.println(myArray[i] + " ");}
        System.out.println("");
    }
}
