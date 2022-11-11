/**
 * @(#)LineStuff.java
 *
 *
 * @author 
 * @version 1.00 2019/4/28
 */

import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

import java.awt.Graphics;
import java.awt.Color;
	
public class LineStuff extends JFrame{
	
    public LineStuff(){
    	
    	super("Line stuff");
    	
    	lineStuffPanel panel = new lineStuffPanel();
   		panel.setLayout(new BorderLayout());
   		panel.setBorder(new EmptyBorder(0, 0, 0, 0));

    	Container c = getContentPane();
    	c.add(panel, BorderLayout.CENTER);
}


    
    public static void main(String[] args){
    	LineStuff window = new LineStuff();
    	window.setBounds(0, 0, 1000, 1000);
    	window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	window.setVisible(true);
    }
}