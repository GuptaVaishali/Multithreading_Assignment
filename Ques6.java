import java.util.concurrent.*;

public class Ques6 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                return 23;
            }
            catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(task);
        future.cancel(true); //cancels the submitted task
        System.out.println("Submitted task has already been cancelled ? = " + future.isCancelled());

        Future<Integer> future1 = executor.submit(task);
        System.out.println("Submitted task has already done ? " + future1.isDone());
        Integer result = future1.get();

        System.out.println("Submitted task has already done ? " + future1.isDone());
        System.out.println("result: " + result);
        executor.shutdownNow();
        System.out.println("Submitted task has already been cancelled ? = " + future1.isCancelled());
    }
}
