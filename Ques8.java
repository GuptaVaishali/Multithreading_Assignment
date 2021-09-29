import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Ques8 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };
        System.out.println("Using Schedule");
        int delay = 2;
        scheduler.schedule(task,2, TimeUnit.SECONDS);

        System.out.println("Using Schedule At Fixed Rate");
        int initialDelay = 2;
        int periodicDelay = 1;
        scheduler.scheduleAtFixedRate(task, initialDelay, periodicDelay,
                TimeUnit.SECONDS);

        System.out.println("Scheduling At A Fixed Delay");
        scheduler.scheduleWithFixedDelay(task, 3, 10, TimeUnit.SECONDS);
        scheduler.shutdown();
    }
}
