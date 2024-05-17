package book.chapter01;


import java.util.concurrent.TimeUnit;

public class TryConcurrency {

    public static void main(String[] args) {
//        browserNews();
//        enjoyMusic();

//        new Thread(() -> {
//            enjoyMusic();
//        }).start();J
//        browserNews();

        new Thread(TryConcurrency::enjoyMusic).start();
        browserNews();

    }

    private static void enjoyMusic() {
        for (;;){
            System.out.println("good music");
            sleep(1);
        }
    }

    private static void browserNews() {
        for (;;){
            System.out.println("good news");
            sleep(1);
        }
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
