package Yun_Michael_Assignment5;
import java.util.Scanner;
import java.time.LocalDate;

/**
 * Author: Michael Yun
 * Assignment: Assignment-5
 * 
 * This program uses the Day class to return the number of days between a user's birthday and the current date.
 **/

public class assignment5_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //get number values for user birthday, today's date, and difference in both
        Day birthday = getUserBirthday(scanner);

        Day today = getToday();

        int daysDifference = calculateDaysDifference(birthday, today);

        //print out results
        System.out.println("Your birthday is: " + birthday.getYear() + "-" + birthday.getMonth() + "-" + birthday.getDate());
        System.out.println("Days from your birthday: " + daysDifference);
    }

    //method that returns the user birthday
    private static Day getUserBirthday(Scanner scanner) {

        //ask user for birthday details indepently with getValidInput method to check for correctness
        int year = getValidInput(scanner, "Enter your birth year (e.g., 1990): ", 1, 9999);
        int month = getValidInput(scanner, "Enter your birth month (1-12): ", 1, 12);

        Day tempDay = new Day(year, month, 1);
        
        int day = getValidInput(scanner, "Enter your birth day: ", 1, tempDay.daysPerMonth(year, month));
        Day today = getToday();

        Day birthday = new Day(year, month, day);

        //ensures birthday is a past date
        while (birthday.daysFrom(today) >= 0) {
            System.out.println("Your birthday must be before today. Please enter a valid birthday.");
            birthday = getUserBirthday(scanner);
        }

        return birthday;
    }

    //method that returns today's date
    private static Day getToday() {
        LocalDate currentDate = LocalDate.now();
        return new Day(currentDate.getYear(), currentDate.getMonthValue(), currentDate.getDayOfMonth());
    }

    //culculates the difference between 2 dates
    private static int calculateDaysDifference(Day birthday, Day today) {
        return today.daysFrom(birthday);
    }

    //ensure user-entered values are correct, askign repeatedly until correct values are entered
    private static int getValidInput(Scanner scanner, String prompt, int min, int max) {
        int input;
        do {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("That's not a valid number. Please try again.");
                System.out.print(prompt);
                scanner.next();
            }
            input = scanner.nextInt();
            if (input < min || input > max) {
                System.out.println("Input must be between " + min + " and " + max + ".");
            }
        } while (input < min || input > max);
        return input;
    }
}
