import java.util.ArrayList;

/**
 * Author: Michael Yun
 * Assignment: Assignment-2
 * 
 * This program removes duplicates from a list and returns a new ArrayList.
 * It also has a main method that tests to ensure correct results.
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