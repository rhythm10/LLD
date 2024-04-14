package Callable;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService ex = Executors.newCachedThreadPool();
        List<Integer> arrayToSort = List.of(0,2,4,1,44,3,2,1);

        Sorter task = new Sorter(arrayToSort, ex);
        Future<List<Integer>> sortedArray = ex.submit(task);

       List<Integer> res =  sortedArray.get();

        System.out.println(res);
    }
}
