package map;

import javax.swing.JFrame;

public class MapFrame extends JFrame
{
	MapPanel _mp;
	public MapFrame()
	{
		_mp=new MapPanel("map1.xml");
		add(_mp);
	}
}
