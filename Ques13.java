public class Ques13 {
    public static void main(String[] args) {
        final Customer customer = new Customer();
        new Thread(){
            public void run(){customer.withdraw(15000);}
        }.start();
        new Thread(){
            public void run(){customer.deposit(10000);}
        }.start();
    }
}

class Customer{
    int amount=20000;

    synchronized void withdraw(int amount){
        System.out.println("going to withdraw...");

        if(this.amount<amount){
            System.out.println("Less balance; waiting for deposit...");
            try{wait();}catch(Exception e){}
        }
        this.amount-=amount;
        System.out.println("withdraw completed...");
    }

    synchronized void deposit(int amount){
        System.out.println("going to deposit...");
        this.amount+=amount;
        System.out.println("deposit completed... ");
        notify();
    }
}
