import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SnakeGame extends JFrame {

    public SnakeGame() {
        initUI();
    }

    private void initUI() {
        GamePanel gamePanel = new GamePanel();

        add(gamePanel);

        setTitle("Professional Snake Game");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SwingUtilities.invokeLater(gamePanel::requestFocusInWindow);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SnakeGame game = new SnakeGame();
            game.setVisible(true);
        });
    }
}

class GamePanel extends JPanel implements ActionListener {

    private static final int SCREEN_WIDTH = 600;
    private static final int SCREEN_HEIGHT = 600;
    private static final int UNIT_SIZE = 25;

    private static final int GAME_UNITS =
            (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);

    private static final int DELAY = 100;

    private final int[] x = new int[GAME_UNITS];
    private final int[] y = new int[GAME_UNITS];

    private int bodyParts = 6;
    private int applesEaten = 0;
    private int highScore = 0;

    private int appleX;
    private int appleY;

    private char direction = 'R';

    private boolean running = false;
    private boolean gameStarted = false;

    private Timer timer;
    private final Random random = new Random();

    public GamePanel() {
        setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        setBackground(new Color(15, 15, 25));
        setFocusable(true);

        addKeyListener(new MyKeyAdapter());

        initializeSnake();
    }

    private void initializeSnake() {
        bodyParts = 6;
        applesEaten = 0;
        direction = 'R';

        int startX = SCREEN_WIDTH / 2;
        int startY = SCREEN_HEIGHT / 2;

        for (int i = 0; i < bodyParts; i++) {
            x[i] = startX - (i * UNIT_SIZE);
            y[i] = startY;
        }

        for (int i = bodyParts; i < GAME_UNITS; i++) {
            x[i] = 0;
            y[i] = 0;
        }
    }

    private void startGame() {
        initializeSnake();
        newApple();

        running = true;
        gameStarted = true;

        if (timer != null) {
            timer.stop();
        }

        timer = new Timer(DELAY, this);
        timer.start();

        requestFocusInWindow();
        repaint();
    }

    private void restartGame() {
        if (timer != null) {
            timer.stop();
        }

        startGame();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        draw(g2d);

        g2d.dispose();
    }

    private void draw(Graphics2D g2d) {

        if (!gameStarted) {
            drawStartScreen(g2d);
            return;
        }

        if (running) {
            drawGame(g2d);
        } else {
            drawGame(g2d);
            drawGameOver(g2d);
        }
    }

    private void drawGame(Graphics2D g2d) {

        drawGrid(g2d);
        drawApple(g2d);
        drawSnake(g2d);
        drawScore(g2d);
    }

    private void drawGrid(Graphics2D g2d) {

        g2d.setColor(new Color(30, 30, 45));

        for (int i = 0; i <= SCREEN_WIDTH / UNIT_SIZE; i++) {
            g2d.drawLine(
                    i * UNIT_SIZE,
                    0,
                    i * UNIT_SIZE,
                    SCREEN_HEIGHT
            );
        }

        for (int i = 0; i <= SCREEN_HEIGHT / UNIT_SIZE; i++) {
            g2d.drawLine(
                    0,
                    i * UNIT_SIZE,
                    SCREEN_WIDTH,
                    i * UNIT_SIZE
            );
        }
    }

    private void drawApple(Graphics2D g2d) {

        g2d.setColor(new Color(235, 60, 60));

        g2d.fillOval(
                appleX,
                appleY,
                UNIT_SIZE,
                UNIT_SIZE
        );

        g2d.setColor(new Color(255, 140, 140));

        g2d.fillOval(
                appleX + 5,
                appleY + 5,
                UNIT_SIZE / 3,
                UNIT_SIZE / 3
        );
    }

