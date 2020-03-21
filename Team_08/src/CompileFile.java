import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * @author Kartik Mathpal
 * @version 1.0
 */

public class CompileFile extends JMenuItem implements ActionListener {
    public CompileFile(String label) {
        super(label);
    }

    public CompileFile() {

    }

    static Map<Shapes, Integer> trackShapes = new HashMap<>();
    static Map<Character, Integer> charMap = new HashMap<>();

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("compile");

        compileCanvas();

    }

    public void push(Character item, int count) {
        if (charMap.containsKey(item)) {
            charMap.put(item, charMap.get(item) + 1);
        } else {
            charMap.put(item, count);
            System.out.println("Key not present in HashMap");
        }
    }

    public void compileCanvas() {

        if (null == charMap || charMap.isEmpty()) {
            infoBox("No Shapes On Canvas", "Failed Case");
            return;
        }

        for (Shapes shp : trackShapes.keySet()) {
            if (trackShapes.containsKey(shp)) {
                if (trackShapes.get(shp) == 1) {
                    infoBox("Compilation Failed!!!", "Compilation Failed");
                    return;
                }
            }
        }
        if ((charMap.containsKey('(') && charMap.containsKey(')') && !(charMap.get('(').equals(charMap.get(')'))))) {
            infoBox("Compilation Failed!!!", "Compilation Failed");
            return;
        }
        if (charMap.containsKey('<') && charMap.containsKey('>') && charMap.get('<') != 3 && charMap.get('>') != 3) {
            infoBox("Compilation Failed!!!", "Compilation Failed");
            return;
        }
        if (charMap.containsKey('@') && charMap.get('@') != 4) {
            infoBox("Compilation Failed!!!", "Compilation Failed");
        } else {
            infoBox("Compilation successful", "Done");
        }

    }

    public void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void setTrackShapes() {

        for (Shapes s : RightPanel.getRightPanelShapes()) {
            if (!trackShapes.containsKey(s))
                trackShapes.put(s, 1);
        }

    }

    public static void removeConnectedShapesFromMap(Shapes s) {
        trackShapes.put(s, 0);
    }
}
