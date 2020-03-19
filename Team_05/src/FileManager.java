import java.awt.Point;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Yijian Hu
 * @modified by Kairui Hsu
 */
public class FileManager {
	private List<Connection> connections;
	private Model model = new Model();
	private int sourceButton, destButton;
	
	public void save(File file) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("shapes");
			doc.appendChild(rootElement);
			if(model.getshapes() != null) {
				for(int key:model.getshapes().keySet()) {
					Element shape = doc.createElement("shape");
					rootElement.appendChild(shape);
					shape.setAttribute("id",Integer.toString(key));
					ButtonBox theShape = model.getshapes().get(key);
					Element type = doc.createElement("type");
					type.appendChild(doc.createTextNode(theShape.getToolTipText()));
					Element title = doc.createElement("title");
					title.appendChild(doc.createTextNode(theShape.getTitle()));
					Element position = doc.createElement("position");
					position.appendChild(doc.createTextNode((theShape.getLocation().x + theShape.getPreferredSize().width / 2) + "," + (theShape.getLocation().y + theShape.getHeight() / 2)));
					shape.appendChild(type);
					shape.appendChild(title);
					shape.appendChild(position);
				}
			}
			if(model.getConnectionCollection() != null) {
				connections = model.getConnectionCollection();
				for(int j = 0 ; j < this.connections.size(); j++) {
					Connection finishedconnection = connections.get(j);
					Element conn = doc.createElement("conn");
					rootElement.appendChild(conn);
					sourceButton = finishedconnection.getSourceButton();
					destButton = finishedconnection.getDestButton();
					Element sourceId = doc.createElement("sourceId");
					sourceId.appendChild(doc.createTextNode(Integer.toString(sourceButton)));
					Element destId = doc.createElement("destId");
					destId.appendChild(doc.createTextNode(Integer.toString(destButton)));
					Element position = doc.createElement("position");
					position.appendChild(doc.createTextNode((finishedconnection.getSourceX() + "," + 
															 finishedconnection.getSourceY() + "," +
															 finishedconnection.getDestX() + "," + 
															 finishedconnection.getDestY())));
					conn.appendChild(sourceId);
					conn.appendChild(destId);
					conn.appendChild(position);
				}
			}
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ShapeInfo[] open(File file) {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(file);
			doc.getDocumentElement().normalize();   
			NodeList nodeList = doc.getElementsByTagName("shape");
			ShapeInfo[] shapes = new ShapeInfo[nodeList.getLength()];
			for(int i = 0;i < nodeList.getLength();i++) {
				Node node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE) {  
					Element shapeElement = (Element) node;
					int id = Integer.parseInt(node.getAttributes().getNamedItem("id").getNodeValue());
					String points[] = shapeElement.getElementsByTagName("position").item(0).getTextContent().split(",");
					Point position = new Point(Integer.parseInt(points[0]),Integer.parseInt(points[1]));
					String type = shapeElement.getElementsByTagName("type").item(0).getTextContent();
					String title = shapeElement.getElementsByTagName("title").item(0).getTextContent();
					shapes[i]=new ShapeInfo(id,type,title,position);
				}
			}
			NodeList connList = doc.getElementsByTagName("conn");
			
			for(int i = 0;i < connList.getLength();i++) {
				Node conn = connList.item(i);
				if (conn.getNodeType() == Node.ELEMENT_NODE) {  
					Element connElement = (Element) conn;
					String points[] = connElement.getElementsByTagName("position").item(0).getTextContent().split(",");
					String sourceId = connElement.getElementsByTagName("sourceId").item(0).getTextContent();
					String destId = connElement.getElementsByTagName("destId").item(0).getTextContent();
					Connection newConn = new Connection();
					newConn.setSourceButton(Integer.parseInt(sourceId));
					newConn.setSourceX(Integer.parseInt(points[0]));
					newConn.setSourceY(Integer.parseInt(points[1]));
					newConn.setDestButton(Integer.parseInt(destId));
					newConn.setDestX(Integer.parseInt(points[2]));
					newConn.setDestY(Integer.parseInt(points[3]));
					model.addConnection(newConn);
				}
			}
			return shapes;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
