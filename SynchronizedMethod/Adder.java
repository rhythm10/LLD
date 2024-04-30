package SynchronizedMethod;

import java.util.concurrent.Callable;

public class Adder implements Callable<Void> {
    private Count count;

    public Adder(Count count) {
        this.count = count;
    }

    @Override
    public Void call() {
        for (int i = 1; i <= 10000; i++) {
            count.incrementByX(i);
//            synchronized (count) {
//                count.value += i;
//            }
        }
        return null;
    }

}
