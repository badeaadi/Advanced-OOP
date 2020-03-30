public class CounterOutTask implements Task {

    private static int cnt = 0;
    CounterOutTask() {
        cnt ++;
        execute();
    }
    public void execute() {
        System.out.println(cnt);
    }
}
