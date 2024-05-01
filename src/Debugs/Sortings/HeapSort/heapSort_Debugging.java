package Debugs.Sortings.HeapSort;

import java.util.Arrays;

public class heapSort_Debugging {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        heapSort_Debugging obj = new heapSort_Debugging();
        obj.buildHeap(arr);

        System.out.print("Sorted array: "+ Arrays.toString(arr));

    }

    void buildHeap(int[] arr) {
        int n = arr.length;

        System.out.println("\nStep 1 : Building heap...");
        int y=1;
        for (int i = n / 2 - 1; i >= 0; i--) {
            System.out.println("\nHeapify Loop iteration : "+y);
            System.out.println("\tHeapifying subtree rooted at index " + i);
            heapify(arr, n, i);
            System.out.println("\tArray after heapifying subtree rooted at index " + i + ": " + Arrays.toString(arr));
            y++;
        }


        int k=1;
        for (int i = n - 1; i > 0; i--) {
            System.out.println("\nLoop iteration : "+k);
            System.out.println("\tSwapping root with element at index " + i);
            // Swap root with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            System.out.println("\tArray after swapping root with element at index " + i + ": " + Arrays.toString(arr));

            // Re-heapify the heap after removing the root
            System.out.println("\tHeapifying the remaining heap with size " + i);
            heapify(arr, i, 0);
            System.out.println("\tArray after heapifying the remaining heap: " + Arrays.toString(arr));
            k++;
        }
        System.out.println("\nSorting completed !!");
    }

    void heapify(int[] arr, int n, int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        System.out.println("\tlargest = "+largest);
        System.out.println("\tleft = "+left);
        System.out.println("\tright = "+right);

        // Find the largest among root, left child, and right child
        if (left < n && arr[left] > arr[largest]) {
            System.out.println("\tleft < n and arr[left] > arr[largest], means left = "+left+" < n = "+n+" and arr["+left+"] = "+arr[left]+" > arr["+largest+"] = "+arr[largest]+"");
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            System.out.println("\tright < n and arr[right] > arr[largest], means right = "+right+" < n = "+n+" and arr["+right+"] = "+arr[right]+" > arr["+largest+"] = "+arr[largest]+"");
            largest = right;
        }

        // If largest is not root, swap it with the root and heapify the affected subtree
        if (largest != i) {
            System.out.println("\tSwapping elements at indices " + i + " and " + largest);
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            System.out.println("\tArray after swapping elements at indices " + i + " and " + largest + ": " + Arrays.toString(arr));
            heapify(arr, n, largest);
        }
    }
}