    private void drawSnake(Graphics2D g2d) {

        for (int i = 0; i < bodyParts; i++) {

            if (i == 0) {

                g2d.setColor(new Color(46, 204, 113));

                g2d.fillRoundRect(
                        x[i],
                        y[i],
                        UNIT_SIZE,
                        UNIT_SIZE,
                        10,
                        10
                );

                drawEyes(g2d);

            } else {

                g2d.setColor(new Color(39, 174, 96));

                g2d.fillRoundRect(
                        x[i],
                        y[i],
                        UNIT_SIZE,
                        UNIT_SIZE,
                        8,
                        8
                );
            }
        }
    }

    private void drawEyes(Graphics2D g2d) {

        g2d.setColor(Color.WHITE);

        int eyeSize = 5;

        if (direction == 'R') {

            g2d.fillOval(
                    x[0] + 15,
                    y[0] + 5,
                    eyeSize,
                    eyeSize
            );

            g2d.fillOval(
                    x[0] + 15,
                    y[0] + 15,
                    eyeSize,
                    eyeSize
            );

        } else if (direction == 'L') {

            g2d.fillOval(
                    x[0] + 5,
                    y[0] + 5,
                    eyeSize,
                    eyeSize
            );

            g2d.fillOval(
                    x[0] + 5,
                    y[0] + 15,
                    eyeSize,
                    eyeSize
            );

        } else if (direction == 'U') {

            g2d.fillOval(
                    x[0] + 5,
                    y[0] + 5,
                    eyeSize,
                    eyeSize
            );

            g2d.fillOval(
                    x[0] + 15,
                    y[0] + 5,
                    eyeSize,
                    eyeSize
            );

        } else {

            g2d.fillOval(
                    x[0] + 5,
                    y[0] + 15,
                    eyeSize,
                    eyeSize
            );

            g2d.fillOval(
                    x[0] + 15,
                    y[0] + 15,
                    eyeSize,
                    eyeSize
            );
        }
    }

    private void drawScore(Graphics2D g2d) {

        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("SansSerif", Font.BOLD, 18));

        String scoreText = "Score: " + applesEaten;
        String highScoreText = "High Score: " + highScore;

        g2d.drawString(
                scoreText,
                20,
                30
        );

        FontMetrics metrics =
                g2d.getFontMetrics();

