//package com.company;


/*********************************************************************************
 * Name: Tejas M. Satam, Gopi Vinyas Musunuru                                    *
 * JAVA ASSIGNMENT 05                                                            *
 * ZID : Z1854197, Z1857015                                                      *
 * TA: Sindhusha Parimi                                                          *
 * Purpose: Implementing the concepts of graphics in JAVA as an application      *
 *********************************************************************************/

//importing the required packages
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;

public class MainPanel extends JPanel implements ActionListener {

	//creating a variable to hold the names of the images
	//declaring it as static
	static String[] imageStringNameA = {"pat1.gif", "pat2.gif", "pat3.gif", "pat4.gif", "pat5.gif"};

	//creating an Image array, this will hold the images
	final static Image[] imageA = new Image[5];

	//creating a tool bar to hold the image buttons
	JToolBar MainPanelToolBar = new JToolBar();

	//creating the object for call TileGridPanel
	TileGridPanel tableGridPanelPtr = new TileGridPanel();

	//initializing the buttons
	JButton patch1btn;
	JButton patch2btn;
	JButton patch3btn;
	JButton patch4btn;
	JButton patch5btn;
	JButton rstBtn;

	public MainPanel() {

		//setting borderLayout
		this.setLayout(new BorderLayout());
		//adding our grid to the center of the panel
		this.add(tableGridPanelPtr, BorderLayout.CENTER);


		//creating a mouse listener
		tableGridPanelPtr.CreateMouseListener();

		//setting the background color of the panel to yellow
		tableGridPanelPtr.setBackground(Color.yellow);



		//now we will assign images to our buttons
		tableGridPanelPtr.loadImgArray();

		//setting the button1 imageIcon
		patch1btn = new JButton(new ImageIcon(imageA[0]));
		//adding the button to the toolbar
		MainPanelToolBar.add(patch1btn);

		//setting the button1 imageIcon
		patch2btn = new JButton(new ImageIcon(imageA[1]));
		//adding the button to the toolbar
		MainPanelToolBar.add(patch2btn);

		//setting the button1 imageIcon
		patch3btn = new JButton(new ImageIcon(imageA[2]));
		//adding the button to the toolbar
		MainPanelToolBar.add(patch3btn);

		//setting the button1 imageIcon
		patch4btn = new JButton(new ImageIcon(imageA[3]));
		//adding the button to the toolbar
		MainPanelToolBar.add(patch4btn);

		//setting the button1 imageIcon
		patch5btn = new JButton(new ImageIcon(imageA[4]));
		//adding the button to the toolbar
		MainPanelToolBar.add(patch5btn);

		//setting
		MainPanelToolBar.setBackground(Color.orange);

		//adding the toolBar to the mainPanel
		this.add(MainPanelToolBar, BorderLayout.NORTH);

		//creating the panel at the botton that will hold the reset button
		JPanel bottom_panel = new JPanel();

		//setting the panel layout to flow layout
		bottom_panel.setLayout(new FlowLayout());
		super.add(bottom_panel, BorderLayout.SOUTH);
		rstBtn = new JButton("Reset");
		//adding the button to the south panel
		bottom_panel.add(rstBtn);
		//setting the background color
		bottom_panel.setBackground(Color.pink);

		tableGridPanelPtr.ResetGridTitle();

		//adding Listeners
		addListeners();

	}//end MainPanel
	@Override
	public void actionPerformed(ActionEvent e) {
		//when the reset button is pressed the following function will be executed
		if (e.getSource() == rstBtn) {

			//calling the function to reset the grid
			tableGridPanelPtr.ResetGridTitle();

			//set the selected tile to -1, means nothing is selected
			tableGridPanelPtr.select_Tile = -1;
		}

		//when the 1st button is pressed
		if (e.getSource() == patch1btn) {
			tableGridPanelPtr.select_Tile = 0;
		}

		//when the 2nd button is pressed
		if (e.getSource() == patch2btn) {
			tableGridPanelPtr.select_Tile = 1;
		}

		//when the 3rd button is pressed
		if (e.getSource() == patch3btn) {
			tableGridPanelPtr.select_Tile = 2;
		}

		//when the 4th button is pressed
		if (e.getSource() == patch4btn) {
			tableGridPanelPtr.select_Tile = 3;
		}
		if (e.getSource() == patch5btn) {
			tableGridPanelPtr.select_Tile = 4;
		}
	}//end actionPerformed

	//adding listeners to all the buttons
	private void addListeners() {
		patch1btn.addActionListener(this);
		patch2btn.addActionListener(this);
		patch3btn.addActionListener(this);
		patch4btn.addActionListener(this);
		patch5btn.addActionListener(this);
		rstBtn.addActionListener(this);
	}//end addListeners

}//end class
