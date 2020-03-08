import java.util.Scanner;

public class Average {

    public static void main(String [] args)
    {
        int x, sum = 0, num = 0;
        Scanner fin = new Scanner(System.in);
        x = fin.nextInt();

        do {
            num ++;
            sum += x;
            x = fin.nextInt();
        } while (x != -1);

        if (num >= 0)
            System.out.println(1.0 * sum / num);
        else
            System.out.println("No numbers");
    }

}
