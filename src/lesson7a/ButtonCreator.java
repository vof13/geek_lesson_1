package lesson7a;

import javax.swing.*;
import java.awt.*;

public class ButtonCreator {

    public JButton createButton (String name, Font font,
                                 JTextField textFieldEnter, JTextArea textArea) {
        JButton button = new JButton(name);

        button.setFont(font);

        button.addActionListener(e ->{
            switch (name) {
                case "=":
                    String num = textFieldEnter.getText();
                    for (int i = 0; i < num.length(); i++) {
                        switch (num.charAt(i)) {
                            case '+':
                                String num1 = num.substring(0, i);
                                String num2 = num.substring(i+1);
                                int result = Integer.parseInt(num1) + Integer.parseInt(num2);
                                textArea.append(num + " = ");
                                textArea.append(result + "\n");
                                textFieldEnter.setText("");
                                break;
                            case '-':
                                num1 = num.substring(0, i);
                                num2 = num.substring(i+1);
                                result = Integer.parseInt(num1) - Integer.parseInt(num2);
                                textArea.append(num + " = ");
                                textArea.append(result + "\n");
                                textFieldEnter.setText("");
                                break;
                            case '*':
                                num1 = num.substring(0, i);
                                num2 = num.substring(i+1);
                                result = Integer.parseInt(num1) * Integer.parseInt(num2);
                                textArea.append(num + " = ");
                                textArea.append(result + "\n");
                                textFieldEnter.setText("");
                                break;
                            case '/':
                                num1 = num.substring(0, i);
                                num2 = num.substring(i+1);
                                result = Integer.parseInt(num1) / Integer.parseInt(num2);
                                textArea.append(num + " = ");
                                textArea.append(result + "\n");
                                textFieldEnter.setText("");
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case "C":
                    textFieldEnter.setText("");
                    textArea.setText("");
                    break;
                default:
                    textFieldEnter.setText(textFieldEnter.getText() + name);
                    break;
            }
        });
        return button;
    }




}
