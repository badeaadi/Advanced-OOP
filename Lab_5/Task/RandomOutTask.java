public class RandomOutTask implements Task {

    private double randomNr;
    RandomOutTask(){
        randomNr = Math.random();
        execute();

    }
    @Override
    public void execute() {
        System.out.println(randomNr);
    }
}
