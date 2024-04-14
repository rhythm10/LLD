package Executors;

import java.util.Arrays;

public class PrintNumber implements Runnable {

    int num;

    PrintNumber(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("Printing Number : " + num + " in Thread :-> " + Thread.currentThread().getName());
    }
}