        g2d.drawString(
                highScoreText,
                SCREEN_WIDTH
                        - metrics.stringWidth(highScoreText)
                        - 20,
                30
        );
    }

    private void drawStartScreen(Graphics2D g2d) {

        g2d.setColor(new Color(46, 204, 113));

        g2d.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        45
                )
        );

        String title = "SNAKE GAME";

        FontMetrics titleMetrics =
                g2d.getFontMetrics();

        g2d.drawString(
                title,
                (SCREEN_WIDTH
                        - titleMetrics.stringWidth(title)) / 2,
                SCREEN_HEIGHT / 3
        );

        g2d.setColor(Color.WHITE);

        g2d.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        20
                )
        );

        String instruction =
                "Press SPACE to Start";

        FontMetrics instructionMetrics =
                g2d.getFontMetrics();

        g2d.drawString(
                instruction,
                (SCREEN_WIDTH
                        - instructionMetrics.stringWidth(instruction)) / 2,
                SCREEN_HEIGHT / 2
        );

        g2d.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        16
                )
        );

        String controls =
                "Use Arrow Keys or WASD to Move";

        FontMetrics controlMetrics =
                g2d.getFontMetrics();

        g2d.drawString(
                controls,
                (SCREEN_WIDTH
                        - controlMetrics.stringWidth(controls)) / 2,
                SCREEN_HEIGHT / 2 + 45
        );
    }

    private void drawGameOver(Graphics2D g2d) {

        g2d.setColor(
                new Color(
                        0,
                        0,
                        0,
                        170
                )
        );

        g2d.fillRect(
                0,
                0,
                SCREEN_WIDTH,
                SCREEN_HEIGHT
        );

        g2d.setColor(
                new Color(231, 76, 60)
        );

        g2d.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        45
                )
        );

        String gameOver =
                "GAME OVER";

        FontMetrics metrics1 =
                g2d.getFontMetrics();

        g2d.drawString(
                gameOver,
                (SCREEN_WIDTH
                        - metrics1.stringWidth(gameOver)) / 2,
                SCREEN_HEIGHT / 3
        );

        g2d.setColor(Color.WHITE);

        g2d.setFont(
                new Font(
                        "SansSerif",
                        Font.BOLD,
                        22
                )
        );

        String finalScore =
                "Final Score: " + applesEaten;

        FontMetrics metrics2 =
                g2d.getFontMetrics();

        g2d.drawString(
                finalScore,
                (SCREEN_WIDTH
                        - metrics2.stringWidth(finalScore)) / 2,
                SCREEN_HEIGHT / 2
        );

        g2d.setFont(
                new Font(
                        "SansSerif",
                        Font.PLAIN,
                        18
                )
        );

        String restart =
                "Press SPACE to Restart";

        FontMetrics metrics3 =
                g2d.getFontMetrics();

        g2d.drawString(
                restart,
                (SCREEN_WIDTH
                        - metrics3.stringWidth(restart)) / 2,
                SCREEN_HEIGHT / 2 + 60
        );
    }

    private void newApple() {

        do {

            appleX =
                    random.nextInt(
                            SCREEN_WIDTH / UNIT_SIZE
                    ) * UNIT_SIZE;

            appleY =
                    random.nextInt(
                            SCREEN_HEIGHT / UNIT_SIZE
                    ) * UNIT_SIZE;

        } while (isAppleOnSnake());
    }

    private boolean isAppleOnSnake() {

        for (int i = 0; i < bodyParts; i++) {

            if (appleX == x[i]
                    && appleY == y[i]) {

                return true;
            }
        }

        return false;
    }

    private void move() {

        for (int i = bodyParts; i > 0; i--) {

            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {

            case 'U':
                y[0] -= UNIT_SIZE;
                break;

            case 'D':
                y[0] += UNIT_SIZE;
                break;

            case 'L':
                x[0] -= UNIT_SIZE;
                break;

            case 'R':
                x[0] += UNIT_SIZE;
                break;
        }
    }

    private void checkApple() {

        if (x[0] == appleX
                && y[0] == appleY) {

            if (bodyParts < GAME_UNITS - 1) {
                bodyParts++;
            }

            applesEaten++;

            if (applesEaten > highScore) {
                highScore = applesEaten;
            }

            if (bodyParts < GAME_UNITS) {
                newApple();
            }
        }
    }

    private void checkCollisions() {

        for (int i = 1; i < bodyParts; i++) {

            if (x[0] == x[i]
                    && y[0] == y[i]) {

                running = false;
                break;
            }
        }

        if (x[0] < 0
                || x[0] >= SCREEN_WIDTH
                || y[0] < 0
                || y[0] >= SCREEN_HEIGHT) {

            running = false;
        }

        if (!running && timer != null) {
            timer.stop();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (running) {

            move();
            checkApple();
            checkCollisions();
        }

        repaint();
    }

    private class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (key == KeyEvent.VK_SPACE) {

                if (!gameStarted) {
                    startGame();
                    return;
                }

                if (!running) {
                    restartGame();
                    return;
                }
            }

            if (!running) {
                return;
            }

            switch (key) {

                case KeyEvent.VK_LEFT:
                case KeyEvent.VK_A:

                    if (direction != 'R') {
                        direction = 'L';
                    }

                    break;

                case KeyEvent.VK_RIGHT:
                case KeyEvent.VK_D:

                    if (direction != 'L') {
                        direction = 'R';
                    }

                    break;

                case KeyEvent.VK_UP:
                case KeyEvent.VK_W:

                    if (direction != 'D') {
                        direction = 'U';
                    }

                    break;

                case KeyEvent.VK_DOWN:
                case KeyEvent.VK_S:

                    if (direction != 'U') {
                        direction = 'D';
                    }

                    break;
            }
        }
    }
}