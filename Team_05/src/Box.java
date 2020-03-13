import java.awt.Point;

public class Box {
	private static Box instance = null;
	private String text = null;
	private Point startPos = null;
	private Point endPos = null;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	private Box() {}
	public static Box getInstance() {
		if(instance == null) {
			instance = new Box();
		}
		return instance;
	}
	
}
