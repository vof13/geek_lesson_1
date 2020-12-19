package lesson8;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import javax.swing.*;
import java.awt.*;

public class SettingWindow extends JFrame  {
    static final int WINDOW_X = GameWindow.WINDOW_X + 50;
    static final int WINDOW_Y = GameWindow.WINDOW_Y;
    static final int WINDOW_WIDTH = GameWindow.WINDOW_WIDTH - 100;
    static final int WINDOW_HEIGHT = GameWindow.WINDOW_HEIGHT;

    static char firstPlayerSymbol;
    private final byte MIN_FIELD_SIZE = 3;
    private final byte MAX_FIELD_SIZE = 10 ;

    private GameWindow gameWindow;
    private JRadioButton rbHumVsAi;
    private JRadioButton rbHumVsHum;
    private JRadioButton rbFirstHumX;
    private JRadioButton rbFirstHumO;
    private ButtonGroup gameMode;
    private ButtonGroup dotMode;
    private JSlider slFieldSize;
    private JSlider slWinningLength;
    private JButton btnStartAGame;
    private JLabel label;
    private Font font;
    private Font fontForSmall;

    public SettingWindow(GameWindow gameWindow)  {
        this.gameWindow = gameWindow;


        font = new Font("Arail", Font.BOLD, 20);
        fontForSmall = new Font("Arail", Font.ITALIC, 15);

        setBounds(WINDOW_X, WINDOW_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe setting");
        setLayout(new GridLayout(11, 1));


        label = new JLabel("Choose game mode: ");
        label.setFont(font);
        add(label);

        rbHumVsAi = new JRadioButton("HumVsAi", true);
        add(rbHumVsAi);
        rbHumVsAi.setFont(fontForSmall);
        rbHumVsHum = new JRadioButton("HumVsHum");
        add(rbHumVsHum);
        rbHumVsHum.setFont(fontForSmall);
        gameMode = new ButtonGroup();
        gameMode.add(rbHumVsAi);
        gameMode.add(rbHumVsHum);

        label = new JLabel("Choose symbol for first player:");
        label.setFont(font);
        add(label);

        dotMode = new ButtonGroup();
        rbFirstHumX = new JRadioButton(" Х");
        rbFirstHumX.setFont(fontForSmall);
        add(rbFirstHumX);
        rbFirstHumX.doClick();
        rbFirstHumO = new JRadioButton(" О");
        rbFirstHumO.setFont(fontForSmall);
        add(rbFirstHumO);
        dotMode.add(rbFirstHumO);
        rbFirstHumX.setEnabled(false);
        dotMode.add(rbFirstHumX);
        rbFirstHumO.setEnabled(false);
        rbHumVsHum.addActionListener(e ->{
                rbFirstHumX.setEnabled(true);
                rbFirstHumO.setEnabled(true);
        });
        rbHumVsAi.addActionListener(e ->{
            rbFirstHumX.setEnabled(false);
            rbFirstHumO.setEnabled(false);
        });

        label = new JLabel("Choose size:");
        label.setFont(font);
        add(label);
        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slFieldSize.setMajorTickSpacing(1);
        slFieldSize.setPaintTicks(true);
        slFieldSize.setPaintLabels(true);
        slFieldSize.setFont(fontForSmall);
        add(slFieldSize);

        label = new JLabel("Choose winning length: ");
        label.setFont(font);
        add(label);
        slWinningLength = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        slWinningLength.setMajorTickSpacing(1);
        slWinningLength.setPaintTicks(true);
        slWinningLength.setPaintLabels(true);
        slWinningLength.setFont(fontForSmall);
        add(slWinningLength);

        slFieldSize.addChangeListener(e -> {
            slWinningLength.setMaximum(slFieldSize.getValue());
        });

        btnStartAGame = new JButton("Start a game");
        btnStartAGame.setFont(font);
        btnStartAGame.setForeground(new Color(13, 79, 23));
        btnStartAGame.setBackground(new Color(165, 242, 157));
        add(btnStartAGame);
        btnStartAGame.addActionListener(e -> {
            int mode;
            if (rbHumVsAi.isSelected()){
                mode = BattleMap.MODE_H_VS_AI;
                firstPlayerSymbol = BattleMap.CHOOSE_DOT_X;
            } else if (rbFirstHumX.isSelected()) {
                mode = BattleMap.MODE_H_VS_H;
                firstPlayerSymbol = BattleMap.CHOOSE_DOT_O;
            } else {
                mode = BattleMap.MODE_H_VS_H;
                firstPlayerSymbol = BattleMap.CHOOSE_DOT_X;
            }
            int fieldSize = slFieldSize.getValue();
            int winningLength = slWinningLength.getValue();

            Logic.SIZE = fieldSize;
            Logic.DOTS_TO_WIN = winningLength;
            Logic.initMap();
            Logic.gameFinished = false;

            gameWindow.startNewGame(mode, fieldSize, winningLength, firstPlayerSymbol);

            setVisible(false);
        });
        setVisible(false);
    }
}

