import java.util.concurrent.atomic.AtomicInteger;

public class Ques12 {
    public static void main(String[] args) throws InterruptedException{
        myThread t = new myThread();
        Thread t1 = new Thread(t,"t1");
        Thread t2 = new Thread(t,"t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        // displaying the count
        System.out.println("count=" + t.getCount());
    }
}

class myThread extends Thread {

    // declaring an atomic variable
    private AtomicInteger count = new AtomicInteger();

    public void run()
    {
        // calculating the count
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(i * 100);

                // calling incrementAndGet() method
                // on count variable
                count.incrementAndGet();
            }
            catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    // returning the count value
    public AtomicInteger getCount() {
        return count;
    }
}
