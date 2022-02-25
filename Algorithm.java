import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Algorithm {
    public static final Scanner SC = new Scanner(System.in);

    /**
     * input data of array
     * @return  array after input
     */
    public static float[] inputData(){
        System.out.print("How many element do you want to input: ");
        int n = SC.nextInt();
        float[] arr = new float[n];
        for (int i = 0; i < n; i++){
            System.out.print("Element " + (i + 1) + " : ");
            arr[i] = SC.nextFloat();
        }
        return arr;
    }
    /**
     * Writing the array read from input array arr to file
     *
     * @param fileName The file name of file to write value
     * @param arr   The input float array
     */
    public static void writeFile(String fileName, float[] arr){
        String lineSeparator = System.getProperty("line.separator");

        try {
            FileOutputStream output = new FileOutputStream(fileName, false);
            for (float x: arr){
                output.write((x + "\t").getBytes());
            }
            output.write(lineSeparator.getBytes());
            output.flush();
            output.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Writing the data from input data to file
     *
     * @param fileName The file name of file to write value
     * @param data   The input float array
     */
    public static void writeDataFile(String fileName, float data){
        try {
            FileOutputStream output = new FileOutputStream(fileName, true);
            output.write((data + "\t").getBytes());
            output.flush();
            output.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Reading the file then input to the array arr
     *
     * @param fileName The file name of file to read
    // * @param arr   The output float array that will contain value read from file
     *
     */

    public static float[] readFile(String fileName){
        FileInputStream input = null;
        float[] newArray = null;
        try {
            input = new FileInputStream(fileName);
            int data = input.read();
            String a = "";
            while (data != -1){
                a += (char)data;
                data = input.read();
            }
            input.close();

            String[] arr = a.split("\\s+");
            newArray = new float[arr.length];
            for (int i = 0; i < arr.length; i++){
                newArray[i] = Float.parseFloat(arr[i]);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newArray;
    }
    /**
     * Sorting the input array using Bubble Sort algorithm.
     *
     * @param arr   Input array using for sorting
     * @return      Returning a sorted array by using the Bubble Sort algorithm
     *
     */
    public static float[] bubbleSort(float[] arr){
        float[] newArray = newArray(arr);
        int n = newArray.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - 1 - i; j++){
                if (newArray[j] > newArray[j+1]){
                    float temp = newArray[j];
                    newArray[j] = newArray[j+1];
                    newArray[j+1] = temp;
                }
            }
            printStep(newArray);
        }
        return newArray;
    }

    /**
     * Sorting the input array using Selection Sort algorithm.
     *
     * @param arr   Input array using for sorting
     * @return      Returning a sorted array by using the Selection Sort algorithm
     *
     */
    public static float[] selectionSort(float[] arr){
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            int minIndex = i;
            for (int j = i; j < n; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                float temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
            printStep(arr);
        }
        return arr;
    }

    /**
     * Sorting the input array using Insertion Sort algorithm.
     *
     * @param arr   Input array using for sorting
     * @return      Returning a sorted array by using the Insertion Sort algorithm
     *
     */
    public static float[] insertSort(float[] arr){
        int n = arr.length;
        for (int i = 1; i < n; i++){
            float ai = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > ai){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = ai;
            printStep(arr);
        }
        return arr;
    }

    /**
     * Searching the indices of elements in array [arr] greater than value. Printing
     * and writing all indices to the console screen and file OUTPUT4.TXT separated by space.
     *
     * @param arr   Input array using for searching
     * @param value The value for searching
     *
     */
    public static void search(float[] arr, float value){
        System.out.println("Index of value greater than " + value + " in array");
        int n = arr.length;
        for (int i = 0; i < n; i++){
            if (arr[i] > value){
                System.out.print(i + "\t");
                writeDataFile("INPUT4.txt",i);
            }
        }
        System.out.println();
    }

    /**
     * Searching by using the Binary Search algorithm. Returning the first index of
     * value if it is present in array arr. otherwise, return -1. The index also
     * written to file OUTPUT5.TXT and shown on the console screen.
     *
     * @param arr   Input array using for searching
     * @param value The value for searching
     * @return  The index of the element if found, otherwise, return -1
     *
     */
    public static void binarySearch(float arr[], float value){
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int mid;
        do {
            mid = (right + left)/2;
            if (arr[mid] == value) break;
            else if(arr[mid] > value){
                right = mid - 1;
            } else if(arr[mid] < value){
                left = mid + 1;
            }
        } while (right >= left);
        if (arr[mid] == value) {
            for (int i = mid - 1; i > 0; i--){
                if (arr[i] != arr[mid]){
                    break;
                } else {
                    mid = i;
                }
            }
            System.out.println("fist index of value need to find is: " + mid);
        } else {
            System.out.println("No have this value in data");
        }
    }

    /**
     * save a new array
     */
    public static float[] newArray(float[] arr){
        float[] newArray = new float[arr.length];
        for (int i = 0; i < arr.length; i++){
            newArray[i] = arr[i];
        }
        return newArray;
    }

    /**
     * print step by step
     */
    public static void printStep(float[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * code above for testing
     */

    /**
     * bubble sort algorithm
     */
    public static long bubbleSortTest(float[] arr){
        long startTime = System.nanoTime();
        float[] newArray = newArray(arr);
        int n = newArray.length;
        for (int i = 0; i < n - 1; i++){
            for (int j = 0; j < n - 1 - i; j++){
                if (newArray[j] > newArray[j+1]){
                    float temp = newArray[j];
                    newArray[j] = newArray[j+1];
                    newArray[j+1] = temp;
                }
            }
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        return totalTime;
    }

    /**
     * selection sort algorithm
     */
    public static long selectionSortTest(float[] arr){
        long startTime = System.nanoTime();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++){
            int minIndex = i;
            for (int j = i; j < n; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                float temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        return totalTime;
    }

    /**
     * insert sort algorithm
     */
    public static long insertSortTest(float[] arr){
        long startTime = System.nanoTime();
        int n = arr.length;
        for (int i = 1; i < n; i++){
            float ai = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > ai){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = ai;
            printStep(arr);
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        return totalTime;
    }

    /**
     * compare to figure out what kind of sorting is the best, worst and average
     */
    public static void compareTimeSort(dataTest a, dataTest b, dataTest c){
        dataTest[] arr = new dataTest[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        for (int i = 1; i < arr.length; i++){
            dataTest ai = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getTime() > ai.getTime()){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = ai;
        }
        System.out.println("1st :" + arr[0].getName() + "- " + arr[0].getTime());
        System.out.println("2sd :" + arr[1].getName() + "- " + arr[1].getTime());
        System.out.println("3rd :" + arr[2].getName() + "- " + arr[2].getTime());
        System.out.println();
    }

}
