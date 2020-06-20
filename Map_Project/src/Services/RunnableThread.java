package Services;

public class RunnableThread implements Runnable {
    @Override
    public void run() {

    }
    public String getName() {
        return Thread.currentThread().getName();
    }
}
