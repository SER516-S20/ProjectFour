import javax.swing.*;

public class TextBox extends JOptionPane {
    String textValue = "";

    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public String getUserInput(){
        return JOptionPane.showInputDialog(null,"Enter Value");
    }
}
