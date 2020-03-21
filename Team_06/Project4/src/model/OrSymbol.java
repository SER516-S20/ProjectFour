package model;
import java.awt.Color;
import java.awt.Graphics;
import controller.Drag;
import controller.ShapeMouseListener;

/**
 * 
 * @Author: Suyog
 * @Since: 03-07-2020
 * @Description: This class is used to model '||' button, which inherits the Shape abstract class, 
 * and is used in both left and right panels.
 */
public class OrSymbol extends Shape{
	
	private static final long serialVersionUID = 1L;
	
	public OrSymbol(int x, int y, boolean rightPanel){
		super("||",x,y);
		
		if(rightPanel) {
			new ShapeMouseListener(this);
			
			ConnectorBar leftBar = new ConnectorBar(20, getSize().height * 1 / 4, type.INPUT);
			ConnectorBar rightBar = new ConnectorBar(getSize().width - 20, getSize().height * 1 / 4, type.OUTPUT);
			
			this.connectors.add(leftBar);
			this.connectors.add(rightBar);
			
			this.add(leftBar);
			this.add(rightBar);
			new Drag(this);

		}
	}
	
	// This is the method used to paint the bars.
	@Override
	protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.LIGHT_GRAY);
        } 
        else {
            g.setColor(getBackground());
        }
        // This is the function used to paint the bars.
        super.paintComponent(g);
    }
	
    // This is the method used to paint the button.
    protected void paintBorder(Graphics g) 
    {
        g.setColor(getForeground());
        g.drawRect(0, 0, getSize().width, getSize().height);
        g.fillRect(getSize().width - 20, getSize().height * 1 / 4, 10, 40);
        g.fillRect(20, getSize().height * 1 / 4, 10, 40);
    }
    
}
