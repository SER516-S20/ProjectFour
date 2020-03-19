import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Yijian Hu
 * @modified by Hongqi Zhang 
 */
public class RightPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;
	private String name;
	private Hashtable<Integer, ButtonBox> shapes;
	private Frame frame;
	protected List<Connection> connections;
	private Model model;
	private ValuePane vPane;
	boolean isAlreadyOneClick = false;
	
	RightPanel() {
		//init();
	}
	
	RightPanel(String name)
	{
		this.name = name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void init()
	{
		
		//this.setBackground(Color.gray);
		//shapes = new Hashtable<Integer, ButtonBox>();
		model = new Model();
		shapes = model.getTabs().get(name).getshapes();
		addMouseListener(this);
		connections = model.getTabs().get(name).getConnectionCollection();
		this.setLayout(null);
	}
	
	public void addButton(String btnCommand, int x, int y) {
		System.out.println("get in to the panel...." + btnCommand);
		ButtonBox btn = ButtonBoxFactory.buildButtonBox(btnCommand);
		addActionAndMouseMotionListener(btn);
		this.add(btn);
		this.autoLocation(btn,x - btn.getPreferredSize().width / 2,y - btn.getPreferredSize().height / 2);
		btn.setToolTipText(btnCommand);
		shapes.put(btn.hashCode(),btn);
		model.getTabs().get(name).setshapes(shapes);
		this.repaint();
	}
	
	private void addActionAndMouseMotionListener(ButtonBox button) {
		button.addMouseMotionListener(this);
		button.addMouseListener(this);
		
	}
	
	public void setFrame(Frame frame) {
		this.frame = frame;
	}
	
	public void setShapeLocation(int hashCode, int x, int y) {
		shapes.get(hashCode).setLocation(x,y);
		model.getFrame().contentRepaint();
	}
	
	public Hashtable<Integer, ButtonBox> getShapes() {
		return shapes;
	}
	
	public void clear() {
		for(ButtonBox shape:shapes.values()) {
			this.remove(shape);
		}
		shapes.clear();
	}
	
	private void autoLocation(ButtonBox button, int x, int y) {
		button.setSize(button.getPreferredSize());
		button.setLocation(x, y);
	}
	/*
	private void updateHashCode(){
		Hashtable<Integer, JButton> update = new Hashtable<Integer, JButton>();
		for(JButton shape:shapes.values()) {
			update.put(shape.hashCode(), shape);
		}
		shapes = update;
	}*/

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("....."+e.getSource());
	}
	//Author:ShihYu Chang
	@Override
	public void mouseDragged(MouseEvent e) {
		e.getComponent().setLocation(e.getX() + e.getComponent().getX(), 
				 e.getY() + e.getComponent().getY());
		for(int i = 0; i < this.connections.size(); i++) {
        	Connection finishedconnection = connections.get(i);
        	if(finishedconnection.getSourceButton() == e.getComponent().hashCode()) {
        		finishedconnection.setSourceX(finishedconnection.getSourceX()+e.getX());
        		finishedconnection.setSourceY(finishedconnection.getSourceY()+e.getY());
        	}
        	else if(finishedconnection.getDestButton() == e.getComponent().hashCode()) {
        		finishedconnection.setDestX(finishedconnection.getDestX()+e.getX());
        		finishedconnection.setDestY(finishedconnection.getDestY()+e.getY());
        	}
        }
		this.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(this)) {
			Box instance = Box.getInstance();
			if(instance.getText() == null) {
				return;
			}
			addButton(instance.getText(),e.getX(),e.getY());
			System.out.println("====" + this.getComponentCount());
			System.out.println("e.getX() " + e.getX());
			System.out.println("e.getY() " + e.getY());
		}else {
			if (e.getClickCount() == 2) {
				Object source = e.getComponent();
				if(source instanceof JPanel){
					ButtonBox panelPressed = (ButtonBox) source;
					if(vPane == null) {
						vPane = panelPressed.createJOptionPane();
						panelPressed.setTitle(vPane.getvalue());
					}else {
						vPane.setValue(panelPressed.getTitle());
						panelPressed.setTitle(vPane.getvalue());
					}
				}
			}
		}
		if(e.getButton() == MouseEvent.BUTTON3) {
			this.remove(e.getComponent());
			connections.removeIf(n->(n.getSourceButton()==e.getComponent().hashCode()));
			connections.removeIf(n->(n.getDestButton()==e.getComponent().hashCode()));
			this.repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	//Author:ShihYu Chang
	public void updateConnection() {
		connections = model.getTabs().get(name).getConnectionCollection();
	}

	//Author:ShihYu Chang
    public void paint(Graphics g) {
    	super.paint(g);
    	//System.out.println("======get into the right panel paint method=====");
        for(int i = 0; i < this.connections.size(); i++) {
        	Connection finishedconnection = connections.get(i);
        	Line line = new Line();
        	line.setSource(finishedconnection.getSourceX(), finishedconnection.getSourceY());
        	line.setDest(finishedconnection.getDestX(), finishedconnection.getDestY());
        	line.draw(g);
        }
    }
    
    public void load(ShapeInfo[] shapeinfo) {
		this.clear();
    	for(int i = 0; i < shapeinfo.length; i++) {
    		addButton(shapeinfo[i].getType(),shapeinfo[i].getPosition().x,shapeinfo[i].getPosition().y);
    	}
    }
}
