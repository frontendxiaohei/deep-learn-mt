package basic;

import java.beans.IntrospectionException;

/**
 * 死锁
 */
public class DeadLock {

    static Object obj1 = new Object();
    static Object obj2 = new Object();


    static class Lock1 implements Runnable {
        @Override
        public void run() {
            System.out.println("lock1 running");
            try {
                while (true) {
                    synchronized (DeadLock.obj1) {
                        System.out.println("Lock lock obj1");
                        Thread.sleep(3000);
                        synchronized (DeadLock.obj2) {
                            System.out.println("Lock lock obj2");
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Lock2 implements Runnable{
        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (DeadLock.obj2) {
                        System.out.println("Lock2 lock obj2");
                        Thread.sleep(3000);
                        synchronized (DeadLock.obj1) {
                            System.out.println("Lock2 lock obj1");
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        Thread t1 = new Thread(new Lock1());
        Thread t2 = new Thread(new Lock2());

        t1.start();
        t2.start();

    }

}
