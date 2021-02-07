package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main
{
    public static void main(String[] args)
    {
        int[] myArray = generateArray();
        {
            int[] tempArray = myArray.clone();
            long startTime = System.currentTimeMillis();
            long count = countingSort(tempArray);
            long endTime = System.currentTimeMillis();
            System.out.println("CountingSort executed " + count + " loops while sorting array of 20'000 numbers.");
            System.out.println("COUNTING SORT sorted this array in " + (endTime - startTime) + " miliseconds. \n");
        }

        {
            int[] tempArray = myArray.clone();
            long startTime = System.currentTimeMillis();
            long count = bubbleSort(tempArray);
            long endTime = System.currentTimeMillis();
            System.out.println("BubbleSort executed " + count + " loops while sorting array of 20'000 numbers.");
            System.out.println("BUBBLE SORT sorted this array in " + (endTime - startTime) + " miliseconds. \n");
        }

        {
            int[] tempArray = myArray.clone();
            long startTime = System.currentTimeMillis();
            quickSort(tempArray, 0, tempArray.length - 1);
            long endTime = System.currentTimeMillis();
            //System.out.println("QuickSort executed " + count + " loops while sorting array of 20'000 numbers.");
            System.out.println("QUICK SORT sorted this array in " + (endTime - startTime) + " miliseconds.");
        }
    }


    public static int[] generateArray()
    {
        Random rd = new Random();
        int[] myArray = new int[20000];
        for (int i = 0; i < myArray.length; i++)
        {
            myArray[i] = rd.nextInt() % 10000000;
        }
        return myArray;
    }

    static long countingSort(int[] myArray)
    {
        int counter1 = 0;
        int counter2 = 0;
        int counter3 = 0;
        int counter4 = 0;
        int sumOfCounters;
        int max = Arrays.stream(myArray).max().getAsInt();
        int min = Arrays.stream(myArray).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[myArray.length];

        for (int i = 0; i < myArray.length; i++)
        {
            count[myArray[i] - min]++;
            counter1++;
        }
        for (int i = 1; i < count.length; i++)
        {
            count[i] += count[i - 1];
            counter2++;
        }
        for (int i = myArray.length - 1; i >= 0; i--)
        {
            output[count[myArray[i] - min] - 1] = myArray[i];
            count[myArray[i] - min]--;
            counter3++;
        }
        for (int i = 0; i < myArray.length; i++)
        {
            myArray[i] = output[i];
            counter4++;
        }
        sumOfCounters = counter1 + counter2 + counter3 + counter4;
        return sumOfCounters;
    }


    public static long bubbleSort(int[] myArray)
    {
        boolean sorted = false;
        long bubbleCounter = 0;
        while (!sorted)
        {
            sorted = true;
            bubbleCounter++;
            for (int i = 0; i < myArray.length - bubbleCounter; i++)
            {
                if (myArray[i] > myArray[i + 1])
                {
                    int temp = myArray[i];
                    myArray[i] = myArray[i + 1];
                    myArray[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        return bubbleCounter;
    }

    static int partition(int[] myArray, int begin, int end)
    {
        //int countPartition = 0;

        int counter = begin;
        for (int i = begin; i < end; i++)
        {
            if (myArray[i] < myArray[end])
            {
                int temp = myArray[counter];
                myArray[counter] = myArray[i];
                myArray[i] = temp;
                counter++;
            }
            //countPartition++;
        }

        int temp = myArray[end];
        myArray[end] = myArray[counter];
        myArray[counter] = temp;

        return counter;
    }

    public static void quickSort(int[] tempArray, int begin, int end)
    {
        //long count = 0;
        if (end <= begin) return;
        int pivot = partition(tempArray, begin, end);
        quickSort(tempArray, begin, pivot - 1);
        quickSort(tempArray, pivot + 1, end);
        //return count++;
    }
}