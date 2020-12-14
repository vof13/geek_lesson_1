package lesson8;

import javax.swing.*;
import java.awt.*;

public class InfoWindow extends JDialog {

    static final int WINDOW_X = GameWindow.WINDOW_X + 150;
    static final int WINDOW_Y = GameWindow.WINDOW_Y + 150;
    static final int WINDOW_WIDTH = GameWindow.WINDOW_WIDTH - 200;
    static final int WINDOW_HEIGHT = 300;

    public InfoWindow() {
        setBounds(WINDOW_X,WINDOW_Y,WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("RESULT!!");
        setModal(true);

    }

    public void winner (String answ){
        JLabel label = new JLabel();
        add(label);
        label.setText(answ);
        label.setFont(new Font("Arial", Font.BOLD,  20));
        label.setHorizontalAlignment(JTextField.CENTER);
        setVisible(true);

    }

}
