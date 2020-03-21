import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/**
 * This class creates a Frame and adds two JPanels to the frame.
 *
 * @author Kartik Mathpal
 * @version 1.0
 */
public class Frame extends JFrame {
    private static final long serialVersionUID = 1L;
    protected static RightPanel rightPanel;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static JTabbedPane tabbedPane = new JTabbedPane();
    

    public Frame() {
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        String TITLE = "Project 4 - Team 8";
        setTitle(TITLE);
        setBackground(Color.BLACK);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLeftPanel() {
        try {
            LeftPanel leftPanel = new LeftPanel();
            Button button = new Button();

            button.addButtonsToLeftPanel(leftPanel);
            leftPanel.setBounds(0, 0, screenSize.width / 6, screenSize.height);
            leftPanel.setVisible(true);
            this.add(leftPanel);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createRightpanel() {
        try {

            tabbedPane.setBounds(screenSize.width / 6, 0, 4 * screenSize.width / 4, screenSize.height);
            // Add Dashboard Tab
            rightPanel = new RightPanel();
            tabbedPane.addTab("New Tab", rightPanel);
            addButtonToTab(tabbedPane);
            this.add(tabbedPane);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void addButtonToTab(final JTabbedPane tabEntity) {
    	JButton newTabButton = new JButton("  New Tab  ");
    	tabEntity.setTabComponentAt(tabEntity.getTabCount() - 1, newTabButton);
    	newTabButton.addActionListener(e -> {

    if (e.getActionCommand().equals("  New Tab  ")) {
            rightPanel = new RightPanel();
            tabbedPane.add("New Tab", rightPanel);

        System.out.println("New Tab has been clicked");
    }
});


        }

    public void createMenu() {
        this.setJMenuBar(new MenuBar());
    }

    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.createLeftPanel();
        frame.createRightpanel();
        frame.createMenu();
        frame.setVisible(true);
    }

}
