package sorting;

import java.awt.*;

/**
 * Created by Patricia on 11/15/2016.
 */
public class InsertionSort extends MasterSort {

    int ndx;

    InsertionSort(int [] sortable, Graphics pen)
    {
        super(sortable, pen);
        ndx = 0;
    }

    @Override
    protected int[] sortMethod(Graphics pen) {

        //do one step of the sort
        //save into currentArray
        //drawSort

        if(ndx < currentArray.length)
        {
            int j;
            int temp = currentArray[ndx];

            for (j = ndx; j > 0 && currentArray[j - 1] > temp; j--)
                currentArray[j] = currentArray[j-1];

            currentArray[j] = temp;

            drawSort(pen);
            ndx++;
            return sortMethod(pen);
        }

        else
        {
            this.sortFinished = true;
            drawSort(pen);
            return currentArray;
        }


    }
}
