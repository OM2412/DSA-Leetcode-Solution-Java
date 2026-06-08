package Recursion.Array_Recursion;

public class Sort_or_not {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 5};

        System.out.println(isSorted(arr, 0));
    }

    static boolean isSorted(int[] arr, int index) {

        // Base Case
        if (index == arr.length - 1) {
            return true;
        }

        // If current element is greater than next element
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        // Check remaining array
        return isSorted(arr, index + 1);
    }
}