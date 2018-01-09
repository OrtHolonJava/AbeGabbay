package map;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import graphics.Img;
public class MapPanel extends JPanel
{
	private int _nRows;
	private int _bSize;
	private Img imgBackground;
	private Map _map;
	private Img _bananaObj;
	private Img _pacManObj;
	private Img _cherryObj;
	
	public MapPanel(String FileName)
	{
		
		if(FileName=="map1.xml")
		{
			_nRows=22;
			imgBackground=new Img("images\\Map1BackGround.jpg", 0, 0, 672, 672);
		}
		else
		{
			_nRows=19;
			imgBackground=new Img("images\\Map2BackGround.jpg", 0, 0, 609, 353);
		}
		_bSize=32;
		_map=new Map(_nRows,"MapFiles\\"+FileName);
		_bananaObj=new Img("images\\GlowingBananaObject.gif", 0, 0, 30, 30);
		_pacManObj=new Img("images\\Trans Pacan_Right.png", 0, 0, 30, 30);
		_cherryObj=new Img("images\\CherryObject.png",0,0,30,30);
	}
	protected void paintComponent(Graphics g1) 
	{
		super.paintComponent(g1);
		Graphics2D g = (Graphics2D) g1;
		imgBackground.drawImg(g);
		paintGame(g);
		
	}
	private void paintGame(Graphics2D g)
	{
		Color c;
		c=new Color(255, 255, 255, 4); 	
		g.setColor(Color.green);
		for (int i = 0; i < _nRows * _nRows; i++) 
		{
			
			if ((_map.get_map()[i / _nRows][i % _nRows] & 1) != 0) // up
			{
				g.drawLine((i % _nRows) * _bSize      , (i /_nRows) * _bSize, 
						
							((i % _nRows)* _bSize) + _bSize , (i / _nRows) * _bSize);
			}
			
			if ((_map.get_map()[i / _nRows][i % _nRows] & 2) != 0) // right
			{
				g.drawLine(((i % _nRows) * _bSize) +_bSize, (i / _nRows) * _bSize,
						
							((i % _nRows ) * _bSize)+_bSize, ((i / _nRows) * _bSize) + _bSize);
			}
			
			if ((_map.get_map()[i / _nRows][i % _nRows] & 4) != 0) // down
			{
				g.drawLine((i % _nRows) * _bSize  , (((i /_nRows) * _bSize)+_bSize),
						
							((i % _nRows)* _bSize)+_bSize , ((i / _nRows) * _bSize)+_bSize);
			}
			
			if ((_map.get_map()[i / _nRows][i % _nRows] & 8) != 0) // left
			{
				g.drawLine((i % _nRows) * _bSize    , (i /_nRows) * _bSize, 
						
							(i % _nRows)* _bSize  , ((i / _nRows) * _bSize)+_bSize);
			}		
			if ((_map.get_map()[i / _nRows][i % _nRows] & 16) != 0) //Banana
			{
				_bananaObj.setImgCords((i % _nRows)* _bSize +_bSize/3,(i / _nRows)* _bSize+_bSize/3);
				_bananaObj.setImgSize(22, 22);
				_bananaObj.drawImg(g);
			}
			if ((_map.get_map()[i / _nRows][i % _nRows] & 32) != 0) //PacMan
			{
				_pacManObj.setImgCords((i % _nRows)* _bSize +_bSize/3,(i / _nRows)* _bSize+_bSize/3);
				_pacManObj.setImgSize(22, 22);
				_pacManObj.drawImg(g);
			}
			if ((_map.get_map()[i / _nRows][i % _nRows] & 64) != 0) //Cherry
			{
				_cherryObj.setImgCords((i % _nRows)* _bSize +_bSize/3,(i / _nRows)* _bSize+_bSize/3);
				_cherryObj.setImgSize(22, 22);
				_cherryObj.drawImg(g);
			}

		
		}
	}
}
