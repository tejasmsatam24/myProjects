/*********************************************************************************
 * Name: Tejas M. Satam, Gopi Vinyas Musunuru                                    *
 * JAVA ASSIGNMENT 05                                                            *
 * ZID : Z1854197, Z1857015                                                      *
 * TA: Sindhusha Parimi                                                          *
 * Purpose: Implementing the concepts of graphics in JAVA as an application      *
 *********************************************************************************/

//package com.company;
import java.awt.*;
import javax.swing.*;
public class GraphicsTilePGM extends JFrame {

    //This method will display the GUI
    public static void main(String[] args) {
        createAndShowGUI();
    }//end main

    public static void createAndShowGUI() {
        //creating the frame
        GraphicsTilePGM frame = new GraphicsTilePGM();
        //setting the close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //setting the size of the frame
        frame.setSize(500, 500);
        //setting the frame to visible
        frame.setVisible(true);
    }//end createAndShowGUI

    //default constructor
    public GraphicsTilePGM() {
        //creating the object for class MainPanel
        MainPanel mainPanelPtr = new MainPanel();
        //setting borderLayout for the frame
        super.setLayout(new BorderLayout());
        //adding the main panel to the center of our frame
        super.add(mainPanelPtr, BorderLayout.CENTER);
        BallAnimation panel = new BallAnimation();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setPreferredSize(new Dimension(300, 100));
        getContentPane().add(panel, BorderLayout.EAST);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));
    } // end of constructor

}
