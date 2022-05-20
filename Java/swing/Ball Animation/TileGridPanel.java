//package com.company;



/*********************************************************************************
 * Name: Tejas M. Satam, Gopi Vinyas Musunuru                                    *
 * JAVA ASSIGNMENT 05                                                            *
 * ZID : Z1854197, Z1857015                                                      *
 * TA: Sindhusha Parimi                                                          *
 * Purpose: Implementing the concepts of graphics in JAVA as an application      *
 *********************************************************************************/

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class TileGridPanel extends JPanel implements MouseListener {

	//The range of this variable is 0-4 in order to accomodate the user clicks on buttons on toolbar
	//so initially we will set it to -1
	public int select_Tile = -1;

	//since our grid would be of 5*5 grid so we set squares to 25
	static final int squares = 25;

	//declaring the rows and columns
	final int gridRow = 5;
	final int gridCol = 5;

	//creating a 2dArray of Image
	Image[][] gif2dArray = new Image[gridRow][gridCol];

	//initializing the variables
	int gridWidth, gridHeight, startX, startY;



	//loading the images into the array
	public void loadImgArray() {
		for (int i = 0; i < MainPanel.imageA.length; i++) {

			//getting the name of the images from the string array and adding the images one by one to the image array
			MainPanel.imageA[i] = (Image) Toolkit.getDefaultToolkit().getImage(MainPanel.imageStringNameA[i]);
		}//end for
	}// end loadImageArray

	// This method is used to reset the grid when the reset button is pressed
	public void ResetGridTitle() {
		for (int i = 0; i < gridRow; i++) {
			for (int j = 0; j < gridCol; j++) {
				//basically we will set all the squares in the grid to null.
				gif2dArray[i][j] = null;
			}//end for
		}//end for
		this.repaint();
	}//end ResetGridTitle

	public void CreateMouseListener() {
		addMouseListener(this);
	}

	//This method is executed when the button is clicked
	@Override
	public void mouseClicked(MouseEvent arg0) {
		//here we will get the location on the grid where the mouse was clicked
		if (select_Tile >= 0) {
			int x = arg0.getX();
			int y = arg0.getY();
			//if it was a valid click in grid
			if (x >= startX && x <= startX + gridWidth && y >= startY && y <= startY + gridHeight) {

				int xIndex = (x - startX) / squares;
				int yIndex = (y - startY) / squares;

				//this will fill the selected tile in gif2dArray with the selected image
				gif2dArray[xIndex][yIndex] = MainPanel.imageA[select_Tile];

				this.repaint();
			}//end if

		}//end if

	}//end mouseClicked()

	//When we want to draw our own graphics on the screen, we should put our graphics code inside the paintComponent() method.
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		//setting the size of the grid
		gridWidth = gridCol * squares;
		gridHeight = gridRow * squares;

		int panelWidth = getWidth();
		int panelHeight = getHeight();

		//This will return the starting x point
		startX = (panelWidth - gridWidth) / 2;

		//This will return the starting y point
		startY = (panelHeight - gridHeight) / 2;

		int row, col;
		//filling empty grid of 5*5 with an inner outer loop
		for (row = 0; row < gridRow; row++) {
			for (col = 0; col < gridCol; col++) {
				// use drawRect method to draw grids on the screen
				g.drawRect(startX + (squares * row), startY + (squares * col), squares, squares);
			}
		}//end for

		//copy gif image array over to the drawing grid with inner outer loop
		for (row = 0; row < gridRow; row++) {
			for (col = 0; col < gridCol; col++) {
				//drawImage will draw the
				g.drawImage(gif2dArray[row][col], startX + (squares * row), startY + (squares * col), this);
			}//end for
		}//end for
	}//end paintComponent


	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
