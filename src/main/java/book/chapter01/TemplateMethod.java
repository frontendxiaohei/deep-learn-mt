package book.chapter01;

public class TemplateMethod {
    public final void print(String message) {
        System.out.println("####");
        wrapPrint(message);
        System.out.println("####");
    }
    protected void wrapPrint(String message) {

    }

    public static void main(String[] args) {
        TemplateMethod t1 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("*" + message + "*");
            }
        };

        TemplateMethod t2 = new TemplateMethod() {
            @Override
            protected void wrapPrint(String message) {
                System.out.println("**" + message + "**");
            }
        };

        t1.print("sss");
        t2.print("sss");


    }
}
