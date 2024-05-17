package basic;

/**
 * 所有非守护线程退出后，整个jvm进程就会退出
 *
 * 守护进程不影响整个jvm的退出
 */

public class WaitNotify {

    public static void main(String[] args) {
        System.out.println("main enter!");
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("s1 executing");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        // 设置成守护进程
        t1.setDaemon(true);
        t1.start();
        System.out.println("main exit");
    }
}
