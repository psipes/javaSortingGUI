package sorting;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Patricia on 11/15/2016.
 */
public class SortFrame extends JFrame {

    JFrame frame = new JFrame();

    /**
     * basic constructor sets the mostly non interactible parts of the frame
     */
    SortFrame()
    {
        frame = new JFrame("Group 2 Sorting");
        frame.setPreferredSize(new Dimension(800, 400));
        frame.add(new SortPanels());
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    /**
     * sets the displayable aspects and fixed aspect
     */
    public void display()
    {
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
