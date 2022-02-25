/*
* Program for sorting and searching float number in array from file
* 8 function
* 1. input data into file
* 2. read data from file and assign in to new array
* 3. sort new array by bubble sorting follow increasing
* 4. sort new array by selection sorting follow increasing
* 5. sort new array by insert sorting follow increasing
* 6. Searching index value in array greater than input value by linear searching
* 7. Searching first index value in array same input value by binary searching
* 0. exist program
 */

import java.util.Random;
import java.util.Scanner;

public class FIND_AND_SELECT {
    public static final Scanner SC = new Scanner(System.in);

    /**
     * function to check run time of sorts algorithm
     */
    public static void timeTest(){
        System.out.println("How many element in array do you want to test: ");
        int n = SC.nextInt();

        // create 3 arrays for testing
        float[] randomArr = new float[n];
        float[] increaseArr = new float[n];
        float[] decreaseArr = new float[n];

        for (int i = 0; i < n; i++){
            randomArr[i] = new Random().nextFloat();
            increaseArr[i] = i + 1;
            decreaseArr[i] = n - i;
        }
        System.out.println("*** Total time for increasing Array ***");

        //create object to contain name and time
        dataTest bubbleInc = new dataTest("Bubble Sort", Algorithm.bubbleSortTest(increaseArr));
        dataTest selectionInc = new dataTest("Selection Sort", Algorithm.selectionSortTest(increaseArr));
        dataTest insertingInc = new dataTest("Inserting Sort", Algorithm.bubbleSortTest(increaseArr));

        Algorithm.compareTimeSort(bubbleInc, selectionInc, insertingInc);

        System.out.println("*** Total time for decreasing Array ***");

        dataTest bubblingDec = new dataTest("Bubble Sort", Algorithm.bubbleSortTest(decreaseArr));
        dataTest selectionDec = new dataTest("Selection Sort", Algorithm.selectionSortTest(decreaseArr));
        dataTest insertingDec = new dataTest("Inserting Sort", Algorithm.bubbleSortTest(decreaseArr));

        Algorithm.compareTimeSort(bubblingDec, selectionDec, insertingDec);

        System.out.println("*** Total time for random Array ***");

        dataTest bubblingRan = new dataTest("Bubble Sort", Algorithm.bubbleSortTest(randomArr));
        dataTest selectionRan = new dataTest("Selection Sort", Algorithm.selectionSortTest(randomArr));
        dataTest insertingRan = new dataTest("Inserting Sort", Algorithm.bubbleSortTest(randomArr));

        Algorithm.compareTimeSort(bubblingRan, selectionRan, insertingRan);
    }

    /**
     * print menu of program
     */
    public static int printMenu() {
        System.out.println("----------MENU---------|");
        System.out.println("| 1. Input             |");
        System.out.println("| 2. Output            |");
        System.out.println("| 3. Bubble Sort       |");
        System.out.println("| 4. Selection Sort    |");
        System.out.println("| 5. Insertion Sort    |");
        System.out.println("| 6. Search > value    |");
        System.out.println("| 7. Search = value    |");
        System.out.println("| 8. Test running time |");
        System.out.println("| 0. Exit              |");
        System.out.println("|----------------------|");
        System.out.print("Input option do you want: ");
        Scanner sc = new Scanner(System.in);
        int selection = sc.nextInt();
        return selection;
    }



    /**
     * main program
     */
    public static void main(String[] args) {
        int selection;

        // array from input
        float[] inputArr = null;
        // new array from reading text
        float[] outputArr = null;

        // run all option of program
        loop:
        do {
            // print menu
            selection = printMenu();
            while (selection < 0 || selection > 8){
                System.out.println();
                System.out.println("Wrong option number");
                System.out.println("Please choice again");
                selection = printMenu();
            }

            // run option 0 - 8
            switch (selection) {

                // input data into file
                case 1:
                    inputArr = Algorithm.inputData();
                    Algorithm.writeFile("INPUT.txt", inputArr);
                    System.out.println("--------");
                    break;

                // read data from file and assign in to new array
                case 2:
                    outputArr = Algorithm.readFile("INPUT.txt");
                    if (outputArr != null) {
                        Algorithm.printStep(outputArr);
                        System.out.println("--------");
                    } else {
                        System.out.println("no have data in file");
                        System.out.println("you need to input data first");
                    }
                    break;

                // sort new array by bubble sorting follow increasing
                case 3:
                    outputArr = Algorithm.readFile("INPUT.txt");
                    if (outputArr != null) {
                        outputArr = Algorithm.bubbleSort(outputArr);
                        Algorithm.writeFile("INPUT1.txt", outputArr);
                    } else {
                        System.out.println("no have data in file");
                        System.out.println("you need to input data first");
                    }

                    break;

                //sort new array by selection sorting follow increasing
                case 4:
                    outputArr = Algorithm.readFile("INPUT.txt");
                    if (outputArr!= null) {
                        outputArr = Algorithm.selectionSort(outputArr);
                        Algorithm.writeFile("INPUT2.txt", outputArr);
                    } else {
                        System.out.println("no have data in file");
                        System.out.println("you need to input data first");
                    }
                    break;

                //sort new array by insert sorting follow increasing
                case 5:
                    outputArr = Algorithm.readFile("INPUT.txt");
                    if (outputArr != null) {
                        outputArr = Algorithm.insertSort(outputArr);
                        Algorithm.writeFile("INPUT3.txt", outputArr);
                    } else {
                        System.out.println("no have data in file");
                        System.out.println("you need to input data first");
                    }
                    break;

                //Searching index value in array greater than input value by linear searching
                case 6:
                    outputArr = Algorithm.readFile("INPUT.txt");
                    if (outputArr != null) {
                        System.out.print("Input value do you want to compare: ");
                        float value = SC.nextFloat();
                        Algorithm.search(outputArr, value);

                    } else {
                        System.out.println("no have data in file");
                        System.out.println("you need to input data first");
                    }
                    break;

                //Searching first index value in array same input value by binary searching
                case 7:
                    outputArr = Algorithm.readFile("INPUT1.txt");
                    if (outputArr != null) {
                        outputArr = Algorithm.readFile("INPUT2.txt");
                    }
                    else {
                        outputArr = Algorithm.readFile("INPUT3.txt");
                    }

                    if (outputArr != null) {
                        System.out.print("Input value do you want to find: ");
                        float value = SC.nextFloat();
                        Algorithm.binarySearch(outputArr, value);
                    } else {
                        System.out.println("no have data in file");
                        System.out.println("you need to input data and sort first");
                    }
                    break;

                case 8:
                    timeTest();
                    break;
                // exist program
                case 0:
                    System.out.print("Good bye");
                    break loop;
            }

            //run program again or not
            System.out.println("Do you want to run again (y/n)");
            String answer = SC.next();
            while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n")){
                System.out.println("You need to choice (y/n)");
                answer = SC.next();
            }
            if (answer.equalsIgnoreCase("n")) break;
        }
        while (selection > 0 || selection < 9);

    }
}