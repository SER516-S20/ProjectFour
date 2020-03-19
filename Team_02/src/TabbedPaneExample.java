
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;  
public class TabbedPaneExample implements ActionListener {  
JFrame f; 
JButton saveBtn = new JButton("Save");
TabbedPaneExample(){  
    f=new JFrame();  
    JTextArea ta=new JTextArea(500,200);  
    JPanel p1=new JPanel();  
    saveBtn.addActionListener(this);
	p1.add(saveBtn);
    
    JTabbedPane tp=new JTabbedPane();  
   tp.setBounds(100,100,600,200);  
    tp.add("main",p1);   
    f.add(tp); 
    f.setExtendedState(JFrame.MAXIMIZED_BOTH);
   // f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);  
}  
public static void main(String[] args) {  
    new TabbedPaneExample();  
}
@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == saveBtn) {
	String value =	showValuePopUp();
	JOptionPane.showMessageDialog(null, value);
	}
}
public String showValuePopUp() {
	String value = JOptionPane.showInputDialog("Value of Shape");  
   return value;

}
	}  