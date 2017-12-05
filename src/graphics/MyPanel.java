package graphics;
import java.awt.Graphics;

import javax.swing.JPanel;
/** 
 *  MyPanel Class
 *	Extends from JPanel
**/
public class MyPanel extends JPanel
{
	private Img _image;
	public MyPanel()
	{
		_image= new Img("images\\PeanutButterJellyTime.jpg", 0, 0, 600, 200);
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		_image.drawImg(g);
	}
}
