import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Author: Michael Yun
 * Assignment: Assignment-4
 * 
 * This program reads words from a text file and displays all the nonduplicate words in ascending order
 **/

public class assignment4_2 {
    public static void main(String[] args) {
        
        // example path to test
        String path = "C:\\Users\\Documents\\SE 320\\YUN-MICHAEL-SE320\\testFile.txt";

        TreeSet<String> words = new TreeSet<>();

        try {
            // read file
            File file = new File(path);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {

                //break txt file into lines
                String line = scanner.nextLine();

                //split line between words
                String[] lineWords = line.split("\\s+");

                //add the words to TreeSet
                for (String word : lineWords) {
                    if (!word.isEmpty()) {

                        //convert ot lower case to prevent duplicates and removes puncuation
                        words.add(word.replaceAll("[^\\p{L}\\p{Nd}]+", "").toLowerCase()); 
                    }
                }
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return;
        }

        //print out words
        for (String word : words) {
            System.out.println(word);
        }
    }
}

