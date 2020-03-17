import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Amudhan Manisekaran
 * @version 1.0
 */

public class Button {
    public void addButtonsToLeftPanel(LeftPanel panel){


        JButton openButton = new JButton(new ImageIcon("src/ImageFiles/openbracket.jpg"));
        openButton.setPreferredSize(new Dimension(200,100));
        openButton.setFont(new Font("Arial", Font.PLAIN, 30));
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openButton.setName("openButton");
                resetButtonClicked(openButton);
            }
        });
        panel.add(openButton);

        JButton closeButton = new JButton(new ImageIcon("src/ImageFiles/closebracket.jpg"));
        closeButton.setPreferredSize(new Dimension(200,100));
        closeButton.setFont(new Font("Arial", Font.PLAIN, 30));
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                closeButton.setName("closeButton");
//                closeButton.setText("close bracket clicked");
                resetButtonClicked(closeButton);
            }
        });
        panel.add(closeButton);

        JButton lessThanButton = new JButton(new ImageIcon("src/ImageFiles/lessthan.jpg"));
        lessThanButton.setPreferredSize(new Dimension(200,100));
        lessThanButton.setFont(new Font("Arial", Font.PLAIN, 30));
        lessThanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lessThanButton.setName("lessThanButton");
//                lessThanButton.setText("lessThanButton");
                resetButtonClicked(lessThanButton);
            }
        });
        panel.add(lessThanButton);

        JButton greaterThanButton = new JButton(new ImageIcon("src/ImageFiles/greaterthan.jpg"));
        greaterThanButton.setPreferredSize(new Dimension(200,100));
        greaterThanButton.setFont(new Font("Arial", Font.PLAIN, 30));
        greaterThanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                greaterThanButton.setName("greaterThanButton");
//                greaterThanButton.setText("greaterThanButton");
                resetButtonClicked(greaterThanButton);
            }
        });
        panel.add(greaterThanButton);

//        JButton atTheRateButton = new JButton("@",new ImageIcon("src/ImageFiles/attherate.jpg"));
        JButton atTheRateButton = new JButton(new ImageIcon("src/ImageFiles/attherate.jpg"));
        atTheRateButton.setPreferredSize(new Dimension(200,100));
        atTheRateButton.setFont(new Font("Arial", Font.PLAIN, 30));
        atTheRateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                atTheRateButton.setName("atTheRateButton");
//                atTheRateButton.setText("atTheRateButton");
                resetButtonClicked(atTheRateButton);
            }
        });
        panel.add(atTheRateButton);

        JButton twoBarButton = new JButton(new ImageIcon("src/ImageFiles/twobars.jpg"));
        twoBarButton.setPreferredSize(new Dimension(200,100));
        twoBarButton.setFont(new Font("Arial", Font.PLAIN, 30));
        twoBarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                twoBarButton.setName("twoBarButton");
//                twoBarButton.setText("twoBarButton");
                resetButtonClicked(twoBarButton);
            }
        });
        panel.add(twoBarButton);

        JButton hypenButton = new JButton(new ImageIcon("src/ImageFiles/hyphen.jpg"));
        hypenButton.setPreferredSize(new Dimension(200,100));
        hypenButton.setFont(new Font("Arial", Font.PLAIN, 30));
        hypenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hypenButton.setName("hypenButton");
