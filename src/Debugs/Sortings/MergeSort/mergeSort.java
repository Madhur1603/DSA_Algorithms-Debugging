package Debugs.Sortings.MergeSort;

import java.util.Arrays;

public class mergeSort {
    public static void main(String[] args) {
        int[] arr = {6,3,9,5,2,8,7,1};
        int l = 0;
        int r = arr.length-1;
        mergeSortArray(arr,l,r);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSortArray(int[] arr,int l,int r) {
        if(l<r){
            int mid = (l + r) / 2;
            mergeSortArray(arr,l,mid);
            mergeSortArray(arr,mid+1, r);
            
            mergeArray(arr, l, mid, r);

        }
    }

    private static void mergeArray(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] a = new int[n1];
        int[] b = new int[n2]; // temp arrays

        for(int i=0; i<n1; i++){
            a[i] = arr[l + i];
        }
        for(int i=0; i<n2; i++){
            b[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while(i < n1 && j < n2){
            if(a[i] < b[j]){
                arr[k] = a[i];
                k++; i++;
            }
            else{
                arr[k] = b[i];
                k++; j++;
            }
        }
        while(i < n1){
            arr[k] = a[i];
            k++; i++;
        }
        while(j < n2){
            arr[k] = b[j];
            k++; j++;
        }
    }
}
