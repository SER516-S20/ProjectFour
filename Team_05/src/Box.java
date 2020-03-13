import java.awt.Point;

public class Box {
	private static Box instance = null;
	public String text = null;
	private static Point startPos = null;
	private static Point endPos = null;
	
	private Box(String instanceOfClass) {
		//this.instanceOfClass = instanceOfClass;
	}
	private Box() {}
	public static Box getInstance() {
		if(instance == null) {
			instance = new Box();
		}
		return instance;
	}
	
}
