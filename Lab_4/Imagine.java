import java.util.Scanner;

public class Imagine {
    public static void main(String[] args)
    {
        Scanner fin = new Scanner(System.in);
        int n = fin.nextInt();
        int m = fin.nextInt();
        int [][] mat = new int[100][100];

        int dimension = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                mat[i][j] = fin.nextInt();
                if (!prime(mat[i][j]))
                    dimension++;
            }
        System.out.println(dimension);
    }

    private static boolean prime(int i) {

        if (i == 2)
            return true;
        if (i % 2 == 0)
            return false;
        for (int j = 3; j < i; j+= 2)
            if (i % j == 0)
                return false;
        return true;
    }
}
