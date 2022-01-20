import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Merge Sort: sorting method and recursion
 */
public class MergeSort
{
    private static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void sort(int[] arr)
    {
        int[] temp = new int[arr.length];
        mergeSortHelper(arr, 0, arr.length - 1, temp);
    }
    
    private static void mergeSortHelper(int[] arr, int from, int to, int[] temp)
    {        
        if(to - from >= 1)
        {
            int mid = (from + to) / 2;
            mergeSortHelper(arr, from, mid, temp);
            mergeSortHelper(arr, mid + 1, to, temp);
            merge(arr, from, mid, to, temp);
        }
    }
    
    private static void merge(int[] arr, int from, int mid, int to, int[] temp) 
    {
        int i = from;       
        int j = mid + 1;    
        int k = from;      
        while(i <= mid && j <= to)
        {
            if(arr[i] < arr[j])
            {
                temp[k] = arr[i];
                i++;
            }
            else
            {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }
        while(i <= mid)
        {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while(j <= to)
        {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for(k = from; k <= to; k++)
        {
            arr[k] = temp[k];
        }

    }
}
