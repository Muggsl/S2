import edu.princeton.cs.algs4.*;
import java.util.*;
import java.util.Arrays;

public class Brute
{
    static Point[] pointers;

    public static Point[] createPointers(int N)
    {
        In input = new In("testinput/input9.txt");
        int P = input.readInt();
        pointers = new Point[P];
        int count = 0;
        while(count < N)
        {
            int xCoOrdinance = input.readInt();
            int yCoOrdinance = input.readInt();
            pointers[count] = new Point(xCoOrdinance, yCoOrdinance);
            count++;
        }
        Arrays.sort(pointers);
        return pointers;
    }

    public static void main(String[] args)
    {
        In input = new In("testinput/input9.txt");
        Out output = new Out();
        int n = input.readInt();
        Brute.createPointers(n);

        for(int i = 0; i < pointers.length - 3; i++)
        {
            for(int j = i + 1; i < pointers.length - 2; j++)
            {
                for(int l = j + 1; i < pointers.length - 1; l++)
                {
                    for(int m = l + 1; i < pointers.length; m++)
                    {
                        boolean pointCompare2to3 = pointers[i].slopeTo(pointers[j]) == pointers[i].slopeTo(pointers[l]);
                        boolean pointCompare2to4 = pointers[i].slopeTo(pointers[j]) == pointers[i].slopeTo(pointers[m]);
                        if(pointCompare2to3 && pointCompare2to4)
                        {
                            output.println( pointers[i]  + " -> " +
                                            pointers[j]  + " -> " +
                                            pointers[l]  + " -> " +
                                            pointers[m]);
                        }
                    }
                }
            }
        }


    }
}
