package SynchronizedMethod;

public class Count {
    public int value;
    Count(int value){
        this.value = value;
    }

    Count(){
        value = 0;
    }

    public synchronized void incrementByX(int x) {
        value += x;
    }

    public synchronized void decrementByX(int x) {
        value -= x;
    }

}
