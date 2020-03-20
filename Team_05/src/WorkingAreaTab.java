import javax.swing.JPanel;

public class WorkingAreaTab extends JPanel{
	private String name;
	
	WorkingAreaTab() {
		this.setLayout(null);
	}
	
	WorkingAreaTab(String name) {
		this.name = name;
		this.setLayout(null);
	}
	
	public String getName() {
		return name;
	}
}
