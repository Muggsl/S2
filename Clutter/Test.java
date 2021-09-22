package Clutter;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class Test {

    static Comparator<Integer> USUAL_COMPARATOR = new Comparator<Integer>() {
        public int compare(Integer intA, Integer intB) {
            if (intA < intB)
                return -1;
            else if (intA > intB)
                return +1;
            return 0;
        }
    };

    static Comparator<Integer> DISTANCE_TO_TWENTY_COMPARATOR = new Comparator<Integer>() {
        public int compare(Integer intA, Integer intB) {
            int dA = Math.abs(intA - 20), dB = Math.abs(intB - 20);
            if (dA < dB)
                return -1;
            else if (dA > dB)
                return +1;
            return USUAL_COMPARATOR.compare(intA, intB);
        }
    };

    public static void main(String[] args){
        Integer[] elements = new Integer[30];
        for(int i = 0; i < 30; i++)
            elements[i] = 30-2*i;

        StdOut.println(Arrays.toString(elements));

        // sorting an array with the natural order
        Arrays.sort(elements);
        StdOut.println(Arrays.toString(elements));

        // doing binary search in an array with a comparator (only useful for Fast2)
        StdOut.println(Arrays.binarySearch(elements,6, USUAL_COMPARATOR));
        StdOut.println(Arrays.binarySearch(elements,7, USUAL_COMPARATOR));
        StdOut.println(Arrays.binarySearch(elements,8, USUAL_COMPARATOR));
        StdOut.println(Arrays.binarySearch(elements,-47, USUAL_COMPARATOR));
        StdOut.println(Arrays.binarySearch(elements,70, USUAL_COMPARATOR));

        // sorting a subset of an array, according to a Comparator
        Arrays.sort(elements,5,25,DISTANCE_TO_TWENTY_COMPARATOR);
        StdOut.println(Arrays.toString(elements));

        // sorting an array according to a Comparator
        Arrays.sort(elements,DISTANCE_TO_TWENTY_COMPARATOR);
        StdOut.println(Arrays.toString(elements));

        // doing binary search in an array with another comparator (only useful for Fast2)
        StdOut.println(Arrays.binarySearch(elements,6, DISTANCE_TO_TWENTY_COMPARATOR));
        StdOut.println(Arrays.binarySearch(elements,7, DISTANCE_TO_TWENTY_COMPARATOR));
        StdOut.println(Arrays.binarySearch(elements,8, DISTANCE_TO_TWENTY_COMPARATOR));
        StdOut.println(Arrays.binarySearch(elements,-47, DISTANCE_TO_TWENTY_COMPARATOR));
        StdOut.println(Arrays.binarySearch(elements,70, DISTANCE_TO_TWENTY_COMPARATOR));
    }
}
