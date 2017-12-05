package map;

import java.io.File;
import javax.xml.parsers.*;
import org.w3c.dom.*;
/**
 * MapClass
 * @author PC 03
 *
 */
public class Map {
	
	protected int _gSize;// the map size
	protected int _gCounter = 0;// counter
	protected int[][] _gMap;// the map

	/**
	 * Constructor
	 * @param size
	 * @param fileName
	 */
	public Map(int size, String fileName) 
	{
		_gMap = new int[size][size];
		_gSize = size;
		
		try 
		{
			File file = new File(fileName);
			DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
					.newDocumentBuilder();
			Document doc = dBuilder.parse(file);
			if (doc.hasChildNodes()) {

				readNode(doc.getChildNodes());
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	public int[][] get_map() 
	{
		return _gMap;
	}
	
	
	/**
	 * Reads Node
	 * @param nodeList
	 */
	private void readNode(NodeList nodeList) 
	{
		for (int count = 0; count < nodeList.getLength(); count++) 
		{
			Node tempNode = nodeList.item(count);
			if (tempNode.getNodeType() == Node.ELEMENT_NODE)
			{
				if (tempNode.hasAttributes()) 
				{
					NamedNodeMap nodeMap = tempNode.getAttributes();
					for (int i = 0; i < nodeMap.getLength(); i++) 
					{
						Node node = nodeMap.item(i);
						_gMap[_gCounter / _gSize][_gCounter % _gSize] = Integer
								.parseInt(node.getNodeValue());
						_gCounter++;
					}
				}
				if (tempNode.hasChildNodes()) 
				{
					readNode(tempNode.getChildNodes());
				}
			}
		}
	}
}
