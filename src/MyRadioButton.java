import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MyRadioButton extends JRadioButton {
    ReadAndWrite readAndWrite = new ReadAndWrite();
    ImageIcon in_selected = new ImageIcon(readAndWrite.readImage("img/in_select.png"));
    ImageIcon selected = new ImageIcon(readAndWrite.readImage("img/selected.png"));

    MyRadioButton() throws IOException {
        super();
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setIcon(in_selected);
        setSelectedIcon(selected);

    }
}
