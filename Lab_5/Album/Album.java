import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Album implements Comparable <Album> {

    static final double eps = 0.00001;

    private String nume;
    private int anul_publicarii;
    private double rating;

    Album(String nume, int anul_publicarii, double rating)
    {
        this.nume = nume;
        this.anul_publicarii = anul_publicarii;
        this.rating = rating;
    }
    @Override
    public int compareTo(Album o) {

        double dif = this.getRating() - o.getRating();

        if (Math.abs(dif) < eps) {
            int i = 0;
            while (i < this.getNume().length() && i < o.getNume().length()) {
                if (this.getNume().charAt(i) < o.getNume().charAt(i))
                    return 1;
                if (this.getNume().charAt(i) > o.getNume().charAt(i))
                    return -1;
                i++;
            }
            if (this.getNume().length() < o.getNume().length())
                return -1;
            if (this.getNume().length() == o.getNume().length())
                return 0;
            return 1;

        }
        if (dif < 0)
            return -1;
        if (dif > 0)
            return 1;
        return 0;
    }

    private String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getAnul_publicarii() {
        return anul_publicarii;
    }

    public void setAnul_publiccarii(int anul_publiccarii) {
        this.anul_publicarii = anul_publiccarii;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    public void print()
    {
        System.out.print(this.getNume() + " ");
        System.out.print(this.getAnul_publicarii() + " ");
        System.out.println(this.getRating());
    }

    public static void main(String[] args) {

        ArrayList<Album> albumList = new ArrayList<>();
        albumList.add(new Album("Axr", 2020, 9.5));
        albumList.add(new Album("Axa", 2020, 9.5));
        albumList.add(new Album("Bab", 2020, 10));
        albumList.add(new Album("Bac", 2020, 10));
        albumList.add(new Album("B", 2020, 8));

        for (int i = 0; i < albumList.size(); i++)
            albumList.get(i).print();

        Collections.sort(albumList);
        System.out.println();

        for (int i = 0; i < albumList.size(); i++) {
            albumList.get(i).print();
        }

    }
}
