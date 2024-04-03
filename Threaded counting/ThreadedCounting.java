public class ThreadedCounting
{
    static int currentIndex;
    static Object lock = new Object();
    public static class Counting extends Thread
    {       
        private int startingIndex;
        private Counter counter;
      
        public Counting(int startingIndex, Counter counter)
        {
            this.startingIndex = startingIndex;
            this.counter = counter;
        }
         
        @Override
        public void run()
        {
            synchronized(lock)
            {
                for(int i = startingIndex; i <= 100; i+=3)
                {
                    while(i != currentIndex)
                    {
                        try
                        {
                            lock.wait();
                        }
                        catch(InterruptedException e)
                        {
                            e.printStackTrace();
                        }
                    }
                    this.counter.count(i);
                    currentIndex++;
                    lock.notifyAll();
                }
            }
        }    
    }
  
    public static void countInThreads(Counter counter)
    {
        Counting t1 = new Counting(1, counter);
        Counting t2 = new Counting(2, counter);
        Counting t3 = new Counting(3, counter);
        currentIndex = 1;
      
        t1.start();
        t2.start();
        t3.start();
        
        try
        {
            t1.join();
            t2.join();
            t3.join();
        }
        catch(InterruptedException e){};
    }
}