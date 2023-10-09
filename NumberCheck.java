import java.util.Scanner;

/**
 * Author: Michael Yun
 * Assignment: Assignment-1
 * 
 * This program will utilize exception handling in order to return the value of
 * the user-given index of an array
 * filled with random numbers, or an error message if out of bounds.
 **/

public class NumberCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 10: ");
        int number = input.nextInt();

        assert (number >= 0 && number <= 10) : "The entered number is out of range";

    }
}