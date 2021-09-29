public class Ques2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for(int i=1;i<=5;i++){
                System.out.println("Hi");
                try{
                    Thread.sleep(1000);
                }catch(Exception e){}
            }
        });
        Thread t2 = new Thread(() -> {
            for(int i=0;i<5;i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {}
            }
        });

        t1.start();
        t2.start();

        System.out.println(t1.isAlive());
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(t1.isAlive());
        System.out.println("This line would be printed after termination of both threads");
    }
}
