package nearsoft.algorithm.sort.quicksort;

public class QuickSort {


    public static void sort(int [] arrayToSort ){

        if ( arrayToSort == null || arrayToSort.length == 0) return;
        sort(arrayToSort, 0, arrayToSort.length);
    }

    private static void sort( int [] arrayToSort, int leftIndex, int rigthIndex){

        if ( leftIndex >= rigthIndex ) return;

        int pivotIndex = leftIndex;
        int lastLeftIndex = leftIndex;
        int lastRightIndex = rigthIndex;

        for (int i = leftIndex + 1; i < rigthIndex; i++){

            if (arrayToSort[i] < arrayToSort[pivotIndex] ) {
                leftIndex++;
                switchElements(arrayToSort, leftIndex, i);
            }
        }

        switchElements(arrayToSort, leftIndex, pivotIndex);
        sort(arrayToSort, lastLeftIndex, leftIndex );
        sort(arrayToSort, leftIndex + 1, lastRightIndex );
    }

    private static void switchElements(int[] arrayToSort, int firstIndex, int secondIndex) {
        int aux = arrayToSort[firstIndex];
        arrayToSort[firstIndex] = arrayToSort[secondIndex];
        arrayToSort[secondIndex] = aux;
    }

}
