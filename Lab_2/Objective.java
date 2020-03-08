import java.util.ArrayList;
import java.util.List;

public class Objective {

    public class Student {

        protected String name;
        List<Integer> grades;

        public Student() {
            grades = new ArrayList<Integer>();
        }
        public Student(String name) {
            grades = new ArrayList<Integer>();
            this.name = name;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void addGrade(int grade) {
            grades.add(grade);
        }

        private double getAverage() {
            int sum = 0;
            for (int i = 0; i < grades.size(); i++)
                sum += grades.get(i);
            return 1.0 * sum / grades.size();
        }
        public void printData() {
            System.out.println(this.name + " are media notelor: " + getAverage());
        }
    }
    public void start() {
        Student student = new Student("Adi");
        for (int i = 1; i <= 10; i++)
            student.addGrade(9 + i % 2);
        student.printData();
    }
    public static void main(String [] args)
    {
        Objective prog = new Objective();
        prog.start();

    }
}
