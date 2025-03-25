/*package view;

import java.awt.*;
import javax.swing.*;

public class Gui {
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 50;
    private static final int SPACING = 20;

    private final GameWindow gameWindow; // The main game frame
    private final JPanel menuPanel; // The menu panel
    private final GameScreen gameScreen; // The game screen panel

    public Gui(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        this.gameScreen = gameWindow.getGameScreen();

        // Create the menu panel
        menuPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("src/assets/background_V2.png");
            g.drawImage(imageIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
            }
        };
        //menuPanel.setBackground(Color.DARK_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(SPACING, 0, 0, 0);

        JButton startButton = createButton("Start Game");
        JButton exitButton = createButton("Exit");

        gbc.gridy = 0;
        menuPanel.add(startButton, gbc);
        gbc.gridy = 1;
        menuPanel.add(exitButton, gbc);

        // Add action listeners
        startButton.addActionListener(e -> startGame());
        exitButton.addActionListener(e -> System.exit(0));

        // Add the menu panel to the game frame
        gameWindow.add(menuPanel);
        gameWindow.revalidate();
        gameWindow.repaint();
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        return button;
    }

    private void startGame() {
        // Switch from the menu panel to the game screen
        gameWindow.remove(menuPanel);
        gameWindow.add(gameScreen);
        gameWindow.revalidate();
        gameWindow.repaint();
    }

    public static void main(String[] args) {
        // Create the game frame
        GameWindow gameWindow = new GameWindow();
        gameWindow.loopGame();

        // Initialize the GUI with the game frame
        Gui gui = new Gui(gameWindow);
    }
}*/