package HelloWorldUsingThreads;

public class Client {

    static void doSomething() {
        System.out.println("Do something return Thread :-> : " + Thread.currentThread().getName());
    }

    public static void main(String[] args)
    {
        System.out.println("Thread name : " + Thread.currentThread().getName());
        doSomething();


        PrintHelloWorld task = new PrintHelloWorld();
        task.run();
        Thread newThread = new Thread(task);
        newThread.start();
//        task.run();

    }
}
