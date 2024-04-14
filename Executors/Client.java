package Executors;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {

        ExecutorService ex = Executors.newFixedThreadPool(10); // will create max 10 threads in threadpool
        for(int i=1;i<=100;i++) {
            PrintNumber task = new PrintNumber(i);
            ex.submit(task);
        }

        ExecutorService exCached = Executors.newCachedThreadPool(); // will create threads if no other thread are free
        for(int i=1;i<=100;i++) {
            PrintNumber task = new PrintNumber(i);
            exCached.submit(task);
        }
    }
}
