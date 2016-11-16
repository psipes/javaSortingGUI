package sorting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Patricia on 11/15/2016.
 */
public class SortPanels extends JPanel {
    JPanel interactable;
    JButton sorter;
    JTextField theirNumbers;
    JComboBox<String> sortOptions;
    String[] sortTypes;
    JLabel instructions;
    String chosenType;
    boolean validInput;
    boolean validSort;
    boolean beginSorting;

    int[] sortableNumbers = new int[10];


    SortPanels()
    {
        validInput = false;
        validSort = false;
        beginSorting = false;

        chosenType = "Select Sort Type";
        interactable = new JPanel();
        interactable.setPreferredSize(new Dimension(800, 150));
        interactable.setBackground(Color.magenta);

        BorderLayout bLayout = new BorderLayout();
        this.setLayout(bLayout);



        BorderLayout interactableLayout = new BorderLayout();
        interactable.setLayout(interactableLayout);
        this.add(interactable, bLayout.NORTH);

        theirNumbers = new JTextField("Enter Numbers Here");
        theirNumbers.addKeyListener(new KeyListen());

        instructions = new JLabel("<html>Welcome to Sorting Headquarters. <br> " +
                "1. Please enter 10 positive integers separated by spaces and press enter/return.<br>" +
                "2. Select the sorting type you wish to view in the dropdown menu.<br>" +
                "3. Press the \"SORT\" button to start the animation.<br>" +
                "Enjoy.");
        instructions.setPreferredSize(new Dimension(600, 100));

        sortTypes = new String[]{"Select Sort Type", "Insertion Sort", "Selection Sort", "Bubble Sort", "Merge Sort", "Quick Sort"};

        sortOptions = new JComboBox<>(sortTypes);
        sortOptions.addItemListener(new TypeListener());

        sorter = new JButton("SORT");
        sorter.addActionListener(new ButtonListener());
        this.add(sorter, bLayout.SOUTH);

        interactable.add(instructions, interactableLayout.NORTH);
        interactable.add(theirNumbers, interactableLayout.CENTER);
        interactable.add(sortOptions, interactableLayout.SOUTH);


    }

    public void paintComponent(Graphics pen)
    {
        super.paintComponent(pen);
        if (!beginSorting) {
            paintStartingCircles(pen);
            repaint();
        }

        else {
            MasterSort sorter;
            repaint();
            switch (chosenType)
            {
                case "Selection Sort":
                    sorter = new SelectionSort(sortableNumbers, pen);
                    break;
                case "Insertion Sort":
                    sorter = new InsertionSort(sortableNumbers, pen);
                    break;
                case "Bubble Sort":
                    sorter = new BubbleSort(sortableNumbers, pen);
                    break;
                case "Merge Sort":
                    sorter = new MergeSort(sortableNumbers, pen);
                    break;
                case "Quick Sort":
                    sorter = new QuickSort(sortableNumbers, pen);
                    break;
                default:
                    sorter = new SelectionSort(sortableNumbers, pen);

            }

            if (!sorter.sortFinished) {
                sorter.sortMethod(pen);
            }

        }






    }

    protected void paintStartingCircles(Graphics g)
    {

        Color chosenColor;
        if (validInput) {
            switch (chosenType) {
                case "Select Sort Type":

                    g.setColor(Color.black);
                    chosenColor = Color.BLACK;
                    g.drawString("Please Select Sort Option Above.", 300, 170);
                    break;
                default:
                    g.setColor(Color.RED);
                    chosenColor = Color.RED;
                    break;

            }

            for (int i = 0; i < 10; i++) {
                g.fillOval(80 * i, 200, 75, 75);
                g.setColor(Color.BLACK);
                g.drawString(Integer.toString(sortableNumbers[i]), (80 * i) + 20, 230);
                g.setColor(chosenColor);
            }
        }
        else
            g.drawString("Please Enter 10 Positive Integers separated by spaces above and then press ENTER.", 0, 200);
        repaint();

    }

    private boolean checkInput(String input)
    {
        String [] splitter;
        if(Character.isAlphabetic(input.charAt(0)))
            return false;
        else
        {
            splitter = input.split(" ");
            for (String split: splitter)
            {
                for (int i = 0; i < split.length(); i++)
                {
                    if(Character.isDigit(split.charAt(i)))
                    {
                        //do nothing
                    }
                    else
                        return false;
                }
            }

            if (splitter.length !=10)
                return false;
        }


        for (int i = 0; i < sortableNumbers.length; i++)
        {
            sortableNumbers[i] = Integer.parseInt(splitter[i]);
        }
        return true;
    }


    /**
     * Private internal class, anonymously sets up Item Listener.
     */
    private class TypeListener implements ItemListener
    {

        /**
         * Checks if a state has been changed on the dropdown box
         * @param e the event
         */

        @Override
        public void itemStateChanged(ItemEvent e) {
            //Item State Changed fires twice, one for selected, one for deselected
            //This if statement ensures that we are just checking the selection statement.
            if (e.getStateChange() == ItemEvent.SELECTED) {
                chosenType =(sortOptions.getSelectedItem().toString());
                validSort = !chosenType.equals(sortTypes[0]);
            }

        }
    }

    private class KeyListen implements KeyListener
    {

        @Override
        public void keyTyped(KeyEvent e) {
            //Nothing to see here
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                JTextField textField = (JTextField) e.getSource();
                String text = textField.getText();
                validInput = (checkInput(text));

                repaint();
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            //nothing to see here.
        }
    }


    private class ButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (validInput && validSort)
                beginSorting = true;

        }
    }
}
