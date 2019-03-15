package com.matthew.designPattern.adapter;


/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-18 15:14
 */
public class OperationAdapter implements  ScoreOperation{
    private QuickSort sortObj;//定义适配器QuickSort对象
    private BinarySearch searchObj;//定义适配者BinarySearch对象

    public OperationAdapter(){
        sortObj = new QuickSort();
        searchObj = new BinarySearch();
    }

    public int[] sort(int[] array) {
        return sortObj.quickSork(array);
    }

    public int search(int[] array, int key) {
        return searchObj.binarySearch(array,key);
    }

    public static void main(String[] args) {
        int abc[] ={3,4,32,1};
        OperationAdapter adapter = new OperationAdapter();
        adapter.sort(abc);
        for(int i:abc){
            System.out.print(i+",");
        }
        System.out.println();
        System.out.println(adapter.search(abc,32));
    }
}
