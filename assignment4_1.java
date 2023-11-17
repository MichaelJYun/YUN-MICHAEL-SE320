import java.util.LinkedHashSet;

/**
 * Author: Michael Yun
 * Assignment: Assignment-4
 * 
 * This program creates two linked hash sets and find their union, difference, and intersection between them.
 **/

public class assignment4_1 {
    public static void main(String[] args) {
        LinkedHashSet<String> set1 = new LinkedHashSet<>();
        LinkedHashSet<String> set2 = new LinkedHashSet<>();

        //add vlaues to set 1
        set1.add("George");
        set1.add("Jim");
        set1.add("John");
        set1.add("Blake");
        set1.add("Kevin");
        set1.add("Michael");

        //add values to set 2
        set2.add("George");
        set2.add("Katie");
        set2.add("Kevin");
        set2.add("Michelle");
        set2.add("Ryan");


        //calling methods and printing out results
        LinkedHashSet<String> union = union(set1, set2);
        System.out.println("Union: " + union);

        LinkedHashSet<String> intersection = intersection(set1, set2);
        System.out.println("Intersection: " + intersection);

        LinkedHashSet<String> differenceSet1Set2 = differenceSet1Set2(set1, set2);
        System.out.println("Difference (First Set - Second Set): " + differenceSet1Set2);

        LinkedHashSet<String> differenceSet2Set1 = differenceSet2Set1(set1, set2);
        System.out.println("Difference (Second Set - First Set): " + differenceSet2Set1);
    }

    //method to find union b/w 2 sets
    public static LinkedHashSet<String> union(LinkedHashSet<String> set1, LinkedHashSet<String> set2) {
        LinkedHashSet<String> union = new LinkedHashSet<>(set1);
        union.addAll(set2);
        return union;
    }

    //method to find intersection b/w 2 sets
    public static LinkedHashSet<String> intersection(LinkedHashSet<String> set1, LinkedHashSet<String> set2) {
        LinkedHashSet<String> intersection = new LinkedHashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    //method to find difference b/w first and second set
    public static LinkedHashSet<String> differenceSet1Set2(LinkedHashSet<String> set1, LinkedHashSet<String> set2) {
        LinkedHashSet<String> differenceSet1Set2 = new LinkedHashSet<>(set1);
        differenceSet1Set2.removeAll(set2);
        return differenceSet1Set2;
    }

    //method to find difference b/w second and first set
    public static LinkedHashSet<String> differenceSet2Set1(LinkedHashSet<String> set1, LinkedHashSet<String> set2) {
        LinkedHashSet<String> differenceSet2Set1 = new LinkedHashSet<>(set2);
        differenceSet2Set1.removeAll(set1);
        return differenceSet2Set1;
    }
}
