import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * Author: Michael Yun
 * Assignment: Assignment-4
 * 
 * This program demonstrates number formatting and parsing using Java's NumberFormat class.
 * It format sa number according to the UK locale and US currency standards and parses a formatted number string back into a number
 **/

public class assignment4_3 {

    public static void main(String[] args) {
        assignment4_3 formatter = new assignment4_3();

        double number = 12345.678;

        // print out results for (a) and (b)
        System.out.println("UK Locale format: " + formatter.UKLocale(number));
        System.out.println("US Currency format: " + formatter.USCurrency(number));

        // define string representing number to be parsed
        String numberToParse = "12,345.678";

        // try to parse string
        try {
            Number parsedNumber = formatter.parseNumber(numberToParse);
            System.out.println("Parsed number: " + parsedNumber);
        } catch (ParseException e) {
            System.out.println("Error parsing the number: " + e.getMessage());
        }
    }

    // method to format a number tp UK locale
    public String UKLocale(double number) {
        // numberFormat instance for UK locale
        NumberFormat ukFormat = NumberFormat.getNumberInstance(Locale.UK);
        // keep two digits after the decimal point
        ukFormat.setMaximumFractionDigits(2);
        ukFormat.setMinimumFractionDigits(2);
        
        return (ukFormat.format(number));
    }

    // method to format a number as US currency
    public String USCurrency(double number) {
        // numberFormat instance for US currency
        NumberFormat usCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        
        return (usCurrencyFormat.format(number));
    }

    // method to parse a string into a number, throws exception in case parsing fails
    public Number parseNumber(String number) throws ParseException {
        
        return (NumberFormat.getNumberInstance().parse(number));
    }
}