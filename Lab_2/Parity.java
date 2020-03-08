import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parity {

    public static void main(String [] args)
    {
        List <Integer> listEven = new ArrayList<Integer>();
        List <Integer> listOdd = new ArrayList<Integer>();

        Scanner fin = new Scanner(System.in);
        int n = fin.nextInt();
        for (int i = 1; i <= n; i++) {
            int p = fin.nextInt();
            if (p % 2 == 0)
                listEven.add(p);
            else
                listOdd.add(p);
        }
        if (listEven.size() > listOdd.size())
            System.out.println("Numerele pare sunt mai multe");
        else
            System.out.println("Numerele impare sunt mai multe");

    }
}
