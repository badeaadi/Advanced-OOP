import java.util.Scanner;

public class Note {

    public class Student {

        public String name;
        public double mark;

        public Student(String name, double mark) {
            this.name = name;
            this.mark = mark;
        }

        public double getMark() {
            return mark;
        }

        public String getName() {
            return name;
        }

        public void setMark(int mark) {
            this.mark = mark;
        }

        public void setName(String name) {
            this.name = name;
        }

        private void printData() {
            System.out.println(this.getName() + " are nota " + this.getMark() + ".");
        }
    }
    public void start_test()
    {
        Scanner fin = new Scanner(System.in);
        int n = fin.nextInt();
        for (int i = 1; i <= n; i++) {

            String name = fin.next();
            double nota = fin.nextDouble();
            Student new_student = new Student(name, nota);
            new_student.printData();
        }
    }
    public static void main(String [] args)
    {
        Note prog = new Note();
        prog.start_test();;

    }
}
