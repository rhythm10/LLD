package HelloWorldUsingThreads;

public class PrintHelloWorld implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello World , Thread name -> " + Thread.currentThread().getName());
    }
}
