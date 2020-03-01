import java.util.Scanner;

public class Lab1 {

    public static void main(String[] args) {

        Scanner fin = new Scanner(System.in);
        System.out.println("Exercitiul:");
        int request = fin.nextInt();

        switch(request) {
            case 1:
                solve_first(fin);
                break;
            case 2:
                solve_second(fin);
                break;
            case 3:
                solve_third(fin);
                break;
            case 4:
                solve_fourth(fin);
                break;
            case 5:
                solve_fifth(fin);
                break;
            case 6:
                solve_sixth(fin);
                break;
            case 7:
                solve_seventh(fin);
        }

    }
    private static void solve_seventh(Scanner fin) {
        int a = 1;
        int b = 1;
        int n = fin.nextInt();
        if (n <= 2)
            System.out.println("1");
        for (n = n - 2; n != 0 ; n--) {
            int c = a + b;
            a = b;
            b = c;
        }
        System.out.println(b);
    }
    private static void solve_sixth(Scanner fin) {

        int a = fin.nextInt();
        int b = fin.nextInt();
        int result = 1;
        while (b != 0) {
            result *= a;
            b--;
        }
        System.out.println(result);
    }
    private static void solve_fifth(Scanner fin) {
        boolean prim = true;
        int n = fin.nextInt();
        for (int i = 2; i < n; i++)
            if (n % i == 0) {
                prim = false;

            }
        System.out.println(prim == true ? "True" : "False");
    }

    private static void solve_fourth(Scanner fin) {

        int n = fin.nextInt();
        long fact = 1;
        while (n != 0) {
            fact *= n;
            n --;
        }
        System.out.println(fact);
    }
    private static void solve_third(Scanner fin) {
        int n = fin.nextInt();
        for (int i = 1; i < n; i++)
            if (n % i == 0)
                System.out.println(i + " ");
    }
    private static void solve_second(Scanner fin) {
        int a = fin.nextInt();
        int b = fin.nextInt();
        System.out.println(max(a, b));
    }

    private static int max(int a, int b) {
        if (a > b)
            return a;
        return b;
    }

    private static void solve_first(Scanner fin) {

        int a = fin.nextInt();
        int b = fin.nextInt();
        for (int i = a; i <= b; i+=2) {
            System.out.print(i + " ");
        }

    }

}


