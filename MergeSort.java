package sorting;

import java.awt.*;

/**
 * Created by Patricia on 11/15/2016.
 */
public class MergeSort extends MasterSort {
    int n;
    MergeSort(int [] sortable, Graphics pen)
    {
        super(sortable, pen);
        n = 0;
    }

    @Override
    protected int[] sortMethod(Graphics pen) {

        //do one step of the sort
        //save into currentArray
        //drawSort

        if (n == this.currentArray.length - 1 )
        {
            this.sortFinished = true;
            drawSort(pen);
            return currentArray;
        }

        int temp = n;
        int lowestNDX = n;

        for (int i = n + 1; i < currentArray.length; i++)
        {
            if(currentArray[i] < currentArray[lowestNDX])
                lowestNDX = i;
        }

        temp = currentArray[n];
        currentArray[n] = currentArray[lowestNDX];
        currentArray[lowestNDX] = temp;

        drawSort(pen);
        n++;

        return sortMethod(pen);
    }
}
