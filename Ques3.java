import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ques3 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        RunThread r1 = new RunThread();
        RunThread r2 = new RunThread();
        executor.submit(r1);
        executor.submit(r2);
        executor.shutdown();
    }
}

class RunThread implements Runnable{
    @Override
    public void run() {
        Thread t = new Thread();
        for (int i=0;i<5;i++){
            try {
                Thread.sleep(300);
            }catch (Exception e){
                System.out.println(e);
            }
            System.out.println(t.getName());
        }
    }
}
