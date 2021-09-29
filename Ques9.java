import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ques9 {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newCachedThreadPool();
        ExecutorService pool2 = Executors.newFixedThreadPool(2);
        pool.execute(new Tasks("A"));
        pool.execute(new Tasks("B"));
        pool.execute(new Tasks("C"));
        pool.execute(new Tasks("D"));

        pool2.execute(new Tasks("A"));
        pool2.execute(new Tasks("B"));
        pool2.execute(new Tasks("C"));
        pool2.execute(new Tasks("D"));

        pool.shutdown();
        pool2.shutdown();
    }
}

class Tasks extends Thread {
    private String taskName;

    public Tasks(String taskName) {
        this.taskName = taskName;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();

        for (int i = 5; i >= 0; i--) {

            System.out.printf("%s -> %s: %d\n", threadName, taskName, i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
