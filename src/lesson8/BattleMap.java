package lesson8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BattleMap extends JPanel {

    private GameWindow gameWindow;

    static final byte MODE_H_VS_AI = 0;
    static final byte MODE_H_VS_H = 1;
    static final char CHOOSE_DOT_X = 'X';
    static final char CHOOSE_DOT_O = 'O';

    private int mode;
    private int fieldSize;
    private int winningLength;

    private boolean isInit;

    static int cellWidth;
    static int cellHeight;


    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        setBackground(new Color(245, 245, 122));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
            int cellX = e.getX() / cellWidth;
            int cellY = e.getY() / cellHeight;

            if (!Logic.gameFinished) {
                Logic.humanTurn(cellX, cellY, mode);
            }
            repaint();
            if (Logic.gameFinished) {
                repaint();
                InfoWindow infoWindow = new InfoWindow();
                infoWindow.winner(Logic.answer);
                }
            }
        });
    }

    public void startNewGame (int mode, int fieldSize, int winningLength, char chooseDotNext){
        this.mode = mode;
        this.fieldSize = fieldSize;
        this.winningLength = winningLength;

        isInit = true;
        Logic.dotNext = chooseDotNext;
        repaint();
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;
        }

        cellHeight = getHeight() / fieldSize;
        cellWidth = getWidth() / fieldSize;
        for (int i = 1; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, getWidth(), y);
            int x = i * cellWidth;
            g.drawLine(x, 0, x, getHeight());
        }

        for (int i = 0; i < Logic.SIZE; i++) {
            for (int j = 0; j < Logic.SIZE; j++) {
                switch (Logic.map[i][j]) {
                    case Logic.DOT_X:
                        drawDotX(g, j, i);
                        break;
                    case Logic.DOT_O:
                        drawDotO(g, j, i);
                        break;
                    default:
                        break;
                }
            }
        }
        if (Logic.gameFinished && !Logic.answer.equalsIgnoreCase("draw.")) {
            drawWinnerLine(g);
        }


    }

    public void drawDotX (Graphics g, int cellX, int cellY) {
          ((Graphics2D)g).setStroke(new BasicStroke(10));
          g.setColor(Color.GREEN);
          int biasX = (int) (cellWidth * 0.2);
          int biasY = (int) (cellHeight * 0.2);
          g.drawLine((cellX*cellWidth) + biasX,(cellY*cellHeight) + biasY,
                  ((cellX+1)*cellWidth) - biasX,((cellY+1)*cellHeight) - biasY);
          g.drawLine((cellX+1)*cellWidth - biasX, cellY*cellHeight + biasY,
                  cellX*cellWidth + biasX, (cellY+1)*cellHeight - biasY);

    }

    public void drawDotO (Graphics g, int cellX, int cellY){
        ((Graphics2D)g).setStroke(new BasicStroke(10));
        g.setColor(Color.RED);
        int biasX = (int) (cellWidth * 0.2);
        int biasY = (int) (cellHeight * 0.2);
        g.drawOval(cellX*cellWidth+ biasX,cellY*cellHeight + biasY,
                cellWidth - 2*biasX,cellHeight- 2*biasY);
    }

    public void drawWinnerLine (Graphics g) {
        g.setColor(Color.BLACK);
        ((Graphics2D)g).setStroke(new BasicStroke(5));
        g.drawLine(Logic.firstWinX, Logic.firstWinY,
                Logic.secondWinX, Logic.secondWinY);

    }

}
