package sorting;

import java.awt.*;

/**
 * Created by Patricia on 11/15/2016.
 */
public class BubbleSort extends MasterSort {
    int n;
    BubbleSort(int [] sortable, Graphics pen)
    {
        super(sortable, pen);
        n = currentArray.length;
    }

    @Override
    protected int[] sortMethod(Graphics pen) {

        //do one step of the sort
        //save into currentArray
        //drawSort

        if (n == 1 )
        {
            this.sortFinished = true;
            drawSort(pen);
            return currentArray;
        }

        int temp;
        for (int i = 0; i < n-1; i++)
        {
            if(currentArray[i+1]<currentArray[i])
            {
                temp = currentArray[i];
                currentArray[i] = currentArray[i+1];
                currentArray[i+1] = temp;
            }
        }
        drawSort(pen);
        n--;

        return sortMethod(pen);
    }
}
