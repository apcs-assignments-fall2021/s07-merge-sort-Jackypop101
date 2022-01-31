import java.util.ArrayList;
import java.util.Arrays;

public class MyMain {
    // ********************
    // Code from homework
    // ********************

    public static int[] merge(int[] arr1, int[] arr2) {
        int j = 0;
        int i = 0;
        int k = 0;
        int [] arr3 = new int[arr1.length*2];
        while (arr3[arr3.length-1] == 0) {
            if (j >= arr1.length){
                for (i = i; i < arr2.length; i ++){
                    arr3[k] = arr2[i];
                    k++;
                }
            }
            else if (i >= arr2.length){
                for (j = j; j < arr1.length; j ++){
                    arr3[k] = arr1[j];
                    k++;
                }
            }
            else if (arr1[j] < arr2[i]) {
                arr3[k] = arr1[j];
                j++;
                k++;
            }
            else if (arr1[j] > arr2[i]) {
                arr3[k] = arr2[i];
                i++;
                k++;
            }

        }
        return arr3;
    }

    // **************************
    // In-class Practice Problems
    // **************************

    // Create a copy of part of an array
    // This should work similarly to substring in that we are
    // given two indexes, start and end, and we start with the
    // value at start and go up to but not including end

    // Examples:
    // subArray([5, 4, 3, 2, 1], 1, 3) => [4, 3]
    // subArray([1, 4, 3, 7], 0, 4) => [1, 4, 3, 7]
    // subArray([1, 4, 3, 7], 2, 4) => [3, 7]
    public static int[] subArray(int[] arr, int begin, int end) {
        int [] arr1 = new int [end - begin];
    for (int i = begin; i < end; i++){
        arr1[i-begin] = arr[i];
    }
//    for (int i = 0; i < arr1.length; i++){
//        arr[i] = arr[begin + i];
//    }
        return arr1;
    }

    // Carries out merge sort!
    // The merge sort algorithm is divided into three main steps
    // Divide the array into two halves
    // Call merge sort (recursively) on the left half and the right half
    // Call merge to combine the two sorted halves into one sorted array
    //
    // We will keep recursing until the array is size 1, at which point we
    // just array the (sorted) array of size 1

    // You can assume that the array's length will be some power of 2

    // Examples:
    // mergeSort([6, 3, 4, 1, 5, 8, 7, 2]) => [1, 2, 3, 4, 5, 6, 7, 8]
    public static int[] mergeSort(int[] arr) {

        if ((arr.length == 0) || (arr.length ==1 )) {
            return arr;
        }
        int[] arr1 = subArray(arr, 0, arr.length/2);
        int[] arr2 = subArray(arr, arr.length/2, arr.length);
        arr1 = mergeSort(arr1);
        arr2 = mergeSort(arr2);
        return merge(arr1,arr2);

    }



    // **************************
    // Homework Methods
    // **************************

    // For homework, we'll revisit a previous algorithm: insertion sort.
    // This will be the final recursive code that we'll write for a while.

    // First, write the insert method, which is given a sorted ArrayList
    // and a number x to insert into that ArrayList

    // Tail recursion will probably be helpful!

    // Hint: recall that we are going to insert x once we find the first
    // number in the ArrayList that is larger than x

    // Hint2: if we never find a number larger than x, x should be inserted
    // at the end of our ArrayList

    // Examples:
    // insert([1, 2, 4, 5], 3) => [1, 2, 3, 4, 5]
    // insert([1, 2, 4, 5], 0) => [0, 1, 2, 4, 5]
    // insert([1, 2, 4, 5, 7, 8], 10) => [1, 2, 4, 5, 7, 8, 10]

    // Wrapper method
    public static ArrayList<Integer> insert(ArrayList<Integer> list, int x) {
        return insertTR(list, x, 0);
    }

    // Tail recursive method
    public static ArrayList<Integer> insertTR(ArrayList<Integer> list, int x, int i) {
        if (list.get(i) > x){
            list.add(i, x);
            return list;
        }
        else if(i >= list.size()-1){
            list.add(list.size()-1, x);
            return list;
        }
        else{
            return insertTR(list, x, i++);
        }
    }

    // Next, write the insertion sort method, which is sorts a given
    // ArrayList using insertion sort

    // We can use the following recursive pseudocode:
    // Base case: if the list is size 1, it's sorted so just return the original list
    // Otherwise:
    // * Save the last element in the ArrayList
    // * Remove the last element of the ArrayList (making the list 1 shorter)
    // * Recursively sort the (now shorter) list
    // * Insert the saved value into the sorted, shorter list

    // No tail recursion necessary!

    // Hint: use the insert value from above

    // Examples:
    /// insertionSort([6, 3, 4, 1, 5, 8, 7, 2]) => [1, 2, 3, 4, 5, 6, 7, 8]
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
        if (list.size() == 1){
            return list;
        }
        else{
            int w = list.get(list.size() -1);
            list.remove(list.size() -1);
            insert(list,w );
            return insertionSort(list);
        }
    }
}
