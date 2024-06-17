package LambdasStreams;

public class AdditionOperation implements MathematicalOperation{
    @Override
    public int operate(int a, int b) {
        return a + b;
    }
}
