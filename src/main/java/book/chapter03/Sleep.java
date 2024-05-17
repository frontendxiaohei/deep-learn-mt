package book.chapter03;

/**
 * 不会放弃monitor锁的所有权
 */
public class Sleep {

    public static void main(String[] args) {
        new Thread(() -> {
            long st = System.currentTimeMillis();
            sleep(2000l);
            long et = System.currentTimeMillis();
            System.out.println(String.format("total spend %d ms",(et - st)));
        }).start();

        long st = System.currentTimeMillis();
        sleep(3000l);
        long et = System.currentTimeMillis();
        System.out.println(String.format("total spend %d ms",(et - st)));
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
