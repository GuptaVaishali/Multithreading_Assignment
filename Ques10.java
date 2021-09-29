public class Ques10 {
    public static void main(String[] args) throws Exception{
        Counter c = new Counter();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    c.increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<1000;i++){
                    c.increment();
                }
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("count = " + c.getCount());
    }
}

class Counter{
    private int count;

    public synchronized void increment(){
        count++;  //count = count + 1
    }

    int getCount(){
        return count;
    }
}
