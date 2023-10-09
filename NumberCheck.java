import java.util.Scanner;

/**
 * Author: Michael Yun
 * Assignment: Assignment-2
 * 
 * This program uses an assert statement to notify the user that 
 * their input is out of a set range.
 **/

public class NumberCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 10: ");
        int number = input.nextInt();

        assert (number >= 0 && number <= 10) : "The entered number is out of range";

    }
}