//                hypenButton.setText("hypenButton");
                resetButtonClicked(hypenButton);
            }
        });
        panel.add(hypenButton);



    }
    private  void resetButtonClicked(JButton button){
        System.out.println(button.getName() + " clicked by the user!!!");
        if(button.getName()=="openButton"){
            LeftPanelMouseListener.setOpenBracketClicked(Boolean.TRUE);
            LeftPanelMouseListener.setCloseBracketClicked(Boolean.FALSE);
            LeftPanelMouseListener.setLessThanClicked(Boolean.FALSE);
            LeftPanelMouseListener.setGreaterThanClicked(Boolean.FALSE);
            LeftPanelMouseListener.setAtTheRateClicked(Boolean.FALSE);
            LeftPanelMouseListener.setTwoBarsClicked(Boolean.FALSE);
            LeftPanelMouseListener.setHyphenClicked(Boolean.FALSE);
        }else if(button.getName()=="closeButton") {
            LeftPanelMouseListener.setCloseBracketClicked(Boolean.TRUE);
            LeftPanelMouseListener.setOpenBracketClicked(Boolean.FALSE);
            LeftPanelMouseListener.setLessThanClicked(Boolean.FALSE);
            LeftPanelMouseListener.setGreaterThanClicked(Boolean.FALSE);
            LeftPanelMouseListener.setAtTheRateClicked(Boolean.FALSE);
            LeftPanelMouseListener.setTwoBarsClicked(Boolean.FALSE);
            LeftPanelMouseListener.setHyphenClicked(Boolean.FALSE);
        }else if(button.getName()=="lessThanButton"){
            LeftPanelMouseListener.setLessThanClicked(Boolean.TRUE);
            LeftPanelMouseListener.setCloseBracketClicked(Boolean.FALSE);
            LeftPanelMouseListener.setOpenBracketClicked(Boolean.FALSE);
            LeftPanelMouseListener.setGreaterThanClicked(Boolean.FALSE);
            LeftPanelMouseListener.setAtTheRateClicked(Boolean.FALSE);
            LeftPanelMouseListener.setTwoBarsClicked(Boolean.FALSE);
            LeftPanelMouseListener.setHyphenClicked(Boolean.FALSE);
        }else if(button.getName()=="greaterThanButton"){
            LeftPanelMouseListener.setGreaterThanClicked(Boolean.TRUE);
            LeftPanelMouseListener.setCloseBracketClicked(Boolean.FALSE);
            LeftPanelMouseListener.setOpenBracketClicked(Boolean.FALSE);
            LeftPanelMouseListener.setLessThanClicked(Boolean.FALSE);
            LeftPanelMouseListener.setAtTheRateClicked(Boolean.FALSE);
            LeftPanelMouseListener.setTwoBarsClicked(Boolean.FALSE);
            LeftPanelMouseListener.setHyphenClicked(Boolean.FALSE);
        }else if(button.getName()=="atTheRateButton"){
            LeftPanelMouseListener.setAtTheRateClicked(Boolean.TRUE);
            LeftPanelMouseListener.setCloseBracketClicked(Boolean.FALSE);
            LeftPanelMouseListener.setOpenBracketClicked(Boolean.FALSE);
            LeftPanelMouseListener.setLessThanClicked(Boolean.FALSE);
            LeftPanelMouseListener.setGreaterThanClicked(Boolean.FALSE);
            LeftPanelMouseListener.setTwoBarsClicked(Boolean.FALSE);
            LeftPanelMouseListener.setHyphenClicked(Boolean.FALSE);
        }else if(button.getName()=="twoBarButton"){
            LeftPanelMouseListener.setTwoBarsClicked(Boolean.TRUE);
            LeftPanelMouseListener.setCloseBracketClicked(Boolean.FALSE);
            LeftPanelMouseListener.setOpenBracketClicked(Boolean.FALSE);
            LeftPanelMouseListener.setLessThanClicked(Boolean.FALSE);
            LeftPanelMouseListener.setGreaterThanClicked(Boolean.FALSE);
            LeftPanelMouseListener.setAtTheRateClicked(Boolean.FALSE);
            LeftPanelMouseListener.setHyphenClicked(Boolean.FALSE);
        }else if(button.getName()=="hyphenButton"){
            LeftPanelMouseListener.setHyphenClicked(Boolean.TRUE);
            LeftPanelMouseListener.setCloseBracketClicked(Boolean.FALSE);
            LeftPanelMouseListener.setOpenBracketClicked(Boolean.FALSE);
            LeftPanelMouseListener.setLessThanClicked(Boolean.FALSE);
            LeftPanelMouseListener.setGreaterThanClicked(Boolean.FALSE);
            LeftPanelMouseListener.setAtTheRateClicked(Boolean.FALSE);
            LeftPanelMouseListener.setTwoBarsClicked(Boolean.FALSE);
        }else
            System.out.println("Wrong Input Entry From User!!!!!");
    }
}
