
public class ShapeAtTheRate extends Icon{

	private static final long serialVersionUID = 1L;
	private int centerX;
	private int centerY;
	private static String text = "@";
	private Dot leftUpperDot,leftLowerDot;
	private Dot rightUpperDot, rightLowerDot;
	
	public ShapeAtTheRate(int x, int y) {
		this.setCenterX(x);
		this.setCenterY(y);
//		this.setLeftDot(new Dot(x, y, false, true));
			
		// call paint component from here, repaint ?!
	}
	
	// On top of parent class Icon,
	// Implement repaint using centerX, centerY, text, rightDot values.
	

	public Dot getRightUpperDot() {
		return rightUpperDot;
	}

	public void setRightUpperDot(Dot rightUpperDot) {
		this.rightUpperDot = rightUpperDot;
	}

	public Dot getRightLowerDot() {
		return rightLowerDot;
	}

	public void setRightLowerDot(Dot rightLowerDot) {
		this.rightLowerDot = rightLowerDot;
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
