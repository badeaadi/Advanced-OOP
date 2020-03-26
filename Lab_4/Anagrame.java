import java.util.Scanner;

public class Anagrame {

    public static void main(String[] args)
    {

        Scanner fin = new Scanner(System.in);
        String a = fin.next();
        String b = fin.next();
        int [] freq = new int [26];
        for (int i = 0; i < 26; i++)
            freq[i] = 0;

        for (int i = 0; i < a.length(); i++)
            freq[a.charAt(i) - 'a'] ++;
        for (int i = 0; i < b.length(); i++)
            freq[b.charAt(i) - 'a'] --;

        for (int i = 0; i < 26; i++)
            if (freq[i] != 0) {
                System.out.println("Not anagrams");
                return;
            }
        System.out.println("They are anangrams");
    }

}
