package com.matthew.designPattern.adapter;

/**
 * Created with IntelliJ IDEA
 * User: maxing
 * TIME: 2016-10-18 15:09
 */
public class BinarySearch {
    public int binarySearch(int array[],int key){
        int low = 0;
        int high = array.length-1;
        while(low <= high){
            int mid = (low+high)/2;
            int midVal = array[mid];
            if(midVal < key ){
                low = mid +1;
            }else if(midVal > key){
                high = mid -1;
            }else{
                return mid;
            }
        }
        return -1;//未找到返回-1.
    }
}
