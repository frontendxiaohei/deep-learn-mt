package book.chapter03;

import java.util.concurrent.TimeUnit;

public class Interrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                // throw new RuntimeException(e);
                System.out.println("oh interrupt");
            }
        });
        thread.start();
        TimeUnit.MICROSECONDS.sleep(2);
        thread.interrupt();
    }
}
