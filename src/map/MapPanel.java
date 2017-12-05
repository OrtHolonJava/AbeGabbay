package map;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import images.Img;
public class MapPanel extends JPanel
{
	private int _nRows;
	private int _bSize;
	private Img imgBackground;
	private Map _map;
	
	public MapPanel()
	{
		_nRows=22;
		imgBackground=new Img("images\\Screenshot_1-Recovered.png", 0, 0, 670, 670);
		_bSize=32;
		_map=new Map(_nRows,"MapFiles\\file.xml");
		
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
		
		g.setColor(Color.white);
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