package images;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
/**
 * Img Class.
 */
public class Img
{
	private Image _image;
	private int x, y, width, height;
	
	/** CONSTRUCTOR **/
	public Img(String path, int x, int y, int width, int height)
	{
		try
		{
		_image = new ImageIcon(this.getClass().getClassLoader().getResource(path)).getImage(); 
		}
		catch(NullPointerException event)
		{
		System.out.println(event.getMessage());
		}
		setImgCords(x, y);
		setImgSize(width, height);
	}
	/** Draws Image **/
	public void drawImg(Graphics g) 
	{
		Graphics2D g2d = (Graphics2D) g;
        		g2d.drawImage(_image, x, y, width, height, null);
	}
	/** Sets the image size using x and y **/
	public void setImgCords(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	/** Sets the image size using width and height **/
	public void setImgSize(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	public void setImg(Image image)
	{
		_image = image;
	}
}


