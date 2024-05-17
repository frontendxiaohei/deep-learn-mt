package book.chapter01;

public class TicketWindow extends Thread {

    // 柜台名称
    private final String name;

    // 最多受理50笔业务
    private static final int MAX = 5000;


    private static int index = 1;
    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index < MAX) {
            System.out.println("柜台：" + name + " 当前的号码是：" + (index++));
        }
    }

    public static void main(String[] args) {
        TicketWindow ticketWindow1 = new TicketWindow("一号出号机");
        ticketWindow1.start();
        TicketWindow ticketWindow2 = new TicketWindow("一号出号机");
        ticketWindow2.start();
        TicketWindow ticketWindow3 = new TicketWindow("一号出号机");
        ticketWindow3.start();
        TicketWindow ticketWindow4 = new TicketWindow("一号出号机");
        ticketWindow4.start();


    }
}
