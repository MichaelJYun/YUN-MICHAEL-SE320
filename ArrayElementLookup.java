import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Author: Michael Yun
 * Assignment: Assignment-1
 * 
 * This program will utilize exception handling in order to return the value of
 * the user-given index of an array
 * filled with random numbers, or an error message if out of bounds.
 **/

public class ArrayElementLookup {
    public static void main(String[] args) {

        // initialize variables
        Scanner scanner = new Scanner(System.in);
        int[] randomArray = new int[100];
        Random random = new Random();
        boolean inBounds = false;
        int userInput = 0;

        // fill array with random values
        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = random.nextInt(100);
        }

        // continue to prompt user until valid input
        while (!inBounds) {
            try {
                System.out.print("Please enter the search value: ");
                userInput = scanner.nextInt();
                System.out.printf("The value at index %d is %d%n", userInput, randomArray[userInput]);
                inBounds = true;

                // if the index is out of bounds
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index out of Bounds");
                // if the user inputs anything but a valid int
            } catch (InputMismatchException e) {
                System.out.println("Please enter a valid integer.");
                scanner.next();
            }
        }

        scanner.close();
    }
}
