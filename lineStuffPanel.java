/**
 * @(#)lineStuffPanel.java
 *
 *
 * @author 
 * @version 1.00 2019/4/28
 */

import javax.swing.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

public class lineStuffPanel extends JPanel implements ActionListener{
	
	// NECCESARY VARIABLES
	private int x, y, newY;
	private Color[] colors = new Color[5];

	// TYPE SETTINGS
	private int type = 0;								// 0 - line. 1 - oval, 2 - rectangle

	// LINE SETTINGS
	private int numLines = 50;							// number of lines
	private int numMoves = 500;							// number of movements in the line
	private int randomStart = 0;  						// 0 for start in center, 1 for random line starts

	// MOVEMENT SETTINGS
	private int variableMovement = 0;					// 0 for normal movement, 1 for variable movement
	private int variability = 25;						// variability amount used for variable movement
	private int moveLengthX = 2;						// length of each individual movement in the X direction for normal movement
	private int moveLengthY = 2;						// length of each individual movement in the Y direction for normal movement

	// COLOR SETTINGS
	private int chooseColor = 1;						// 0 for random, 1 - BLACK, 2 - BLUE, 3 - ORANGE, 4 - GREEN, 5 - RED, 6 - Multicolor
	private int numColors = 5;							// number of random colors used
	private Color colorOne = Color.blue;				// More likely color
	private Color colorTwo = Color.pink;					// Less likely color
	private int colorRatio = 3;							// ratio:1 odds of first color

	// TIMER SETTINGS
	private int useTimer = 1;							// 0 for no timer, 1 for timer
	private double timePerMove = .1;                    // time per move in seconds

   public lineStuffPanel(){
    setBackground(Color.WHITE);
   
	if(useTimer == 1){
		javax.swing.Timer timer = new javax.swing.Timer((int)(timePerMove * 1000), this);
    	timer.start();
	}
    
    colors[0] = Color.BLACK;
    colors[1] = Color.BLUE;
    colors[2] = Color.ORANGE;
    colors[3] = Color.GREEN;
    colors[4] = Color.RED;

  }
   
       public void paintComponent(Graphics g){
    	super.paintComponent(g);

    	for(int j = 0; j < numLines; j++){

			if(randomStart == 1){
				x = (int)(Math.random() * 900);
				y = (int)(Math.random() * 900);
			}
			else{
				g.setColor(Color.BLACK);
				g.drawLine(500, 850, 500, 900);
				x = 500;
    			y = 850;
			}

		if(chooseColor == 1){
			g.setColor(Color.BLACK);
		}
		else if(chooseColor == 2){
			g.setColor(Color.BLUE);
		}
		else if(chooseColor == 3){
			g.setColor(Color.ORANGE);
		}
		else if(chooseColor == 4){
			g.setColor(Color.GREEN);
		}
		else if(chooseColor == 5){
			g.setColor(Color.RED);
		}
		else if(chooseColor == 6){
			if((int)(Math.random() * (colorRatio + 1)) == 1)
				g.setColor(colorTwo);
			else
				g.setColor(colorOne);
		}
		else{
    	g.setColor(colors[(int)(Math.random() * numColors)]);
		}

    		for(int i = 0; i < numMoves; i++){
    			int newX = x;
    			if((int)(Math.random() * 2) == 0){
					if(variableMovement == 1){
						newX += (int)(Math.random() * variability);
					}
					else{
						newX += moveLengthX;
					}
    			}
    			else{
    				if(variableMovement == 1){
						newX -= (int)(Math.random() * variability);
					}
					else{
						newX -= moveLengthX;
					}
				}

				if(variableMovement == 1){
					newY = y - (int)(Math.random() * variability);
				}
				else{
					newY = y - moveLengthY;
				}

				switch (type){
					case 0:
					g.drawLine(x, y, newX, newY);
					break;
					case 1:
					g.drawOval(x, y, newX, newY);
					break;
					case 2:
					g.drawRect(x, y, newX, newY);
					break;
					default:
					g.drawLine(x, y, newX, newY);
					break;
				}
    			
    			x = newX;
    			y = newY;
    		
    	}
    }	
 	
}
     public void actionPerformed(ActionEvent e){
   		repaint();
   	}

}