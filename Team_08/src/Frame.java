import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


/**
 * Creates a Frame and adds two JPanels two the frame.
 *
 * @author Kartik Mathpal
 * @version 1.0
 */
public class Frame extends JFrame {
    private static final long serialVersionUID = 1L;
    private final String TITLE = "Project 4 - Team 8";
    protected static RightPanel rightPanel;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    static JTabbedPane tabbedPane = new JTabbedPane();
    

    public Frame() {
        setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        setLayout(null);
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
            
            //JPanel dashboardPanel = new JPanel();
            //dashboardPanel.add(new JLabel("Dashboard"));
            
            tabbedPane.setBounds(screenSize.width / 6, 0, 4 * screenSize.width / 4, screenSize.height);//350,150,1350,550); 
            // Add Dashboard Tab
            rightPanel = new RightPanel();
            
//          rightPanel.setBounds(screenSize.width / 6, 0, 4 * screenSize.width / 4, screenSize.height);
//	        rightPanel.setSize(200,200);
            
//          rightPanel.setVisible(true);
            tabbedPane.addTab("New Tab", rightPanel);
            addButtonToTab(tabbedPane);
            
//            this.setLayout(new BorderLayout());
//            this.setPreferredSize(new Dimension(200, 200));
//            this.add(tabbedPane, BorderLayout.CENTER);
            this.add(tabbedPane);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void addButtonToTab(final JTabbedPane tabEntity) {
    	JButton newTabButton = new JButton("  New Tab  ");
    	tabEntity.setTabComponentAt(tabEntity.getTabCount() - 1, newTabButton);
    	newTabButton.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
			//TO DO: write action to create new tab
			if (e.getActionCommand().equals("  New Tab  ")) {
				
				
					rightPanel = new RightPanel();
					tabbedPane.add("New Tab", rightPanel);
				
				System.out.println("New Tab has been clicked");
			}
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
