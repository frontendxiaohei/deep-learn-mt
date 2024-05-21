package basic;

import java.util.concurrent.TimeUnit;

public class ThreadStatus2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadStatus2());
        System.out.println(t1.getState());


        t1.start();

        System.out.println(t1.getState());

        TimeUnit.SECONDS.sleep(1);

        System.out.println(t1.getState());
    }
}
