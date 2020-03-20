
public class ShapeDash extends Icon{

	
	private static final long serialVersionUID = 1L;
	private int centerX;
	private int centerY;
	private static String text = "-";
	private Dot leftDot;
	private Dot rightDot;
	
	
	public ShapeDash(int x, int y) {
		this.setCenterX(x);
		this.setCenterY(y);
//		this.setLeftDot(new Dot(x, y, false, true));
			
		// call paint component from here, repaint ?!
	}
	
	// On top of parent class Icon,
	// Implement repaint using centerX, centerY, text, rightDot values.
	
	public Dot getLeftDot() {
		return leftDot;
	}

	public void setLeftDot(Dot leftDot) {
		this.leftDot = leftDot;
	}

	public Dot getRightDot() {
		return rightDot;
	}

	public void setRightDot(Dot rightDot) {
		this.rightDot = rightDot;
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

}
