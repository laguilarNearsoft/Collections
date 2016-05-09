package nearsoft.algorithm.sort.quicksort;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by laguilar on 5/8/16.
 */
public class QuickSortTest {


    @Test
    public void sortTest(){

        int [] numbersToSort = {3,4,2,5,1,1,6,8,9,10,4,15,12,99,88,19};
        int [] numbersSorted = {1,1,2,3,4,4,5,6,8,9,10,12,15,19,88,99};

        QuickSort.sort(numbersToSort);

        for (int i = 0; i < numbersSorted.length; i++) {
            System.out.print(numbersToSort[i] + ",");
            Assert.assertTrue( numbersSorted[i] == numbersToSort[i] );
        }
    }


}
