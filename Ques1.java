public class Ques1 {
    public static void main(String[] args) {
        Thread1 t1  = new Thread1();
        t1.start();

        Thread t2 = new Thread(new Thread2());
        t2.start();
    }
}
class Thread1 extends Thread{
    public void run(){
        System.out.println("This Run method is executing by extending thread class");
    }
}

class Thread2 implements Runnable{
    public void run(){
        System.out.println("This Run Method is executing by implementing runnable interface");
    }
}
