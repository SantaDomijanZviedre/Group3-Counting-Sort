
import java.util.Random;
import java.util.*;

public class Main {

    public static void main(String[] args) {
       Random rd = new Random();
        int[] myArray = new int [20000];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = rd.nextInt(20000);
        }
            printArray(myArray);
            //bubbleSort(myArray);
            //printArray(myArray);
            countSort(myArray);
            printArray(myArray);
        }

    static void bubbleSort(int[] myArray) {
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < myArray.length - 1; i++) {
                if (myArray[i] > myArray[i + 1]) {
                    temp = myArray[i];
                    myArray[i] = myArray[i + 1];
                    myArray[i + 1] = temp;
                    sorted = false;
                        }
                    }
                }
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
