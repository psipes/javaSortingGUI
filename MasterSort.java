package sorting;


import java.awt.*;

/**
 * Created by Patricia on 11/15/2016.
 */
public abstract class MasterSort {

    int [] previousArray;
    int [] currentArray;
    boolean [] changeArray;
    boolean sortFinished;

    MasterSort(int[] sortingNumbers, Graphics pen)
    {
        this.previousArray = new int[10];
        this.currentArray = new int[10];
        this.changeArray = new boolean[10];
        this.sortFinished = false;

        for (int i = 0; i<currentArray.length; i++)
        {
            this.currentArray[i] = sortingNumbers[i];
            this.previousArray[i] = sortingNumbers[i];
            this.changeArray[i] = false;
        }

        drawSort(pen);
    }


    protected void drawSort(Graphics pen)
    {
        for(int i = 0; i< changeArray.length; i++)
        {
            if(currentArray[i] == previousArray[i]) {
                if(changeArray[i])
                {
                //doNothing
                }
                else
                    changeArray[i] = false;
            }
            else
                changeArray[i] = true;
        }

        drawCircles(pen);
        copyArray(currentArray, previousArray);

    }



    protected void copyArray (int[] arrayToCopy, int[] arrayDestination)
    {
        for (int i = 0; i < arrayDestination.length; i++)
        {
            arrayDestination[i] = arrayToCopy[i];
        }
    }




    protected void drawCircles(Graphics pen)
    {

        for (int i = 0; i < 10; i++) {

            if (this.sortFinished)
                pen.setColor(Color.GREEN);
            else if(changeArray[i])
                pen.setColor(Color.ORANGE);
            else
                pen.setColor(Color.RED);


            pen.fillOval(80 * i, 200, 75, 75);
            pen.setColor(Color.BLACK);
            pen.drawString(Integer.toString(currentArray[i]), (80 * i) + 20, 230);
        }
    }


    protected abstract int[] sortMethod(Graphics pen);
}
