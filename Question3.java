/**
 * Author: Michael Yun
 * Based on skeleton code given by Dr. Akbas
 * Assignment: Final Assignment
 * 
 * This program demonstrates a generic linear search algorithm in Java.
 */

public class Question3 {
    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].compareTo(key) == 0) {
                return i;
            }
        }
        return -1; // key not found
    }

    public static void main(String[] args) {
        Integer[] list = { 3, 4, 5, 1, -3, -5, -1 };
        System.out.println(linearSearch(list, 2)); // Should print -1, as 2 is not in the list
        System.out.println(linearSearch(list, 5)); // Should print 2, as 5 is at index 2
    }
}