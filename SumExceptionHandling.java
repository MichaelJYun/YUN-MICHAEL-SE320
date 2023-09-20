import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Author: Michael Yun
 * Assignment: Assignment-1
 * 
 * This program will utilize exception handling in order to return the sum of 2
 * user-given integers.
 * If the user inputs an invalid input, the program will continue to ask the
 * user until they input a valid integer.
 **/

public class SumExceptionHandling {
    public static void main(String[] args) {

        //initialize variables
        Scanner scanner = new Scanner(System.in);
        int[] userInput = new int[2];
        int i = 0;

        //continue asking for 2 valid integers
        while (i < 2) {
            System.out.printf("Please enter integer %d : ", (i + 1));
            try {
                userInput[i] = scanner.nextInt();
                i++;
            
            //if the user inputs anything but a valid integer
            } catch (InputMismatchException e) {
                System.out.println("That's not a valid integer. Try again.");
                scanner.next();
            }
        }

        //print out sum
        System.out.printf("Sum: %d", (userInput[0] + userInput[1]));
        scanner.close();
    }
}
