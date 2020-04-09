import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Clienti {

    public static ArrayList<Client> arrayClient= new ArrayList<>();


    public static boolean readClient(BufferedReader br) throws IOException {
        String line = br.readLine();
        if (line == null)
            return false;
        String[] sp = line.split(" ");
        Client myClient = new Client(sp[0], sp[1], Integer.parseInt(sp[2]));
        arrayClient.add(myClient);
        return true;
    }


    public static class Client{


        String nume, prenume;
        int varsta;

        Client(String nume, String prenume, int varsta) {
            this.nume = nume;
            this.prenume = prenume;
            this.varsta = varsta;

        }
        boolean eMajor() {
            return (varsta >= 18);
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("clienti.txt"));
        while (readClient(br));
        int cnt = 0;
        for (Client myClient : arrayClient) {
            if (myClient.eMajor())
                cnt ++;
        }
        System.out.println("Avem " + cnt + " clienti majori:\n");
        for (Client myClient : arrayClient) {
            if (myClient.eMajor())
                System.out.println(myClient.nume + " " + myClient.prenume + " " + myClient.varsta);
        }
        System.out.println("\nSi " +  (arrayClient.size() - cnt) + " client/i minori");

    }
}
