package Callable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {

    private List<Integer> arrToSort;
    private ExecutorService ex;

    Sorter(List<Integer> arrToSort, ExecutorService ex)
    {
        this.arrToSort = arrToSort;
        this.ex = ex;
    }

    @Override
    public List<Integer> call() throws Exception {
        if(arrToSort.size() <= 1) {
            return arrToSort;
        }
        int mid = arrToSort.size() / 2;
        List<Integer> leftArray = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        for(int i=0;i<mid;i++)
        {
            leftArray.add((arrToSort.get(i)));
        }

        for(int i=mid;i<arrToSort.size();i++)
        {
            rightArray.add((arrToSort.get(i)));
        }

        Sorter task1 = new Sorter(leftArray, ex); // Pass the ExecutorService
        Sorter task2 = new Sorter(rightArray, ex); // Pass the ExecutorService

        Future<List<Integer>> sortedLeftArray = ex.submit(task1); // Future is used as promise that we will get some data
        Future<List<Integer>> sortedRightArray = ex.submit(task2);

        leftArray = sortedLeftArray.get(); //get is same as wait, as it will wait till i get sortedleftarray from the task1 thread
        rightArray = sortedRightArray.get();

        List<Integer> finalSortedArray = new ArrayList<>();
        int i=0,j=0;

        while(i < leftArray.size() && j < rightArray.size())
        {
            if(leftArray.get(i) <= rightArray.get(j))
            {
                finalSortedArray.add(leftArray.get(i));
                i++;
            }
            else {
                finalSortedArray.add(rightArray.get(j));
                j++;
            }
        }

        while(i < leftArray.size())
        {
            finalSortedArray.add(leftArray.get(i));
            i++;
        }

        while(j < rightArray.size())
        {
            finalSortedArray.add(rightArray.get(j));
            j++;
        }

        return finalSortedArray;
    }
}
