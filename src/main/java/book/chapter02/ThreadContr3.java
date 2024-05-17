package book.chapter02;

public class ThreadContr3 {


    public static void main(String[] args) {
        Thread t1 = new Thread("t1");

        ThreadGroup group = new ThreadGroup("test group");

        Thread t2 = new Thread(group, "t2");

        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();

        System.out.println("main thread belong group:" + mainThreadGroup.getName());
        System.out.println("t1 and main belong the same group: " + (mainThreadGroup == t1.getThreadGroup()));
        System.out.println("t2 thread group not belong main group: " + (mainThreadGroup == t2.getThreadGroup()));
        System.out.println("t2 thread group belong main testgroup: " + (group == t2.getThreadGroup()));
    }
}
