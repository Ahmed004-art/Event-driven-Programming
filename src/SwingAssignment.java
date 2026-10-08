import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class SwingAssignment {

    JFrame frame;
    JPanel panel;
    JLabel label;
    
    JLabel nameLabel;
    JLabel descriptionLabel;
    JButton changeTextButton;
    JButton changeBackgroundButton;
    JButton resetButton;
    ImageIcon imageIcon;
    JPanel cardPanel;
    JPanel buttonPanel;

    public SwingAssignment() {
        // 1. Initialize JFrame
        frame = new JFrame("Java Swing Assignment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null); // Center on screen
        
        // 2. Initialize main JPanel with GridBagLayout for absolute perfect centering
        panel = new JPanel(new GridBagLayout());
        Color defaultBgColor = new Color(240, 245, 250); // Light neutral blue/gray
        panel.setBackground(defaultBgColor);
        
        // Create a wrapper panel with vertical BoxLayout
        JPanel wrapperPanel = new JPanel();
        wrapperPanel.setLayout(new BoxLayout(wrapperPanel, BoxLayout.Y_AXIS));
        wrapperPanel.setOpaque(false); // Let the main panel's background show through
        
        // Load Icon
        JLabel iconLabel = new JLabel();
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        try {
            URL iconURL = getClass().getResource("/assets/app_icon.png");
            if (iconURL != null) {
                imageIcon = new ImageIcon(iconURL);
            } else {
                // Fallback: load directly from relative file path if not in classpath (e.g. running from IDE/terminal)
                imageIcon = new ImageIcon("assets/app_icon.png");
            }
            
            if (imageIcon.getImageLoadStatus() == MediaTracker.ERRORED) {
                System.out.println("Icon not found. Please ensure your image is named exactly 'app_icon.png' inside the 'assets' folder.");
            } else {
                frame.setIconImage(imageIcon.getImage());
                
                // Scale the icon for the main UI
                Image img = imageIcon.getImage();
                Image scaledImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImg);
                iconLabel.setIcon(scaledIcon);
            }
        } catch (Exception e) {
            System.out.println("Error loading image icon: " + e.getMessage());
        }
        
        // 3. Create the central card panel to hold content
        cardPanel = new JPanel();
        cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
        cardPanel.setBackground(Color.WHITE);
        // Smaller content card, well balanced
        cardPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));
        cardPanel.setMaximumSize(new Dimension(500, 300));
        cardPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Welcome Label
        label = new JLabel("Welcome to Java Swing First Individual Assignment by 'Ahmed Kamara'", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 22));
        label.setForeground(new Color(0, 30, 80)); // Dark navy
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Name Label
        nameLabel = new JLabel("Ahmed Junior Kamara", SwingConstants.CENTER);
        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
        nameLabel.setForeground(new Color(0, 30, 80));
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Description Label
        descriptionLabel = new JLabel("<html><div style='text-align: center; color: #5a6e82;'>A simple interactive Java Swing application created to demonstrate<br>basic GUI components and user interaction.</div></html>", SwingConstants.CENTER);
        descriptionLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Add labels to the card panel with vertical glue for vertical centering
        cardPanel.add(Box.createVerticalGlue());
        cardPanel.add(label);
        cardPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        cardPanel.add(nameLabel);
        cardPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        cardPanel.add(descriptionLabel);
        cardPanel.add(Box.createVerticalGlue());
        
        // 4. Button Panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        changeTextButton = new JButton("Change Text");
        changeBackgroundButton = new JButton("Change Background");
        resetButton = new JButton("Reset");

        // Style buttons to look intentional and professional
        Font buttonFont = new Font("SansSerif", Font.PLAIN, 14);
        Dimension buttonSize = new Dimension(160, 40); // Large intentional size
        
        changeTextButton.setFont(buttonFont);
        changeTextButton.setPreferredSize(buttonSize);
        changeTextButton.setFocusPainted(false);
        
        // Slightly wider for the longer text
        changeBackgroundButton.setFont(buttonFont);
        changeBackgroundButton.setPreferredSize(new Dimension(180, 40)); 
        changeBackgroundButton.setFocusPainted(false);
        
        resetButton.setFont(buttonFont);
        resetButton.setPreferredSize(buttonSize);
        resetButton.setFocusPainted(false);

        buttonPanel.add(changeTextButton);
        buttonPanel.add(changeBackgroundButton);
        buttonPanel.add(resetButton);

        // Functionality: Change Text
        changeTextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("<html><div style='text-align: center;'>Java Swing Made Simple!</div></html>");
            }
        });

        // Functionality: Change Background
        changeBackgroundButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Change to a different professional color (Subtle Peach/Orange)
                Color newColor = new Color(255, 235, 220);
                panel.setBackground(newColor);
            }
        });

        // Functionality: Reset
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Restore original state
                label.setText("Welcome to Java Swing First Individual Assignment by 'Ahmed Kamara'");
                panel.setBackground(defaultBgColor);
            }
        });

        // Assemble the wrapper panel
        wrapperPanel.add(iconLabel);
        wrapperPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Gap between icon and card
        wrapperPanel.add(cardPanel);
        wrapperPanel.add(Box.createRigidArea(new Dimension(0, 30))); // Gap between card and buttons
        wrapperPanel.add(buttonPanel);

        // Add wrapper to the GridBagLayout panel (centers it perfectly)
        panel.add(wrapperPanel, new GridBagConstraints());
        
        // Add main panel to frame
        frame.add(panel);
        
        // Ensure frame is visible
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Create the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingAssignment();
            }
        });
    }
}
