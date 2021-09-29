import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ques15 {
    public static void main(String[] args) throws InterruptedException {
        Runnner run = new Runnner();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    run.firstThread();
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    run.secondThread();
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    run.thridThread();
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    run.fourthThread();
                }catch (InterruptedException e){
                    System.out.println(e);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();

       run.finished();

    }
}

class Runnner{
    int count =0;
    Lock lock = new ReentrantLock();
    Condition cond = lock.newCondition();

    public void increase(){
        for(int i=0;i<10000;i++){
            count++;
        }
    }
    public void firstThread() throws InterruptedException {
        lock.lock();
        System.out.println("waiting");
        cond.await();
        System.out.println("Woken up!!!");
        try{
            increase();
        }finally {
            lock.unlock();
        }
    }
    public void secondThread() throws InterruptedException {
        lock.lock();
        System.out.println("waiting...............");
        cond.await();
        System.out.println("Woken up2!!!");
        try{
            increase();
        }finally {
            lock.unlock();
        }
    }
    public void thridThread() throws InterruptedException {
        Thread.sleep(1000);
        lock.lock();

        System.out.println("press key");
        new Scanner(System.in).nextLine();
        cond.signal();
        try{
            increase();
        }finally {
            lock.unlock();
        }
    }
    public void fourthThread() throws InterruptedException {
        Thread.sleep(1000);
        lock.lock();

        System.out.println("press key");
        new Scanner(System.in).nextLine();
        cond.signalAll();
        try{
            increase();
        }finally {
            lock.unlock();
        }
    }
    public void finished(){
        System.out.println("count is: " + count);
    }
}
