public class Ques11 {
    public static void main(String[] args) {
        First fnew = new First();
        Second ss = new Second(fnew, "Hello");
        Second ss1= new Second (fnew,"Vaishali");
        Second ss2 = new Second(fnew, "Gupta");
    }
}
class First
{
    public void display(String msg)
    {
        System.out.print ("["+msg);
        try
        {
            Thread.sleep(1000);
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println ("]");
    }
}

class Second extends Thread
{
    First fobj;
    String msg;
    Second (First fp,String str)
    {
        fobj = fp;
        msg = str;
        start();
    }
    public void run()
    {
       synchronized(fobj)      //Synchronized block
       {
            fobj.display(msg);
       }
    }
}

