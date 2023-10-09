import java.util.ArrayList;

/**
 * Author: Michael Yun
 * Assignment: Assignment-1
 * 
 * This program will utilize exception handling in order to return the value of
 * the user-given index of an array
 * filled with random numbers, or an error message if out of bounds.
 **/

public class Exercise19_03 {
    
    //main method to test functionality of removeDuplicates
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(14);
        list.add(24);
        list.add(14);
        list.add(42);
        list.add(25);
        ArrayList<Integer> newList = removeDuplicates(list);
        System.out.print(newList);
    }

    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        
        ArrayList<E> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!newList.contains(list.get(i))) {
                newList.add(list.get(i));
            }
        }
        return newList;
    }
}