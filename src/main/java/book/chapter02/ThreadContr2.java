package book.chapter02;

import java.util.stream.IntStream;

public class ThreadContr2 {

    private final static String PREFIX = "ALEX-";

    public static void main(String[] args) {
        IntStream.range(0,5).mapToObj(ThreadContr2::createThread)
                .forEach(Thread::start);
    }

    private static Thread createThread(final int i) {
        return new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }, PREFIX + i);
    }
}
