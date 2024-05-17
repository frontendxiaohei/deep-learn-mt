package book.chapter01;

import java.util.concurrent.TimeUnit;

/**
 * 每一个线程都有自己的程序计数器， 局部变量表， 以及生命周期
 *
 * new
 * runnable
 * running
 * blocked
 * teminated
 *
 *
 * 1. new 创建线程 没有调用start方法
 * 2. runnable 调用start方法 ， 只能变成running或者意外终止
 * 线程的运行与否，得听cpu调度
 * 总结： 线程调用start方法，状态编程runnable,听cpu调度
 * 3. running: cpu通过轮询从任务得可执行队列中选中线程，那么它才能真正得执行自己得代码逻辑
 * 可以变化得状态
 * teminated: 调用stop
 * blocked: sleep, wait, 网络io， 获取锁，yield
 * 4. blocked
 * 可以变化得状态
 * teminated: 调用stop
 * runnable: 阻塞结束，sleep结束， notify/notifyAll,获取到锁资源，阻塞过程中被打断
 * 5. teminated
 * 整个生命周期结束
 *
 * 线程调用start方法， run方法是jvm调用 start0 这个方法是一个jni方法
 * 不能两次调用start方法， 会报Iligalthreadstateexception
 *
 *
 *
 */
public class LifeCircle {
//    public static void main(String[] args) {
//        Thread t1 = new Thread(() -> {
//            System.out.println("exception");
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//        t1.start();
//        t1.start();
//    }
        public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("exception");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        TimeUnit.SECONDS.sleep(1);
        t1.start();
    }


}
