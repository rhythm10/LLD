package Synchronized;

import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class Adder implements Callable<Void> {
    private Count count;

    public Adder(Count count) {
        this.count = count;
    }

    @Override
    public Void call() {
        for (int i = 1; i <= 10000; i++) {
            synchronized (count) {
                count.value += i;
            }
        }
        return null;
    }

}
