import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Ques7 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        List<Callable<String>> taskList = new ArrayList<>();
        taskList.add(new Task1());
        taskList.add(new Task2());
        List<Future<String>> results = service.invokeAll(taskList);
        for (Future<String> f : results) {
            System.out.println(f.get());
        }
        service.shutdown();
    }
}

class Task1 implements Callable<String> {
    @Override
    public String call() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Task 1";
    }
}

class Task2 implements Callable<String> {
    @Override
    public String call() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Task 2";
    }
}
