import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Ques4 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        try {
            executor.submit(new MyThread());
            executor.submit(new MyThread());
            System.out.println("Shutingdown executor");
            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println(e);
        } finally {
            if (!executor.isTerminated()) {
                System.out.println("cancel unfinished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
}

static class MyThread extends Thread{
    public void run(){
            System.out.println("Running Task!" + Thread.currentThread().getName());
    }
}
}
