package view;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;

public class Gui 
{
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 50;
    private static final int SPACING = 20;

    private final JFrame frame;
    private final JPanel panel;

    public Gui() {
        frame = new JFrame("Phantom Siege");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1024, 576); // Set the fixed size of the window
        frame.setResizable(false); // Disable resizing to maintain the 16:9 aspect ratio

        panel = new JPanel(new GridBagLayout());
        frame.add(panel);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(SPACING, 0, 0, 0);

        JButton button1 = createButton("Button 1");
        JButton button2 = createButton("Button 2");
        JButton button3 = createButton("Button 3");
        JButton button4 = createButton("Button 4");

        gbc.gridy = 0; panel.add(button1, gbc);
        gbc.gridy = 1; panel.add(button2, gbc);
        gbc.gridy = 2; panel.add(button3, gbc);
        gbc.gridy = 3; panel.add(button4, gbc);

        frame.setLocationRelativeTo(null); // Center the window on the screen
        frame.setVisible(true);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(BUTTON_WIDTH, BUTTON_HEIGHT));
        return button;
    }
}