
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class gui implements ActionListener
{
    GridBagConstraints c = new GridBagConstraints(); //Creating the object that will be used to set the attributes of the variuous GUI components

    public gui(SortingArray inputArray, SortingMethod sorter)
    {

        JFrame window = new JFrame("Sorting Algorithm Visualizer"); //Creating the window frame
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel containerPanel = new JPanel(); //Container panel that will contain the other panels for the window
        BoxLayout b1 = new BoxLayout(containerPanel,BoxLayout.Y_AXIS);
        containerPanel.setLayout(b1);
        window.setContentPane(containerPanel);

        //Any panels in the window shoudl get added to containerPanel here.
        containerPanel.add(createInputPanel(inputArray,sorter)); 
        containerPanel.add(createMainPanel());
        containerPanel.add(createOutputPanel());
        

        window.setSize(720,480);
        window.setVisible(true);
    }

    public JPanel createInputPanel(SortingArray inputArray, SortingMethod sorter)
    {

        JPanel inputPanel = new JPanel(new GridBagLayout()); //The panel that will contain the input components

        JLabel arraySizeText = new JLabel("Array Size (9999 maximum):");
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        inputPanel.add(arraySizeText, c);

        JTextField arraySizeInput = new JTextField(4);
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(0,5,0,0);
        inputPanel.add(arraySizeInput,c);

        JButton generateButton = new JButton("Generate");
        c.gridx = 2;
        c.gridy = 0;
        generateButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                inputArray.setElementCount(Integer.parseInt(arraySizeInput.getText()));
                inputArray.generateValues();
            }
        });
        inputPanel.add(generateButton,c);



        String[] methodList =  new String[2];
        methodList[0] = "Bubble Sort";
        methodList[1] = "Reverse Bubble Sort";

        JComboBox sortingOptions = new JComboBox(methodList);
        c.anchor = GridBagConstraints.NORTHEAST;
        sortingOptions.setSelectedIndex(0);
        c.gridx = 3;
        c.gridy = 0;
        inputPanel.add(sortingOptions,c);

        JButton sortButton = new JButton("Sort");
        c.anchor = GridBagConstraints.FIRST_LINE_END;
        c.gridx = 4;
        c.gridy = 0;
        sortButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                sorter.selectMethod(sortingOptions.getSelectedIndex(), sorter);
            }
        });
        inputPanel.add(sortButton,c);

        return inputPanel;
    }

    public JPanel createOutputPanel()
    {
        JPanel outputPanel = new JPanel(new GridBagLayout()); //The panel that will include some stats about the last algorithm run
        outputPanel.setMaximumSize(new Dimension(720,100));
        outputPanel.setPreferredSize(new Dimension(720,100));
        
        JButton test = new JButton("output panel");
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        outputPanel.add(test, c);

        return outputPanel;
    }

    public JPanel createMainPanel()
    {
        JPanel mainPanel = new JPanel(new GridBagLayout()); //The panel that will contain the main "visualizer" portion of the GUI
        mainPanel.setPreferredSize(new Dimension(400,400));
        mainPanel.setMaximumSize(new Dimension(400,400));

        JButton test = new JButton("main panel");
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.weightx = 1;
        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.BOTH;
        mainPanel.add(test, c);

        return mainPanel;
    }

}