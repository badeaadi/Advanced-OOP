import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import sun.awt.SunHints;

import java.io.*;
import java.util.Scanner;

public class Pairs {


    public static void main(String [] args) throws IOException, ValueException {

        Scanner fin  = new Scanner(System.in);
        FileWriter out = new FileWriter(new File("pairs.out"));

        int n = 5;
        while (n != 0) {
            int a = fin.nextInt();
            int b = fin.nextInt();
            if (a > b) {
                try {
                    throw new ValueException("Insert other numbers");
                }
                catch (ValueException exp) {
                    System.out.println(exp);
                    continue;
                }
            }
            out.write(Integer.toString(a) + " ");
            out.write(Integer.toString(b) + "\n");
            n--;
        }
    }
}
