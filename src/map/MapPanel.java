package map;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import graphics.Img;
public class MapPanel extends JPanel
{
	private int _nRows;
	private int _bSize;
	private Img imgBackground;
	private Map _map;
	
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
		g.setColor(c);
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
			
		}
	}
}
