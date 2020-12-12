package lesson7a;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    public MyWindow(){
        setBounds(400, 200, 700, 600);
        setTitle("Calculator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        Font font = new Font("Arial", Font.BOLD, 36);

        JTextField textFieldEnter = new JTextField();
        textFieldEnter.setFont(font);
        add(textFieldEnter, BorderLayout.NORTH);
        JTextArea textArea = new JTextArea();
        textArea.setFont(font);
        add(textArea, BorderLayout.CENTER);


        // делаем клавиатуру

        JPanel numPad = new JPanel(new GridLayout(4, 4));
        numPad.setFont(font);
        add(numPad, BorderLayout.SOUTH);

        ButtonCreator btcr = new ButtonCreator();

        for (int i = 0; i < 9; i++) {
            numPad.add(btcr.createButton("" + (i+1), font, textFieldEnter, textArea));
        }

        numPad.add(btcr.createButton("0", font, textFieldEnter, textArea));
        numPad.add(btcr.createButton("+", font, textFieldEnter, textArea));
        numPad.add(btcr.createButton("-", font, textFieldEnter, textArea));
        numPad.add(btcr.createButton("/", font, textFieldEnter, textArea));
        numPad.add(btcr.createButton("*", font, textFieldEnter, textArea));
        numPad.add(btcr.createButton("=", font, textFieldEnter, textArea));
        numPad.add(btcr.createButton("C", font, textFieldEnter, textArea));


        setVisible(true);
    }

}
