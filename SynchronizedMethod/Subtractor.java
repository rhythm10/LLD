package SynchronizedMethod;

import java.util.concurrent.Callable;

public class Subtractor implements Callable<Void> {
    private Count count;

    public Subtractor(Count count) {
        this.count = count;
    }

    @Override
    public Void call() {
        for (int i = 1; i <= 10000; i++) {
            count.decrementByX(i);
//            synchronized (count) {
//                count.value -= i;
//            }
        }
        return null;
    }
}
