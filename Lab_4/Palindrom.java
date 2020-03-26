import java.util.Scanner;

public class Palindrom {

    public static void main(String[] args)
    {
        Scanner fin = new Scanner(System.in);
        int n = fin.nextInt();
        String [] a = new String[100];
        String [] b = new String[100];

        int k = 0;
        for (int i = 0; i < n; i++) {
            a[i] = fin.next();
            if (isPalindrom(a[i]))
                b[k++] = a[i];
        }
        int best = 0;
        for (int i = 1; i < k; i++)
            if (b[i].length() > b[best].length())
                best = i;
        System.out.println(b[best]);
    }
    private static boolean isPalindrom(String s) {

        for (int i = 0, j = s.length() - 1; i < j; i++, j--)
            if (s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }
}
