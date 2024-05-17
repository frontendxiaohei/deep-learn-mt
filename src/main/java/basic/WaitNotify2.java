package basic;

public class WaitNotify2 {


    static class MyThread extends Thread{
        private boolean stopped = false;
        @Override
        public void run() {
            while (!stopped) {
                int a = 1,b = 2;
                int c = a + b;
                System.out.println("running...");
            }
        }

        public void stop2() {
            stopped = true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread();
        t1.start();
//        t1.stop2();
        t1.join();
    }

}
