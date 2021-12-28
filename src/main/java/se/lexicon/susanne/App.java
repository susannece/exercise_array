package se.lexicon.susanne;
import sun.security.util.ArrayUtil;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Random;
import java.util.Scanner;

public class App{
    public static void main( String[] args ){
//        storeIntInArray();
//        findNumber();
//        sortStringArray();
//        copyArray();
//        countryCity();
//        calcAverage();
//        unevenNumbers();
//        removeDuplicates();
/**     Add elements to an array.
        int[] array = {9,4,12};
        int element = 5;
        array = addToArray(array,element);
        System.out.println(Arrays.toString(array));
 */
        multiplicationTable();
 //       reverseArray();
 //     diagonalNumbers();
 //               twoArrays();
    }

/**
 * 1. Write a program which will store elements in an array of type ‘int’ and print it out.
 * Expected output: 11 23 39 etc.
 */
 public static void storeIntInArray(){
     int[] ar1 = new int[] {2, 56, 90};
     for(int i=0; i<ar1.length; i++){
             System.out.println(ar1[i]);
     }
 }
 /**
 * 2. Create a program and create a method with name ‘indexOf’ which will find and
  * return the index of an element in the array. If the element doesn’t exist your
  * method should return -1 as value. Expected output: Index position of number 5 is: 2.
 */
public static void findNumber(){
    int[] numbers = new int[] {2, 56, 90, 34, 11, 5};
    int numberToFind = 11;
    int indexToFind = indexOf(numbers, numberToFind);
    System.out.println("Index position of number " + numberToFind + " is " + indexToFind);
}

public static int indexOf(int[] numbers, int number){
    Arrays.sort(numbers);
    int indexToFind = Arrays.binarySearch(numbers, number);
    return indexToFind;
}

/** 3. Write a program which will sort string array.
 * Expected output: String array: [Paris, London, New York, Stockholm]
 * Sort string array: [London, New York, Paris, Stockholm]
 */
public static void sortStringArray(){
    String[] myArray = {"Paris","London","New York","Stockholm"};
    Arrays.sort(myArray);
    for (String name:myArray){
        System.out.print(name + " ");
    }
}

 /**
 * 4. Write a program which will copy the elements of one array into another array.
 * Expected output: Elements from first array: 1 15 20
 * Elements from second array: 1 15 20
 */
 public static void copyArray(){
     int[] numbers1 = new int[] {2, 56, 90, 34, 11, 5};
     int[] numbers2 = Arrays.copyOf(numbers1, numbers1.length);

     System.out.print("First Array: ");
     for (int number: numbers1) {
         System.out.print(" " + number);
     }
     System.out.println();
     System.out.print("Second Array: ");
     for (int number: numbers2) {
         System.out.print(" " + number);
     }
 }

/**
 * 5. Create a two-dimensional string array [2][2].
 * Assign values to the 2d array containing any Country and City.
 * Expected output: France Paris Sweden Stockholm
 */
public static void countryCity(){
    String[][] names = new String[2][2];
    names[0][0] = "France";
    names[0][1] = "Paris";
    names[1][0] = "Sweden";
    names[1][1] = "Stockholm";

    for (int i = 0; i < names.length; i++) {

        for (int j = 0; j < names[i].length; j++) {
            System.out.print(names[i][j] + " ");

            if(j==names[i].length-1){
                System.out.println();
            }
        }
    }
}

/**
 * 6. Write a program which will set up an array to hold the next values in this
 * order: 43, 5, 23, 17, 2, 14 and print the average of these 6 numbers.
 * Expected output: Average is: 17.3
 */
public static void calcAverage(){
    double[] numbers = {43, 5, 23, 17, 2, 14};
    double sum=0;
    for (int i = 0; i < numbers.length; i++) sum = sum + numbers[i];

    double resultat = sum / 6;
    DecimalFormat formatter = new DecimalFormat("#0.0");
    System.out.println("Average is " + formatter.format(resultat));

    OptionalDouble average = Arrays.stream(numbers).average();
    System.out.println("  " + average);
}

/**
 * 7. Write a program which will set up an array to hold 10 numbers and print out only
 * the uneven numbers. Expected output: Array: 1 2 4 7 9 12  Odd Array: 1 7 9
*/
    public static void unevenNumbers(){
        int[] myArray = new int[10];
        int[] oddArray = new int[0];

        for (int i = 0; i < 10; i++)
            myArray[i] = new Random().nextInt(501);

        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] % 2 != 0){
                oddArray = Arrays.copyOf(oddArray, 1 + oddArray.length);
                oddArray[oddArray.length-1] = myArray[i];
            }
        }
        System.out.print("Odd numbers: " + Arrays.toString(oddArray));
 }

/**
 * 8. Write a program which will remove the duplicate elements of a
 * given array [20, 20, 40, 20, 30, 40, 50, 60, 50].
 * Expected output: Array: 20 20 40 20 30 40 50 60 50
 * Array without duplicate values: 20 40 30 50 60
 */
