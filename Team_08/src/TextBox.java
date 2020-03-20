import javax.swing.*;
import java.util.HashMap;

/*
 * Author: Kartik Mathpal
 * */

public class TextBox extends JOptionPane {
    public static HashMap<Shapes, String> objectMessageMap = new HashMap<>();


    public void setTextValue(String textValue, Shapes shape) {
        objectMessageMap.put(shape, textValue);
    }

    public String getUserInput() {
        return JOptionPane.showInputDialog(null, "Enter Value");
    }

    public void showUserInput(Shapes shape) {
        JOptionPane.showMessageDialog(null, objectMessageMap.get(shape));
    }

    public Boolean isPresentInMap(Shapes s) {
        if (objectMessageMap.containsKey(s))
            return true;
        else
            return false;
    }
}
