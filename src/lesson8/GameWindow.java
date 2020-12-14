package lesson8;

import sun.plugin2.util.ColorUtil;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    static final int WINDOW_X = 600;
    static final int WINDOW_Y = 300;
    static final int WINDOW_WIDTH = 505;
    static final int WINDOW_HEIGHT = 555;
    private Font font;


    private SettingWindow settingWindow;
    private BattleMap battleMap;
    private InfoWindow infoWindow;

    public GameWindow() {
        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        settingWindow = new SettingWindow(this);
        battleMap = new BattleMap(this);
        infoWindow = new InfoWindow();

        add (battleMap, BorderLayout.CENTER);
        infoWindow.setVisible(false);

        font = new Font("Arail", Font.BOLD, 20);
        JPanel panel = new JPanel(new GridLayout(1,2));
        JButton btnStartNewGame = new JButton("Start new game");
        btnStartNewGame.setFont(font);
        btnStartNewGame.setForeground(new Color(13, 79, 23));
        btnStartNewGame.setBackground(new Color(165, 242, 157));
        panel.add(btnStartNewGame);

        JButton btnExit = new JButton("EXIT");
        panel.add(btnExit);
        add(panel, BorderLayout.SOUTH);
        btnExit.setFont(font);
        btnExit.setBackground(new Color(255, 133, 133));
        btnExit.setForeground(new Color(154, 0, 0));      ;

        btnStartNewGame.addActionListener(e ->{
            settingWindow.setVisible(true);
        });

        btnExit.addActionListener(e -> {
            System.exit(0);
        });

        setVisible(true);
    }

    public void startNewGame (int mode, int fieldSize, int winningLength, char dotNext){
      battleMap.startNewGame(mode,fieldSize, winningLength, dotNext);
    }
}
