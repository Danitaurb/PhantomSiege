package view;

import main.Game;
import main.GameScreen;

import javax.swing.*;
import java.awt.*;

public class Gui {
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 50;
    private static final int SPACING = 20;

    private final Game game; // The main game frame
    private final JPanel menuPanel; // The menu panel
    private final GameScreen gameScreen; // The game screen panel

    public Gui(Game game) {
        this.game = game;
        this.gameScreen = game.getGameScreen();

        // Create the menu panel
        menuPanel = new JPanel(new GridBagLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            ImageIcon imageIcon = new ImageIcon("src/assets/background_menu.png");
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
        game.add(menuPanel);
        game.revalidate();
        game.repaint();
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        return button;
    }

    private void startGame() {
        // Switch from the menu panel to the game screen
        game.remove(menuPanel);
        game.add(gameScreen);
        game.revalidate();
        game.repaint();
    }

    public static void main(String[] args) {
        // Create the game frame
        Game game = new Game();

        // Initialize the GUI with the game frame
        new Gui(game);
    }
}