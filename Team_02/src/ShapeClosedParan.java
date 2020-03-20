
public class ShapeClosedParan extends Icon{
	
	
	private static final long serialVersionUID = 1L;
	private int centerX;
	private int centerY;
	private static String text = ")";
	private Dot leftDot;
	
	public ShapeClosedParan(int x, int y) {
		this.setCenterX(x);
		this.setCenterY(y);
		this.setRightDot(new Dot(x, y, false, true));
		
		
		// call paint component from here, repaint ?!
	}
	
	// On top of parent class Icon,
	// Implement repaint using centerX, centerY, text, rightDot values.
	

	public Dot getRightDot() {
		return leftDot;
	}

	public void setRightDot(Dot leftDot) {
		this.leftDot = leftDot;
	}

	public int getCenterX() {
		return centerX;
	}

	public void setCenterX(int centerX) {
		this.centerX = centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	public void setCenterY(int centerY) {
		this.centerY = centerY;
	}

}
