package book.chapter01;

public class TicketWindowRunnable implements Runnable{

    private int index = 1;
    private final static int MAX = 50;

    @Override
    public void run() {
        while (index < MAX) {
            System.out.println(Thread.currentThread() + " 当前的号码是：" + (index++));
        }
    }

    public static void main(String[] args) {
        final TicketWindowRunnable task = new TicketWindowRunnable();


        Thread t1 = new Thread(task, "1号窗口");
        Thread t2 = new Thread(task, "2号窗口");
        Thread t3 = new Thread(task, "3号窗口");
        Thread t4 = new Thread(task, "4号窗口");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
