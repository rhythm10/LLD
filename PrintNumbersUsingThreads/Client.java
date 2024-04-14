package PrintNumbersUsingThreads;

public class Client {

    public static void main(String[] args) {

        for(int i=0;i<100;i++)
        {
            PrintNumber task = new PrintNumber(i);
            Thread t = new Thread(task);
            t.start();
//            task.run();
        }
    }
}
