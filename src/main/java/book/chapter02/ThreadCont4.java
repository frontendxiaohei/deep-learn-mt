package book.chapter02;

public class ThreadCont4 {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("please enter the stack size");
            System.exit(1);
        }
        ThreadGroup group = new ThreadGroup("test group");

        Runnable runnable = new Runnable() {
            final int MAX = Integer.MAX_VALUE;

            @Override
            public void run() {
                int i = 0;
                recurse(i);
            }

            private void recurse(int i) {
                System.out.println(i);
                if (i < MAX) {
                    recurse(i + 1);
                }
            }
        };
        Thread thread = new Thread(group, runnable,"test", Integer.parseInt(args[0]));

        thread.start();


    }
}
