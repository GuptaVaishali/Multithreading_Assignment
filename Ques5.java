import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Ques5 {
    public static void main(String[] args) {
        Task task1 = new Task();
        Task task2 = new Task();
        System.out.println("Starting Threads");
        ThreadPoolExecutor tExecutor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        System.out.println("get Task count before:"+ tExecutor.getTaskCount());
        tExecutor.submit(task1);
        tExecutor.submit(task2);
        System.out.println("Is Executor is shutdown :"+ tExecutor.isShutdown());
        System.out.println("get Task count after:"+ tExecutor.getTaskCount());
        tExecutor.shutdown(); // shutdown worker threads
        System.out.println("Is Executor is shutdown :"+ tExecutor.isShutdown());

        System.out.println("Is Executor is Terminated :"+ tExecutor.isTerminated());
        System.out.println("Main ends");
    }
}
class Task implements Runnable{
    public void run(){
        for(int i=0;i<5;i++){
            if(i==3)
                System.out.println("i = " + i);
        }
    }
}
