package sorting;

import java.awt.*;

/**
 * Created by Patricia on 11/15/2016.
 */
public class QuickSort extends MasterSort {
    int startIdx;
    int endIdx;
    QuickSort(int [] sortable, Graphics pen)
    {
        super(sortable, pen);
        startIdx = 0;
        endIdx = currentArray.length-1;
    }

    @Override
    protected int[] sortMethod(Graphics pen) {

        if (!this.sortFinished) {
            recursiveQuick(currentArray, startIdx, endIdx, pen);
            for (int item : currentArray) {
                System.out.println(item);
            }
            this.sortFinished = true;
            drawSort(pen);
        }
        return currentArray;

    }


    protected void recursiveQuick(int[] array, int start, int end, Graphics pen)
    {
       int idx = partition(array, start, end);
        if (start < idx -1)
        {
            drawSort(pen);
            recursiveQuick(array, start, idx-1, pen);
        }
        if(end> idx)
        {
            drawSort(pen);
            recursiveQuick(array, idx, end, pen);
        }

        this.sortFinished = true;
        drawSort(pen);
    }


    protected int partition(int[] array, int left, int right)
    {
        int pivot = array[left];

        while (left <= right)
        {
            while (array[left] < pivot)
                left++;
            while (array[right] > pivot)
                right --;


            if (left <= right)
            {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;


                left++;
                right--;
            }
        }

        return left;


    }
}
