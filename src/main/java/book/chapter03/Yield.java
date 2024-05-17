package book.chapter03;

import java.util.stream.IntStream;

/**
 * 提醒调度器我愿意放弃当前cpu资源，如果cpu资源不紧张，则会忽略这种提醒
 *
 * sleep 和 yield 的爱恨情仇
 * 1. sleep 会导致当前线程暂停指定的时间，没有cpu时间片的消耗
 * 2. yield 只是对cpu调度器的一个提示，如果cpu调度器没有忽略这个提示，他会导致线程上下文的切换
 * 3. sleep会使线程短暂block,会在给定的时间内释放cpu资源
 * 4. yield 会使 running状态的thread进入runnable状态（cpu没有忽略这个hint的情况下）
 * 5. 一个线程sleep 另一个线程调用interrupt会捕获到中断信号，yield不会
 */
public class Yield {

    public static void main(String[] args) {
        IntStream.range(0,2).mapToObj(Yield::create)
                .forEach(Thread::start);
    }

    private static Thread create(int i) {
        return new Thread(() -> {
            if (i == 0) {
                Thread.yield();
            }
            System.out.println(i);
        });
    }
}
