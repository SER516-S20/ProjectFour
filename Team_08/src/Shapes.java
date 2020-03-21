import java.awt.Graphics;

/**
 * This class consists of
 *
 * @author Anusha Singh
 * @version 1.0
 */

public abstract class Shapes {

    public abstract void drawShape(Graphics graphic);

    public abstract boolean containsPoint(int x, int y);

    public abstract int getX();

    public abstract void setX(int x);

    public abstract int getY();

    public abstract void setY(int y);


}
