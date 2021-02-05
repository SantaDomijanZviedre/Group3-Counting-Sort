package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        Random rd = new Random();
        int[] myArray = new int[20000];
        for (int i = 0; i < myArray.length; i++) {
          myArray[i] = rd.nextInt();
        }
          //System.out.println(Arrays.toString(myArray));

        {
            long startTime = System.currentTimeMillis();
            long counts = bubbleSort(myArray);
            long endTime = System.currentTimeMillis();
            System.out.println("Array was sorted in " + (endTime - startTime) + " miliseconds.");

            //System.out.println(Arrays.toString(myArray));
            System.out.println("There were " + counts + " loops used in the sorting process.");
        }

    }




    public static long bubbleSort(int[] myArray) {
        boolean sorted = false;
        long counter = 0;
        while (!sorted) {
            sorted = true;
            counter++;
            for (int i = 0; i < myArray.length - counter; i++) {
                if (myArray[i] > myArray[i + 1]) {
                    int temp = myArray[i];
                    myArray[i] = myArray[i + 1];
                    myArray[i + 1] = temp;
                    sorted = false;
                }
            }
        }
       return counter;
    }
}
