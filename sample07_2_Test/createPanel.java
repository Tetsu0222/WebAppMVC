package sample07_2_Test;

import java.awt.Color;

import javax.swing.JPanel;

public class createPanel extends JPanel{
	
	Color color;
	
	createPanel( int i ){
		switch( i ) {
		
		case 0 :
			color = Color.cyan;
			break;
		
		case 1 :
			color = Color.white;
			break;
			
		case 2 :
			color = Color.black;
			break;	
		
		}
	}
	
	
}