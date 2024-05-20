package basic;

/**
 * 线程状态：
 *
 */
public class ThreadStatus extends Thread {

    private String name;

    public ThreadStatus(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+ " thread " + i);
        }
    }

    public static void main(String[] args) {
        ThreadStatus thread1 = new ThreadStatus("thread1");
        ThreadStatus thread2 = new ThreadStatus("thread1");
        ThreadStatus thread3 = new ThreadStatus("thread1");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
