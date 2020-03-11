import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

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
            rightPanel = new RightPanel();
            rightPanel.setBounds(screenSize.width / 6, 0, 4 * screenSize.width / 4, screenSize.height);
            rightPanel.setVisible(true);
            this.add(rightPanel);

        } catch (Exception e) {
            e.printStackTrace();
        }
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