public static void removeDuplicates(){
    int[] oldArray = {20, 20, 40, 20, 30, 40, 50, 60, 50};
    int[] newArray = new int[0];

    Arrays.sort(oldArray);
    for (int i=0 ; i < (oldArray.length - 1); i++) {
        if(oldArray[i]!=oldArray[i+1]){
            newArray = Arrays.copyOf(newArray, 1 + newArray.length);
            newArray[newArray.length-1] = oldArray[i];
        }

    }
    if(oldArray[oldArray.length-2]!=oldArray[oldArray.length-1]) {
        newArray = Arrays.copyOf(newArray, 1 + newArray.length);
        newArray[newArray.length - 1] = oldArray[oldArray.length-1];
    }
    System.out.print("No duplicates: " + Arrays.toString(newArray));
    System.out.println();
    System.out.print("Array: " + Arrays.toString(oldArray));
}
/**
 * 9. Write a method which will add elements in an array. Remember that arrays are fixed
 * in size so you need to come up with a solution to “expand” the array.
 */
public static int[] addToArray(int[] array, int element){
    array = Arrays.copyOf(array, 1 + array.length);
    array[array.length-1] = element;
      return array;
}

/**
 * 10. Write a program which will represent multiplication table stored in multidimensional
 *  array. Hint: You have two-dimensional array with
 * values [[1,2,3,4,5,6,7,8,9,10], [1,2,3,4,5,6,7,8,9,10]]
 */
public static void multiplicationTable(){
    int[][] table = new int[10][10];
    Scanner myObj = new Scanner(System.in);

    for (int i = 0; i < table.length; i++) {
        for (int j = 0; j < table.length; j++) {
            table[i][j] = (i+1)*(j+1);
        }
    }
    printArray(table);
    /**
    System.out.println("Första siffran?  ");
    int number1 = myObj.nextInt();
    System.out.println("Andra siffran?  ");
    int number2 = myObj.nextInt();
    System.out.println(number1 +"*"+number2+"="+table[number1][number2]);
     */
}
/**
 * 11. Write a program that ask the user for an integer and repeat that question until
 * user give you a specific value that user already has been told about as a message in
 * your program. Store these values in an array and print that array.
 * After that reverse the array elements so that the first element becomes the last element,
 * the second element becomes the second to last element, etc. Do not just reverse the
 * order in which they are printed. You need to change the way they are stored in the array.
 */
public static void reverseArray(){
    int[] newArray = new int[0];
    Scanner myObj = new Scanner(System.in);
    int setNumber = 64;
    int number=0;
    int[] reverseArray = new int[0];

    System.out.println("64");

    while(number != setNumber) {
        System.out.println("Write the number:  ");
        number = myObj.nextInt();
        newArray = addToArray(newArray, number);
    }

    System.out.println("Your numbers: " + Arrays.toString(newArray));

    for (int i = newArray.length-1; i >= 0; i--) {
        reverseArray = addToArray(reverseArray, newArray[i]);
    }

    System.out.println("Reverse numbers: " + Arrays.toString(reverseArray));
}
/**
 * 12. Write a program which will print the diagonal elements of two-dimensional array.
 * Expected output: 1 4 9
 */
public static void diagonalNumbers(){
    int[][] myArray = new int[3][3];
    int startNumber = 1;

    myArray = fillArray(myArray, startNumber);
    System.out.println("Filled: ");
    printArray(myArray);
    System.out.println();
    printArrayDiagonal(myArray);

}

public static int[][] fillArray(int[][] array, int number){
    for (int i = 0; i < array.length; i++) {
        for (int j = 0; j < array.length; j++) {
            array[i][j] = number;
            number ++;
        }
    }
    return array;
}
public static void printArray(int[][] array){
    for (int i = 0; i < array.length; i++) {

        for (int j = 0; j < array[i].length; j++) {
            System.out.print(array[i][j] + " ");

            if(j==array[i].length-1){
                System.out.println();
            }
        }
    }
}
public static void printArrayDiagonal(int[][] array){
    int k=0;

    for (int i = 0; i < array.length; i++) {

        for (int j = 0; j < array[i].length; j++) {
            System.out.print(array[k][j] + " ");
            k++;
            if(j==array[i].length-1){
                System.out.println();
            }
        }
    }

}
/**
 * 13. Create two arrays with arbitrary size and fill one with random numbers.
 * Then copy over the numbers from the array with random numbers so that the even numbers
 * are located in the rear (the right side) part of the array and the odd numbers are
 * located in the front part (the left side).
 */
public static void twoArrays(){
    int[] array1 = new int[7];
    int[] array2 = new int[7];
    int j=0;

    array1 = fillWithRandomInt(array1, 7);
    System.out.println("First Array " + Arrays.toString(array1));

    for (int i = 0; i < array1.length; i++) {
        if (array1[i] % 2 != 0) {
            array2[j] = array1[i];
            j++;
        }
    }
    for (int i = 0; i < array1.length; i++) {
        if (array1[i] % 2 == 0){
            array2[j] = array1[i];
            j++;
        }
    }
    System.out.println("Second Array " + Arrays.toString(array2));
}

public static int[] fillWithRandomInt(int[] array, int arrayLength){
    for (int i = 0; i < arrayLength; i++)
        array[i] = new Random().nextInt(501);
    return array;
}


}