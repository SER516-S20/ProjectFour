public class ShapeGreaterThan extends Icon{

	private static final long serialVersionUID = 1L;
	private int centerX;
	private int centerY;
	private static String text = ">";
	private Dot rightDot;
	private Dot leftUpperDot, leftLowerDot;
	
	public ShapeGreaterThan(int x, int y) {
		this.setCenterX(x);
		this.setCenterY(y);
		this.setRightDot(new Dot(x, y, false, true));
			
		// call paint component from here, repaint ?!
	}
	
	// On top of parent class Icon,
	// Implement repaint using centerX, centerY, text, rightDot values.
	
	public Dot getRightDot() {
		return rightDot;
	}

	public void setRightDot(Dot rightDot) {
		this.rightDot = rightDot;
	}

	public Dot getLeftUpperDot() {
		return leftUpperDot;
	}

	public void setLeftUpperDot(Dot leftUpperDot) {
		this.leftUpperDot = leftUpperDot;
	}

	public Dot getLeftLowerDot() {
		return leftLowerDot;
	}

	public void setLeftLowerDot(Dot leftLowerDot) {
		this.leftLowerDot = leftLowerDot;
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
