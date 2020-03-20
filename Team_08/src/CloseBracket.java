import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;

/**
 * @author Anusha Singh
 * @version 1.0
 */

public class CloseBracket extends Shapes implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int OFFSET = 50;
//    private double x, y;
    private int x, y;
    private Shape closebracket = null;
    private Shapes dot = null;
    private boolean isLineDrawn = false;
    public CloseBracket(){

    }

//    public CloseBracket(double x, double y) {
    public CloseBracket(int x, int y) {
        this.x = x - OFFSET;
        this.y = y - OFFSET;

    }

    public Shapes getDot() {
        return dot;
    }

    public void setDot(Shapes dot) {
        this.dot = dot;
    }

    @Override
    public void drawShape(Graphics graphic) {

        closebracket = new Rectangle2D.Double(x, y, 200, 100);
        Graphics2D graphics2 = (Graphics2D) graphic;
        dot = new Dot(x + 100 - 70, y + 100 - 50);
        dot.drawShape(graphics2);

        Font font = new Font("Serif", Font.PLAIN, 40);
        graphics2.setFont(font);
        graphics2.drawString(")", x + 105, y + 60);

        graphics2.draw(closebracket);

    }

    public boolean containsPoint(int x, int y) {
        return closebracket.contains(x, y);
    }

    @Override
    public int getX() {
        return (int) x;
    }

    @Override
    public void setX(int x) {
        this.x = x - OFFSET;
    }

    @Override
    public int getY() {
        return (int) y;
    }

    @Override
    public void setY(int y) {
        this.y = y - OFFSET;
    }



    public boolean isLineDrawn() {
        return isLineDrawn;
    }

    public void setLineDrawn(boolean isLineDrawn) {
        this.isLineDrawn = isLineDrawn;
    }

}
